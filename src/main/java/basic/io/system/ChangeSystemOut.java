package basic.io.system;

import java.io.PrintWriter;

public class ChangeSystemOut {

  public static void main(String[] args) {
    PrintWriter out = new PrintWriter(System.out, true);
    out.print("Hello,word!");
    System.out.println(out.checkError());
    out.close();
  }
}
