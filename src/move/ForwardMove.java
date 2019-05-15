package move;

import logic.Hitbox;
import logic.Position;
import obstacle.Monster;

public class ForwardMove implements Move {
	
	private double xSpeed;
	private double ySpeed;
	private Hitbox obj;
	
	public ForwardMove (Hitbox obj) {
		this.obj = obj;
		this.xSpeed = -25;
		this.ySpeed = 0;
		obj.setxSpeed(xSpeed); 
		obj.setySpeed(ySpeed); 
	}

	@Override
	public Position move() {
		double x = obj.getxSpeed();
		double y = 0;
		return new Position(x, y);
	}
}
