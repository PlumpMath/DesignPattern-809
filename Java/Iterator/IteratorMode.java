import java.util.List;
import java.util.ArrayList;

/* Iterator && Aggregate  */
interface Iterator {
	void First();
	void Next();
	boolean IsDone();
	Item CurrentItem();
}

interface Aggregate {
	Iterator CreateIterator();
}

class Item {
	public int id;
	public Item(int n) {
    id = n;
	}
}

class ConcreteIterator implements Iterator {
	private ConcreteAggregate _aggregate;
	private int index;

	public ConcreteIterator(ConcreteAggregate aggregate) {
	  _aggregate = aggregate;
	}

	public void First() {
    index = 0;
	}

	public void Next() {
		index++;
	}

	public boolean IsDone() {
		return index >= _aggregate.length();
	}

	public Item CurrentItem() {
		return _aggregate.get(index);
	}
}

class ConcreteAggregate implements Aggregate {
  private List<Item> items = new ArrayList<Item>();

	public void add(int n) {
		items.add(new Item(n));
	}

	public Item get(int index) {
		return items.get(index);
	}

	public int length() {
		return items.size();
	}

  public Iterator CreateIterator() {
		return new ConcreteIterator(this);
	}
}

/* Client */
class Client {
	public void operation(Aggregate aggregate) {
		Iterator iter = aggregate.CreateIterator();
		iter.First();
		while(!iter.IsDone()) {
			System.out.println(iter.CurrentItem().id);
			iter.Next();
		}
	}
}

/* Main Entrance */
public class IteratorMode {
  public static void main(String[] args) {
		Client client = new Client();
		ConcreteAggregate aggregate = new ConcreteAggregate();
		aggregate.add(1);
		aggregate.add(2);
		aggregate.add(3);
		aggregate.add(4);
		aggregate.add(5);
		client.operation(aggregate);
  }
}
