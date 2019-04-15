package basic.string;

/**
 * StringBuffer public StringBuffer deleteCharAt(int index) public StringBuffer delete(int start,int
 * end)
 *
 * @author yangqc
 */
public class StringBufferDelete {

  public static void main(String[] args) {
    StringBuffer sb = new StringBuffer();
    sb.append("hello").append("world").append("java");
    System.out.println("sb:" + sb);
    // 删除指定位置字符
//		sb.deleteCharAt(1);
//		System.out.println("sb:"+sb);
//		sb.deleteCharAt(1);/
//		System.out.println("sb:"+sb);
    //public StirngBuffer delete(int start,int end)
    //删除范围
//		sb.delete(5, 10);
//		System.out.println("sb:"+sb);
    //删除范围
    sb.delete(0, sb.length());
    System.out.println("sb:" + sb);
  }
}
