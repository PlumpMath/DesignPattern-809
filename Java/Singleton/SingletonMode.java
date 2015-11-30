/* Singleton */
class Singleton {
  private static Singleton uniqueInstance = null;
  private Singleton() {}
  public static Singleton Instance() {
    if(uniqueInstance == null) {
      uniqueInstance = new Singleton();
      System.out.println("Singleton instance built.");
    }
    return uniqueInstance;
  }
}


/* Main Entrance */
public class SingletonMode {
  public static void main(String[] args) {
    System.out.println("Get instance1.");
    Singleton instance1 = Singleton.Instance();
    System.out.println("Get instance2.");
    Singleton instance2 = Singleton.Instance();
    if(instance1 == instance2) {
      System.out.println("instance1 and instance2 are the same thing.");
    }
  }
}
