import java.util.List;
import java.util.ArrayList;

/* Component */
interface Component {
  public void Operation();
}

class Leaf implements Component {
	public void Operation() {
		System.out.println("a leaf component do its operation");
	}
}

class Composite implements Component {
	private List<Component> children = new ArrayList<Component>();
  public void add(Component component) {
    children.add(component);
	}
	public void remove(Component component) {
		children.remove(component);
	}
	public Component getChildren(int index) {
		return children.get(index); 
	}
	public void Operation() {
		System.out.println("a composite component do its operation");
		for(Component child : children) {
			child.Operation();
		}
	}
}

/* Client */
class Client {
	private Component _component;
  public Client(Component component) {
    _component = component;
	}
	public void Operation() {
		_component.Operation();
	}
}

/* Main Entrance */
public class CompositeMode {
  public static void main(String[] args) {
		Composite component = new Composite();
		component.add(new Leaf());
		component.add(new Leaf());
    Composite composite = new Composite();
		composite.add(new Leaf());
		composite.add(new Leaf());
		composite.add(new Leaf());
		component.add(composite);
		component.add(new Leaf());
		Client client = new Client(component);
		client.Operation();
  }
}
