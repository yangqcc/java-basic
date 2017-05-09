package com.yqc.io.ArrayListAndStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 复制单级文件夹
 * 
 * 数据源:MyCopy
 * 目的地:d:CopyFolder
 *   分析:
 *      A:封装目录
 *      B：获取该目录下的所有文本的File数组
 *      C:遍历File数组，得到每一个File对象
 */
public class CopyFolder {
	public static void main(String[] args) {
		File srcFolder=new File("MyCopy");
		//封装目的地
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
