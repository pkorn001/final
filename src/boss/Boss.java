package boss;

import hero.base.Hero;
import javafx.scene.canvas.GraphicsContext;
import logic.Hitbox;
import logic.Position;
import obstacle.Bat;
import obstacle.EvilFairy;
import obstacle.FlyingFire;
import obstacle.Hornet;
import obstacle.Monster;
import obstacle.Skeleton;
import obstacle.Slime;
import render.Irenderable;
import render.Resource;

public class Boss extends Hitbox implements Irenderable {

	private final static int HIT_POINT = 100;
	private static int bossHp = 200;
	private final static int KILLED_POINT = 100 * 200;
	private static boolean destroyed;
	private int z;
	private boolean isAppeared;
	
	public boolean isAppeared() {
		return isAppeared;
	}

	public void setAppeared(boolean isAppeared) {
		isAppeared = isAppeared;
	}

	public Boss(Position a, int xSpeed, int ySpeed) {
		super(a, 200, 500, xSpeed, ySpeed);
		this.z = Integer.MAX_VALUE;
		this.destroyed = false;
		setAppeared(false);
	}

	public static void isAttacked() {
		if (!destroyed) {
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

	public static int getBossHp() {
		return bossHp;
	}

	public boolean isDestroyed() {
		return destroyed;
	}

	public Hitbox create(Position p,int attackType,int MonsterType, double xSpeed, double ySpeed) {
		if (attackType == 0) {
			ParriedBall e = new ParriedBall(p, 50, 50, -50, 0);
			return e;
		}
		else if (attackType == 1) {
			BossAttack e = new BossAttack(p, 50, 50, -50, 0);
			return e;
		}
		else{
			if (MonsterType == 1) {
				Monster e = new Hornet(p,0,0,MonsterType,xSpeed,ySpeed);
				return e;
			}
			else if (MonsterType == 2) {
				Monster e = new FlyingFire(p,0,0,MonsterType,xSpeed,ySpeed);
				return e;
			}
			else if (MonsterType == 3) {
				Monster e = new EvilFairy(p,0,0,MonsterType,xSpeed,ySpeed);
				return e;
			}
			else if (MonsterType == 4) {
				Monster e = new Skeleton(p,0,0,MonsterType,xSpeed,ySpeed);
				return e;
			}
			else if (MonsterType == 5) {
				Monster e = new Bat(p,0,0,MonsterType,xSpeed,ySpeed);
				return e;
			}
			else{
				Monster e = new Slime(p,0,0,MonsterType,xSpeed,ySpeed);
				return e;
			}
		}
	}	

	@Override
	public void draw(GraphicsContext g2d, long time) {
		if (isDestroyed()) {
			g2d.drawImage(Resource.Dead, this.getB().getX(), this.getB().getY(), this.getWidth(), this.getHeight());
		} else {
			if (getBossHp() <= 100) {
				g2d.drawImage(Resource.HardBoss, this.getB().getX(), this.getB().getY(), this.getWidth(),
						this.getHeight());
			} else {
				g2d.drawImage(Resource.Boss, this.getB().getX(), this.getB().getY(), this.getWidth(), this.getHeight());
			}
		}
	}

	@Override
	public boolean IsVisible() {
		if (Hero.getScore() > 5000 && Hero.getScore() % 5000 <= 500) {setAppeared(true);};
		return isAppeared;
	}

	@Override
	public int getZ() {
		return 3;
	}

}
