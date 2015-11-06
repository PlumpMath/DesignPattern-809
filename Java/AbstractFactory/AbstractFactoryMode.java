/* Products */
class Product {};
class ProductA extends Product {};
class ProductB extends Product {};

class ProductA1 extends ProductA
{
    ProductA1() { System.out.println("create a new product A1"); }
};

class ProductA2 extends ProductA
{
    ProductA2() { System.out.println("create a new product A2"); }
};

class ProductB1 extends ProductB
{
    ProductB1() { System.out.println("create a new product B1"); }
};

class ProductB2 extends ProductB
{
    ProductB2() { System.out.println("create a new product B2"); }
};


/* Factories */
class AbstractFactory
{
    ProductA createProductA() { return new ProductA(); }
    ProductB createProductB() { return new ProductB(); }
};

class ConcreteFactory1 extends AbstractFactory
{
    public ProductA1 createProductA() { return new ProductA1(); }
    public ProductB1 createProductB() { return new ProductB1(); }
};

class ConcreteFactory2 extends AbstractFactory
{
    public ProductA2 createProductA() { return new ProductA2(); }
    public ProductB2 createProductB() { return new ProductB2(); }
};

/* Main Entrance */
public class AbstractFactoryMode {
  public static void main(String[] args) {
    AbstractFactory factory;
    if (args.length < 1 || (args.length >= 1 && args[0].equals("1"))) {
      System.out.println("ConcreteFactory1 built");
      factory = new ConcreteFactory1();
    }
    else {
      System.out.println("ConcreteFactory2 built");
      factory = new ConcreteFactory2();
    }
    ProductA a = factory.createProductA();
    ProductB b = factory.createProductB();
 }
}
