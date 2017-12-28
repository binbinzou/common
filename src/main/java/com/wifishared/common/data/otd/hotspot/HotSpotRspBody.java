package com.wifishared.common.data.otd.hotspot;


import lombok.Data;

@Data
public class HotSpotRspBody {

	private String id;
	
	private String advertisement;

	private String bssid;

	private String charingModule;

	private String charingStandard;

	private String description;

	private String hotspotType;

	private String password;

	private String ssid;
	
	private String lng;
	
	private String lat;
	
	private String publicCert;

}
