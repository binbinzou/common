package com.wifishared.common.framework.resultobj;

import com.wifishared.common.framework.page.PageInfo;
import lombok.Data;

@Data
public class GeneralPagingResult<T> {

	private int code;
	private String message;
	private PageInfo pageInfo;
	private T content;
	
}
