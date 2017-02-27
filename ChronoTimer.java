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

  public ChronoTimer(){
    theTimer = new Timer;
    currEvent = null;
    mainLoop();
  }

  // Used by simulator to pass in events
  public void sendEvent(Event e)
  {
    handleEvent(e);
  }

  private void handleEvent(Event e){
    if (e != null){
      switch (e){
        case POWER:
          break;
        case EXIT:
          break;
        case RESET:
          break;
        case TIME:
          break;
        case DNF:
          break;
        case CANCEL:
          break;
        case TOG:
          break;
        case TRIG:
          break;
        case START:
          break;
        case FINISH:
          break;
        case default:
          break;
      }
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
