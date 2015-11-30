/* Prototypes */
class Prototype
{
  protected String _type;
  public Prototype() { setType("Prototype"); }
  public Prototype(Prototype other) { setType(other.getType()); }
  public String getType() { return _type; }
  public void setType(String type) { _type = type; }
  public Prototype Clone() { return new Prototype(this); }
}

class ConcretePrototype1 extends Prototype
{
  public ConcretePrototype1() { setType("ConcretePrototype1"); }
  public ConcretePrototype1(ConcretePrototype1 other) { _type = other.getType(); }
  public ConcretePrototype1 Clone() { return new ConcretePrototype1(this); }
}

class ConcretePrototype2 extends Prototype
{
  public ConcretePrototype2() { setType("ConcretePrototype2"); }
  public ConcretePrototype2(ConcretePrototype2 other) { _type = other.getType(); }
  public ConcretePrototype2 Clone() { return new ConcretePrototype2(this); }
}


/* Client */
class Client
{
  private Prototype _prototype;
  public Client() { this(new Prototype()); }
  public Client(Prototype proto) { _prototype = proto; }
  public void Operation() {
    Prototype p = _prototype.Clone();
    System.out.println("Using " + p.getType() + " created from prototype.");
  }
}


/* Main Entrance */
public class PrototypeMode {
  public static void main(String[] args) {
    Client client;
    if (args.length < 1 || (args.length >= 1 && args[0].equals("1"))) {
      client = new Client(new ConcretePrototype1());
    }
    else {
      client = new Client(new ConcretePrototype2());
    }
    System.out.println("Client built for Operation.");
    client.Operation();
 }
}
