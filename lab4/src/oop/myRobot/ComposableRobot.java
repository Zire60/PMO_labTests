package oop.myRobot;

import oop.robotComponents.*;

public class ComposableRobot extends BaseRobot{
	
	private final Component[] robotComponents;

	public ComposableRobot(String name) {
		super(name);
		this.robotComponents = new Component[10];
	}
	
	public void switchAll(boolean status) {
		for (var i : this.robotComponents) {
			i.turn(status);
		}
	}
	
	public boolean attach(Component cmp) {
		int ind = 0;
		while(ind < this.robotComponents.length && this.robotComponents[ind] != null) {
			ind++;
		}
		if (ind < this.robotComponents.length && cmp.attach(this)) {
			this.robotComponents[ind] = cmp;
			return true;
		}
		return false;
	}
	
	private Component searchComponent(Object tmp) {
		int i = 0;
		while (i <this.robotComponents.length) {
			if(this.robotComponents[i].getClass() != tmp.getClass()) {
				return this.robotComponents[i];
			}
		}
		return null;
	}
	
	
	/*forse potrebb essere utile far si che alcuni componenti possano 
	 * salvare al loro interno lo stato delle cose
	 *  e che il bot possa solo richiamare le loro funzioni*/
}
