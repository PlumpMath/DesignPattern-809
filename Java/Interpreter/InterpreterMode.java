import java.util.Scanner;

abstract class AbstractExpression {
	protected String ss;
	abstract public void interpret();
}

class NonterminalExpression extends AbstractExpression {
	@Override
	public void interpret() {
		System.out.println("interprete num-terminal expression: " + ss);
		String subexp[] = ss.split(",");
		TerminalExpression te;
		for(String s : subexp) {
			te = new TerminalExpression(s);
			te.interpret();
		}
	}
	public NonterminalExpression(String input) {
		ss = input;
	}
}

class TerminalExpression extends AbstractExpression {
	@Override
	public void interpret() {
		System.out.println("interprete terminal expression: " + ss);
	}
	public TerminalExpression(String input) {
		ss = input;
	}
}

/* Context */
class Context {
	private String state = "<info about Interpreter>";
	public String getInfo() {
		return state;
	}
}

/* Client */
class Client {
	private Context ctx = new Context();
	public void interpret(String input) {
		System.out.println("use " + ctx.getInfo());
		AbstractExpression exp = new NonterminalExpression(input);
		exp.interpret();
	}
}

/* Main Entrance */
public class InterpreterMode {
  public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Input: ");
		Client client = new Client();
		client.interpret(sc.next());
  }
}
