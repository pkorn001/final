package obstacle;

import java.util.Random;

import hero.action.FireBall;
import hero.base.Swordman;
import javafx.scene.canvas.GraphicsContext;
import logic.Hitbox;
import logic.Position;
import move.ForwardMove;
import move.SineMove;
import render.Irenderable;
import render.Resource;

public class FlyingFire extends Monster implements Irenderable{
	
	Random moveType = new Random();

	public FlyingFire(Position a,int width,int height,int monsterType, double xSpeed, double ySpeed) {
		super(a,width,height,monsterType, xSpeed, ySpeed);
		if(moveType.nextInt(3) == 0) {
			movePattern = new SineMove(this);
		}
		else {
			movePattern = new ForwardMove(this);
		}
	}
	
	@Override
	public void draw(GraphicsContext g2d) {
		g2d.drawImage(Resource.BossAttack,A.getX(),A.getY(),5,5);
		g2d.drawImage(Resource.BossAttack,B.getX(),B.getY(),5,5);
		g2d.drawImage(Resource.BossAttack,C.getX(),C.getY(),5,5);
		g2d.drawImage(Resource.BossAttack,D.getX(),D.getY(),5,5);
		if (isDestroyed()) {
			g2d.drawImage(Resource.Dead,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight());
		}
		else {
			g2d.drawImage(Resource.Monster2,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight());
		}
	}
	
	@Override
	public boolean collide(Hitbox hitbox) {
		if (hitbox instanceof FireBall) {
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
