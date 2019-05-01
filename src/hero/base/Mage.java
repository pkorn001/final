package hero.base;

import java.awt.Graphics2D;
import java.util.ArrayList;
import hero.action.Attackable;
import hero.action.FireBall;
import javafx.animation.AnimationTimer;
import logic.Hitbox;
import logic.Position;
import obstacle.Sprite;

public class Mage extends Hero implements Attackable {
	
	final long startNanoTime = System.nanoTime();
	private Sprite attack;

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
				fireball.update(FireBall.FIREBALL_SPEED, 0);
			}
		};
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
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		
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

}
