/* Colleege */
class Colleague {
	protected Mediator _mediator;
  public void regist(Mediator mediator) {
		_mediator = mediator;
	}
}

class ConcreteColleague extends Colleague {
	public int id;
	public void sendMsg(int target) {
		System.out.println(">>> Request: Colleague No." + id + " send a message to the mediator.");
    _mediator.sendMsg(target);
	}

	public ConcreteColleague(int n) {
		id = n;
	}
}

/* Mediator */
interface Mediator {
	void sendMsg(int target);
}

class ConcreteMediator implements Mediator {
	public void sendMsg(int target) {
    System.out.println(">>> Response: the mediator send the message to Colleague No." + target + ".");
	}
}

/* Main Entrance */
public class MediatorMode {
  public static void main(String[] args) {
		ConcreteColleague c1 = new ConcreteColleague(1);
		ConcreteColleague c2 = new ConcreteColleague(2);
		ConcreteColleague c3 = new ConcreteColleague(3);
		ConcreteColleague c4 = new ConcreteColleague(4);
		ConcreteColleague c5 = new ConcreteColleague(5);
		ConcreteMediator mediator = new ConcreteMediator(); 
		c1.regist(mediator);
		c2.regist(mediator);
		c3.regist(mediator);
		c4.regist(mediator);
		c5.regist(mediator);
		c1.sendMsg(3);
		c2.sendMsg(4);
		c3.sendMsg(5);
		c4.sendMsg(1);
		c5.sendMsg(2);
  }
}
