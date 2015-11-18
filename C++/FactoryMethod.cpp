#include <iostream>
#include <cstring>
#include <string>

using namespace std;

/* Products */
class Product
{
  protected:
    string type;
  public:
    Product() { type = "default"; }
    string getType() { return type; }
};

class ConcreteProduct : public Product
{
  public:
    ConcreteProduct() { type = "concrete"; }
};


/* Creators */
class Creator
{
  public:
    virtual Product * factoryMethod() { return new Product; }
    void anOperation()
    {
      cout << "factory method invoked in an operation" << endl;
      Product * p = factoryMethod();
      cout << "using " << p->getType() << " product for the operation" << endl;
    }
};

class ConcreteCreator : public Creator
{
  public:
    ConcreteProduct * factoryMethod() { return new ConcreteProduct; }
};


/* Main Entrance */
int main(int argc, char* argv[])
{
  Creator * creator;
  if (argc < 2 || (argc >= 2 && !strcmp(argv[1], "1")))
  {
    cout << "default creator built" << endl;
    creator = new Creator;
  }
  else
  {
    cout << "concrete creator built" << endl;
    creator = new ConcreteCreator;
  }
  creator->anOperation();
  return 0;
}
