package logic;

import java.util.ArrayList;
import java.util.List;

import boss.Boss;
import boss.BossAttack;
import boss.ParriedBall;
import java.util.Random;
import hero.base.Hero;
import obstacle.Monster;
import obstacle.ObstacleBox;
import scene.GameScreen;
import java.awt.event.KeyEvent;
import hero.base.Assassin;
import hero.base.Boomeranger;
import hero.base.Hero;
import hero.base.Mage;
import hero.base.Swordman;

public class GameLogic {

public class GameLogic {
	
	private static GameLogic instance = new GameLogic();
	protected Hero hero;
	protected Boss boss;
	protected GameScreen screen;
	protected static List<Monster> monsters;
	protected static List<ObstacleBox> obstacleBoxes;
	protected static List<Object> boss_Attack;
	protected static List<Hitbox> everything;
	protected static boolean jump;
	protected static boolean attack;
	protected static double speedFactor;
	
	public GameLogic() {
		hero = new Hero(new Position(20.00,0.00),0) {
			
			@Override
			public void updateScore(Monster monster) {
				// TODO Auto-generated method stub
				setScore( getScore() + monster.getMonsterPoint());
			}};
		
		boss = new Boss(new Position(1600,500), 0, 0);
		screen = new GameScreen(1920, 1080);
		this.speedFactor = 1;
		
	}

	public static void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE && !jump) {
			setJump(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_A && !attack) {
			setAttack(true);
		}
	}

	public static void keyRelease(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			setJump(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			setAttack(false);
		}
	}

	public void updateState() {
		if (isJump()) {
			hero.jump();
		}
		if (isAttack()) {
			if (hero instanceof Mage) {
				((Mage) hero).attack();
			} else if (hero instanceof Boomeranger) {
				((Boomeranger) hero).attack();
			} else if (hero instanceof Swordman) {
				((Swordman) hero).attack();
			} else if (hero instanceof Assassin) {
				((Assassin) hero).attack();
			}
		}
	}

	public static boolean isJump() {
		return jump;
	}

	public static void setJump(boolean jump) {
		GameLogic.jump = jump;
	}

	public static boolean isAttack() {
		return attack;
	}

	public static void setAttack(boolean attack) {
		GameLogic.attack = attack;
	}
}
