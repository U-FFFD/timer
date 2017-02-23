import java.util.Scanner;

public class TimeTest {

	public TimeTest() {
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Time timer = new Time();
		Scanner uInput = new Scanner(System.in);
		String cmnd = "";
		Boolean run = true;
		System.out.println("STOPWATCH TIMER - COMMANDS : |start | stop | pause | resume| \n                             |raw time | print | exit |");
		while(run) {
			System.out.print("Timer : ");
			cmnd = uInput.nextLine();
			if(cmnd.contains("exit") || cmnd.contains("cancel")) {
				run = false;
			}
			else if (cmnd.contains("start")) {
				timer.start();
				System.out.println("+++++++++++++++++ TIMING ++++++++++++++++++++");
			}
			else if (cmnd.contains("stop")) {
				timer.stop();

				System.out.println("++++++++++++++ TIMER STOPPED ++++++++++++++++");
			}
			else if (cmnd.contains("pause")) {
				timer.pause();

				System.out.println("+++++++++++++++++ PAUSED +++++++++++++++++++++");
			}
			else if (cmnd.contains("resume")) {
				timer.resume();
				System.out.println("+++++++++++++++++ RESUMED +++++++++++++++++++++");
			}
			else if (cmnd.contains("raw time")) {
				System.out.println("\n Time in microseconds : " + timer.elapsed());
			}
			else if (cmnd.contains("print")) {
				System.out.println("\n" + timer.toString());
			}
		}
		uInput.close();
	}
}
