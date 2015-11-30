#include <iostream>
#include <cstring>

using namespace std;

/* Singleton */
class Singleton {
  private:
    static Singleton * uniqueInstance;
    Singleton() {}
  public:
    static Singleton * Instance()
    {
      if(uniqueInstance == NULL)
      {
         uniqueInstance = new Singleton();
         cout << "Singleton instance built." << endl;
      }
      return uniqueInstance;
    }
};

Singleton * Singleton::uniqueInstance;


/* Main Entrance */
int main(int argc, char* argv[])
{
  cout << "Get instance1." << endl;
  Singleton * instance1 = Singleton::Instance();
  cout << "Get instance2." << endl;
  Singleton * instance2 = Singleton::Instance();
  if(instance1 == instance2)
  {
    cout << "instance1 and instance2 are the same thing." << endl;
  }
  return 0;
}
