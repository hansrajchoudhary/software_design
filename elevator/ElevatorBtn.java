package design.elevator;

public class ElevatorBtn implements IButton {
	private int floor_no;
	public ElevatorBtn(int flr) {
		this.floor_no = flr;
	}
	
	public int getFloorNo()
	{
		return floor_no;
	}
}
