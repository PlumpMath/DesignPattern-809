/* Subject*/
interface Subject {
  public void Request();
}

class RealSubject implements Subject {
	public void Request() {
		System.out.println("do the request");
	}
}

class Proxy implements Subject {
	private RealSubject realSubject = new RealSubject();
	public void Request() {
		System.out.println("send the request via a proxy");
		realSubject.Request();
	}
}

/* Client */
class Client {
	private Subject subject = new Proxy();
	public void Operation() {
    subject.Request();
	}
}

/* Main Entrance */
public class ProxyMode {
  public static void main(String[] args) {
    Client client = new Client();
		client.Operation();
  }
}
