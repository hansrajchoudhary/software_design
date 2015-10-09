package design.elevator;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Elevator {
	private final int CAPACITY = 10;
	public enum Direction {UP, DOWN, STOP};

	private Direction dir;
	private int elv_id;
	private int curr_flr_id;
	private List<IButton> buttons;
	private TreeSet<Floor> listOfFloorsToGo;
	private Thread thread;
	
	public Elevator(int elv_id) {
		this.elv_id = elv_id;
		this.curr_flr_id = 1;
		this.dir = Direction.STOP;
		buttons = new ArrayList<IButton>();
		listOfFloorsToGo = new TreeSet<Floor>();
		initializeButtons();
	}

	private void initializeButtons() {
		buttons.add(new ElevatorBtn(1));
		buttons.add(new ElevatorBtn(2));
		buttons.add(new ElevatorBtn(3));
		buttons.add(new ElevatorBtn(4));
	}
	
	public void startElevator()
	{
		if(this.dir == Direction.STOP)
		{
			this.dir = Direction.UP;
			thread = new Thread( new ElevatorWorkerThread(this));
			thread.start();
		}
	}
	
	public void stopElevator()
	{
		if(this.dir != Direction.STOP)
			this.dir = Direction.STOP;
	}
	
	public int getElvId(){
		return elv_id;
	}
	
	public Direction getDir(){
		return dir;
	}
	public void setDir(Direction d)
	{
		this.dir = d;
	}
	public void addFloorToServe(Floor f)
	{
		listOfFloorsToGo.add(f);
	}
	
	public void removeFloor(Floor f)
	{
		listOfFloorsToGo.remove(f);
	}
	
	public TreeSet<Floor> getListOfFloor()
	{
		return listOfFloorsToGo;
	}
	
	public int getCurrentFloorId()
	{
		return curr_flr_id;
	}
	
	public int setCurrentFloorId(int curr)
	{
		return curr_flr_id = curr;
	}
}
