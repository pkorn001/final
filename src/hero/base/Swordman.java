package hero.base;

import hero.action.Attackable;
import javafx.scene.canvas.GraphicsContext;
import logic.Hitbox;
import logic.Position;
import obstacle.Monster;

public class Swordman extends Hero implements Attackable {

	private Hitbox attackBox;

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
