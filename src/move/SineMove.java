package move;

import logic.Hitbox;
import logic.Position;
import obstacle.Monster;

public class SineMove implements Move {
	
	private double xSpeed;
	private double ySpeed;
	private Hitbox obj;
	
	public SineMove(Hitbox obj) {
		this.obj = obj;
		this.xSpeed = -25;
		this.ySpeed = 10;
		obj.setxSpeed(xSpeed); 
		obj.setySpeed(ySpeed); 
	}

	@Override
	public Position move() {
		double x = obj.getxSpeed();
		double y = obj.getySpeed();
		return new Position(x, y);
	}

	public double getxSpeed() {
		return xSpeed;
	}

	public void setxSpeed(double xSpeed) {
		this.xSpeed = xSpeed;
	}

	public double getySpeed() {
		return ySpeed;
	}

	public void setySpeed(double ySpeed) {
		this.ySpeed = ySpeed;
	}
	
	
}
