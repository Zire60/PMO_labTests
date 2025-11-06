package oop.robotComponents;

public class AtomicBattery extends Component{
	
	public AtomicBattery (String name) {
		super(name, 0);
	}
	
	public void fullRecharge() {
		if (this.isOn && this.mainFrame != null && this.mainFrame.getBatteryLevel() < 50) {
			for(int i = 0; i < 4; i++)
				this.mainFrame.recharge();
		}
	}
}
