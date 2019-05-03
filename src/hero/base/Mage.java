package hero.base;

import java.util.ArrayList;
import hero.action.Attackable;
import hero.action.FireBall;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import logic.Hitbox;
import logic.Position;

public class Mage extends Hero implements Attackable {
	
	final long startNanoTime = System.nanoTime();

	public Mage(Position position, int speed) {
		super(position, speed);
	}

	@Override
	public boolean attack() {
		FireBall fireball = new FireBall(new Position(this.C.getX(), this.C.getY()/2), FireBall.FIREBALL_SPEED); 
		new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				int time = (int) ((now - System.nanoTime())/1000000000.0);
				fireball.update(FireBall.FIREBALL_SPEED, 0, time/3);
			}
		}.start();
		if(fireball.collide(monster))
			return true;
		return false;
	}

	@Override
	public void updateScore() {
		// TODO Auto-generated method stub
		if(this.attack()) {
			score += monster.getMonsterPoint();
			monster.setDestroyed(true);
		}
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
