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
  FINISH;
  // mode
  enum MODE{
    IND,
    PARIND,
    GRP,
    PARGRP
  }
}
