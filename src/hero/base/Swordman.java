package hero.base;

import hero.action.Attackable;
import javafx.scene.canvas.GraphicsContext;
import logic.Hitbox;
import logic.Position;
import obstacle.Monster;
import render.Resource;

public class Swordman extends Hero implements Attackable {

	private static Hitbox attackBox;
	private boolean isJumped = false;
	private boolean isAttacked = false;
	
	public boolean isJumped() {
		return isJumped;
	}

	public void setJumped(boolean isJumped) {
		this.isJumped = isJumped;
	}

	public boolean isAttacked() {
		return isAttacked;
	}
	
	public static Hitbox getAttackBox() {
		return attackBox;
	}

	public void setAttacked(boolean isAttacked) {
		this.isAttacked = isAttacked;
	}

	public Swordman(Position position, int speed) {
		super(position, speed);
	}

	@Override
	public void attack() {
		attackBox = new Hitbox(new Position(this.getC().getX() + 1, this.getC().getY() / 2), 1, 1) {
		};
	}

	@Override
	public void updateScore(Monster monster) {
		// TODO Auto-generated method stub
		setScore( getScore() + monster.getMonsterPoint());
	}


	@Override
	public void draw(GraphicsContext g2d, long time) {
		g2d.drawImage(Resource.Hero3, this.getA().getX(), this.getA().getY(), this.getWidth(), this.getHeight());
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
