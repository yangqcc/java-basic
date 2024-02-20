package designpattern.factory.abstractfactory;


import designpattern.factory.Sender;

/**
 * @author yangqc
 */
public interface Provider {

    /**
     * @return
     */
    Sender produce();
}

