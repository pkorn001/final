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

public class GameLogic {
	
	private static GameLogic instance = new GameLogic();
	protected Hero hero;
	protected Boss boss;
	protected GameScreen screen;
	protected static List<Monster> monsters;
	protected static List<ObstacleBox> obstacleBoxes;
	protected static List<Object> boss_Attack;
	protected static List<Hitbox> everything;
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
		
	
	
	
}
