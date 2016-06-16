/* state */
interface State {
  void handle();
}

class ConcreteState_0 implements State {
	private static State state = null;
	private ConcreteState_0() {}
	public static State instance() {
		if(state == null) {
      state = new ConcreteState_0();
		}
		return state;
	}
	public void handle() {
		System.out.println("do work under state 0");
	}
}

class ConcreteState_1 implements State {
	private static State state = null;
	private ConcreteState_1() {}
	public static State instance() {
		if(state == null) {
      state = new ConcreteState_1();
		}
		return state;
	}
	public void handle() {
		System.out.println("do work under state 1");
	}
}

class ConcreteState_2 implements State {
	private static State state = null;
	private ConcreteState_2() {}
	public static State instance() {
		if(state == null) {
      state = new ConcreteState_2();
		}
		return state;
	}
	public void handle() {
		System.out.println("do work under state 2");
	}
}

class ConcreteState_3 implements State {
	private static State state = null;
	private ConcreteState_3() {}
	public static State instance() {
		if(state == null) {
      state = new ConcreteState_3();
		}
		return state;
	}
	public void handle() {
		System.out.println("do work under state 3");
	}
}

/* context */
class Context {
	private State state = ConcreteState_0.instance();
	public void request() {
		state.handle();
	}
	public void changeState(State newState) {
		state = newState;
		System.out.println("change the state to " + getState());
	}
	public String getState() {
		return state.getClass().getName();
	}
}

/* Main Entrance */
public class StateMode {
	public static void main(String[] args) {
    Context context = new Context();
		System.out.println("build a context. state: " + context.getState());
		context.request();
		context.changeState(ConcreteState_1.instance());
		context.request();
		context.changeState(ConcreteState_2.instance());
		context.request();
		context.changeState(ConcreteState_3.instance());
		context.request();
	}
}
