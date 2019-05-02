package obstacle;

import java.awt.Graphics2D;
import java.util.Random;

import hero.action.Attackable;
import logic.Hitbox;
import logic.Position;
import render.Irenderable;
import render.Resource;

public class Boss extends Hitbox implements Irenderable,Attackable{ 
	
	/* 
	 1 = red 
	 2 = green
	 3 = black
	 4 = purple */
	private int bossStage;
	private final static int HIT_POINT = 100;
	private static int bossHp = 200;
	private final static int KILLED_POINT = 100*200;
	private static boolean destroyed;
	private int z;
	
	public Boss(Position a,int bossStage,int xSpeed,int ySpeed) {
		super(a,20,20,xSpeed,ySpeed);
		this.z = Integer.MAX_VALUE;
		this.destroyed = false;
		this.bossStage = bossStage;
		
	}
	
	public static void isAttacked() {
		bossHp--;
		if (getBossHp() == 0) {
			destroyed = true;
		}
	}
	
	public int getHIT_POINT() {
		return HIT_POINT;
	}
	
	public int getKILLED_POINT() {
		return KILLED_POINT;
	}
	
	public int getBossStage() {
		return this.bossStage;
	}
	
	public static int getBossHp() {
		return bossHp;
	}
	
	public boolean isDestroyed() {
		return destroyed;
	}
	
	public void create(int monsterType,int xSpeed,int ySpeed){
		Monster a = new Monster(this.getA(),monsterType,xSpeed,ySpeed);
	}
	
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		Random attackPattern = new Random();
		Random attackType = new Random();
		Random monsterType = new Random();
		
		
		switch(attackPattern.nextInt(2)) {
		
		case 0:  
			switch(attackType.nextInt(2)) {
			/*0 = parried
			  1 = boss_fireball
			  2 = monster */
			case 0: 
			case 1:	
			case 2: new Monster(this.getA(),monsterType.nextInt(5),50,0);
				
				
		}
		case 1:
		case 2:
		}
	}

	@Override
	public void draw(Graphics2D g2d) {
		if (isDestroyed()) {
			switch(getBossStage()) {
			case 1: g2d.drawImage(Resource.DeadBoss1,this.getB().getX(),this.getB().getY(),null);
			case 2: g2d.drawImage(Resource.DeadBoss2,this.getB().getX(),this.getB().getY(),null);
			case 3: g2d.drawImage(Resource.DeadBoss3,this.getB().getX(),this.getB().getY(),null);
			case 4: g2d.drawImage(Resource.DeadBoss4,this.getB().getX(),this.getB().getY(),null);
			}
		}
		
		else {
			if (getBossHp() <= 100) {
				switch(getBossStage()) {
				case 1: g2d.drawImage(Resource.HardBoss1,this.getB().getX(),this.getB().getY(),null);
				case 2: g2d.drawImage(Resource.HardBoss2,this.getB().getX(),this.getB().getY(),null);
				case 3: g2d.drawImage(Resource.HardBoss3,this.getB().getX(),this.getB().getY(),null);
				case 4: g2d.drawImage(Resource.HardBoss4,this.getB().getX(),this.getB().getY(),null);
				}
			}
			else {
				switch(getBossStage()) {
				case 1: g2d.drawImage(Resource.Boss1,this.getB().getX(),this.getB().getY(),null);
				case 2: g2d.drawImage(Resource.Boss2,this.getB().getX(),this.getB().getY(),null);
				case 3: g2d.drawImage(Resource.Boss3,this.getB().getX(),this.getB().getY(),null);
				case 4: g2d.drawImage(Resource.Boss4,this.getB().getX(),this.getB().getY(),null);
			}
		}
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
