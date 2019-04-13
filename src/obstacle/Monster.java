package obstacle;

import mechanic.Hitbox;
import mechanic.Position;

public class Monster extends Hitbox{
	
	/* 0 = normal 
	 1 = red 
	 2 = green
	 3 = black
	 4 = purple */
	private int monsterType;
	private int monsterPoint;
	private final static int[] MONSTER_POINT = {0,50,200,70,60};
	private boolean destroyed;
	
	

	public Monster(Position a,int monsterType,int speed) {
		super(a,20,20,speed);
		this.monsterType = monsterType;
		
	}

	public void setMonsterPoint(int monsterType) {
		this.monsterPoint = MONSTER_POINT[monsterType];

	}

	public int getMonsterPoint() {
		return monsterPoint;
	}


	public void setMonsterType(int monsterType) {
		this.monsterType = monsterType;
	}


	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}
	
}
	
	


