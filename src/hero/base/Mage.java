package hero.base;

import hero.action.Attackable;
import hero.action.FireBall;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import logic.Position;
import obstacle.Monster;
import render.Resource;

public class Mage extends Hero implements Attackable {

	final long startNanoTime = System.nanoTime();

	public Mage(Position position, int speed) {
		super(position, speed);
	}

	@Override
	public void attack() {
		FireBall fireball = new FireBall(new Position(this.getC().getX(), this.getC().getY() / 2));
		new AnimationTimer() {

			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				long time =  (now - System.nanoTime()) * 60 / 1000000000;
				fireball.update(FireBall.FIREBALL_SPEED, 0, time );
			}
		}.start();
	}

	@Override
	public void updateScore(Monster monster) {
		// TODO Auto-generated method stub
		setScore( getScore() + monster.getMonsterPoint());
	}

	@Override
	public void draw(GraphicsContext g2d, long time) {
		// TODO Auto-generated method stub
		g2d.drawImage(Resource.Hero1, this.getA().getX(), this.getA().getY(), this.getWidth(), this.getHeight());
	}

	@Override
	public boolean IsVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return z--;
	}



}
