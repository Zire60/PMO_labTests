package oop.myRobot.test;

import oop.myRobot.*;

public class TestRobots {

	public static void main(String[] args) {
		final RobotWithTwoArms r1 = new RobotWithTwoArms("Pin0");
		final BaseRobot r0 = new BaseRobot("WALL-E");
		System.out.println(r0);
		while(r0.moveUp()) {
			if (r0.getBatteryLevel() < 1.2) {
				r0.recharge();
			}
		};
		while(r0.moveRight()) {
			if (r0.getBatteryLevel() < 1.2) {
				r0.recharge();
			}
		};
		System.out.println(r0);
		System.out.println();
		System.out.println();
		System.out.println(r1);
		while(r1.moveUp()) {
			if (r1.getBatteryLevel() < 1.2) {
				r1.recharge();
			}
		};
		r1.pickUp();
		r1.pickUp();
		r1.pickUp();
		System.out.println(r1.getItemsCarried()); //2
		r1.recharge();
		r1.dropDown();
		System.out.println(r1.getItemsCarried()); //2
		System.out.println(r1);

	}

}
