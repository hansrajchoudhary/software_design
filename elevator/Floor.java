package design.elevator;

public class Floor implements Comparable<Floor> {
	private int floor_id;
	public Floor(int floorId) {
		this.floor_id = floorId;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return floor_id;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.floor_id == ((Floor) obj).floor_id;
	}

	@Override
	public int compareTo(Floor o) {
		// TODO Auto-generated method stub
		if(o.floor_id > this.floor_id)
			return 1;
		if(o.floor_id == this.floor_id)
			return 0;
		return -1;
	}
	
	public int getFloorId()
	{
		return floor_id;
	}
}
