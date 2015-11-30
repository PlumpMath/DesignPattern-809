#include <iostream>
#include <cstring>
#include <string>

using namespace std;

/* Prototypes */
class Prototype
{
  protected:
    string _type;
  public:
    Prototype() { setType("Prototype"); }
    Prototype(const Prototype& other) { setType(other.getType()); }
    string getType() const { return _type; }
    void setType(string type) { _type = type; }
    virtual Prototype * Clone() { return new Prototype(*this); }
};

class ConcretePrototype1 : public Prototype
{
  public:
    ConcretePrototype1() { setType("ConcretePrototype1"); }
    ConcretePrototype1(ConcretePrototype1& other) { _type = other.getType(); }
    ConcretePrototype1 * Clone() { return new ConcretePrototype1(*this); }
};

class ConcretePrototype2 : public Prototype
{
  public:
    ConcretePrototype2() { setType("ConcretePrototype2"); }
    ConcretePrototype2(const ConcretePrototype1& other) { _type = other.getType(); }
    ConcretePrototype2 * Clone() { return new ConcretePrototype2(*this); }
};


/* Client */
class Client
{
  private:
    Prototype * _prototype;
  public:
    Client() { Client(new Prototype()); }
    Client(Prototype * proto) { _prototype = proto; } 
    void Operation()
    {
      Prototype * p = _prototype->Clone();
      cout << "Using " << p->getType() << " created from prototype." << endl;
    }
};


/* Main Entrance */
int main(int argc, char* argv[])
{
  Client * client;
  if (argc < 2 || (argc >= 2 && !strcmp(argv[1], "1")))
  {
    client = new Client(new ConcretePrototype1());
  }
  else
  {
    client = new Client(new ConcretePrototype2());
  }
  cout << "Client built for Operation." << endl;
  client->Operation();
  return 0;
}
