import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Simulator{

  private boolean running = true;
  private ChronoTimer theTimer = new ChronoTimer();

  public void listen(){
    Scanner sc = new Scanner(System.in);
    String[] split = new String[2];
    Event inputEvent = null;
    int arg = -1;

    System.out.println("Welcome to ChronoTimer Simulator\nEnter FILE <filename> to load, or type commands for manual mode");

    while (running){
      // wait for a valid input
      while (inputEvent == null){
        split = parse(sc.nextLine());
        // convert the string to an event
        inputEvent = strToEvent(split[0]);
      }
      if (inputEvent == Event.EXIT){
        System.exit(0);
      }
      if (inputEvent == Event.FILE){
        runFile(split[1]);
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

  private void runFile(String filename){
    long currTime;
    String path = "testfiles/";
    try{
      File file = new File(path + filename);
      Scanner sc = new Scanner(file);
      // handle each line of the file
      while (sc.hasNextLine()){
        System.out.println(sc.nextLine());
      }
    }catch(FileNotFoundException ex){
      ex.printStackTrace();
    }
    return;
  }

  private long parseHMS(String hms){
    //TODO: parses a timestamp in the format of hh:mm:ss(.0)
    String[] times = hms.split(":");
    return 0;
  }

  public static void main(String[] args){
    Simulator sim = new Simulator();
    sim.listen();
  }
}
