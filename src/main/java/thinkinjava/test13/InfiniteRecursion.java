package thinkinjava.test13;
/*
 * toString递归调用,注意，如果打印内存地址，应该用super.toString();
 */
import java.util.ArrayList;
import java.util.List;

public class InfiniteRecursion {
	public String toString(){
//		return "InfiniteRecursion address:"+this+"\n";  //这里会照成递归调用，产生堆栈溢出
		return "InfiniteRecursion address:"+super.toString();
	}
	public static void main(String[] args) {
		List<InfiniteRecursion> v=new ArrayList<InfiniteRecursion>();
		for(int i=0;i<10;i++){
			v.add(new InfiniteRecursion());
		}
		System.out.println(v);
	}
}
