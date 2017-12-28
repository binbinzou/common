package com.wifishared.common.framework.page;

import lombok.Data;

@Data
public class PageInfo {

	//当前页数
	private int page;
	//当前页数数量
	private int count;
	//总页数
	private int totalpage;
	//数据总数
	private int totalcount;
	
}
