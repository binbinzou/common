package com.wifishared.common.framework.jwt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.filter.GenericFilterBean;

import com.alibaba.fastjson.JSONObject;
import com.wifishared.common.data.dto.user.LoginReqBody;
import com.wifishared.common.framework.contant.CommonConstant;
import com.wifishared.common.framework.contant.CommonResultCodeConstant;
import com.wifishared.common.framework.redis.RedisManager;
import com.wifishared.common.framework.redis.RedisStringManager;
import com.wifishared.common.framework.resultobj.GeneralResult;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HTTPBearerAuthorizationFilter extends GenericFilterBean {

	private final RedisStringManager redisManager;
	
	public HTTPBearerAuthorizationFilter(RedisStringManager redisManager) {
		super();
		this.redisManager = redisManager;
	}
	@Override
	public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
			throws IOException, ServletException {
		final HttpServletRequest request = (HttpServletRequest) req;
	    final HttpServletResponse response = (HttpServletResponse) res;
	    final String authHeader = request.getHeader("Authorization");
	    log.info("token:{}",authHeader);
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
        	responseMessage(response, response.getWriter());
            log.error("Missing or invalid Authorization header");
            return;
        }
        final String token = authHeader.substring(7);
        try {
        	//取出token中相应的信息
            final Claims claims = JwtManager.parseJWT(token);
            final String subject = claims.getSubject();
            final LoginReqBody reqBody = JSONObject.parseObject(subject, LoginReqBody.class);
            final String key = reqBody.getUserId() + CommonConstant.TOKEN_SPILTE_DEVICEID_USERID + reqBody.getDeviceId();
            if(!redisManager.exists(key)) {
            	responseMessage(response, response.getWriter());
            	log.error("Invalid token,token not exist in redis!");
            	return;
            }
        } catch (final SignatureException e) {
        	e.printStackTrace();
        	responseMessage(response, response.getWriter());
        	log.error("Invalid token:{}",e.getStackTrace());
        	return;
        } catch (Exception e) {
        	e.printStackTrace();
        	responseMessage(response, response.getWriter());
        	log.error("Invalid token:{}",e.getStackTrace());
        	return;
		}
        chain.doFilter(req, res);
	}
	//请求不通过，返回错误信息给客户端
    private void responseMessage(HttpServletResponse response, PrintWriter out) {
    	GeneralResult result = new GeneralResult();
    	result.setCode(CommonResultCodeConstant.UNAUTHORIZED);
    	result.setMessage("Invalid Token");
    	response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json; charset=utf-8");  
        String json = JSONObject.toJSONString(result);
        out.print(json);
        out.flush();
        out.close();
    }

}
