package designpattern.factory;

public class SendFactory1 {

    public Sender produce(String type) {
        switch (type) {
            case "mail":
                return new MailSender();
            case "sms":
                return new SmsSender();
            default:
                throw new IllegalArgumentException();

        }
    }
}
