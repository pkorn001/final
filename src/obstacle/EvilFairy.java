package obstacle;

import hero.action.Boomerang;
import hero.action.FireBall;
import javafx.scene.canvas.GraphicsContext;
import logic.Hitbox;
import logic.Position;
import move.SineMove;
import render.Resource;

public class EvilFairy extends Monster{

	public EvilFairy(Position a, int width, int height, int monsterType, double xSpeed, double ySpeed) {
		super(a, width, height, monsterType, xSpeed, ySpeed);
		movePattern = new SineMove(this);
	}

	@Override
	public void draw(GraphicsContext g2d) {
		if (isDestroyed()) {
			g2d.drawImage(Resource.Dead,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight());
		}
		else {
			g2d.drawImage(Resource.Monster3,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight());
		}
	}
	
	@Override
	public boolean collide(Hitbox hitbox) {
		if (hitbox instanceof Boomerang) {
			if (((this.getA().getX() < hitbox.getD().getX()) && (this.getA().getX() > hitbox.getA().getX()) && (this.getB().getY() > hitbox.getD().getY()))
					|| ((this.getA().getX() < hitbox.getC().getX()) && (this.getD().getX() > hitbox.getC().getX()) && (this.getA().getY() < hitbox.getC().getY()) && (this.getB().getY() > hitbox.getC().getY()))
					|| ((this.getD().getX() > hitbox.getA().getX() && (this.getA().getX() < hitbox.getA().getX()) && (this.getC().getY() > hitbox.getA().getY())))
					|| ((this.getD().getX() > hitbox.getB().getX() && (this.getA().getX() < hitbox.getB().getX()) && (this.getC().getY() > hitbox.getB().getY()) && (this.getD().getY() < hitbox.getB().getY())))
					) {
				this.setDestroyed(true);
			}
		}
		return isDestroyed();
	}
}
