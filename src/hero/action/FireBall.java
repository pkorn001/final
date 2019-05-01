package hero.action;

import java.awt.Graphics2D;

import hero.base.Mage;
import logic.Hitbox;
import logic.Position;
import render.Renderable;

public class FireBall extends Hitbox implements Renderable {
	//xSpeed > map's speed, graphic, collide?, 
	public static final int FIREBALL_SPEED = 2;
	
	public FireBall(Position position, int speed) {
		super(position, speed);
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean IsVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}
}
