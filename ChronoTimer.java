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
  private boolean running() = false;
  private Time theTimer;
  // default to IND mode
  private Mode mode = IND;
  // tracks whether channels are enabled
  private boolean[] channels = new boolean[8];

  private Queue<Racer> 		racerQueue 	 = new LinkedList<Racer>();
  private Queue<Racer> 		currentQueue = new LinkedList<Racer>();
  private ArrayList<Racer> 	finishedList = new ArrayList<Racer>();


  public ChronoTimer(){
    theTimer = new Time();
  }

  // Used by simulator to pass in events
  public void sendEvent(Event e, String arg)
  {
    // TODO: Check here if the Event needs an arg?
    handleEvent(e, arg);
  }

  private void handleEvent(Event e, String arg){
    switch (e){
      case EVENT:
        setMode(arg);
        break;
      case POWER:
        if (!running){
          running = true;
          powerup();
        }
        else{
          running = false;
          powerdown();
        }
        break;
      case RESET:
    	  reset();
        break;
      case TIME:
        break;
      case DNF:
        dnfRacer();
        break;
      case CANCEL:
        break;
      case TOG:
        toggleChannel(arg);
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

  private void reset() {
	  running() = false;
	  theTimer = new Timer();
	  mode = IND;
	  channels = new boolean[8];

	  racerQueue 	 = new LinkedList<Racer>();
	  currentQueue = new LinkedList<Racer>();
	  finishedList = new ArrayList<Racer>();
  }
  
  private void powerup(){

  }

  private void powerdown(){

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

  public void addRacer(int id) {
	  racerQueue.add(new Racer(id));
  }

  private void toggleChannel(String channel){
    // parse string to int, converts range 1-8 to 0-7
    int channel = Integer.parseInt(channel) - 1;
    // toggles that channel
    channels[channel] = !channels[channel];
  }

  private void startRacer(){
    // moves racer from racerQueue to the currently racing queue and sets their start time.
	  Racer tempRacer = racerQueue.remove();
	  tempRacer.startTime = theTimer.getTime();
	  currentQueue.add(tempRacer);
  }

  public void dnfRacer() {
	  // TODO

  }

  private void finishRacer(){
    // remove top racer from queue
    Racer finishedRacer = currentQueue.remove();

    // set their finish time
    finishedRacer.endTime = theTimer.getTime();
    finishedRacer.raceTime = finishedRacer.endTime - finishedRacer.startTime;

    //store finished racer in finished list
    finishedList.add(finishedRacer);
  }

  // inner class for encapsulating a racer's data
  private class Racer{
    public double startTime;
    public double endTime;
    public double raceTime;
    public int id;

    // TODO create state of racer.

    public Racer(){
      id = racerCount++;
    }
    public Racer(int idNum) {
        id = idNum;
    }
  }
}
