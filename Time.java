
public class Time {
    private boolean running;
    private boolean paused; // not counting but start time is preseved
    private long start; //start time in microseconds
    private long pausedStart; // start time of current paused start
    private long end;
    private long offset;

    public Time() {
        this.pausedStart = 0;
        this.start = 0;
        this.end = 0;
        this.offset = 0;
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
            paused = true;

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
        } else if (!isRunning() && isPaused()) {
            return (pausedStart - start);
        } else
            return (end - start);
    }

    //new time format
    public double getTime() {
        long enlapsed = elapsed();
        return Double.parseDouble((String.format("%05d.%d", (enlapsed/ 1000000000) % 60,(enlapsed % 1000000000)/10000000)));
    }

    public String toString() {
        long enlapsed = elapsed();
        return (String.format("%05d.%d", (enlapsed/ 1000000000) % 60,(enlapsed % 1000000000)/10000000)) + " seconds";
    }
    // 11:02:22.54
    public long setTime(String time){
        final long MULT_H = 3600000000000L;
        final long MULT_M = 60000000000L;
        final long MULT_S = 1000000000L;
        String h = time.substring(0, 2);
        String m = time.substring(3, 5);
        String s = time.substring(6,8);

        Long hL = Long.parseLong(h) * MULT_H;
        Long mL = Long.parseLong(m) * MULT_M;
        Long sL = Long.parseLong(s) * MULT_S;
        offset = hL + mL+ sL;

        return offset;
    }

    // returns time + set time in hh:mm:ss.ss
    public String timeStamp() {
        long time = elapsed() + offset;
        long n = time/1000000000;
        return (String.format("%02d:%02d:%02d.%d", (n / 3600)%24, (n / 60)%60, n % 60,(time % 1000000000)/10000000));
    }
}
