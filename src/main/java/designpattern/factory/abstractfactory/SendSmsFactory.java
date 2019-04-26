package designpattern.factory.abstractfactory;

import designpattern.factory.Sender;
import designpattern.factory.SmsSender;

/**
 * @author yangqc
 */
public class SendSmsFactory implements Provider {
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
