package move;

import logic.Hitbox;
import logic.Position;
import obstacle.Monster;

public class SineMove implements Move {
	
	private double xSpeed;
	private double ySpeed;
	private Hitbox obj;;
	private long time;
	
	public SineMove(Hitbox obj) {
		this.obj = obj;
		this.xSpeed = -25;
		this.ySpeed = 10;
		obj.setxSpeed(xSpeed); 
		obj.setySpeed(ySpeed); 
	}

	@Override
	public Position move() {
		double x = this.xSpeed;
		double y = 200 * Math.sin(ySpeed);
		return new Position(x, y);
	}
}
