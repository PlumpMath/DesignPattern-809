interface Target {
  void Request(); 
}

/* Adaptors */
class Adaptor1 extends Adaptee implements Target {
	public void Request() {
		System.out.println("do the adaptor1 work...");
    SpecificRequest();
	}
}

class Adaptor2 implements Target {
	private Adaptee adaptee = new Adaptee();
	public void Request() {
		System.out.println("do the adaptor2 work...");
    adaptee.SpecificRequest();
	}
}

/* Adaptee */
class Adaptee {
  public void SpecificRequest() {
		System.out.println("send specific request");
	}
}

/* Client */
class Client
{
	private Target _target;
	public Client(Target target) {
		_target = target;
	}
  public void Operation() {
		System.out.println("send request");
    _target.Request();
  }
}


/* Main Entrance */
public class AdaptorMode {
  public static void main(String[] args) {
    Client client;
    if (args.length < 1 || (args.length >= 1 && args[0].equals("1"))) {
      System.out.println("Create a Client using Adaptor1");
      client = new Client(new Adaptor1());
    } else {
      System.out.println("Create a Client using Adaptor2");
      client = new Client(new Adaptor2());
    }
    System.out.println("Client built for Operation.");
    client.Operation();
 }
}
