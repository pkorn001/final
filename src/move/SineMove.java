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
		this.xSpeed = -50;
		this.ySpeed = 10;
		obj.setxSpeed(xSpeed); 
		obj.setySpeed(ySpeed); 
	}
	
	@Override
	public Position move(long time) {
		double x = obj.getA().getX() + this.xSpeed * time;
		double y = obj.getA().getY() + 400 * Math.sin(ySpeed * time);
		return new Position(x, y);
	}
}
