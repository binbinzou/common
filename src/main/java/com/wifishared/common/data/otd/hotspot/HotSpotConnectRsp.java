package com.wifishared.common.data.otd.hotspot;

import lombok.Data;

@Data
public class HotSpotConnectRsp {

	private String id;

	private int connectNum;

	private String deviceId;

	private String hotspotconfigId;

	private String userId;
	
}
