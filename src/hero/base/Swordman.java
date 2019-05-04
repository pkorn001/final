package hero.base;

import hero.action.Attackable;
import javafx.scene.canvas.GraphicsContext;
import logic.Hitbox;
import logic.Position;
import obstacle.Monster;
import render.Resource;

public class Swordman extends Hero implements Attackable {

	private static Hitbox attackBox;

	public Swordman(Position position, int speed) {
		super(position, speed);
	}

	@Override
	public void attack() {
		attackBox = new Hitbox(new Position(this.C.getX() + 1, this.C.getY() / 2), 1, 1) {
		};
	}

	@Override
	public void updateScore(Monster monster) {
		// TODO Auto-generated method stub
		setScore( getScore() + monster.getMonsterPoint());
	}
	
	public static Hitbox getAttackBox() {
		return attackBox;
	}

	@Override
	public void draw(GraphicsContext g2d) {
		g2d.drawImage(Resource.Hero3, position.getX(), position.getY());
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
