import java.util.Scanner;

public class Simulator{

  private boolean running = true;
  private ChronoTimer theTimer = new ChronoTimer();

  public void listen(){
    Scanner sc = new Scanner(System.in);
    String[] split = new String[2];
    Event inputEvent = null;
    int arg = -1;

    while (running){
      // wait for a valid input
      while (inputEvent == null){
        split = parse(sc.nextLine());
        // convert the string to an event
        inputEvent = strToEvent(split[0]);
      }
      theTimer.sendEvent(inputEvent, split[1]);
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
