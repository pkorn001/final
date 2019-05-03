package hero.base;

import item.Item;
import javafx.animation.AnimationTimer;
import logic.Hitbox;
import logic.Position;
import obstacle.Monster;
import obstacle.ObstacleBox;
import render.Irenderable;

public abstract class Hero extends Hitbox implements Irenderable{
	
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

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void setObstacle(ObstacleBox obstacle) {
		this.obstacle = obstacle;
	}

	public void setMonster(Monster monster) {
		this.monster = monster;
	}

	public double getHeight() {
		return HEIGHT;
	}

	@Override
	public boolean isDestroyed() {
		return isDestroyed;
	}
}
