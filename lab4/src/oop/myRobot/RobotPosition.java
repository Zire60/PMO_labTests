package oop.myRobot;

import oop.myRobot.interfaces.Position2D;

public class RobotPosition implements Position2D {
	
	private int x;
	private int y;
	
	public RobotPosition(final int x, final int y){
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(final Object o) {
		if(o instanceof Position2D) {
			final var p = (Position2D)o;
			return (p.getX() == this.x && p.getY() == this.y);
		}else {
			return false;
		}
	}
	
	public int hashCode() {
		return (this.x*5)%23 * (this.y*2)%13; //Not really that secure
	}

	public int getX() {
		return this.x;
	}


	public int getY() {
		return this.y;
	}

	public Position2D sumVector( final Position2D p) { //gives the vectorial sum of this instance and p
		return new RobotPosition(this.x + p.getX(), this.y + p.getY());
	}

	public Position2D sumVector(final int x, final int y) {
		return new RobotPosition(this.x + x, this.y + y);
	}

	public String toString() {
		return "Position: (x="+this.x + ", y=" +this.y +")";
	}
}
