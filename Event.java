 public enum Event{
  // command
  POWER,
  EXIT,
  RESET,
  TIME,
  DNF,
  CANCEL,
  TOG,
  TRIG,
  START,
  FINISH,

  IND{
    @Override public boolean isMode(){
      return true;
    }
  },
  PARIND{
    @Override public boolean isMode(){
      return true;
    }
  },
  GRP{
    @Override public boolean isMode(){
      return true;
    }
  },
  PARGRP{
    @Override public boolean isMode(){
      return true;
    }
  };

  public boolean isMode(){
    return false;
  }
}
