package com.wifishared.common.data.dto.hotspot;

import lombok.Data;

@Data
public class HotSpotOtherMsg {

	//设备连接数
	private int deviceNum;
	//连接数
	private int connectNum;
	//信号强度
	private double strengthScore;
	//信号速度
	private double speedScore;
	//信号速度
	private double stableScore;
	
}
