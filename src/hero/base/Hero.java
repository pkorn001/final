package hero.base;

import javafx.animation.AnimationTimer;
import logic.Hitbox;
import logic.Position;
import obstacle.Monster;
import render.Irenderable;

public abstract class Hero extends Hitbox implements Irenderable {

	public static final int HEIGHT = 100;
	public static int score;
	protected int xSpeed;
	protected Position position = new Position(this.C.getX(), this.C.getY() / 2);
	protected Hitbox hero;
	protected boolean isDestroyed = false;

	public Hero(Position a, int xSpeed) {
		super(a, xSpeed);
		this.hero = new Hitbox(a, 3, 5) {
		};
		this.position = a;
		this.xSpeed = xSpeed;
	}

	public void jump() {
		new AnimationTimer() {

			@Override
			public void handle(long now) {
				boolean hasJumped = false;
				double maxHeight = getC().getY() + 2;
				double ground = getA().getY();
				long time = (now - System.nanoTime()) * 60 / 1000000000;
				if (getC().getY() < maxHeight && !hasJumped) {
					for (Position i : new Position[] { getA(), getB(), getC(), getD() }) {
						if (getB().getY() > maxHeight) {
							getB().setY(maxHeight);
							getC().setY(maxHeight);
							hasJumped = true;
							break;
						} else {
							i.setY(i.getY() + 2 * time);
						}
					}
				}
				try {
					wait(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (hasJumped) {
					for (Position i : new Position[] { getA(), getB(), getC(), getD() }) {
						if (getA().getY() < 0) {
							getA().setY(ground);
							getD().setY(ground);
							stop();
						} else {
							i.setY(i.getY() - 2 * time);
						}
					}
				}
			}

		}.start();
	}

	public abstract void updateScore(Monster monster);

	public double getxSpeed() {
		return xSpeed;
	}

	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public double getHeight() {
		return HEIGHT;
	}

	@Override
	public boolean isDestroyed() {
		return isDestroyed;
	}
}
