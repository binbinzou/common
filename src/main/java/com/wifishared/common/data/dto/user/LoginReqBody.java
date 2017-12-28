package com.wifishared.common.data.dto.user;

import java.io.Serializable;

import lombok.Data;

@Data
public class LoginReqBody implements Serializable {

	private String userId;
	
	private String deviceId;
	
	private String phoneNumber;
	
	private String deviceUuid;
	
	private String deviceName;
	
	private String deviceSystem;
	
	private String systemVersion;
	
}
