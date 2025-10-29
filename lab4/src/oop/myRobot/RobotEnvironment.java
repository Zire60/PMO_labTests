package oop.myRobot;

import oop.myRobot.interfaces.Position2D;

public class RobotEnvironment {

	public static final int X_UPPER_LIMIT = 100;
	public static final int Y_UPPER_LIMIT = 100;
	public static final int X_LOWER_LIMIT = -100;
	public static final int Y_LOWER_LIMIT = -100;
	
	private Position2D position;
	
	public RobotEnvironment(final Position2D position) {
		this.position = position;
	}
	
	protected boolean isWithinWorld(final Position2D p) {
		int x = p.getX();
		int y = p.getY();
		return (x >= RobotEnvironment.X_LOWER_LIMIT && x <= RobotEnvironment.X_UPPER_LIMIT && y >= RobotEnvironment.Y_LOWER_LIMIT && y <= RobotEnvironment.X_UPPER_LIMIT);
	}
	
	public boolean move(final int dx, final int dy) {
		if(isWithinWorld(this.position)) {
			Position2D p = this.position.sumVector(dx, dy);
			if(isWithinWorld(p)) {
				this.position = p;
				return true;
			}
		}
		return false;
	}
	
	public Position2D getPosition() {
		return this.position;
	}
}
