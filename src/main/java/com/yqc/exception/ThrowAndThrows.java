package com.yqc.exception;

public class ThrowAndThrows {
	public static double sqrt(String nStr) throws Exception{
		if(nStr==null)
			throw new Exception("输入的字符不能为空!");
		double n=0;
		try{
			n=Double.parseDouble(nStr);
		}catch(NumberFormatException e){
			throw new Exception("输入的字符串必须转化成数字！",e);
		}
		if(n<0)
			throw new Exception("输入的字符串转化成的数字必须大于0!");
		return Math.sqrt(n);
	}
	public static void main(String[] args)throws Exception{
		try{
			ThrowAndThrows.sqrt("-111");
		}catch(Exception e){
			System.out.println("Got a Exception: "+e.getMessage());
			e.printStackTrace();
			throw e;
		}
		System.out.println();
		ThrowAndThrows.sqrt("-111");
	}
}
