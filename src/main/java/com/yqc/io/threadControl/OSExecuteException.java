package com.yqc.io.threadControl;

/**
 * 自定义异常
 * 
 * @author yangqc 2016.6.1 我记得高一都还在过儿童节
 */
public class OSExecuteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OSExecuteException(String why) {
		super(why);
	}
}
