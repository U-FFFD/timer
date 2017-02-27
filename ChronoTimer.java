/*
  CS361
  ChronoTimer
  Sprint 1
  Team U+FFFD:
  * AJ
  * Emmett
  * Kerstin
  * Kody
  * Owen
*/

public class ChronoTimer{
  // enum defines the event commands
  public enum Event{
    POWER,
    EXIT,
    RESET,
    TIME,
    DNF,
    CANCEL,
    TOG,
    TRIG,
    START,
    FINISH
  }

  private Time theTimer;
  private Event currEvent;

  public ChronoTimer(){
    theTimer = new Timer;
    currEvent = null;
    mainLoop();
  }

  public void sendEvent(Event e)
  {
    currEvent = e;
  }

  private void mainLoop(){
    while (running) {
      handleEvent(currEvent);
    }
  }

  private void handleEvent(String )

  // inner class for encapsulating a racer's data
  private class Racer{
    public long startTime;
    public long endTime;
    public int ID;
  }

  private
}
