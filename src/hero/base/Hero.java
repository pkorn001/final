package hero.base;

import item.Item;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import logic.Hitbox;
import logic.Position;
import obstacle.Monster;
import obstacle.ObstacleBox;
import render.Irenderable;
import render.Resource;

public class Hero extends Hitbox implements Irenderable {

	public static final int HEIGHT = 100;
	private static int score;
	private static int stage = 0;

	protected int z;
	protected Position position;
	protected boolean isDestroyed = false;
	protected boolean isJumped = false;

	public Hero(Position a) {
		super(a, 167, 300);
		Hero.stage = 0;
		Hero.score = 0;
		this.z = Integer.MAX_VALUE;
		this.position = a;
	}
	
	public void updateScore(Monster monster) {
		// TODO Auto-generated method stub
		setScore( getScore() + monster.getMonsterPoint());
	}
	
	public boolean isJumped() {
		return isJumped;
	}

	public void setJumped(boolean isJumped) {
		this.isJumped = isJumped;
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

	public void setDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}

	@Override
	public boolean isDestroyed() {
		return isDestroyed;
	}

	@Override
	public void draw(GraphicsContext g2d, long time) {
		// TODO Auto-generated method stub
		g2d.drawImage(Resource.Hero0, position.getX(), position.getY());
	}

	@Override
	public boolean IsVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;
	}

}
