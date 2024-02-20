package zm;

/**
 * Created by yangqc on 2017/10/22
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author yangqc
 * @Date 2017/7/23
 */
public class JdbcOperate {

  /**
   * 获取数据库链接
   */
  private static Connection getConnection() {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/zm?characterEncoding=utf8&useSSL=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String username = "root";
    String password = "123";
    Connection conn = null;
    try {
      //classLoader,加载对应驱动
      Class.forName(driver);
      conn = DriverManager.getConnection(url, username, password);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return conn;
  }

  private static int insert(List<ModelClass> list, String tableName) {
    Connection conn = getConnection();
    try {
      conn.setAutoCommit(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    int i = 0;
    String sql = String.format(
        "insert into %s (date,title,author,periodical,region,province,address1,address2,address3,address4) "
            + "values(?,?,?,?,?,?,?,?,?,?)",
        tableName);
    PreparedStatement pstmt;
    try {
      String provice = "";
      pstmt = conn.prepareStatement(sql);
      for (ModelClass modelClass : list) {
        String name = modelClass.getAuthor();
        String[] names = name.split(";");
        for (String n : names) {
          pstmt.setString(1, new SimpleDateFormat("yyyy").format(modelClass.getDate()));
          pstmt.setString(2, modelClass.getTitle());
          String address1 = modelClass.getAddress1();
          String province = getProvince(address1);
          System.out.println(address1);
          pstmt.setString(3, n);
          pstmt.setString(4, modelClass.getPeriodical());
          pstmt.setString(5, getRegionEnglish(province));
          pstmt.setString(6, getProvince(address1));
         /* if (address1 != null && !address1.equals("")) {
            String[] split = address1.split(",");
            if (split.length > 1) {
              address1 = split[0];
            }
            String[] split1 = address1.split("\\)");
            if (split1.length > 1) {
              address1 = split1[1];
            }
            String[] split2 = address1.split(":");
            if (split2.length > 1) {
              address1 = split2[1];
            }
            String[] split3 = address1.split("，");
            if (split3.length > 1) {
              address1 = split3[1];
            }
          }*/
          pstmt.setString(7, address1);
          pstmt.setString(8, modelClass.getAddress2());
          pstmt.setString(9, modelClass.getAddress3());
          pstmt.setString(10, modelClass.getAddress4());
          pstmt.addBatch();
          i++;
          if (i / 1000 == 0) {
            pstmt.executeBatch();
            //  System.out.println("提交");
          }
        }
      }
      pstmt.executeBatch();
      conn.commit();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return i;
  }

  private static final String[] provinces = new String[]{
      "上海", "江苏", "浙江", "安徽", "福建", "江西", "山东", "台湾"
      , "北京", "天津", "山西", "河北", "内蒙古", "四川", "贵州", "云南", "重庆", "西藏", "陕西", "甘肃", "青海"
      , "宁夏", "新疆", "黑龙江", "湖北", "吉林", "辽宁", "河南", "湖南", "广西", "广东", "海南", "香港", "澳门"};


  private static final String[] provincesEnglish = new String[]
      {"anhui", "beijing", "chongqing",
          "fujian", "gansu", "guangdong",
          "guangxi", "guizhou", "hainan", "hebei", "heilongjiang",
          "henan", "hongkong", "hubei", "hunan", "jiangsu", "jiangxi", "jilin",
          "liaoning", "macao", "qinghai", "shaanxi", "shandong", "shanghai", "shanxi",
          "sichuan", "taiwan", "tianjin", "xinjiang", "yunnan", "zhejiang", "neimenggu", "xizang",
          "ningxia"};

  private static String getProvince(String address) {
    if (address != null) {
      address = address.toLowerCase();
      for (String s : provincesEnglish) {
        if (address.contains(s)) {
          return s;
        }
      }
    }
    return "";
  }


  private static String getRegion(String province) {
    if (province == null) {
      return "不详";
    } else if (province.contains("上海") || province.contains("江苏") || province.contains("浙江") ||
        province.contains("安徽") || province.contains("福建") || province.contains("江西") ||
        province.contains("山东") || province.contains("台湾")
    ) {
      return "华东";
    } else if (province.contains("北京") || "天津".equals(province) || "山西".equals(province)
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

  /**
   * 获取英文的省
   */
  private static String getRegionEnglish(String province) {
    province = province.toLowerCase();
    if (province == null) {
      return "不详";
    } else if (province.contains("shanghai") || province.contains("jiangsu") || province
        .contains("zhejiang") ||
        province.contains("anhui") || province.contains("fujian") || province.contains("jiangxi") ||
        province.contains("shandong") || province.contains("taiwan")
    ) {
      return "华东";
    } else if (province.contains("beijing") || "tianjin".equals(province) || "shanxi"
        .equals(province)
        || "hebei".equals(province) || "neimenggu".equals(province)) {
      return "华北";
    } else if ("sichuan".equals(province) || "guizhou".equals(province) || "yunnan".equals(province)
        || "chongqing"
        .equals(province) || "xizang".equals(province)) {
      return "西南";
    } else if ("shaanxi".equals(province) || "gansu".equals(province) || "qinghai".equals(province)
        || "ningxia"
        .equals(province) || "xinjiang".equals(province)) {
      return "西北";
    } else if ("heilongjiang".equals(province) || "jilin".equals(province) || "liaoning"
        .equals(province)) {
      return "东北";
    } else if ("henan".equals(province) || "hubei".equals(province) || "hunan".equals(province)) {
      return "华中";
    } else if ("guangdong".equals(province) || "guangxi".equals(province) || "hainan"
        .equals(province)
        || "hongkong"
        .equals(province) || "macao".equals(province)) {
      return "华南";
    } else if ("不详".equals(province)) {
      return "不详";
    } else {
      return "";
    }
  }

  private static List<ModelClass> getAll(String tableName) {
    Connection conn = getConnection();
    String sql = String.format("select * from %s", tableName);
    PreparedStatement ps;
    List<ModelClass> resultList = new ArrayList<>();
    try {
      ps = conn.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      int col = rs.getMetaData().getColumnCount();
      while (rs.next()) {
        Object value;
        ModelClass modelClass = new ModelClass();
        for (int i = 1; i <= col; i++) {
          String columnName = rs.getMetaData().getColumnName(i);
          String methodName = "set" + firstCharToUpperCase(columnName);
          Method method = modelClass.getClass()
              .getMethod(methodName, modelClass.getClass().getDeclaredField(columnName).getType());
          if (columnName.equals("date")) {
            value = rs.getDate(i);
            method.invoke(modelClass, (Date) value);
          } else if (columnName.equals("id")) {
            value = rs.getInt(i);
            method.invoke(modelClass, (Integer) value);
          } else {
            value = rs.getString(i);
            method.invoke(modelClass, (String) value);
          }
        }
        resultList.add(modelClass);
      }
    } catch (SQLException | NoSuchMethodException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchFieldException e) {
      e.printStackTrace();
    }
    return resultList;
  }

  public static String firstCharToUpperCase(String str) {
    char[] chars = str.toCharArray();
    chars[0] -= 32;
    return String.valueOf(chars);
  }

  public static void main(String[] args) {
    String[] tables = new String[]{"eg"};
    Arrays.stream(tables).forEach(table -> {
      List<ModelClass> list = getAll(table);
      insert(list, "eg_copy");
    });
  }
}
