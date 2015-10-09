package design.elevator;

import java.util.Scanner;
/**
 * Basic elevator manager having two elevators and multiple floors to go
 * When the elevators are not idle, you can see the log message going up or down
 * Repeat input "Y" and then command(1/2/3/4 - 1/2/3/4 (from floor to destination floor), stop, start) after each command
 * @author hansraj.choudhary
 *
 */
public class ElevatorManager {
	public static void main(String[] args) throws InterruptedException {
		Elevator first = new Elevator(1);
		Elevator second = new Elevator(2);
		first.startElevator();
		second.startElevator();
		Scanner sc = new Scanner(System.in);
		System.out
				.println("Repeat input Y and then command(1/2/3/4 - 1/2/3/4 (from floor to destination floor), stop, start) after each command, (exit to terminate to program)");
		
		while (sc.hasNext() && (!sc.nextLine().equalsIgnoreCase("exit"))) {
			String command = sc.nextLine();
			if (command.contains("-")) {
				int from = Integer.parseInt(command.split("-")[0].trim());
				int to = Integer.parseInt(command.split("-")[1].trim());
				if(from != to)
				{
					Floor f = new Floor(to);
					if(Math.abs(from - first.getCurrentFloorId()) >= Math.abs(from - second.getCurrentFloorId()))
						second.addFloorToServe(f);
					else
						first.addFloorToServe(f);
				}
				else
					System.out.println("Please check: From floor and to floor are same");
			}
			else if(command.equals("stop"))
			{
				first.stopElevator();
			}
			else
			{
				first.startElevator();
			}
		}
	}

	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}
