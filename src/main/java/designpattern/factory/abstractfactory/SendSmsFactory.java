package designpattern.factory.abstractfactory;

import designpattern.factory.Sender;
import designpattern.factory.SmsSender;

public class SendSmsFactory implements Provider {
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
