package design.elevator;

import design.elevator.Elevator.Direction;

public class ElevatorWorkerThread implements Runnable {

	private Elevator elevator;

	ElevatorWorkerThread(Elevator elv) {
		this.elevator = elv;
	}

	@Override
	public void run() {
		while (elevator.getDir() != Direction.STOP) {
			if (elevator.getListOfFloor().size() == 0) {
				try {
					System.out.println("Elevator "+elevator.getElvId()+" is idle");
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				if (elevator.getDir() == Direction.UP) {
					Floor floorToGo = null;
					for (Floor f : elevator.getListOfFloor()) {
						if (f.getFloorId() >= elevator.getCurrentFloorId()) {
							try {
								System.out.println("Elevator "+elevator.getElvId()+" going up to floor id "+f.getFloorId());
								elevator.setCurrentFloorId(f.getFloorId());
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							floorToGo = f;
							break;
						}
					}

					if (floorToGo == null)
						elevator.setDir(Direction.DOWN);
					else
						elevator.getListOfFloor().remove(floorToGo);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					Floor floorToGo = null;
					for (Floor f : elevator.getListOfFloor()) {
						if (f.getFloorId() <= elevator.getCurrentFloorId()) {
							try {
								System.out.println("Elevator "+elevator.getElvId()+" going down to floor id "+f.getFloorId());
								elevator.setCurrentFloorId(f.getFloorId());
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							floorToGo = f;
							break;
						}
					}

					if (floorToGo == null)
						elevator.setDir(Direction.UP);
					else
						elevator.getListOfFloor().remove(floorToGo);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

}
