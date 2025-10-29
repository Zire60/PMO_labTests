package oop.myRobot;

public class BasicArm {

	private final double FUEL_FOR_PICK_UP = 10.0; 
	private final double FUEL_FOR_DROP_DOWN = 5.0;
	
	private String armName;
	private boolean isHolding;
	
	public BasicArm(String armName ) {
		this.armName = armName;
		this.isHolding = false;
	}
	
	public boolean isGrabbing() {
		return this.isHolding;
	}
	
	public void pickUp() {
		if (!isHolding) {
			isHolding = true;
		}
	}
	
	public void dropDown() {
		if (isHolding) {
			isHolding = false;
		}
	}
	
	public double getConsumptionForPickUp() {
		return FUEL_FOR_PICK_UP;
	}
	
	public double getConsumptionForDropDown() {
		return FUEL_FOR_DROP_DOWN;
	}
	
	public String toString() {
		return armName;
	}
	
}
