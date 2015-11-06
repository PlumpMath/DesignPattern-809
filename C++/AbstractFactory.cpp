#include <iostream>
#include <string>

using namespace std;

/* Products */
class Product {};
class ProductA : public Product {};
class ProductB : public Product {};

class ProductA1 : public ProductA
{
  public:
    ProductA1() { cout << "create a new product A1" << endl; }
};

class ProductA2 : public ProductA
{
  public:
    ProductA2() { cout << "create a new product A2" << endl; }
};

class ProductB1 : public ProductB
{
  public:
    ProductB1() { cout << "create a new product B1" << endl; }
};

class ProductB2 : public ProductB
{
  public:
    ProductB2() { cout << "create a new product B2" << endl; }
};


/* Factories */
class AbstractFactory
{
  public:
    virtual ProductA * createProductA() { return new ProductA; }
    virtual ProductB * createProductB() { return new ProductB; }
};

class ConcreteFactory1 : public AbstractFactory
{
  public:
    ProductA1 * createProductA() { return new ProductA1(); }
    ProductB1 * createProductB() { return new ProductB1(); }
};

class ConcreteFactory2 : public AbstractFactory
{
  public:
    ProductA2 * createProductA() { return new ProductA2(); }
    ProductB2 * createProductB() { return new ProductB2(); }
};

/* Main Entrance */
int main(int argc, char* argv[])
{
  AbstractFactory * factory;
  if (argc < 2 || (argc >= 2 && !strcmp(argv[1], "1")))
  {
    cout << "ConcreteFactory1 built" << endl;
    factory = new ConcreteFactory1();
  }
  else
  {
    cout << "ConcreteFactory2 built" << endl;
    factory = new ConcreteFactory2();
  }
  ProductA * a = factory->createProductA();
  ProductB * b = factory->createProductB();
  return 0;
}
