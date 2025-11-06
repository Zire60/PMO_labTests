package oop.robotComponents;

import oop.myRobot.ComposableRobot;

public abstract class Component {
	
	private String componentName;
	protected boolean isOn;
	protected boolean isAttached;
	protected ComposableRobot mainFrame;
	protected final double batteryCost;
	
	protected Component(String name, double btCost) {
		this.componentName = name;
		this.isOn = false;
		this.isAttached = false;
		this.mainFrame = null;
		this.batteryCost = btCost;
	}

	public double getBatteryCost() {
		return this.batteryCost;
	}
	
	public void turn(boolean status) {
		this.isOn = status;
		if(status)
			System.out.println("Turned " +componentName + " " + "on.");
		else
			System.out.println("Turned " +componentName + " " + "off.");
	}
	
	public boolean attach(ComposableRobot robot) {
		if (!this.isAttached && robot != null) {
			this.mainFrame = robot;
			this.isAttached = true;
			return true;
		}else
			return false;
	}
}
