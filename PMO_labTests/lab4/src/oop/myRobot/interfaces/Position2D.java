package oop.myRobot.interfaces;

public interface Position2D {
	
	int getX();
	
	int getY();
	
	Position2D sumVector(Position2D p);
	
	Position2D sumVector(int x, int y);
	
}
