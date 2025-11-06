package oop.myRobot.interfaces;

public interface RobotWithArms extends Robot {
	
	boolean pickUp();
	
	boolean dropDown();
	
	int getItemsCarried();
}
