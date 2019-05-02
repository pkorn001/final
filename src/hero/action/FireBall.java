package hero.action;

import java.awt.Graphics2D;

import hero.base.Mage;
import logic.Hitbox;
import logic.Position;
import render.Irenderable;
import render.Resource;

public class FireBall extends Hitbox implements Irenderable {
	//xSpeed > map's speed, graphic, collide?, 
	public static final int FIREBALL_SPEED = 2;
	private int z;
	private boolean isDestroyed = false;
	
	
	public FireBall(Position position, int speed) {
		super(position, speed);
		this.z = Integer.MAX_VALUE;
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.drawImage(Resource.FireBall,this.getB().getX(),this.getB().getY(),null);
	}

	@Override
	public boolean IsVisible() {
		return true;
	}

	@Override
	public int getZ() {
		return z--;
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return this.isDestroyed;
	}
	
	public void setDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}
}
