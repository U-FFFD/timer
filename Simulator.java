import java.util.Scanner;

public class Simulator{

  private boolean running = true;
  private ChronoTimer theTimer = new ChronoTimer();

  public void listen(){
    Scanner sc = new Scanner(System.in);
    Event inputEvent = null;
    int[] args = null;

    while (running){
      // wait for a valid input
      while (inputEvent == null){
        String[] split = parse(sc.nextLine());
        inputEvent = strToEvent(split[0]);
      }
      // this code just for testing
      theTimer.sendEvent(inputEvent, 0);
      inputEvent = null;
    }
  }

  private String[] parse(String input){
    // splits line at spaces
    return input.split("\\s+");
  }

  private Event strToEvent(String s){
    // checks if string is in event enum
    for (Event e : Event.values()){
      if (e.name().equals(s)){
        return e;
      }
    }

    return null;
  }

  public static void main(String[] args){
    Simulator sim = new Simulator();
    sim.listen();
  }
}
