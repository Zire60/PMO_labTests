package oop.myRobot;

import oop.myRobot.interfaces.RobotWithArms;

public class RobotWithTwoArms extends BaseRobot implements RobotWithArms {
	
	private final BasicArm armSx;
	private final BasicArm armDx;
	private int heldObjectCount;
	/*private Object heldObject = null;*/
	
	public RobotWithTwoArms(String name) {
		super(name);
		this.armSx = new BasicArm("Sx");
		this.armDx = new BasicArm("Dx");
		this.heldObjectCount = 0;
	}
	
	private BasicArm selectFreeArm() {
		BasicArm freeArm = null;
		if (!armSx.isGrabbing()) {
			freeArm = armSx;
		}else if(!armDx.isGrabbing()) {
			freeArm = armDx;
		}
		return freeArm;
	}
	
	public boolean pickUp() {
		BasicArm arm = this.selectFreeArm();
		if (arm != null && heldObjectCount <= 2 && this.isBatteryEnough(arm.getConsumptionForPickUp())) {
			arm.pickUp();
			heldObjectCount++;
			this.consumeBattery(arm.getConsumptionForPickUp());
			/*dovrebbe esserci qualcosa per raccogliere l'oggetto 
			 * nella posizione del robot*/
			return true;
		} else {
			return false;
		}
	}

	private BasicArm selectOccupiedArm() {
		BasicArm holdingArm = null;
		if (armSx.isGrabbing()) {
			holdingArm = armSx;
		}else if(armDx.isGrabbing()) {
			holdingArm = armDx;
		}
		return holdingArm;
	}
	
	public boolean dropDown() {
		BasicArm arm = this.selectOccupiedArm();
		if (arm != null && heldObjectCount >= 0 && this.isBatteryEnough(arm.getConsumptionForDropDown())) {
			arm.dropDown();
			heldObjectCount--;
			this.consumeBattery(arm.getConsumptionForDropDown());
			/*dovrebbe esserci qualcosa per lasciare l'oggetto 
			 * nella posizione del robot*/
			return true;
		} else {
			return false;
		}
	}
	
	public int getItemsCarried() {
		return heldObjectCount;
	}

}
