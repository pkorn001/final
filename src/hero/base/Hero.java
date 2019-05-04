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

public abstract class Hero extends Hitbox implements Irenderable {

	public static final int HEIGHT = 100;
	private static int score;
	private static int stage;

	protected int z;
	protected int xSpeed;
	protected Position position = new Position(this.C.getX(), this.C.getY() / 2);
	protected Hitbox hero;
	protected boolean isDestroyed = false;
	protected boolean isJumped = false;

	public Hero(Position a, int xSpeed) {
		super(a, xSpeed);
		this.hero = new Hitbox(a, 3, 5) {
		};
		Hero.stage = 0;
		Hero.score = 0;
		this.z = Integer.MAX_VALUE;
		this.position = a;
		this.xSpeed = xSpeed;
	}

	public boolean isJumped() {
		return isJumped;
	}

	public void setJumped(boolean isJumped) {
		this.isJumped = isJumped;
	}

	public void tranform(Item item) {
		if (this.collide(item)) {
			switch (item.getItemType()) {
			case ("Mage"):
				hero = new Mage(position, 0);
				break;
			case ("Boomeranger"):
				hero = new Boomeranger(position, 0);
				break;
			case ("Swordman"):
				hero = new Swordman(position, 0);
				break;
			case ("Assassin"):
				hero = new Assassin(position, 0);
				break;
			}
		}
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

	// when hit with stage what happen? >> hero died >> if(hero.collide) >> change
	// gc of hero to dead body.
	@Override
	public boolean collide(Hitbox hitbox) {
		if (hitbox instanceof Monster || hitbox instanceof ObstacleBox) {
			if (((this.getA().getX() < hitbox.getD().getX()) && (this.getA().getX() > hitbox.getA().getX())
					&& (this.getB().getY() > hitbox.getD().getY()))
					|| ((this.getA().getX() < hitbox.getC().getX()) && (this.getD().getX() > hitbox.getC().getX())
							&& (this.getA().getY() < hitbox.getC().getY())
							&& (this.getB().getY() > hitbox.getC().getY()))
					|| ((this.getD().getX() > hitbox.getA().getX() && (this.getA().getX() < hitbox.getA().getX())
							&& (this.getC().getY() > hitbox.getA().getY())))
					|| ((this.getD().getX() > hitbox.getB().getX() && (this.getA().getX() < hitbox.getB().getX())
							&& (this.getC().getY() > hitbox.getB().getY())
							&& (this.getD().getY() < hitbox.getB().getY())))) {
				this.setDestroyed(true);
			} else if (hitbox instanceof Item) {
				this.tranform((Item) hitbox);
			}
		}
		return isDestroyed;
	}

	public void setDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}

	@Override
	public boolean isDestroyed() {
		return isDestroyed;
	}

	@Override
	public void draw(GraphicsContext g2d) {
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
		return z--;
	}

}
