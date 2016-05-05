/* ImpFactory */
class ImpFactory {
  public static Implementor makeImp(String mode) {
    switch (mode) {
     case "A": return new ConcreteImplementorA();
     case "B": return new ConcreteImplementorB();
     default: return null;
    }
  }
}

/* Implementors */
interface Implementor {
  public void OperationImpl(); 
}

class ConcreteImplementorA implements Implementor {
  public void OperationImpl() {
     System.out.println("Implementor A: do the specific part of the Operation");
  }
}

class ConcreteImplementorB implements Implementor {
  public void OperationImpl() {
     System.out.println("Implementor B: do the specific part of the Operation");
  }
}

/* Abstraction */
class Abstraction {
  Implementor impl;

  public void Operation() {
     System.out.println("do the abstraction part of the Operation");
     impl.OperationImpl();
  }
  
  public Implementor getImp() {
    return ImpFactory.makeImp("A");
  }

	public Abstraction() {
    impl = getImp();
	}
}

class RefinedAbstraction extends Abstraction {
  @Override
  public void Operation() {
     System.out.println("do the refined abstraction part of the Operation");
     impl.OperationImpl();
  }

  @Override
  public Implementor getImp() {
    return ImpFactory.makeImp("B");
  }

	public RefinedAbstraction() {
    impl = getImp();
	}
}

/* Client */
class Client {
  private Abstraction abstraction = null;
  public void doOperation() {
    abstraction.Operation();
  }
  public Client(String mode) {
    switch(mode) {
     case "A": abstraction = new Abstraction(); break;
     case "B": abstraction = new RefinedAbstraction(); break;
    }
  }
}

/* Main Entrance */
public class BridgeMode {
  public static void main(String[] args) {
    Client client;
    if (args.length < 1 || (args.length >= 1 && args[0].equals("A"))) {
      client = new Client("A");
    } else {
      client = new Client("B");
    }
    client.doOperation();
  }
}
