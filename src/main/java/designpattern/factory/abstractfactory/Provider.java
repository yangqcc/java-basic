package designpattern.factory.abstractfactory;


import designpattern.factory.Sender;

public interface Provider {
    public Sender produce();
}

