package basic.string;

/**
 * StringBuffer��ת����
 *   public StringBuffer reverse()
 *
 * ��ȡ����:ע�ⷵ��ֵ���Ͳ�����StringBuffer������String��
 *   public String substring(int start);
 *   public String substring(int start,int end);
 */
public class StringBufferReplace {

  public static void main(String[] args) {
    StringBuffer sb = new StringBuffer();
    sb.append("½���Ұ���");
    System.out.println("sb:" + sb);
    sb.reverse();
    System.out.println("sb:" + sb);
    //����StringBuffer
    StringBuffer sb2 = new StringBuffer();
    sb2.append("hello").append("world").append("java");
    String s = sb2.substring(5);
    System.out.println("sb2:" + sb2);
    System.out.println("s:" + s);
    String ss = sb2.substring(5, 10);
    System.out.println(ss);
  }
}
