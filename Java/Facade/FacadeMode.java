import java.util.Random;

/* Facade */ 
class Facade {
  public void execute() {
    System.out.println("Start Job from the Facade:");
    SubsystemsA flowA = new SubsystemsA();
    SubsystemsB flowB = new SubsystemsB();
    SubsystemsC flowC = new SubsystemsC();
    Random random = new Random();
    int state =random.nextInt(3);
    while(state != 0) {
      switch(state) {
        case 1: flowA.executeFlowA(); break;
        case 2: flowB.executeFlowB(); break;
        case 3: flowC.executeFlowC(); break;
      }
      state =random.nextInt(3);
    }
    System.out.println("Job finished");
  }
}

/* Subsystems */
class SubsystemsA {
  public void executeFlowA() {
    System.out.println("  - Flow A done");
  }
}

class SubsystemsB {
  public void executeFlowB() {
    System.out.println("  - Flow B done");
  }
}

class SubsystemsC {
  public void executeFlowC() {
    System.out.println("  - Flow C done");
  }
}

/* Main Entrance */
public class FacadeMode {
  public static void main(String[] args) {
    Facade facade = new Facade();
    facade.execute();
  }
}
