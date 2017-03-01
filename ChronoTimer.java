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

import java.util.*;

public class ChronoTimer{
  public enum Mode{
    IND,
    PARIND,
    GRP,
    PARGRP
  }
  // enum defines the event commands

  private Time theTimer;
  private int racerCount;
  private Mode mode = null;

  private Queue<Racer> racerQueue = new LinkedList<Racer>();

  public ChronoTimer(){
    theTimer = new Time();
    racerCount = 0;
  }

  // Used by simulator to pass in events
  public void sendEvent(Event e, String arg)
  {
    handleEvent(e, arg);

  }

  private void handleEvent(Event e, String arg){
    switch (e){
      case EVENT:
        setMode(arg);
        break;
      case POWER:
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
        startRacer();
        break;
      case FINISH:
        finishRacer();
        break;
      default:
        break;
    }
  }

  private void setMode(String mode){
    if (mode != null){
      for (Mode m : Mode.values()){
        if (m.name().equals(mode)){
          System.out.println("Event: " + m.name());
          this.mode = m;
        }
      }
    }
  }

  private void startRacer(){
    // adds a new racer to the currently racing queue
    racerQueue.add(new Racer());
  }

  private void finishRacer(){
    // remove top racer from queue
    Racer finished = racerQueue.remove();
    // set their finish time
    finished.endTime = theTimer.getTime();
    // TODO: store finished racer in finished list
  }

  // inner class for encapsulating a racer's data
  private class Racer{
    public double startTime;
    public double endTime;
    public int id;

    public Racer(){
      id = racerCount++;
      startTime = theTimer.getTime();
    }
  }
}
