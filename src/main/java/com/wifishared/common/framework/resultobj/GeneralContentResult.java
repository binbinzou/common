package com.wifishared.common.framework.resultobj;

import lombok.Data;

@Data
public class GeneralContentResult<T> {

	private int code;
	private String message;
	private T content;
	
}
