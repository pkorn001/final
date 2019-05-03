package obstacle;

import java.awt.Graphics2D;

import javafx.scene.canvas.GraphicsContext;
import logic.Hitbox;
import logic.Position;
import move.Move;
import render.Irenderable;
import render.Resource;

public class Monster extends Hitbox implements Irenderable{
	
	/* 0 = normal 
	 1 = red 
	 2 = green
	 3 = black
	 4 = purple */
	protected int monsterType;
	protected int monsterPoint;
	protected final static int[] MONSTER_POINT = {0,50,200,70,60};
	protected boolean destroyed;
	protected Move movePattern;
	protected int z;
	
	

	public Monster(Position a,int monsterType,double xSpeed,double ySpeed) {
		super(a,20,20,xSpeed,ySpeed);
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
	public void draw(GraphicsContext g2d) {
		if (isDestroyed()) {
		}
		else {
		}
	}

	@Override
	public void update(double xSpeed, double ySpeed, long time) {
		for(Position i  : new Position[] {this.A, this.B, this.C, this.D}){
			i.setX(this.movePattern.move(time).getX());
			i.setY(this.movePattern.move(time).getY());
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
	
	


