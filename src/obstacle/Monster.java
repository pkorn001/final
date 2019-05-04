package obstacle;


import javafx.scene.canvas.GraphicsContext;
import logic.Hitbox;
import logic.Position;
import move.Move;
import render.Irenderable;

public abstract class Monster extends Hitbox implements Irenderable{
	
	/* 0 = normal 
	 1 = red 
	 2 = green
	 3 = black
	 4 = purple */
	protected int monsterType;
	protected int monsterPoint;
	protected final static int[] MONSTER_POINT = {0,700,200,50,60,50};
	protected boolean destroyed;
	protected Move movePattern;
	protected int z;
	
	

	public Monster(Position a,int width,int height,int monsterType,double xSpeed,double ySpeed) {
		super(a,width,height,xSpeed,ySpeed);
		this.z = Integer.MAX_VALUE;
		this.destroyed = false;
		this.monsterType = monsterType;
		setMonsterPoint(monsterType);
		
	}
	
	
	public void setMonsterPoint(int monsterType) {
		this.monsterPoint = MONSTER_POINT[monsterType];

	}
	
	public int getMonsterPoint() {
		return this.monsterPoint;
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}
	
	public boolean isDestroyed() {
		return this.destroyed;
	}

	public int getMonsterType() {
		return this.monsterType;
	}
	
	public Move getMovePattern() {
		return movePattern;
	}


	public void setMovePattern(Move movePattern) {
		this.movePattern = movePattern;
	}


	@Override
	public abstract void draw(GraphicsContext g2d);

	@Override
	public void update(double xSpeed, double ySpeed, long time) {
		for(Position i  : new Position[] {this.A, this.B, this.C, this.D}){
			i.setX(i.getX()+this.movePattern.move(time).getX());
			i.setY(i.getY()+this.movePattern.move(time).getY());
		}
	}
	
	@Override
	public boolean IsVisible() {
		return true;
	}

	@Override
	public int getZ() {
		return z--;
	}
}
	
	


