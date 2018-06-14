package zm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p>title:</p>
 * <p>description:</p>
 *
 * @author yangqc
 * @date Created in 2018-03-29
 * @modified By yangqc
 */
public class FileOperate {

  private static final String SPLIT = "@";

  private static void operateFile(String filePath) throws IOException {
    // 相对路径，如果没有则要建立一个新的output。txt文件
    File file = new File(filePath);
    // 建立一个输入流对象reader
    InputStreamReader reader = new InputStreamReader(
        new FileInputStream(file));
    BufferedReader br = new BufferedReader(reader);
    System.out.println(file.getName() + "**");
    File writename = new File("C:\\Users\\yangqc\\Desktop\\" + file.getName());
    // 创建新文件
    writename.createNewFile();
    BufferedWriter out = new BufferedWriter(new FileWriter(writename));
    String line = "";
    String[] arrays = null;
    while ((line = br.readLine()) != null) {
      System.out.println(line);
      if (!line.contains("【")) {
        if (arrays != null && arrays.length > 0) {
          for (String s : arrays) {
            if (s != null && !s.equals("")) {
              out.write(s + SPLIT);
            } else {
              out.write("不详" + SPLIT);
            }
          }
          //换行
          out.write("\r\n");
          out.flush();
        }
        arrays = new String[7];
        continue;
      }
      if (line.contains("标题")) {
        arrays[0] = operateTitle(line);
      } else if (line.contains("作者单位")) {
        arrays[2] = operateAuthorCompany(line);
      } else if (line.contains("作者")) {
        arrays[1] = operateAuthor(line);
      } else if (line.contains("出处")) {
        arrays[3] = operateSource(line)[0];
        arrays[4] = operateSource(line)[1];
      } else if (line.contains("国省市名")) {
        arrays[5] = operateProvince(line);
        arrays[6] = getArea(arrays[5]);
      }
    }
    for (String s : arrays) {
      if (s != null && !s.equals("")) {
        out.write(s + SPLIT);
      } else {
        out.write("不详" + SPLIT);
      }
    }
    //换行
    out.write("\r\n");
    out.flush();
    // 最后记得关闭文件
    out.close();
  }

  /**
   * 处理标题
   */
  private static String operateTitle(String content) {
    String names = "";
    String[] contents = content.split(":");
    for (int i = 1; i < contents.length; i++) {
      names += contents[i] + ":";
    }
    names = names.substring(0, names.length() - 1);
    return names;
  }

  private static String operateAuthorCompany(String content) {
    String names = "";
    if (content != null && content.length() > 0) {
      names = content.split(":")[1];
    }
    return names;
  }

  /**
   * 处理作者
   */
  private static String operateAuthor(String content) {
    return content.split(":")[1];
  }

  /**
   * 处理省市
   */
  private static String operateProvince(String content) {
    String[] s = content.split(":");
    if (s.length <= 1) {
      return "不详";
    }
    return s[1];
  }

  /**
   * 处理出处 数组第一个元素是期刊名称，数组第二个元素是年份
   * 一共两个元素
   */
  private static String[] operateSource(String content) {
    String[] arrays = content.split(":");
    if (arrays.length <= 1) {
      return new String[]{"不详", "不详"};
    }
    String s1 = arrays[1];
    String year = "";
    if ((year = s1.split(";")[1]) != null && year.length() > 0) {
      if (year.split("\\.").length > 0) {
        year = year.split("\\.")[0];
      }
    }
    String[] s2 = new String[]{s1.split(";")[0], year};
    return s2;
  }

  private static String getArea(String province) {
    if (province == null) {
      return "不详";
    } else if (province.equals("上海") || province.equals("江苏") || province.equals("浙江") ||
        province.equals("安徽") || province.equals("福建") || province.equals("江西") ||
        province.equals("山东") || province.equals("台湾")
        ) {
      return "华东";
    } else if (province.equals("北京") || province.equals("天津") || province.equals("山西")
        || province.equals("河北") || province.equals("内蒙古")) {
      return "华北";
    } else if (province.equals("四川") || province.equals("贵州") || province.equals("云南") || province
        .equals("重庆") || province.equals("西藏")) {
      return "西南";
    } else if (province.equals("陕西") || province.equals("甘肃") || province.equals("青海") || province
        .equals("宁夏") || province.equals("新疆")) {
      return "西北";
    } else if (province.equals("黑龙江") || province.equals("吉林") || province.equals("辽宁")) {
      return "东北";
    } else if (province.equals("河南") || province.equals("湖北") || province.equals("湖南")) {
      return "华中";
    } else if (province.equals("广东") || province.equals("广西") || province.equals("海南") || province
        .equals("香港") || province.equals("澳门")) {
      return "华南";
    } else if (province.equals("不详")) {
      return "不详";
    } else {
      return "";
    }
  }

  public static void main(String[] args) throws IOException {
    operateFile("C:\\Users\\yangqc\\Desktop\\zm-5.3\\UC中华医学会期刊.txt");
  }
}
