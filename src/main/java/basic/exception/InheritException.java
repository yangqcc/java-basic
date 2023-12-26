package basic.exception;

class Sports {
	public Sports() throws TheFirstException{
		throw new TheFirstException("a");
	}
	public static void Name() throws TheFirstException {
	}

	public static void Age() throws TheFirstException, TheSecondException {
		throw new TheFirstException("2");
	}
}

public class InheritException extends Sports {
	public InheritException() throws TheFirstException{
		super();
	}
	public static void Name() throws TheFirstException {
		throw new TheFirstException("���!");
	}

	public static void Age() throws TheSecondException {
		throw new TheSecondException();
	}

	public static void main(String[] args) {
		try {
			InheritException.Age();
		} catch (TheSecondException e) {
			e.printStackTrace();
		}
	}
}
