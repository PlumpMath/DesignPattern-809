/* Component */
interface Component {
	public void Operation();
}

class ConcreteComponent implements Component {
	public void Operation() {
		System.out.println("do specific operation.");
	}
}

/* Decorator*/
class Decorator implements Component {
  protected Component component = new ConcreteComponent();
	public void Operation() {
		component.Operation();
	}
}

class ConcreteDecoratorA extends Decorator {
	@Override
	public void Operation() {
		component.Operation();
		AddedBehavior();
	}
	private void AddedBehavior() {
		System.out.println("do added behavior.");
	}
}

class ConcreteDecoratorB extends Decorator {
	@Override
	public void Operation() {
		component.Operation();
		UpdateAddedState();
	}
	private String state = "initialized";
	private void UpdateAddedState() {
		state = "updated";
		System.out.println("update added behavior: " + state);
	}
}

/* Main Entrance */
public class DecoratorMode {
  public static void main(String[] args) {
    Decorator decorator;
    if (args.length < 1 || (args.length >= 1 && args[0].equals("A"))) {
      decorator = new ConcreteDecoratorA();
    } else {
      decorator = new ConcreteDecoratorB();
    }
    decorator.Operation();
  }
}
