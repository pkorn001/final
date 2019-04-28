package obstacle;

import java.awt.Graphics2D;

import logic.Hitbox;
import logic.Position;
import render.Renderable;
import render.Resource;

public class Monster extends Hitbox implements Renderable{
	
	/* 0 = normal 
	 1 = red 
	 2 = green
	 3 = black
	 4 = purple */
	private int monsterType;
	private int monsterPoint;
	private final static int[] MONSTER_POINT = {0,50,200,70,60};
	private boolean destroyed;
	private int z;
	
	

	public Monster(Position a,int monsterType,int xSpeed,int ySpeed) {
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
	@Override
	public void draw(Graphics2D g2d) {
		if (isDestroyed()) {
			g2d.drawImage(Resource.Monster5,this.getB().getX(),this.getB().getY(),null);
		}
		
		else {
			if (getMonsterType() == 0 )
				g2d.drawImage(Resource.Monster0,this.getB().getX(),this.getB().getY(),null);
			else if (getMonsterType() == 1)
				g2d.drawImage(Resource.Monster1,this.getB().getX(),this.getB().getY(),null);
			else if (getMonsterType() == 2)
				g2d.drawImage(Resource.Monster2,this.getB().getX(),this.getB().getY(),null);
			else if (getMonsterType() == 3)
				g2d.drawImage(Resource.Monster3,this.getB().getX(),this.getB().getY(),null);
			else if (getMonsterType() == 4)
				g2d.drawImage(Resource.Monster4,this.getB().getX(),this.getB().getY(),null);
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
	
	


