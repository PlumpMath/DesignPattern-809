/* Memento */
class Memento {
	private String _state;
	public String getState() {
		return _state;
	}
	public void setState(String newState) {
		_state = newState;
	}
	public Memento(String state) {
    _state = state;
	}
}

/* Originator */
class Originator {
  private String state = "initialized";
	public Memento createMemento() {
		return new Memento(state);
	}
	public void setMemento(Memento m) {
		state = m.getState();
	}
	public String getState() {
     return state;
	}
	public void setState(String newState) {
		state = newState;
	}
}

/* Caretaker */
class Caretaker {
	public Memento memento;
}

/* Main Entrance */
public class MementoMode {
  public static void main(String[] args) {
		Originator originator = new Originator();
		originator.setState("before changed");
		System.out.println("At first the originator state: " + originator.getState());
		System.out.println("We use a caretaker to keep a memento.");
		Caretaker caretaker = new Caretaker();
		caretaker.memento = originator.createMemento();
		System.out.print("Then we do something ");
		originator.setState("after changed");
		System.out.println("and the originator state: " + originator.getState());
    originator.setMemento(caretaker.memento);
		System.out.println("By using a memento, the originator state is recovered: " + originator.getState());
	}
}
