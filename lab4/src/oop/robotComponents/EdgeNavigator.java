package oop.robotComponents;

public class EdgeNavigator extends Component{
	
	private static final double NAVIGATOR_BT_COST = 10.0;

	public EdgeNavigator(String name) {
		super(name, NAVIGATOR_BT_COST);
	}
	
	public void navigate() {
		if(this.isOn) {
			this.reachEdge();
			this.navigateEdge();
		}
	}
	
	private void reachEdge() {
		while(this.mainFrame.moveUp()); //da fare la versione che consuma meno batteria posibile
	}
	
	private void navigateEdge() {
		boolean canMove = true;
		while(canMove) {
			while(this.mainFrame.moveRight());
			while(this.mainFrame.moveDown());
			while(this.mainFrame.moveLeft());
			while(this.mainFrame.moveUp());
			canMove = this.mainFrame.getBatteryLevel() >= oop.myRobot.BaseRobot.MOVEMENT_DELTA_CONSUMPTION;
		}
	}
	
}
