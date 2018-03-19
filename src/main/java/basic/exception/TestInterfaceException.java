package basic.exception;

interface Auto{
	public void Name() throws Exception;
	public void Engine() throws Exception;
}
public class TestInterfaceException implements Auto{
	public void Name() throws TheFirstException{
		throw new TheFirstException("this is test interface!");
	}
	public void Engine(){}
	public static void main(String[] args){
		TestInterfaceException e=new TestInterfaceException();
		try{
			e.Name();
		}catch(TheFirstException n){
			n.printStackTrace();
		}
	}
}
