/* Command */
interface Command {
	public void Execute();
}

class ConcreteCommand implements Command {
	private Receiver receiver;
	public String state = "initialized";
  public void Execute() {
		System.out.println("3. command executed.");
		receiver.Action();
    System.out.println("5. command state updated: " + state + " --> done");
		state = "done";
	}
	public ConcreteCommand (Receiver r) {
		receiver = r;
	}
}

/* Invoker */
class Invoker {
	public Command command;
	public void invoke() {
		System.out.println("2. invoker invoke the Command.");
		command.Execute();
	}
	public Invoker(Command c) {
		command = c;
	}
}

/* Receiver */
class Receiver {
	public void Action() {
		System.out.println("4. receiver do the action.");
	}
}

/* Client */
class Client {
	private Receiver receiver = new Receiver();
	public void Operation() {
		Command command = new ConcreteCommand(receiver);
		System.out.println("1. client do operations.");
		Invoker invoker = new Invoker(command);
		invoker.invoke();
	}
}

/* Main Entrance */
public class CommandMode {
  public static void main(String[] args) {
		Client client = new Client();
		client.Operation();
  }
}
