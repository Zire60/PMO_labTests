package oop.myRobot;

import oop.myRobot.interfaces.Position2D;
import oop.myRobot.interfaces.Robot;

public class BaseRobot implements Robot {

	public static final double BATTERY_FULL = 100;
	public static final double MOVEMENT_DELTA_CONSUMPTION = 1.2;
	private static final int MOVEMENT_DELTA = 1;
	
	private double batteryLevel;
	private RobotEnvironment environment;
	private String robotName;
	
	private double batteryForMovement;
	
	public BaseRobot(String name) {
		this.robotName = name;
		this.environment = new RobotEnvironment(new RobotPosition(0,0));
		this.batteryLevel = 100;
	}
	
	private void normaliseBattery() {
		if (this.batteryLevel < 0) {
			this.batteryLevel = 0;
		}
		if (this.batteryLevel > 100) {
			this.batteryLevel = 100;
		}
	}
	
	protected void consumeBattery(double amount) {
		this.batteryLevel -= amount;
		this.normaliseBattery();
	}

	protected void consumeBatteryForMovement() {
		consumeBattery(this.batteryForMovement);
	}
	
	private void getBatteryForMovement(int dx, int dy) {
		this.batteryForMovement = dx*MOVEMENT_DELTA_CONSUMPTION + dy*MOVEMENT_DELTA_CONSUMPTION;
	}
	
	protected boolean isBatteryEnough(double OpCost) {
		return this.batteryLevel >= OpCost;
	}
	
	protected void log(String msg) {
		System.out.println(msg);
	}
	
	private boolean move(int dx, int dy) {
		getBatteryForMovement(dx, dy);
		if(isBatteryEnough(this.batteryForMovement)) {
			oop.myRobot.interfaces.Position2D p = this.environment.getPosition();
			if(this.environment.move(dx, dy)) {
				consumeBatteryForMovement();
				log("Moved " + this.robotName + " from " + p + " to " + this.environment.getPosition() +". Battery: " + this.batteryLevel + ".");
				return true;
			}else {
				log("Unautorized move, destination was out of bounds.");
			}
		}else {
			log("Not enough battery to allow for movement; Current battery level: " + 
					this.batteryLevel + ", battery required to move: " + this.batteryForMovement + ".");
		}
		return false;
	}
	public boolean moveUp() {
		return move(0, MOVEMENT_DELTA);
	}
	
	public boolean moveDown() {
		return move(0, -MOVEMENT_DELTA);
	}
	
	public boolean moveLeft() {
		return move(-MOVEMENT_DELTA, 0);
	}
	
	public boolean moveRight() {
		return move(MOVEMENT_DELTA, 0);
	}
	
	public void recharge() {
		this.batteryLevel += 100;
		this.normaliseBattery();
	}
	
	public double getBatteryLevel() {
		return this.batteryLevel;
	}
	
	public Position2D getPosition() {
		return environment.getPosition();
	}
	
	public String toString() {
		return this.robotName + " in " + this.environment.getPosition() + "; Battery Level: " +this.batteryLevel +".";
	}
	
	
}
