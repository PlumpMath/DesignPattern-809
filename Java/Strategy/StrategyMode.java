import java.util.Scanner;

/* strategy */
interface Strategy {
  void algorithmInterface();
}

class ConcreteStrategyA implements Strategy {
	private static Strategy strategy = null;
	private ConcreteStrategyA() {}
	public static Strategy instance() {
		if(strategy == null) {
      strategy = new ConcreteStrategyA();
		}
		return strategy;
	}
	public void algorithmInterface() {
		System.out.println("run the algorithm using strategy A");
	}
}

class ConcreteStrategyB implements Strategy {
	private static Strategy strategy = null;
	private ConcreteStrategyB() {}
	public static Strategy instance() {
		if(strategy == null) {
      strategy = new ConcreteStrategyB();
		}
		return strategy;
	}
	public void algorithmInterface() {
		System.out.println("run the algorithm using strategy B");
	}
}

class ConcreteStrategyC implements Strategy {
	private static Strategy strategy = null;
	private ConcreteStrategyC() {}
	public static Strategy instance() {
		if(strategy == null) {
      strategy = new ConcreteStrategyC();
		}
		return strategy;
	}
	public void algorithmInterface() {
		System.out.println("run the algorithm using strategy C");
	}
}

/* context */
class Context {
	private Strategy _strategy = ConcreteStrategyA.instance();
	public void contextInterface() {
		System.out.println("call the context interface");
		_strategy.algorithmInterface();
	}
	public void setStrategy(Strategy strategy) {
		_strategy = strategy;
		System.out.println("set the current strategy: " + getstrategy());
	}
	public String getstrategy() {
		return _strategy.getClass().getName();
	}
}

/* Main Entrance */
public class StrategyMode {
	public static void main(String[] args) {
    Context context = new Context();
		System.out.println("build a context.");
		System.out.println("choose a strategy: A, B or C ?");
		System.out.print("your choice: ");
		Scanner sc = new Scanner(System.in);
		switch(sc.next()) {
			case "A": 
				context.setStrategy(ConcreteStrategyA.instance());
				break;
			case "B": 
				context.setStrategy(ConcreteStrategyB.instance());
				break;
			default: 
				context.setStrategy(ConcreteStrategyC.instance());
		}
		context.contextInterface();
	}
}
