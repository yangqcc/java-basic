package basic.io.test1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * ����:
 *    A:��װ����ԴFile
 *    B:��װĿ�ĵ�File
 *    C���ж�File���ļ��л����ļ�
 *
 */
public class CopyFolderDemo {

  public static void main(String[] args) throws IOException {
    File srcFile = new File("MyCopy");
    File destFile = new File("D:\\");
    copyFolder(srcFile, destFile);
  }

  private static void copyFolder(File srcFile, File destFile) throws IOException {
    if (srcFile.isDirectory()) {
      File newFolder = new File(destFile, srcFile.getName());
      newFolder.mkdir();
      File[] fileArray = srcFile.listFiles();
      for (File file : fileArray) {
        copyFolder(file, newFolder);
      }
    } else {
      File newFile = new File(destFile, srcFile.getName());
      copyFile(srcFile, newFile);
    }

  }

  private static void copyFile(File srcFile, File newFile) throws IOException {
    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFile));
    byte[] bys = new byte[1024];
    int len = 0;
    while ((len = bis.read(bys)) != -1) {
      bos.write(bys, 0, len);
    }
    bis.close();
    bos.close();
  }
}
