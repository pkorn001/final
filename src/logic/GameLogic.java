package logic;

import java.util.List;

import hero.base.Hero;
import obstacle.Monster;
import obstacle.ObstacleBox;
import scene.GameScreen;

public class GameLogic {
	
	private static GameLogic instance = new GameLogic();
	protected Hero hero;
	protected GameScreen screen;
	protected static List<Monster> monsters;
	protected static List<ObstacleBox> obstacleBoxes;
	protected static List<Object> bossAttack;
	protected static List<Hitbox> everything;
	protected static double speedFactor;
	
	
}
