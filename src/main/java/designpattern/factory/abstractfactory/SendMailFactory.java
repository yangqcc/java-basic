package designpattern.factory.abstractfactory;

import designpattern.factory.MailSender;
import designpattern.factory.Sender;

/**
 * @author yangqc
 */
public class SendMailFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
