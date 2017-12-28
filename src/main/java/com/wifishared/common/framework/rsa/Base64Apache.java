package com.wifishared.common.framework.rsa;

public class Base64Apache {

	/** 
     *  
     * 创建日期2011-4-25上午10:12:38 
     * 修改日期 
     * 作者：dh *TODO 使用Base64加密算法加密字符串 
     *return 
     */  
    public static String encodeStr(byte[] b){  
        org.apache.commons.codec.binary.Base64 base64=new  org.apache.commons.codec.binary.Base64();  
        b=base64.encode(b);  
        String s=new String(b);  
        return s;  
        
    }  
      
    /** 
     *  
     * 创建日期2011-4-25上午10:15:11 
     * 修改日期 
     * 作者：dh     *TODO 使用Base64加密 
     *return 
     */  
    public static byte[] decodeStr(String encodeStr){  
        byte[] b=encodeStr.getBytes();  
        org.apache.commons.codec.binary.Base64 base64=new  org.apache.commons.codec.binary.Base64();  
        b=base64.decode(b);  
        return b;  
    }  

	
}
