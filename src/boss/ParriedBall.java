package boss;

import java.awt.Graphics2D;

import logic.Position;
import render.Resource;

public class ParriedBall extends BossAttack{
	
	private int z;
	private boolean isParried;

	public ParriedBall(Position a, int width, int height, int xSpeed, int ySpeed) {
		super(a, width, height, xSpeed, ySpeed);
		z = Integer.MAX_VALUE;
		isParried = false;
	}
	
	public boolean isParried() {
		return isParried;
	}

	public void setParried(boolean isParried) {
		this.isParried = isParried;
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		if (!isParried) {
			g2d.drawImage(Resource.ParriedBall1,this.getB().getX(),this.getB().getY(),null);
	}
		else {
			g2d.drawImage(Resource.ParriedBall2,this.getB().getX(),this.getB().getY(),null);
		}
	}
}
