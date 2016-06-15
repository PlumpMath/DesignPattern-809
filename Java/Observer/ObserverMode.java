import java.util.List;
import java.util.LinkedList;

/* Subjects */
class Subject {
  private List<Observer> observers = new LinkedList<Observer>();
	public void attach(Observer o) {
		observers.add(o);
	}
	public void detach(Observer o) {
		observers.remove(o);
	}
	public void Notify() {
		for(Observer o : observers) {
			o.update();
		}
	}
}

class ConcreteSubject extends Subject {
	private String subjectState = "before operation";
	public String getState() {
		return subjectState;
	}
	public void setState(String state) {
		subjectState = state;
	}
	public void operation() {
		subjectState = "after operation";
		Notify();
	}
}

/* Observer */
interface Observer {
	void update();
}

class ConcreteObserver implements Observer {
	private static int totalNums = 0;
	private ConcreteSubject _subject;
	private String observerState;
	public int id;
	public void update() {
		observerState = _subject.getState();
	}
	public String getState() {
		return observerState;
	}
  public ConcreteObserver(ConcreteSubject subject) {
		_subject = subject;
		update();
		id = totalNums++;
	}
}

/* Main Entrance */
public class ObserverMode {
  public static void main(String[] args) {
    ConcreteSubject subject = new ConcreteSubject();
		System.out.println("1.create a subject. (subject state: " + subject.getState() + ")");
		System.out.println("2.add three observers: ");
		ConcreteObserver o1 = new ConcreteObserver(subject);
		ConcreteObserver o2 = new ConcreteObserver(subject);
		ConcreteObserver o3 = new ConcreteObserver(subject);
		subject.attach(o1);
		System.out.println("  - observer #" + o1.id + " added. (observer state: " + o1.getState() + ")");
		subject.attach(o2);
		System.out.println("  - observer #" + o2.id + " added. (observer state: " + o2.getState() + ")");
		subject.attach(o3);
		System.out.println("  - observer #" + o3.id + " added. (observer state: " + o3.getState() + ")");
		subject.operation();
		System.out.println("3.do something and change the subject's state. (subject state: " + subject.getState() + ")");
		System.out.println("  - observer #" + o1.id + " notified. (observer state: " + o1.getState() + ")");
		System.out.println("  - observer #" + o2.id + " notified. (observer state: " + o2.getState() + ")");
		System.out.println("  - observer #" + o3.id + " notified. (observer state: " + o3.getState() + ")");
	}
}
