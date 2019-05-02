package hero.base;

import java.awt.Graphics2D;

import hero.action.Attackable;
import hero.action.Boomerange;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import logic.Hitbox;
import logic.Position;

public class Boomeranger extends Hero implements Attackable {
	
	private Hitbox attackBox;
	
	public Boomeranger(Position position, int speed) {
		super(position, speed);
	}

	@Override
	public boolean attack() {
		Boomerange  boomerange = new Boomerange(new Position(this.C.getX()+1, this.C.getY()/2));
		new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				boomerange.move();
			}
		};
		if(boomerange.collide(monster))
			return true;
		return false;
	}

	@Override
	public void updateScore() {
		// TODO Auto-generated method stub
		if(this.attack()) {
			score += monster.getMonsterPoint();
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
