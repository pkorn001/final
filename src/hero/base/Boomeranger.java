package hero.base;

import hero.action.Attackable;
import hero.action.Boomerang;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import logic.Hitbox;
import logic.Position;
import obstacle.Monster;

public class Boomeranger extends Hero implements Attackable {

	private Hitbox attackBox;

	public Boomeranger(Position position, int speed) {
		super(position, speed);
	}

	@Override
	public void attack() {
		Boomerang boomerange = new Boomerang(new Position(this.C.getX() + 1, this.C.getY() / 2));
		new AnimationTimer() {

			@Override
			public void handle(long now) {
				boomerange.move();
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
