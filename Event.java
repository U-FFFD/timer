 public enum Event{
  // command
  EVENT{
    @Override public boolean needsArg(){
      return true;
    }
  },
  POWER,
  EXIT,
  RESET,
  TIME{
    @Override public boolean needsArg(){
      return true;
    }
  },
  DNF,
  CANCEL,
  TOG{
    @Override public boolean needsArg(){
      return true;
    }
  },
  TRIG{
    @Override public boolean needsArg(){
      return true;
    }
  },
  START,
  FINISH;

  public boolean needsArg(){
    return false;
  }
}
