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
	private FireBall fireball;

	public Mage(Position position, int speed) {
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
				fireball.update(FireBall.FIREBALL_SPEED, 0, time );
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
	public void draw(GraphicsContext g2d, long time) {
		// TODO Auto-generated method stub
		g2d.drawImage(Resource.Hero1, this.getA().getX(), this.getA().getY(), this.getWidth(), this.getHeight());
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
<<<<<<< HEAD


||||||| merged common ancestors

	@Override
	public void draw(GraphicsContext g2d) {
		// TODO Auto-generated method stub
		g2d.drawImage(Resource.Hero1, this.getA().getX(), this.getA().getY(), this.getWidth(), this.getHeight());
	}


=======
>>>>>>> 1744ad215e28e74f46172d896fdaa04f964e8412
}
