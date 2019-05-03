package hero.base;

import hero.action.Attackable;
import hero.action.FireBall;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import logic.Position;
import obstacle.Monster;

public class Mage extends Hero implements Attackable {

	final long startNanoTime = System.nanoTime();

	public Mage(Position position, int speed) {
		super(position, speed);
	}

	@Override
	public void attack() {
		FireBall fireball = new FireBall(new Position(this.C.getX(), this.C.getY() / 2), FireBall.FIREBALL_SPEED);
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
		score += monster.getMonsterPoint();
		monster.setDestroyed(true);
	}


	@Override
	public boolean IsVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(GraphicsContext g2d) {
		// TODO Auto-generated method stub
		
	}


}
