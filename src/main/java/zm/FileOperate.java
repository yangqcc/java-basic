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
        if (arrays != null) {
          for (String s : arrays) {
            if (s != null && !"".equals(s)) {
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
    StringBuilder names = new StringBuilder();
    String[] contents = content.split(":");
    for (int i = 1; i < contents.length; i++) {
      names.append(contents[i]).append(":");
    }
    names = new StringBuilder(names.substring(0, names.length() - 1));
    return names.toString();
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
   * 处理出处 数组第一个元素是期刊名称，数组第二个元素是年份 一共两个元素
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
    } else if ("上海".equals(province) || "江苏".equals(province) || "浙江".equals(province) ||
        "安徽".equals(province) || "福建".equals(province) || "江西".equals(province) ||
        "山东".equals(province) || "台湾".equals(province)
    ) {
      return "华东";
    } else if ("北京".equals(province) || "天津".equals(province) || "山西".equals(province)
        || "河北".equals(province) || "内蒙古".equals(province)) {
      return "华北";
    } else if ("四川".equals(province) || "贵州".equals(province) || "云南".equals(province) || "重庆"
        .equals(province) || "西藏".equals(province)) {
      return "西南";
    } else if ("陕西".equals(province) || "甘肃".equals(province) || "青海".equals(province) || "宁夏"
        .equals(province) || "新疆".equals(province)) {
      return "西北";
    } else if ("黑龙江".equals(province) || "吉林".equals(province) || "辽宁".equals(province)) {
      return "东北";
    } else if ("河南".equals(province) || "湖北".equals(province) || "湖南".equals(province)) {
      return "华中";
    } else if ("广东".equals(province) || "广西".equals(province) || "海南".equals(province) || "香港"
        .equals(province) || "澳门".equals(province)) {
      return "华南";
    } else if ("不详".equals(province)) {
      return "不详";
    } else {
      return "";
    }
  }

  public static void main(String[] args) throws IOException {
    operateFile("C:\\Users\\yangqc\\Desktop\\zm-5.3\\UC中华医学会期刊.txt");
  }
}
