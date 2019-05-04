package hero.action;

import javafx.scene.canvas.GraphicsContext;
import logic.Hitbox;
import logic.Position;
import obstacle.Monster;
import obstacle.ObstacleBox;
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
	public boolean collide(Hitbox hitbox) {
		if(hitbox instanceof Monster || hitbox instanceof ObstacleBox) {
			if(((this.getA().getX() < hitbox.getD().getX()) && (this.getA().getX() > hitbox.getA().getX()) && (this.getB().getY() > hitbox.getD().getY()))
					|| ((this.getA().getX() < hitbox.getC().getX()) && (this.getD().getX() > hitbox.getC().getX()) && (this.getA().getY() < hitbox.getC().getY()) && (this.getB().getY() > hitbox.getC().getY()))
					|| ((this.getD().getX() > hitbox.getA().getX() && (this.getA().getX() < hitbox.getA().getX()) && (this.getC().getY() > hitbox.getA().getY())))
					|| ((this.getD().getX() > hitbox.getB().getX() && (this.getA().getX() < hitbox.getB().getX()) && (this.getC().getY() > hitbox.getB().getY()) && (this.getD().getY() < hitbox.getB().getY())))
					) {
				this.setDestroyed(true);
				((Monster) hitbox).setDestroyed(true);
			}
		}
		return isDestroyed();
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

	@Override
	public void draw(GraphicsContext g2d) {
		// TODO Auto-generated method stub
		
	}
}
