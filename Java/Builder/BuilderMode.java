/* Builders */
class Builder {
    public void buildPart1() { System.out.println("Part1 built in default style"); }
    public void buildPart2() { System.out.println("Part2 built in default style"); }
    public void buildPart3() { System.out.println("Part3 built in default style"); }
}

class StyleABuilder extends Builder {
    public void buildPart1() { System.out.println("Part1 built in StyleA"); }
    public void buildPart2() { System.out.println("Part2 built in StyleA"); }
}

class StyleBBuilder extends Builder {
    public void buildPart1() { System.out.println("Part1 built in StyleB"); }
    public void buildPart3() { System.out.println("Part3 built in StyleB"); }
}

/* Director */
class Director {
    public Director(Builder builder) { _builder = builder; }
    public void build() {
      _builder.buildPart1();
      _builder.buildPart2();
      _builder.buildPart3();
    }

    private Builder _builder;
}

/* Main Entrance */
public class BuilderMode {
  public static void main(String[] args) {
    Builder builder;
    if (args.length < 1 || (args.length >= 1 && args[0].equals("A"))) {
      builder = new StyleABuilder();
      System.out.println("StyleABuilder built");
    } else {
      builder = new StyleBBuilder();
      System.out.println("StyleBBuilder built");
    }
    Director director = new Director(builder);
    director.build();
  }
}
