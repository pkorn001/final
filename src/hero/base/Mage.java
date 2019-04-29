package hero.base;

import java.util.ArrayList;
import hero.action.Attackable;
import javafx.animation.AnimationTimer;
import logic.Hitbox;
import logic.Position;
import obstacle.Sprite;

public class Mage extends Hero implements Attackable {
	
	final long startNanoTime = System.nanoTime();
	private Sprite attack;
	private int c = this.getC().getY()/2;
	public Mage(Position position, int speed) {
		super(position, speed);
	}

	@Override
	public boolean attack() {
		Fireball fireball = new Fireball();
		if(fireball.collide())      
		return false;
	}

	@Override
	public void updateScore() {
		// TODO Auto-generated method stub
		
	}

}
