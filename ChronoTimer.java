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
  private boolean running = false;
  private Time theTimer;
  // default to IND mode
  private Mode mode = Mode.IND;
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
    	power();
        break;
      case RESET:
    	reset();
        break;
      case TIME:
        break;
      case NEWRUN:
        break;
      case ENDRUN:
        break;
      case NUM:
        addRacer(Integer.parseInt(arg));
        break;
      case DNF:
        dnfRacer();
        break;
      case CANCEL:
    	cancel();
        break;
      case TOG:
        toggleChannel(arg);
        break;
      case TRIG:
    	triggerChannel(arg);
        break;
      case START:
        startRacer();
        break;
      case FINISH:
        finishRacer();
        break;
      default:
        System.out.println("This command not supported yet");
        break;
    }
  }

  private void power() {
	  if (!running){
          running = true;
          reset();
        }
        else{
          running = false;
        }
  }

  private void reset() {
	  running = false;
	  theTimer = new Time();
	  mode = Mode.IND;
	  channels = new boolean[8];
	  racerQueue = new LinkedList<Racer>();
	  currentQueue = new LinkedList<Racer>();
	  finishedList = new ArrayList<Racer>();
  }

  private void cancel() {
	  while (!racerQueue.isEmpty()) {
		  currentQueue.add(racerQueue.remove());
	  }
	  racerQueue = currentQueue;
	  currentQueue = new LinkedList<Racer>();
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

  private void toggleChannel(String ch){
    // parse string to int, converts range 1-8 to 0-7
    int channel = Integer.parseInt(ch) - 1;
    // toggles that channel
    channels[channel] = !channels[channel];
  }

  private void triggerChannel(String ch){
	    // parse string to int, converts range 1-8 to 0-7
	    int channel = Integer.parseInt(ch) - 1;

	    // checks if the channel is active
	    if (channels[channel]) {
	    	//starts a racer if the channel is odd
	    	if (channel%2 == 1)
	    		startRacer();
	    	//ends a racer if the channel is even
	    	else
	    		finishRacer();
	    }
	  }

  private void startRacer(){
    // moves racer from racerQueue to the currently racing queue and sets their start time.
	  Racer tempRacer = racerQueue.remove();
	  tempRacer.startTime = theTimer.getTime();
	  currentQueue.add(tempRacer);
  }

  public void dnfRacer() {
	  // remove top racer from queue
	  Racer dnfRacer = currentQueue.remove();

	  // set end time and race time to negative values
	  dnfRacer.endTime = -1;
	  dnfRacer.raceTime = -1;

	  // add DNF racer to finished list
	  finishedList.add(dnfRacer);
  }

  private void newRun(){
    //TODO: set up a new run with empty queues
  }

  private void endRun(){
    //TODO: ends the run, clearing memory n stuff
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

    public Racer(int idNum) {
        id = idNum;
    }
  }
}
