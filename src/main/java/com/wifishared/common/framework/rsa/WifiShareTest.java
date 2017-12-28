package com.wifishared.common.framework.rsa;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

public class WifiShareTest {

	public static void main(String[] args) throws Exception {
		
		System.out.println("--------------公钥加密私钥解密过程-------------------");  
        String plainText="112233445";  
        //公钥加密过程  
        byte[] cipherData=RSACoder.encrypt(RSACoder.loadPublicKeyByStr(RSACoder.getPublicKey()),plainText.getBytes());  
        String cipher=Base64Apache.encodeStr(cipherData);  
        //私钥解密过程  
        byte[] res=RSACoder.decrypt(RSACoder.loadPrivateKeyByStr(RSACoder.getPrivateKey()), Base64Apache.decodeStr(cipher));  
        String restr=new String(res);  
        System.out.println("原文："+plainText);  
        System.out.println("加密："+cipher);  
        System.out.println("加密长度："+cipher.length());  
        System.out.println("解密："+restr);  
        System.out.println();  
          
        System.out.println("--------------私钥加密公钥解密过程-------------------");  
        plainText=restr;  
        //私钥加密过程  
        cipherData=RSACoder.encrypt(RSACoder.loadPrivateKeyByStr(RSACoder.getPrivateKey()),plainText.getBytes());  
        cipher=Base64Apache.encodeStr(cipherData);  
        //公钥解密过程  
        res=RSACoder.decrypt(RSACoder.loadPublicKeyByStr(RSACoder.getPublicKey()), Base64Apache.decodeStr(cipher));  
        restr=new String(res);  
        System.out.println("原文："+plainText);  
        System.out.println("加密："+cipher); 
        System.out.println("加密长度："+cipher.length());  
        System.out.println("解密："+restr);  
        System.out.println();  
		/*Map<String, Object> map = RSACoder.initKey();
		String publickey = Base64.encode(((RSAPublicKey)map.get("public")).getEncoded());
		String privatekey = Base64.encode(((RSAPrivateKey)map.get("private")).getEncoded());
		System.out.println("--------------公钥加密私钥解密过程-------------------");  
        String plainText="wifishare";  
        //公钥加密过程  
        byte[] cipherData=RSACoder.encrypt(RSACoder.loadPublicKeyByStr(publickey),plainText.getBytes());  
        String cipher=Base64.encode(cipherData);  
        //私钥解密过程  
        byte[] res=RSACoder.decrypt(RSACoder.loadPrivateKeyByStr(privatekey), Base64.decode(cipher));  
        String restr=new String(res);  
        System.out.println("原文："+plainText);  
        System.out.println("加密："+cipher);  
        System.out.println("加密长度："+cipher.length());  
        System.out.println("解密："+restr);  
        System.out.println();  
          
        System.out.println("--------------私钥加密公钥解密过程-------------------");  
        plainText=restr;  
        //私钥加密过程  
        cipherData=RSACoder.encrypt(RSACoder.loadPrivateKeyByStr(privatekey),plainText.getBytes());  
        cipher=Base64.encode(cipherData);  
        //公钥解密过程  
        res=RSACoder.decrypt(RSACoder.loadPublicKeyByStr(publickey), Base64.decode(cipher));  
        restr=new String(res);  
        System.out.println("原文："+plainText);  
        System.out.println("加密："+cipher); 
        System.out.println("加密长度："+cipher.length());  
        System.out.println("解密："+restr);  
        System.out.println(); */
        
        
        
	}
	
}
