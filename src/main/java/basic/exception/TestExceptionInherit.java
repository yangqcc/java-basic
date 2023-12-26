package basic.exception;

class TheFirstException extends Exception{
	private static final long serialVersionUID = 1L;
	public TheFirstException(String s){
		super("Hello");
		System.out.println("The String is "+s);
	}
}
class TheSecondException extends Exception{
	private static final long serialVersionUID = 1L;
}
class TheThirdException extends Exception{
	private static final long serialVersionUID = 1L;
}
class Animal{
	public void N() throws TheFirstException{}
	public void F() throws TheFirstException,TheSecondException{}
	public void G(){};
}
public class TestExceptionInherit extends Animal{
	public void N() throws TheFirstException{
		throw new TheFirstException("���!");
	}
	public void F() throws TheSecondException,TheFirstException{
		throw new TheSecondException();
	}
	public static void main(String[] args) throws TheSecondException, TheFirstException {
		TestExceptionInherit m=new TestExceptionInherit();
		try{
			m.F();
		}catch(TheSecondException e){
			e.printStackTrace();
		}
		try{
			m.N();
		}catch(TheFirstException e){
			e.printStackTrace();
		}
	}
}

