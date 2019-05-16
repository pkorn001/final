package boss;

import hero.base.Hero;
import javafx.scene.canvas.GraphicsContext;
import logic.GameLogic;
import logic.Hitbox;
import logic.Position;
import obstacle.Bat;
import obstacle.Evil;
import obstacle.FlyingFire;
import obstacle.Hornet;
import obstacle.Monster;
import obstacle.Skeleton;
import obstacle.Slime;
import render.Irenderable;
import render.Resource;

public class Boss extends Hitbox implements Irenderable {

	private final static int HIT_POINT = 300;
	private static int bossHp = 200;
	private final static int KILLED_POINT = 300 * 200;
	private static boolean destroyed;
	private int z;
	private boolean isAppeared;
	
	public boolean isAppeared() {
		return isAppeared;
	}

	public void setAppeared(boolean Appeared) {
		isAppeared = Appeared;
	}

	public Boss(Position a, int xSpeed, int ySpeed) {
		super(a, 520, 692, xSpeed, ySpeed);
		this.z = Integer.MAX_VALUE;
		this.destroyed = false;
		isAppeared = false;
	}

	public static void isAttacked() {
		if (!destroyed) {
			bossHp--;
			Hero.setScore(Hero.getScore() + HIT_POINT);
		}
		if (getBossHp() == 0) {
			Hero.setScore(Hero.getScore() + KILLED_POINT); 
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
			ParriedBall e = new ParriedBall(p, 50, 50, -27, 0);
			return e;
		}
		else if (attackType == 1) {
			BossAttack e = new BossAttack(p, 50, 50, -27, 0);
			return e;
		}
		else{
			if (MonsterType == 1) {
				Monster e = new Hornet(new Position(1600,GameLogic.getHero().getB().getY()+60), 100, 100, 1, -50, 0);
				return e;
			}
			else if (MonsterType == 2) {
				Monster e = new FlyingFire(new Position(1600,GameLogic.getHero().getB().getY()+60), 150, 150, 2, -50, 0);
				return e;
			}
			else if (MonsterType == 3) {
				Monster e = new Evil(new Position(1600,GameLogic.getHero().getB().getY()), 200, 200, 3, -50, 0);
				return e;
			}
			else if (MonsterType == 4) {
				Monster e = new Skeleton(new Position(1600,550), 250, 250, 4, -50, 0);
				return e;
			}
			else if (MonsterType == 5) {
				Monster e = new Bat(new Position(1600,GameLogic.getHero().getB().getY()+60), 100, 100, 5, -50, 0);
				return e;
			}
			else{
				Monster e = new Slime(new Position(1600,700), 100, 100, 6, -50, 0);
				return e;
			}
		}
	}	

	@Override
	public void draw(GraphicsContext g2d) {
		g2d.drawImage(Resource.BossAttack,A.getX(),A.getY(),5,5);
		g2d.drawImage(Resource.BossAttack,B.getX(),B.getY(),5,5);
		g2d.drawImage(Resource.BossAttack,C.getX(),C.getY(),5,5);
		g2d.drawImage(Resource.BossAttack,D.getX(),D.getY(),5,5);
		if (isDestroyed()) {
			g2d.drawImage(Resource.Dead, this.getB().getX(), this.getB().getY(), this.getWidth(), this.getHeight());
		} else {
			if (getBossHp() <= 100) {
				g2d.drawImage(Resource.HardBoss, this.getB().getX(), this.getB().getY(), this.getWidth()+100,this.getHeight()+100);
			} else {
				g2d.drawImage(Resource.Boss, this.getB().getX(), this.getB().getY(), this.getWidth()+100, this.getHeight()+100);
			}
		}
	}

	@Override
	public boolean IsVisible() {
		return isAppeared;
	}

	@Override
	public int getZ() {
		return Integer.MIN_VALUE+1;
	}

}

