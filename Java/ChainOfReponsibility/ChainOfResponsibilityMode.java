/* Handler */
abstract class Handler {
	public Handler successor = null;
	abstract public void HandleRequest();
}

class ConcreteHandler1 extends Handler {
	@Override
	public void HandleRequest() {
		System.out.println("do work of handler1.");
	}
}

class ConcreteHandler2 extends Handler {
	@Override
	public void HandleRequest() {
		System.out.println("do work of handler2.");
	}
}

class ConcreteHandler3 extends Handler {
	@Override
	public void HandleRequest() {
		System.out.println("do work of handler3.");
	}
}

/* Client */
class Client {
	public void Operation(Handler handler) {
		Handler curHandler = handler;
    while(curHandler != null) {
			curHandler.HandleRequest();
			curHandler = curHandler.successor;
		}
	}
}

/* Main Entrance */
public class ChainOfResponsibilityMode {
  public static void main(String[] args) {
		ConcreteHandler1 hdl1 = new ConcreteHandler1();
		ConcreteHandler2 hdl2 = new ConcreteHandler2();
		ConcreteHandler3 hdl3 = new ConcreteHandler3();
		hdl1.successor = hdl2;
		hdl2.successor = hdl3;
		Client client = new Client();
		client.Operation(hdl1);
  }
}
