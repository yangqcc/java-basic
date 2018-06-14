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
    String url = "jdbc:mysql://localhost:3306/zm?characterEncoding=utf8&useSSL=true";
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
        "insert into %s (title,author,unit,periodical,time,number,place,region,ishospital) values(?,?,?,?,?,?,?,?,?)",
        tableName);
    PreparedStatement pstmt;
    try {
      pstmt = conn.prepareStatement(sql);
      for (ModelClass modelClass : list) {
        String name = modelClass.getAuthor();
        String[] names = name.split(";");
        for (String n : names) {
          pstmt.setString(1, modelClass.getTitle());
          pstmt.setString(2, n);
          pstmt.setString(3, null);
          pstmt.setString(4, modelClass.getPeriodical());
          pstmt.setString(5, new SimpleDateFormat("yyyy").format(modelClass.getTime()));
          pstmt.setString(6, modelClass.getNumber());
          pstmt.setString(7, modelClass.getPlace());
          pstmt.setString(8, modelClass.getRegion());
          pstmt.setString(9, modelClass.getIshospital());
          pstmt.addBatch();
          i++;
          if (i / 1000 == 0) {
            pstmt.executeBatch();
            System.out.println("提交");
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
          if (columnName.equals("time")) {
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
    String[] tables = new String[]{"qbwx", "hxqk", "zhyxhqk", "xzwx"};
    Arrays.stream(tables).forEach(table -> {
      List<ModelClass> list = getAll(table);
      insert(list, table + "_author");
    });
  }
}
