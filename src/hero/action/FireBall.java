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
	private boolean isDestroyed = false;
	
	
	public FireBall(Position position) {
		super(position, 50, 50, FIREBALL_SPEED);
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
//		g2d.drawImage(Resource.BossAttack, this.A.getX(), this.A.getY());
//		g2d.drawImage(Resource.BossAttack, this.B.getX(), this.B.getY());
//		g2d.drawImage(Resource.BossAttack, this.C.getX(), this.C.getY());
//		g2d.drawImage(Resource.BossAttack, this.D.getX(), this.D.getY());
		g2d.drawImage(Resource.FireBall, this.B.getX(), this.B.getY(), 90, 90);
		// draw in front of hero
	}
	
	public void setDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}

}
