package basic.exception;

public class ThrowAndThrows {

  public static double sqrt(String nStr) throws Exception {
    if (nStr == null) {
      throw new Exception("������ַ�����Ϊ��!");
    }
    double n = 0;
    try {
      n = Double.parseDouble(nStr);
    } catch (NumberFormatException e) {
      throw new Exception("������ַ�������ת�������֣�", e);
    }
    if (n < 0) {
      throw new Exception("������ַ���ת���ɵ����ֱ������0!");
    }
    return Math.sqrt(n);
  }

  public static void main(String[] args) throws Exception {
    try {
      ThrowAndThrows.sqrt("-111");
    } catch (Exception e) {
      System.out.println("Got a Exception: " + e.getMessage());
      e.printStackTrace();
      throw e;
    }
    System.out.println();
    ThrowAndThrows.sqrt("-111");
  }
}
