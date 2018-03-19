package basic.annotation.test;

public class AnnotationsDemo1 {
	
//	@SuppressWarnings("deprecation")                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ngs()
	public static void main(String[] args) {
		System.runFinalizersOnExit(true);
	} 
	
	@Deprecated
	public static void sayHello(){
		System.out.println("hello,qicheng");
	}
	
	@Override
	public String toString(){
		return null;
	}
}
