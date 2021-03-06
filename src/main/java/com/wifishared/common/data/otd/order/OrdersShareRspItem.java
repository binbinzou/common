package com.wifishared.common.data.otd.order;

import com.wifishared.common.data.otd.hotspot.HotSpotRspBody;

import lombok.Data;

@Data
public class OrdersShareRspItem {

	private String id;
	
	private String hotSpotId;
	
	private HotSpotRspBody hotSpotRspBody;
	
	private String networkId;
	
	private String wifiDataUseage;
	
	private String saveMoney;
	
	private String spendMoney;
	
	private String beginTime;
	
	private String endTime;
	
	private String spendTime;
	
	private String userPhoneNumber;
	
	private String deviceSystem;
	
	private String systemVersion;
	
	private boolean commented;
	
}
