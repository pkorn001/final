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
	public static final double FIREBALL_SPEED = 10.0;
	private int z;
	private Position position;
	private boolean isDestroyed = false;
	
	
	public FireBall(Position position) {
		super(position, 10, 10, FIREBALL_SPEED, 0);
		this.z = Integer.MAX_VALUE;
		this.position = position;
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
		return 5;
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return this.isDestroyed;
	}

	@Override
	public void draw(GraphicsContext g2d) {
		// TODO Auto-generated method stub
		
		g2d.drawImage(Resource.FireBall, this.B.getX(), this.B.getY());
		// draw in front of hero
	}
	
	public void setDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

}
