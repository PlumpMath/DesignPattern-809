/* Products */
class Product
{
  protected String type;
  public Product() { type = "default"; }
  public String getType() { return type; }
}

class ConcreteProduct extends Product
{
  public ConcreteProduct() { type = "concrete"; }
}


/* Creators */
class Creator
{
  public Product factoryMethod() { return new Product(); }
  public void anOperation()
  {
      System.out.println("factory method invoked in an operation");
      Product p = factoryMethod();
      System.out.println("using " + p.getType() + " product for the operation");
  }
}

class ConcreteCreator extends Creator
{
   public ConcreteProduct factoryMethod() { return new ConcreteProduct(); }
}


/* Main Entrance */
public class FactoryMethodMode {
  public static void main(String[] args) {
    Creator creator;
    if (args.length < 1 || (args.length >= 1 && args[0].equals("1"))) {
      System.out.println("default creator built");
      creator = new Creator();
    }
    else {
      System.out.println("concrete creator built");
      creator = new ConcreteCreator();
    }
    creator.anOperation();
 }
}
