

public class Time {
    private boolean running;
    private boolean paused; // not counting but start time is preseved
    private long start; //start time in microseconds
    private long pausedStart; // start time of current paused start
    private long end;


    public Time() {
        this.pausedStart = 0;
        this.start = 0;
        this.end = 0;
    }

    /**
     * Determines if the Timer is running (could be paused)
     *
     * @return Whether the Timer is currently running
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * Whether this Timer is paused
     *
     * @return true if it is currently paused
     */
    public boolean isPaused() {
        return paused;
    }

    /**
     * Starts the Timer
     */
    public void start() {
        start = System.nanoTime();
        running = true;
        paused = false;
        pausedStart = -1;
    }

    /**
     * Stops the Timer and returns the time elapsed
     *
     * @return Stops the Timer
     */
    public long stop() {
        if (!isRunning()) {
            return -1;
        } else if (isPaused()) {
            running = false;
            paused = false;

            return pausedStart - start;
        } else {
            end = System.nanoTime();
            running = false;
            return end - start;
        }
    }

    /**
     * Pauses the Timer
     *
     * @return The time elapsed so far
     */
    public long pause() {
        if (!isRunning()) {
            return -1;
        } else if (isPaused()) {
            return (pausedStart - start);
        } else {
            pausedStart = System.nanoTime();
            paused = true;
            return (pausedStart - start);
        }
    }

    /**
     * Resumes the Timer from it's paused state
     */
    public void resume() {
        if (isPaused() && isRunning()) {
            start = System.nanoTime() - (pausedStart - start);
            paused = false;
        }
    }

    /**
     * Returns the total time elapsed
     *
     * @return The total time elapsed
     */
    public long elapsed() {
        if (isRunning()) {
            if (isPaused())
                return (pausedStart - start);
            return (System.nanoTime() - start);
        } else
            return (end - start);
    }

    /**
     * Returns the number of seconds this Timer has elapsed
     *
     * @return The String of the number of seconds
     */
//     public String toString() {
//         long enlapsed = elapsed();
//         return ((double) enlapsed / 1000000000.0) + " Seconds";
//     }
    
        //new time format
    public double getTime() { 
        long enlapsed = elapsed();
        return Double.parseDouble((String.format("%05d.%d", (enlapsed/ 1000000000) % 60,(enlapsed % 1000000000)/10000000))); 
    }
    
      public String toString() {
        long enlapsed = elapsed();
        return (String.format("%05d.%d", (enlapsed/ 1000000000) % 60,(enlapsed % 1000000000)/10000000)) + " seconds";  
    }

}
