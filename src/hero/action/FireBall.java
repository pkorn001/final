package hero.action;

import javafx.scene.canvas.GraphicsContext;
import logic.Hitbox;
import logic.Position;
import obstacle.FlyingFire;
import obstacle.Monster;
import obstacle.ObstacleBox;
import obstacle.Slime;
import render.Irenderable;
import render.Resource;

public class FireBall extends Hitbox implements Irenderable {
	//xSpeed > map's speed, graphic, collide?, 
	public static final int FIREBALL_SPEED = 2;
	private int z;
	private Position heroPoint;
	private boolean isDestroyed = false;
	
	
	public FireBall(Position position) {
		super(position, 1, 1, FIREBALL_SPEED, 0);
		this.z = Integer.MAX_VALUE;
		heroPoint = new Position(position.getX()-1, position.getY());
	}
	
	@Override
	public boolean collide(Hitbox hitbox) {
		if(hitbox instanceof ObstacleBox || hitbox instanceof FlyingFire || hitbox instanceof Slime) {
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

	@Override
	public void draw(GraphicsContext g2d, long time) {
		// TODO Auto-generated method stub
		g2d.drawImage(Resource.FireBall, heroPoint.getX()+1, heroPoint.getY());
		// draw in front of hero
	}
	
	public void setDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}

}
