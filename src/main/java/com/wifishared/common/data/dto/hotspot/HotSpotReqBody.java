package com.wifishared.common.data.dto.hotspot;

import lombok.Data;

@Data
public class HotSpotReqBody {

	/**
	 * 热点名称
	 */
	private String ssid;
	
	/**
	 * 物理地址
	 */
	private String bssid;
	
	/**
	 * 热点密码
	 */
	private String password;
	
	/**
	 * 经度
	 */
	private String lng;
	
	/**
	 * 纬度
	 */
	private String lat;
	
	/**
	 * 热点类型
	 */
	private String hotSpotType;
	
	/**
	 * 计费模式
	 */
	private String charingModule;
	
	/**
	 * 计费标准
	 */
	private String charingStandard;
	
	/**
	 * 热点描述
	 */
	private String descrition;
	
	@Override
	public String toString() {
		return "HotSpotReqBody [ssid=" + ssid + ", bssid=" + bssid + ", password=" + password + ", lng=" + lng
				+ ", lat=" + lat + ", hotSpotType=" + hotSpotType + ", charingModule=" + charingModule
				+ ", charingStandard=" + charingStandard + ", descrition=" + descrition + "]";
	}
	
	
	
	
}
