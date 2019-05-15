package obstacle;

import hero.action.Boomerang;
import hero.action.FireBall;
import javafx.scene.canvas.GraphicsContext;
import logic.Hitbox;
import logic.Position;
import move.ForwardMove;
import move.SineMove;
import render.Resource;

public class Evil extends Monster{

	public Evil(Position a, int width, int height, int monsterType, double xSpeed, double ySpeed) {
		super(a, width, height, monsterType, xSpeed, ySpeed);
		movePattern = new SineMove(this);
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
			g2d.drawImage(Resource.Monster3,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight());
		}
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(this.getB().getY() <= 600) {
			this.setySpeed(((SineMove)movePattern).getySpeed());
			
		}else if(this.getB().getY() >= 900) {
			this.setySpeed(((SineMove)movePattern).getySpeed() * -1);
		}
		for(Position i  : new Position[] {this.A, this.B, this.C, this.D}){
			i.setX(i.getX() + this.xSpeed);
			i.setY(i.getY() + this.ySpeed);
		}
		System.out.println(((SineMove)movePattern).getySpeed());
		System.out.println(this.xSpeed + " " + this.ySpeed);
		System.out.println(this.A.getX());
		System.out.println(this.A.getY());
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
