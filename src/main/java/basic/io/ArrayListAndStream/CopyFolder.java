package basic.io.ArrayListAndStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * ���Ƶ����ļ���
 * 
 * ����Դ:MyCopy
 * Ŀ�ĵ�:d:CopyFolder
 *   ����:
 *      A:��װĿ¼
 *      B����ȡ��Ŀ¼�µ������ı���File����
 *      C:����File���飬�õ�ÿһ��File����
 */
public class CopyFolder {
	public static void main(String[] args) {
		File srcFolder=new File("MyCopy");
		//��װĿ�ĵ�
		File destFolder=new File("D:\\test");
		if(!destFolder.exists())
			destFolder.mkdir();
		File[] filearray=srcFolder.listFiles();
		
		for(File file:filearray)
		{
			String name=file.getName();
			File newFile=new File(destFolder,name);
			try {
				copyFile(file,newFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void copyFile(File file, File newFile) throws IOException {
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
		BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(newFile));
		byte[] bys=new byte[1024];
		int len=0;
		while((len=bis.read(bys))!=-1)
			bos.write(bys,0,len);
		bis.close();
		bos.close();
	}
}
