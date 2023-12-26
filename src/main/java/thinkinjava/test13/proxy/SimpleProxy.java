package thinkinjava.test13.proxy;

public class SimpleProxy implements Interface{
	private Interface proxied;
	public SimpleProxy(Interface proxied){
		this.proxied=proxied;
	}
	@Override
	public void doSomething() {
		System.out.println("SimpleProxy doSomething");
		proxied.doSomething();
	}

	@Override
	public void somethingElse(String args) {
		System.out.println("SimpleProxy doSomething");
		proxied.doSomething();
	}
}
