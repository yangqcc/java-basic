package basic.io.test1;

import java.io.IOException;
import java.io.Reader;

/*
 * ��Readerħ��BufferedReader��readerLine()�Ĺ���
 */
public class MyBufferedReader {

  private Reader r;

  public MyBufferedReader(Reader r) {
    this.r = r;
  }
//	public String readerLine(){
  /*
   * ����һ���ַ���
   * ����r�����ܹ��ṩʲô����
   * ����һ���ַ�������ʲô�����ȽϺ�
   * ʹ���ַ�������������
   */

  //	}
  public void close() throws IOException {
    this.r.close();
  }
}
