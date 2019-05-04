package hero.base;

import hero.action.Attackable;
import hero.action.Boomerang;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import logic.Hitbox;
import logic.Position;
import obstacle.Monster;
import render.Resource;

public class Boomeranger extends Hero implements Attackable {

	private Hitbox attackBox;

	public Boomeranger(Position position, int speed) {
		super(position, speed);
	}

	public Hitbox getAttackBox() {
		return attackBox;
	}

	@Override
	public void attack() {
		Boomerang boomerange = new Boomerang(new Position(this.getC().getX() + 1, this.getC().getY() / 2));
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
		setScore( getScore() + monster.getMonsterPoint());
	}

	@Override
	public void draw(GraphicsContext g2d) {
		// TODO Auto-generated method stub
		g2d.drawImage(Resource.Hero2, this.getA().getX(), this.getA().getY(), this.getWidth(), this.getHeight());
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
