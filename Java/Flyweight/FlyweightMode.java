import java.util.Map;
import java.util.HashMap;

/* Flyweight */
interface Flyweight {
	public void Operation(String extrinsicState);
}

class ConcreteFlyweight implements Flyweight {
	private String id;
	private String intrinsicState;
	public void Operation(String extrinsicState) {
    intrinsicState = "changed intrinsicly";
		System.out.println("ConcreteFlyweight ID: " + id + ", State: " + intrinsicState);
	}
	public ConcreteFlyweight(String key) {
    id = key;
		intrinsicState = "initialized";
		System.out.println("new ConcreteFlyweight built, ID: " + id);
	}
}

class UnsharedConcreteFlyweight implements Flyweight {
	private String id;
	private String allState;
	public void Operation(String extrinsicState) {
		allState = extrinsicState; 
		System.out.println("UnsharedConcreteFlyweight ID: " + id + ", State: " + allState);
	}
	public UnsharedConcreteFlyweight(String key) {
    id = key;
		allState = "initialized";
		System.out.println("new UnsharedConcreteFlyweight built, ID: " + id);
	}
}

/* FlyweightFactory */
class FlyweightFactory {
  private static Map<String, Flyweight> flyweights = new HashMap<String, Flyweight>();
	public static Flyweight getFlyweight(String key) {
     if(flyweights.containsKey(key)) {
			 return flyweights.get(key);
		 } else {
			 Flyweight newFlyweight = new ConcreteFlyweight(key);
			 flyweights.put(key, newFlyweight);
			 return newFlyweight;
		 }
	}
}



/* Client */
class Client {
  public void Operation(String key, boolean shared) {
		Flyweight flyweight;
		if(shared) {
		  flyweight = FlyweightFactory.getFlyweight(key);
		} else {
      flyweight = new UnsharedConcreteFlyweight(key);
		}
    flyweight.Operation("changed extrinsicly");
  }
}


/* Main Entrance */
public class FlyweightMode {
  public static void main(String[] args) {
    Client client = new Client();
    System.out.println("Client built for Operation.");
    client.Operation("1", true);
    client.Operation("2", true);
    client.Operation("1", false);
    client.Operation("2", false);
    client.Operation("1", true);
    client.Operation("2", true);
    client.Operation("1", false);
    client.Operation("2", false);
 }
}
