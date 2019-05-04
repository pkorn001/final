package hero.base;

import javafx.animation.AnimationTimer;
import logic.Hitbox;
import logic.Position;
import obstacle.Monster;
import render.Irenderable;

public abstract class Hero extends Hitbox implements Irenderable {

	public static final int HEIGHT = 100;
	private static int score;
	private static int stage;
	
	protected int xSpeed;
	protected Position position = new Position(this.C.getX(), this.C.getY() / 2);
	protected Hitbox hero;
	protected boolean isDestroyed = false;

	public Hero(Position a, int xSpeed) {
		super(a, xSpeed);
		this.hero = new Hitbox(a, 3, 5) {
		};
		Hero.stage = 0;
		Hero.score = 0;
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

	public static int getScore() {
		return Hero.score;
	}

	public static void setScore(int score) {
		Hero.score = score;
	}
	
	public static int getStage() {
		return Hero.stage;
	}
	
	public static void setStage(int stage) {
		Hero.stage = stage;
	}

	public double getHeight() {
		return HEIGHT;
	}
	
	// when hit with st what happen?
	@Override
	public boolean collide(Hitbox hitbox) {
		return false;
	}

	@Override
	public boolean isDestroyed() {
		return isDestroyed;
	}
}
