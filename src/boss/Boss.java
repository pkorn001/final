package boss;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import hero.action.Attackable;
import logic.Hitbox;
import logic.Position;
import obstacle.Monster;
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
		if(!destroyed) {
			bossHp--;
		}
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
	public boolean attack() {
		
		Random attackPattern = new Random();
		Random attackType = new Random();
		Random monsterType = new Random();
		
		List<Integer> list = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for(int e = 0;e < 10 ;e++) {
			list.add(e);
		}
		for(int e = 0;e < 4 ;e++) {
			list2.add(e);
		}
		if ((getBossHp() <= 100)) {
			switch(attackPattern.nextInt(2)) {
			
			case 1: 
				for (int j = 0;j<5;j++) {
					int i = attackPattern.nextInt(list.size());
					int k = i;
					list.remove(k);
					
					if (i == 0) {
							ParriedBall a = new ParriedBall(new Position(1080,100),50 ,50, -50, 0);
					}
					
					else if (i == 1) {
							ParriedBall b = new ParriedBall(new Position(1080,100), 50, 50, -50, 0);
					}
					
					else if (i == 2) {
							ParriedBall c = new ParriedBall(new Position(1080,250),50 ,50, -50, 0);
					}
					
					else if (i == 3) {
							ParriedBall d = new ParriedBall(new Position(1080,250),50 ,50, -50, 0);
					}
					
					else if (i == 4) {
							BossAttack e = new BossAttack(new Position(1080,100),50 ,50, -50, 0);
					}
					else if (i == 5) {
							BossAttack f = new BossAttack(new Position(1080,100), 50, 50, -50, 0);
					}
					else if (i == 6) {
							BossAttack g = new BossAttack(new Position(1080,100), 50, 50, -50, 0);
					}
					else if (i == 7) {
							BossAttack h = new BossAttack(new Position(1080,250), 50, 50, -50, 0);
					}
					else if (i == 8) {
							BossAttack I = new BossAttack(new Position(1080,250), 50, 50, -50, 0);
					}
					else if (i == 7) {
							BossAttack J = new BossAttack(new Position(1080,250), 50, 50, -50, 0);
					}
					try {
					wait(200);
					}
					catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			
			case 2:  
				for (int i = 0;i<5;i++) {
					if (i == 0) {
						/*0 = parried
						  1 = boss_fireball
						  2 = monster */
							if (attackType.nextInt(2) == 0) { 
									ParriedBall a = new ParriedBall(this.getA(),50 ,50, -50, 0);
							}else if (attackType.nextInt(2) == 1) { 
									BossAttack a = new BossAttack(this.getA(), 50, 50, -50, 0);
							}else if (attackType.nextInt(2) == 2) { 
									Monster a = new Monster(this.getA(),monsterType.nextInt(5),-50,0);
						}
					}
					
					else if (i == 1) {
						/*0 = parried
						  1 = boss_fireball
						  2 = monster */
							if (attackType.nextInt(2) == 0) { 
									ParriedBall b = new ParriedBall(this.getA(),50 ,50, -50, 0);
							}else if (attackType.nextInt(2) == 1) { 
									BossAttack b = new BossAttack(this.getA(), 50, 50, -50, 0);
							}else if (attackType.nextInt(2) == 2) { 
									Monster b = new Monster(this.getA(),monsterType.nextInt(5),-50,0);
						}
					}
					
					else if (i == 2) {
						/*0 = parried
						  1 = boss_fireball
						  2 = monster */
							if (attackType.nextInt(2) == 0) { 
									ParriedBall c = new ParriedBall(this.getA(),50 ,50, -50, 0);
							}else if (attackType.nextInt(2) == 1) { 
									BossAttack c = new BossAttack(this.getA(), 50, 50, -50, 0);
							}else if (attackType.nextInt(2) == 2) { 
									Monster c = new Monster(this.getA(),monsterType.nextInt(5),-50,0);
						}
					}
					
					else if (i == 3) {
						/*0 = parried
						  1 = boss_fireball
						  2 = monster */
							if (attackType.nextInt(2) == 0) { 
									ParriedBall d = new ParriedBall(this.getA(),50 ,50, -50, 0);
							}else if (attackType.nextInt(2) == 1) { 
									BossAttack d = new BossAttack(this.getA(), 50, 50, -50, 0);
							}else if (attackType.nextInt(2) == 2) { 
									Monster d = new Monster(this.getA(),monsterType.nextInt(5),-50,0);
						}
					}
					
					else if (i == 4) {
						/*0 = parried
						  1 = boss_fireball
						  2 = monster */
							if (attackType.nextInt(2) == 0) { 
									ParriedBall e = new ParriedBall(this.getA(),50 ,50, -50, 0);
							}else if (attackType.nextInt(2) == 1) { 
									BossAttack e = new BossAttack(this.getA(), 50, 50, -50, 0);
							}else if (attackType.nextInt(2) == 2) { 
									Monster e = new Monster(this.getA(),monsterType.nextInt(5),-50,0);
						}
					}
					try {
						wait(1000);
					}
					catch(InterruptedException e) {
							e.printStackTrace();
					}
					
				}
	
			default:
				for (int j = 0;j<3;j++) {
					int i = attackPattern.nextInt(list2.size());
					int k = i;
					list.remove(k);
					
					if (i == 0) {
							ParriedBall a = new ParriedBall(new Position(1080,100),50 ,50, -50, 0);
							BossAttack b = new BossAttack(new Position(1080,150), 50, 50, -50, 0);
							BossAttack c = new BossAttack(new Position(1080,200), 50, 50, -50, 0);
							BossAttack d = new BossAttack(new Position(1080,250), 50, 50, -50, 0);
					}
					
					else if (i == 1) {
							BossAttack e = new BossAttack(new Position(1080,100), 50, 50, -50, 0);
							ParriedBall f = new ParriedBall(new Position(1080,150), 50, 50, -50, 0);
							BossAttack g = new BossAttack(new Position(1080,200), 50, 50, -50, 0);
							BossAttack h = new BossAttack(new Position(1080,250), 50, 50, -50, 0);
							
					}
					
					else if (i == 2) {
						BossAttack I = new BossAttack(new Position(1080,100), 50, 50, -50, 0);
						BossAttack J = new BossAttack(new Position(1080,150), 50, 50, -50, 0);
						ParriedBall K = new ParriedBall(new Position(1080,200), 50, 50, -50, 0);
						BossAttack l = new BossAttack(new Position(1080,250), 50, 50, -50, 0);
					}
					
					else if (i == 3) {
						BossAttack m = new BossAttack(new Position(1080,100), 50, 50, -50, 0);
						BossAttack n = new BossAttack(new Position(1080,150), 50, 50, -50, 0);
						BossAttack o = new BossAttack(new Position(1080,200), 50, 50, -50, 0);
						ParriedBall p = new ParriedBall(new Position(1080,250), 50, 50, -50, 0);
							
					}
					try {
					wait(1000);
					}
					catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}else {
			
			switch(attackPattern.nextInt(1)) {
				
				case 1: 
					for (int j = 0;j<5;j++) {
						int i = attackPattern.nextInt(list.size());
						int k = i;
						list.remove(k);
						
						if (i == 0) {
								ParriedBall a = new ParriedBall(new Position(1080,100),50 ,50, -50, 0);
						}
						
						else if (i == 1) {
								ParriedBall b = new ParriedBall(new Position(1080,100), 50, 50, -50, 0);
						}
						
						else if (i == 2) {
								ParriedBall c = new ParriedBall(new Position(1080,250),50 ,50, -50, 0);
						}
						
						else if (i == 3) {
								ParriedBall d = new ParriedBall(new Position(1080,250),50 ,50, -50, 0);
						}
						
						else if (i == 4) {
								BossAttack e = new BossAttack(new Position(1080,100),50 ,50, -50, 0);
						}
						else if (i == 5) {
								BossAttack f = new BossAttack(new Position(1080,100), 50, 50, -50, 0);
						}
						else if (i == 6) {
								BossAttack g = new BossAttack(new Position(1080,100), 50, 50, -50, 0);
						}
						else if (i == 7) {
								BossAttack h = new BossAttack(new Position(1080,250), 50, 50, -50, 0);
						}
						else if (i == 8) {
								BossAttack I = new BossAttack(new Position(1080,250), 50, 50, -50, 0);
						}
						else if (i == 7) {
								BossAttack J = new BossAttack(new Position(1080,250), 50, 50, -50, 0);
						}
						try {
							wait(200);
						}
						catch(InterruptedException e) {
							e.printStackTrace();
						}
					}
		
				default:
					for (int j = 0;j<3;j++) {
						int i = attackPattern.nextInt(list2.size());
						int k = i;
						list.remove(k);
						
						if (i == 0) {
								ParriedBall a = new ParriedBall(new Position(1080,100),50 ,50, -50, 0);
								BossAttack b = new BossAttack(new Position(1080,150), 50, 50, -50, 0);
								BossAttack c = new BossAttack(new Position(1080,200), 50, 50, -50, 0);
								BossAttack d = new BossAttack(new Position(1080,250), 50, 50, -50, 0);
						}
						
						else if (i == 1) {
								BossAttack e = new BossAttack(new Position(1080,100), 50, 50, -50, 0);
								ParriedBall f = new ParriedBall(new Position(1080,150), 50, 50, -50, 0);
								BossAttack g = new BossAttack(new Position(1080,200), 50, 50, -50, 0);
								BossAttack h = new BossAttack(new Position(1080,250), 50, 50, -50, 0);
								
						}
						
						else if (i == 2) {
							BossAttack I = new BossAttack(new Position(1080,100), 50, 50, -50, 0);
							BossAttack J = new BossAttack(new Position(1080,150), 50, 50, -50, 0);
							ParriedBall K = new ParriedBall(new Position(1080,200), 50, 50, -50, 0);
							BossAttack l = new BossAttack(new Position(1080,250), 50, 50, -50, 0);
						}
						
						else if (i == 3) {
							BossAttack m = new BossAttack(new Position(1080,100), 50, 50, -50, 0);
							BossAttack n = new BossAttack(new Position(1080,150), 50, 50, -50, 0);
							BossAttack o = new BossAttack(new Position(1080,200), 50, 50, -50, 0);
							ParriedBall p = new ParriedBall(new Position(1080,250), 50, 50, -50, 0);
								
						}
						try {
							wait(1000);
						}
						catch(InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
		}
		return false;
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
