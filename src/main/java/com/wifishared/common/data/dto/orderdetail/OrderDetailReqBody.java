package com.wifishared.common.data.dto.orderdetail;

import lombok.Data;

@Data
public class OrderDetailReqBody {

	private String wifiData;
	
	private String type;
	
	private String hotSpotId;
	
	private String orderMergerId;
	
	private String deviceId;
	
	private String networkId;
	
}
