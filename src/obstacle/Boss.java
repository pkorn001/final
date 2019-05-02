package obstacle;

import java.awt.Graphics2D;

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
	private static int hitPoint = 100;
	private static int bossHp = 200;
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
	
	public int getHitPoint() {
		return hitPoint;
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
	
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
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
