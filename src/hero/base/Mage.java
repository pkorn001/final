package hero.base;

import hero.action.Attackable;
import hero.action.FireBall;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import logic.GameLogic;
import logic.Position;
import obstacle.Monster;
import render.Irenderable;
import render.Resource;

public class Mage extends Hero implements Attackable,Irenderable {

	final long startNanoTime = System.nanoTime();
	private FireBall fireball;

	public Mage(Position position) {
		super(position);
	}

	public FireBall getFireball() {
		return fireball;
	}

	@Override
	public void attack() {
		fireball = new FireBall(new Position(this.C.getX(), this.C.getY() / 2));
		new AnimationTimer() {

			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				long time =  (now - System.nanoTime()) * 60 / 1000000000;
				fireball.update();
			}
		}.start();
	}

	@Override
	public void updateScore(Monster monster) {
		// TODO Auto-generated method stub
		setScore(getStage()+monster.getMonsterPoint());
		monster.setDestroyed(true);
	}

	@Override
	public void draw(GraphicsContext g2d) {
		g2d.drawImage(Resource.BossAttack,A.getX(),A.getY(),5,5);
		g2d.drawImage(Resource.BossAttack,B.getX(),B.getY(),5,5);
		g2d.drawImage(Resource.BossAttack,C.getX(),C.getY(),5,5);
		g2d.drawImage(Resource.BossAttack,D.getX(),D.getY(),5,5);
		// TODO Auto-generated method stub
		if(GameLogic.isAttack()) {
			g2d.drawImage(Resource.Hero1_Attack, this.getA().getX(), this.getB().getY(), this.getWidth(), this.getHeight());
		}else {
			g2d.drawImage(Resource.Hero1, this.getA().getX(), this.getB().getY(),167,300);
		}
	}
	@Override
	public boolean IsVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 5;
	}

}
