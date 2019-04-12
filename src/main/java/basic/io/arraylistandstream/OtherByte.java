package basic.io.arraylistandstream;

import java.io.FileInputStream;
import java.io.IOException;

public class OtherByte {
	public static void main(String[] args) throws IOException {
		FileInputStream f=new FileInputStream("b.txt");
//		int ch=0;
		byte[] bys=new byte[1024];
		int len=0;
		while((len=f.read(bys))!=-1)
			System.out.print(new String(bys,0,len));
	}
}
