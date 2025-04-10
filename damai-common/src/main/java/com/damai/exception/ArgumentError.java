package com.damai.exception;

import lombok.Data;

/**
 * @program:
 * @description: 参数错误
 * @author:  旷智仁
 **/
@Data
public class ArgumentError {
	
	private String argumentName;
	
	private String message;
}
