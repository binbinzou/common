package com.wifishared.common.framework.jwt;

import java.security.Key;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import com.alibaba.fastjson.JSONObject;
import com.wifishared.common.data.dto.user.LoginReqBody;
import com.wifishared.common.framework.contant.CommonConstant;
import com.wifishared.common.framework.rsa.Base64;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtManager {

	public static String createJWT(String id, String issuer, String subject) {
		 //The JWT signature algorithm we will be using to sign the token
	    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

	    //We will sign our JWT with our ApiKey secret
	    byte[] apiKeySecretBytes = Base64.decode(CommonConstant.SECRET);
	    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

	    //Let's set the JWT Claims
	    JwtBuilder builder = Jwts.builder().setId(id)
	                                .setSubject(subject)
	                                .setIssuer(issuer)
	                                .signWith(signatureAlgorithm, signingKey);

	    //Builds the JWT and serializes it to a compact, URL-safe string
	    return builder.compact();
	}
	
	public static Claims parseJWT(String jwt) {
		Claims claims = Jwts.parser()         
			       .setSigningKey(Base64.decode(CommonConstant.SECRET))
			       .parseClaimsJws(jwt).getBody();
		return claims;
	}
	
	public static LoginReqBody parseToken(String authorization) {
		String token = authorization.substring(7);
    	//取出token中相应的信息
        Claims claims = JwtManager.parseJWT(token);
        String subject = claims.getSubject();
        LoginReqBody reqBody = JSONObject.parseObject(subject, LoginReqBody.class);
        return reqBody;
	}
	
}
