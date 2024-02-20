package basic.io.copyfolder;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * ���󣺸����ƶ�Ŀ¼�µ��ƶ��ļ������޸ĺ�׺�� ָ���ļ���:.java�ļ� �ƶ���׺����:.jad
 *
 * �ȸ����ļ�����Ŀ�ĵ�Ŀ¼�¸���
 *
 * @author yangqc
 */
public class CopyFolder {

  public static void main(String[] args) throws IOException {
    File srcFolder = new File("MyCopy");
    File destFolder = new File("d:\\jad");
    if (!destFolder.exists()) {
      destFolder.mkdir();
    }

    File[] fileArray = srcFolder.listFiles(new FilenameFilter() {
      @Override
      public boolean accept(File dir, String name) {
        return new File(dir, name).isFile() && name.endsWith(".java");
      }
    });
    for (File file : fileArray) {
      String name = file.getName();
      File newFile = new File(destFolder, name);
      copyFile(file, newFile);
    }
    File[] destFileArray = destFolder.listFiles();
    for (File destFile : destFileArray) {
      String name = destFile.getName();
      String newName = name.replace(".java", ".jad");
      File newFile = new File(destFolder, newName);
      destFile.renameTo(newFile);
    }
  }

  private static void copyFile(File file, File newFile) throws IOException {
    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
        file));
    BufferedOutputStream bos = new BufferedOutputStream(
        new FileOutputStream(newFile));
    byte[] bys = new byte[1024];
    int len = 0;
    while ((len = bis.read(bys)) != -1) {
      bos.write(bys, 0, len);
    }
    bis.close();
    bos.close();
  }
}
