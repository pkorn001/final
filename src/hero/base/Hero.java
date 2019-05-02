package hero.base;

import item.Item;
import javafx.stage.Stage;
import logic.Hitbox;
import logic.Position;
import obstacle.Monster;
import obstacle.ObstacleBox;
import render.Renderable;

public abstract class Hero extends Hitbox implements Renderable{
	
	public static final int HEIGHT = 100;
//	private boolean isDead = false;
	public int score;
	protected int xSpeed;
	protected Position position = new Position(this.C.getX(), this.C.getY()/2);
	protected Stage stage;
	protected ObstacleBox obstacle;
	protected Hitbox hero;
	protected Monster monster;
	
	public Hero(Position a, int xSpeed) {
		super(a, xSpeed);
		this.hero = new Hitbox(a, 3, 5) {
		};
		this.position = a;
		this.xSpeed = xSpeed;
	}
	
	public int getxSpeed() {
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

	public abstract void updateScore();

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

	public static int getHeight() {
		return HEIGHT;
	}
	
	public void transform(Item item) {
		switch(item.getItemType()) {
		case("Assassin"):
			this.hero = new Assassin(position, xSpeed);
			break;
		case("Boomeranger"):
			this.hero = new Boomeranger(position, xSpeed);
			break;
		case("Mage"):
			this.hero = new Mage(position, xSpeed);
			break;
		case("Swordman"):
			this.hero = new Swordman(position, xSpeed);
			break;
		}
	
	}
	
	public void jump() throws InterruptedException {
		this.setA(new Position(this.getA().getX(), this.getA().getY()+2)); //PosA same X increase Y by 2
		this.setB(new Position(this.getB().getX(), this.getB().getY()+2)); //PosB same X increase Y by 2
		this.setC(new Position(this.getC().getX(), this.getC().getY()+2)); //PosC same X increase Y by 2
		this.setD(new Position(this.getD().getX(), this.getD().getY()+2)); //PosD same X increase Y by 2
		wait(1000);            											   //wait 1 second before fall down
		this.setA(new Position(this.getA().getX(), this.getA().getY()-2)); //PosA get back to first Y-position
		this.setB(new Position(this.getB().getX(), this.getB().getY()-2)); //PosB get back to first Y-position
		this.setC(new Position(this.getC().getX(), this.getC().getY()-2)); //PosC get back to first Y-position
		this.setD(new Position(this.getD().getX(), this.getD().getY()-2)); //PosD get back to first Y-position
		
	}
	
	@Override
	public boolean isDestroyed() {
		return this.collide(monster) || this.collide(obstacle);
	}
	
}
