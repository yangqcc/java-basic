package basic.math.SystemTest;

import java.util.Arrays;

/*
 * public static void arraycopy(Object src,int srcPos,Object dest,int destPos int length)
 * ע�ⷽ����
 * ��ָ��Դ�����и���һ�����飬���ƴ�ָ����λ�ÿ�ʼ����Ŀ�������ָ��λ�ý���
 * 
 * src Դ���飬srcPos���������е���ʼλ��
 * destĿ������
 * destPosĿ���������ʼλ��
 * lengthҪ���Ƶ�����Ԫ�ص�����
 * 2015.10.2
 */
public class SystemDemo3 {
	public static void main(String[] args) {
		//��������
		int [] arr={11,22,33,44,55};
		int [] arr2={6,7,8,9,10};
		System.arraycopy(arr, 1, arr2, 2, 2);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));//ע���Դ���鸴�Ƶ�Ŀ������
	}
}
