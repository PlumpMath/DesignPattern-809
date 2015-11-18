#include <iostream>
#include <cstring>

using namespace std;

/* Builders */
class Builder
{
  public:
    virtual void buildPart1() { cout << "Part1 built in default style" << endl; }
    virtual void buildPart2() { cout << "Part2 built in default style" << endl; }
    virtual void buildPart3() { cout << "Part3 built in default style" << endl; }
};

class StyleABuilder : public Builder
{
  public:
    void buildPart1() { cout << "Part1 built in StyleA" << endl; }
    void buildPart2() { cout << "Part2 built in StyleA" << endl; }
};

class StyleBBuilder : public Builder
{
  public:
    void buildPart1() { cout << "Part1 built in StyleB" << endl; }
    void buildPart3() { cout << "Part3 built in StyleB" << endl; }
};

/* Director */
class Director
{
  public:
    Director(Builder * builder) { _builder = builder; }
    void build()
    {
      _builder->buildPart1();
      _builder->buildPart2();
      _builder->buildPart3();
    }

  private:
    Builder * _builder;
};

/* Main Entrance */
int main(int argc, char* argv[])
{
  Builder * builder;
  if (argc < 2 || (argc >= 2 && !strcmp(argv[1], "A")))
  {
    builder = new StyleABuilder;
    cout << "StyleABuilder built" << endl;
  }
  else
  {
    builder = new StyleBBuilder;
    cout << "StyleBBuilder built" << endl;
  }
  Director director(builder);
  director.build();
  return 0;
}
