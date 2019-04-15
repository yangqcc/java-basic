package designpattern.factory;

/**
 * 静态工厂方法
 */
public class SendFactory3 {

  public static Sender produceMail() {
    return new MailSender();
  }

  public static Sender produceSms() {
    return new SmsSender();
  }
}
