package logic;

import java.awt.event.KeyEvent;
import java.util.List;
import boss.Boss;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import boss.Boss;
import boss.BossAttack;
import boss.ParriedBall;
import hero.base.Assassin;
import hero.base.Boomeranger;
import hero.base.Hero;
import hero.base.Mage;
import hero.base.Swordman;
import item.Item;
import obstacle.Monster;
import obstacle.Bat;
import obstacle.EvilFairy;
import obstacle.FlyingFire;
import obstacle.Hornet;
import obstacle.Monster;
import obstacle.ObstacleBox;
import obstacle.Skeleton;
import obstacle.Slime;
import render.RenderableHolder;
import scene.Background;

public class GameLogic {
<<<<<<< HEAD

	private static GameLogic instance = new GameLogic();
	
	private Background bg;
	private static boolean gameOver = false;
	protected Hero hero;
	protected Boss boss;
	protected GameScreen screen;
	protected static List<Monster> monsters;
	protected static List<ObstacleBox> obstacleBoxes;
	protected static List<Item> items;
	protected static List<Object> boss_Attack;
	protected static List<Hitbox> everything;
||||||| merged common ancestors
	
	private static GameLogic instance = new GameLogic();
	protected Hero hero;
	protected Boss boss;
	protected GameScreen screen;
	protected static List<Monster> monsters;
	protected static List<ObstacleBox> obstacleBoxes;
	protected static List<Object> boss_Attack;
	protected static List<Hitbox> everything;
=======
	
	static {
		new GameLogic();
	}
	
	protected static Hero hero;
	protected static Boss boss;
	protected static List<Monster> monsters = new ArrayList<Monster>();
	protected static List<ObstacleBox> obstacleBoxes = new ArrayList<ObstacleBox>();
	protected static List<Hitbox> boss_Attack = new ArrayList<Hitbox>();
	protected static List<Hitbox> everything = new ArrayList<Hitbox>();
>>>>>>> 1744ad215e28e74f46172d896fdaa04f964e8412
	protected static boolean jump;
	protected static boolean attack;
	protected static double speedFactor;
<<<<<<< HEAD

	public GameLogic() {
		hero = new Hero(new Position(50.00, 0.00), 0) {

			@Override
			public void updateScore(Monster monster) {
				// TODO Auto-generated method stub
				setScore(getScore() + monster.getMonsterPoint());
			}
		};

		boss = new Boss(new Position(1600, 0), 0, 0);
		screen = new GameScreen();
		this.speedFactor = 1;

||||||| merged common ancestors
	private Hero hero;
	private Background bg;
	private static boolean jump;
	private static boolean attack;
	
	public GameLogic() {
		hero = new Hero(new Position(50.00,0.00),0) {
			
			@Override
			public void updateScore(Monster monster) {
				// TODO Auto-generated method stub
				setScore( getScore() + monster.getMonsterPoint());
			}};
		
		boss = new Boss(new Position(1600,0), 0, 0);
		screen = new GameScreen(1920, 1080);
		this.speedFactor = 1;
		
=======
	private Background bg;
	static Random isMonsterGen = new Random();
	private static int counter = 0;
	private static int boss_Timer = 0;
	
	private GameLogic() {
		hero = new Hero(new Position(50.00,0.00));
			
		bg = new Background();
		boss = new Boss(new Position(1600,0), 0, 0);
		speedFactor = 1;
		
		
>>>>>>> 1744ad215e28e74f46172d896fdaa04f964e8412
		RenderableHolder.getInstance().getEntities().add(hero);
		RenderableHolder.getInstance().getEntities().add(bg);
		RenderableHolder.getInstance().getEntities().add(boss);
		//everything.add(hero);
		//everything.add(boss);
	}

	public static double getSpeedFactor() {
		return speedFactor;
	}

	public static void setSpeedFactor(double speedFactor) {
		GameLogic.speedFactor = speedFactor;
	}

<<<<<<< HEAD
	public void ObstacleBoxesGen() {
		Random obstacleBox_Type = new Random();
		while (true) {
			ObstacleBox e = new ObstacleBox(new Position(1600, 0), 50, obstacleBox_Type.nextInt(2), 0);
			obstacleBoxes.add(e);
			everything.add(e);
			RenderableHolder.getInstance().getEntities().add(e);
			try {
				wait(800);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
||||||| merged common ancestors
	public void ObstacleBoxesGen() {
		Random obstacleBox_Type = new Random();
		while(true) {
				ObstacleBox e = new ObstacleBox(new Position(1600,0),50, obstacleBox_Type.nextInt(2),0);
				obstacleBoxes.add(e);
				everything.add(e);
				RenderableHolder.getInstance().getEntities().add(e);
				try {
					wait(800);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
=======
	public static void ObstacleBoxesGen() {
		if (counter % 48 == 0) {
			Random obstacleBox_Type = new Random();
			ObstacleBox e = new ObstacleBox(new Position(1000,0),50, obstacleBox_Type.nextInt(2),0);
			obstacleBoxes.add(e);
			everything.add(e);
			RenderableHolder.getInstance().getEntities().add(e);
>>>>>>> 1744ad215e28e74f46172d896fdaa04f964e8412
		}
	}
<<<<<<< HEAD

	public void ItemGen() {
		Random itemType = new Random();
		while (true) {
			Item i = new Item(new Position(1600, 0), 50, itemType.nextInt(2));
			items.add(i);
			everything.add(i);
			RenderableHolder.getInstance().getEntities().add(i);
			try {
				wait(800);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void MonstersGen() {
||||||| merged common ancestors
	
	public void MonstersGen() {
=======
	
	public static void MonstersGen() {
>>>>>>> 1744ad215e28e74f46172d896fdaa04f964e8412
		Random monsterType = new Random();
		if(counter % 48 == 0) {
			if (Hero.getStage() == 0) {
<<<<<<< HEAD
				Monster e = new Hornet(new Position(1600, hero.getHeight() * 2 / 3), 100, 100, 0, -50, 0);
||||||| merged common ancestors
				Monster e = new Hornet(new Position(1600,hero.getHeight()* 2 / 3), 100, 100, 0, -50, 0);
=======
				Monster e = new Hornet(new Position(1000,hero.getHeight()* 2 / 3), 100, 100, 0, -50, 0);
>>>>>>> 1744ad215e28e74f46172d896fdaa04f964e8412
				monsters.add(e);
				everything.add(e);
				RenderableHolder.getInstance().getEntities().add(e);
<<<<<<< HEAD
			} else if (Hero.getStage() == 1) {
				if (monsterType.nextInt(2) == 0) {
					Monster e = new Slime(new Position(1600, 0), 100, 100, 0, -50, 0);
||||||| merged common ancestors
			}
			else if (Hero.getStage() == 1) {
				if(monsterType.nextInt(2) == 0) {
					Monster e = new Slime(new Position(1600,0), 100, 100, 0, -50, 0);
=======
			}
			else if (Hero.getStage() == 1) {
				if(monsterType.nextInt(2) == 0) {
					Monster e = new Slime(new Position(1000,0), 100, 100, 0, -50, 0);
>>>>>>> 1744ad215e28e74f46172d896fdaa04f964e8412
					monsters.add(e);
					everything.add(e);
					RenderableHolder.getInstance().getEntities().add(e);
<<<<<<< HEAD
				} else if (monsterType.nextInt(2) == 1) {
					Monster e = new FlyingFire(new Position(1600, 250), 100, 100, 0, -50, 0);
||||||| merged common ancestors
				}
				else if(monsterType.nextInt(2) == 1) {
					Monster e = new FlyingFire(new Position(1600,250), 100, 100, 0, -50, 0);
=======
				}
				else if(monsterType.nextInt(2) == 1) {
					Monster e = new FlyingFire(new Position(1000,250), 100, 100, 0, -50, 0);
>>>>>>> 1744ad215e28e74f46172d896fdaa04f964e8412
					monsters.add(e);
					everything.add(e);
					RenderableHolder.getInstance().getEntities().add(e);
				}
<<<<<<< HEAD
			} else if (Hero.getStage() == 2) {
				if (monsterType.nextInt(2) == 0) {
					Monster e = new Hornet(new Position(1600, hero.getHeight() * 2 / 3), 100, 100, 0, -50, 0);
||||||| merged common ancestors
			}
			else if (Hero.getStage() == 2) {
				if(monsterType.nextInt(2) == 0) {
					Monster e = new Hornet(new Position(1600,hero.getHeight()* 2 / 3), 100, 100, 0, -50, 0);
=======
			}
			else if (Hero.getStage() == 2) {
				if(monsterType.nextInt(2) == 0) {
					Monster e = new Hornet(new Position(1000,hero.getHeight()* 2 / 3), 100, 100, 0, -50, 0);
>>>>>>> 1744ad215e28e74f46172d896fdaa04f964e8412
					monsters.add(e);
					everything.add(e);
					RenderableHolder.getInstance().getEntities().add(e);
				} else if (monsterType.nextInt(2) == 1) {
					Monster e = new EvilFairy(new Position(1600, 250), 100, 100, 0, -50, 0);
					monsters.add(e);
					everything.add(e);
					RenderableHolder.getInstance().getEntities().add(e);
				}

			} else if (Hero.getStage() == 3) {
				if (monsterType.nextInt(2) == 0) {
					Monster e = new Hornet(new Position(1600, hero.getHeight() * 2 / 3), 100, 100, 0, -50, 0);
					monsters.add(e);
					everything.add(e);
					RenderableHolder.getInstance().getEntities().add(e);
				} else if (monsterType.nextInt(2) == 1) {
					Monster e = new Skeleton(new Position(1600, 0), 100, 100, 0, -50, 0);
					monsters.add(e);
					everything.add(e);
					RenderableHolder.getInstance().getEntities().add(e);
				}
			} else if (Hero.getStage() == 4) {
				if (monsterType.nextInt(2) == 0) {
					Monster e = new Slime(new Position(1600, 0), 100, 100, 0, -50, 0);
					monsters.add(e);
					everything.add(e);
					RenderableHolder.getInstance().getEntities().add(e);
				} else if (monsterType.nextInt(2) == 1) {
					Monster e = new Bat(new Position(1600, hero.getHeight() * 2 / 3), 100, 100, 0, -50, 0);
					monsters.add(e);
					everything.add(e);
					RenderableHolder.getInstance().getEntities().add(e);
				}
			}
		}
	}

	public static void BossAttackGen() {
		Random attackPattern = new Random();
		Random attackType = new Random();
		Random monsterType = new Random();

		List<Integer> list = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for (int e = 0; e < 10; e++) {
			list.add(e);
		}
		for (int e = 0; e < 4; e++) {
			list2.add(e);
		}

		if ((boss.getBossHp() <= 100)) {
			switch (attackPattern.nextInt(2)) {
<<<<<<< HEAD

||||||| merged common ancestors
	
=======
>>>>>>> 1744ad215e28e74f46172d896fdaa04f964e8412
			case 1:
<<<<<<< HEAD
				for (int j = 0; j < 5; j++) {
					int i = attackPattern.nextInt(list.size());
					int k = i;
					list.remove(k);

||||||| merged common ancestors
				for (int j = 0; j < 5; j++) {
					int i = attackPattern.nextInt(list.size());
					int k = i;
					list.remove(k);
					
=======
				int i = attackPattern.nextInt(list.size());
				if(counter % 12 == 0) {
>>>>>>> 1744ad215e28e74f46172d896fdaa04f964e8412
					if (i == 0) {
						ParriedBall e = (ParriedBall) boss.create(new Position(1920, 100), 0, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					}
<<<<<<< HEAD

					else if (i == 1) {
						ParriedBall e = (ParriedBall) boss.create(new Position(1920, 100), 0, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					}

||||||| merged common ancestors
	
					else if (i == 1) {
						ParriedBall e = (ParriedBall) boss.create(new Position(1920, 100),0,-1,-50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					}
	
=======
		
>>>>>>> 1744ad215e28e74f46172d896fdaa04f964e8412
					else if (i == 2) {
						ParriedBall e = (ParriedBall) boss.create(new Position(1920, 250), 0, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					}
<<<<<<< HEAD

					else if (i == 3) {
						ParriedBall e = (ParriedBall) boss.create(new Position(1920, 250), 0, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					}

||||||| merged common ancestors
	
					else if (i == 3) {
						ParriedBall e = (ParriedBall) boss.create(new Position(1920, 250),0,-1,-50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					}
	
=======
		
>>>>>>> 1744ad215e28e74f46172d896fdaa04f964e8412
					else if (i == 4) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 100), 1, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					} else if (i == 5) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 100), 1, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
<<<<<<< HEAD
					} else if (i == 6) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 100), 1, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
||||||| merged common ancestors
					} else if (i == 6) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 100),1,-1,-50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
=======
		
>>>>>>> 1744ad215e28e74f46172d896fdaa04f964e8412
					} else if (i == 7) {
<<<<<<< HEAD
						BossAttack e = (BossAttack) boss.create(new Position(1920, 250), 1, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
||||||| merged common ancestors
						BossAttack e = (BossAttack) boss.create(new Position(1920, 250),1,-1,-50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
=======
							BossAttack e = (BossAttack) boss.create(new Position(1920, 250),1,-1,-50, 0);
							boss_Attack.add(e);
							everything.add(e);
							RenderableHolder.getInstance().getEntities().add(e);
>>>>>>> 1744ad215e28e74f46172d896fdaa04f964e8412
					} else if (i == 8) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 250), 1, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
<<<<<<< HEAD
					} else if (i == 7) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 250), 1, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					}
					try {
						wait(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
||||||| merged common ancestors
					} else if (i == 7) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 250),1,-1,-50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					}
					try {
						wait(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
=======
>>>>>>> 1744ad215e28e74f46172d896fdaa04f964e8412
					}
				}

			case 2:
<<<<<<< HEAD
				for (int i = 0; i < 5; i++) {
					/*
					 * 0 = parried 1 = boss_fireball 2 = monster
					 */
					if (attackType.nextInt(3) == 0) {
						ParriedBall e = (ParriedBall) boss
								.create(new Position(boss.getB().getX(), hero.getA().getY() + 100), 0, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					} else if (attackType.nextInt(3) == 1) {
						BossAttack e = (BossAttack) boss
								.create(new Position(boss.getB().getX(), hero.getB().getY() - 100), 1, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					} else if (attackType.nextInt(3) == 2) {
						Monster e = (Monster) boss.create(new Position(boss.getB().getX(), hero.getA().getY() + 100), 2,
								monsterType.nextInt(6) + 1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
||||||| merged common ancestors
				for (int i = 0; i < 5; i++) {
						/*
						 * 0 = parried 1 = boss_fireball 2 = monster
						 */
						if (attackType.nextInt(3) == 0) {
							ParriedBall e = (ParriedBall) boss.create(new Position(boss.getB().getX(),hero.getA().getY()+100),0,-1,-50, 0);
							boss_Attack.add(e);
							everything.add(e);
							RenderableHolder.getInstance().getEntities().add(e);
						} else if (attackType.nextInt(3) == 1) {
							BossAttack e = (BossAttack) boss.create(new Position(boss.getB().getX(),hero.getB().getY()-100),1,-1,-50, 0);
							boss_Attack.add(e);
							everything.add(e);
							RenderableHolder.getInstance().getEntities().add(e);
						} else if (attackType.nextInt(3) == 2) {
							Monster e = (Monster) boss.create(new Position(boss.getB().getX(),hero.getA().getY()+100),2,monsterType.nextInt(6)+1,-50, 0);
							boss_Attack.add(e);
							everything.add(e);
							RenderableHolder.getInstance().getEntities().add(e);
						}
						try {
							wait(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
=======
						/*
						 * 0 = parried 1 = boss_fireball 2 = monster
						 */
					if (counter % 60 == 0) {
						if (attackType.nextInt(3) == 0) {
							ParriedBall e = (ParriedBall) boss.create(new Position(boss.getB().getX(),hero.getA().getY()+100),0,-1,-50, 0);
							boss_Attack.add(e);
							everything.add(e);
							RenderableHolder.getInstance().getEntities().add(e);
						} else if (attackType.nextInt(3) == 1) {
							BossAttack e = (BossAttack) boss.create(new Position(boss.getB().getX(),hero.getB().getY()-100),1,-1,-50, 0);
							boss_Attack.add(e);
							everything.add(e);
							RenderableHolder.getInstance().getEntities().add(e);
						} else if (attackType.nextInt(3) == 2) {
							Monster e = (Monster) boss.create(new Position(boss.getB().getX(),hero.getA().getY()+100),2,monsterType.nextInt(6)+1,-50, 0);
							boss_Attack.add(e);
							everything.add(e);
							RenderableHolder.getInstance().getEntities().add(e);
						}
>>>>>>> 1744ad215e28e74f46172d896fdaa04f964e8412
					}
					try {
						wait(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			default:
<<<<<<< HEAD
				for (int j = 0; j < 3; j++) {
					int i = attackPattern.nextInt(list2.size());
					int k = i;
					list.remove(k);

					if (i == 0) {
						ParriedBall e1 = (ParriedBall) boss.create(new Position(1920, 100), 0, -1, -50, 0);
						BossAttack e2 = (BossAttack) boss.create(new Position(1920, 150), 1, -1, -50, 0);
						BossAttack e3 = (BossAttack) boss.create(new Position(1920, 200), 1, -1, -50, 0);
						BossAttack e4 = (BossAttack) boss.create(new Position(1920, 250), 1, -1, -50, 0);
						boss_Attack.add(e1);
						boss_Attack.add(e2);
						boss_Attack.add(e3);
						boss_Attack.add(e4);
						everything.add(e1);
						everything.add(e2);
						everything.add(e3);
						everything.add(e4);
						RenderableHolder.getInstance().getEntities().add(e1);
						RenderableHolder.getInstance().getEntities().add(e2);
						RenderableHolder.getInstance().getEntities().add(e3);
						RenderableHolder.getInstance().getEntities().add(e4);
					}

					else if (i == 1) {
						ParriedBall e1 = (ParriedBall) boss.create(new Position(1920, 150), 0, -1, -50, 0);
						BossAttack e2 = (BossAttack) boss.create(new Position(1920, 100), 1, -1, -50, 0);
						BossAttack e3 = (BossAttack) boss.create(new Position(1920, 200), 1, -1, -50, 0);
						BossAttack e4 = (BossAttack) boss.create(new Position(1920, 250), 1, -1, -50, 0);
						boss_Attack.add(e1);
						boss_Attack.add(e2);
						boss_Attack.add(e3);
						boss_Attack.add(e4);
						everything.add(e1);
						everything.add(e2);
						everything.add(e3);
						everything.add(e4);
						RenderableHolder.getInstance().getEntities().add(e1);
						RenderableHolder.getInstance().getEntities().add(e2);
						RenderableHolder.getInstance().getEntities().add(e3);
						RenderableHolder.getInstance().getEntities().add(e4);
					}

					else if (i == 2) {
						ParriedBall e1 = (ParriedBall) boss.create(new Position(1920, 200), 0, -1, -50, 0);
						BossAttack e2 = (BossAttack) boss.create(new Position(1920, 100), 1, -1, -50, 0);
						BossAttack e3 = (BossAttack) boss.create(new Position(1920, 150), 1, -1, -50, 0);
						BossAttack e4 = (BossAttack) boss.create(new Position(1920, 250), 1, -1, -50, 0);
						boss_Attack.add(e1);
						boss_Attack.add(e2);
						boss_Attack.add(e3);
						boss_Attack.add(e4);
						everything.add(e1);
						everything.add(e2);
						everything.add(e3);
						everything.add(e4);
						RenderableHolder.getInstance().getEntities().add(e1);
						RenderableHolder.getInstance().getEntities().add(e2);
						RenderableHolder.getInstance().getEntities().add(e3);
						RenderableHolder.getInstance().getEntities().add(e4);
					}

					else if (i == 3) {
						ParriedBall e1 = (ParriedBall) boss.create(new Position(1920, 250), 0, -1, -50, 0);
						BossAttack e2 = (BossAttack) boss.create(new Position(1920, 100), 1, -1, -50, 0);
						BossAttack e3 = (BossAttack) boss.create(new Position(1920, 150), 1, -1, -50, 0);
						BossAttack e4 = (BossAttack) boss.create(new Position(1920, 200), 1, -1, -50, 0);
						boss_Attack.add(e1);
						boss_Attack.add(e2);
						boss_Attack.add(e3);
						boss_Attack.add(e4);
						everything.add(e1);
						everything.add(e2);
						everything.add(e3);
						everything.add(e4);
						RenderableHolder.getInstance().getEntities().add(e1);
						RenderableHolder.getInstance().getEntities().add(e2);
						RenderableHolder.getInstance().getEntities().add(e3);
						RenderableHolder.getInstance().getEntities().add(e4);

					}
					try {
						wait(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
||||||| merged common ancestors
				for (int j = 0; j < 3; j++) {
					int i = attackPattern.nextInt(list2.size());
					int k = i;
					list.remove(k);
	
					if (i == 0) {
						ParriedBall e1 = (ParriedBall) boss.create(new Position(1920, 100),0,-1,-50, 0);
						BossAttack e2 = (BossAttack) boss.create(new Position(1920, 150),1,-1,-50, 0);
						BossAttack e3 = (BossAttack) boss.create(new Position(1920, 200),1,-1,-50, 0);
						BossAttack e4 = (BossAttack) boss.create(new Position(1920, 250),1,-1,-50, 0);
						boss_Attack.add(e1);
						boss_Attack.add(e2);
						boss_Attack.add(e3);
						boss_Attack.add(e4);
						everything.add(e1);
						everything.add(e2);
						everything.add(e3);
						everything.add(e4);
						RenderableHolder.getInstance().getEntities().add(e1);
						RenderableHolder.getInstance().getEntities().add(e2);
						RenderableHolder.getInstance().getEntities().add(e3);
						RenderableHolder.getInstance().getEntities().add(e4);
					}
	
					else if (i == 1) {
						ParriedBall e1 = (ParriedBall) boss.create(new Position(1920, 150),0,-1,-50, 0);
						BossAttack e2 = (BossAttack) boss.create(new Position(1920, 100),1,-1,-50, 0);
						BossAttack e3 = (BossAttack) boss.create(new Position(1920, 200),1,-1,-50, 0);
						BossAttack e4 = (BossAttack) boss.create(new Position(1920, 250),1,-1,-50, 0);
						boss_Attack.add(e1);
						boss_Attack.add(e2);
						boss_Attack.add(e3);
						boss_Attack.add(e4);
						everything.add(e1);
						everything.add(e2);
						everything.add(e3);
						everything.add(e4);
						RenderableHolder.getInstance().getEntities().add(e1);
						RenderableHolder.getInstance().getEntities().add(e2);
						RenderableHolder.getInstance().getEntities().add(e3);
						RenderableHolder.getInstance().getEntities().add(e4);
					}
	
					else if (i == 2) {
						ParriedBall e1 = (ParriedBall) boss.create(new Position(1920, 200),0,-1,-50, 0);
						BossAttack e2 = (BossAttack) boss.create(new Position(1920, 100),1,-1,-50, 0);
						BossAttack e3 = (BossAttack) boss.create(new Position(1920, 150),1,-1,-50, 0);
						BossAttack e4 = (BossAttack) boss.create(new Position(1920, 250),1,-1,-50, 0);
						boss_Attack.add(e1);
						boss_Attack.add(e2);
						boss_Attack.add(e3);
						boss_Attack.add(e4);
						everything.add(e1);
						everything.add(e2);
						everything.add(e3);
						everything.add(e4);
						RenderableHolder.getInstance().getEntities().add(e1);
						RenderableHolder.getInstance().getEntities().add(e2);
						RenderableHolder.getInstance().getEntities().add(e3);
						RenderableHolder.getInstance().getEntities().add(e4);
					}
	
					else if (i == 3) {
						ParriedBall e1 = (ParriedBall) boss.create(new Position(1920, 250),0,-1,-50, 0);
						BossAttack e2 = (BossAttack) boss.create(new Position(1920, 100),1,-1,-50, 0);
						BossAttack e3 = (BossAttack) boss.create(new Position(1920, 150),1,-1,-50, 0);
						BossAttack e4 = (BossAttack) boss.create(new Position(1920, 200),1,-1,-50, 0);
						boss_Attack.add(e1);
						boss_Attack.add(e2);
						boss_Attack.add(e3);
						boss_Attack.add(e4);
						everything.add(e1);
						everything.add(e2);
						everything.add(e3);
						everything.add(e4);
						RenderableHolder.getInstance().getEntities().add(e1);
						RenderableHolder.getInstance().getEntities().add(e2);
						RenderableHolder.getInstance().getEntities().add(e3);
						RenderableHolder.getInstance().getEntities().add(e4);
	
					}
					try {
						wait(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
=======
					int i1 = attackPattern.nextInt(list2.size());
					
					if (counter % 60 == 0) {
						if (i1 == 0) {
							ParriedBall e1 = (ParriedBall) boss.create(new Position(1920, 100),0,-1,-50, 0);
							BossAttack e2 = (BossAttack) boss.create(new Position(1920, 150),1,-1,-50, 0);
							BossAttack e3 = (BossAttack) boss.create(new Position(1920, 200),1,-1,-50, 0);
							BossAttack e4 = (BossAttack) boss.create(new Position(1920, 250),1,-1,-50, 0);
							boss_Attack.add(e1);
							boss_Attack.add(e2);
							boss_Attack.add(e3);
							boss_Attack.add(e4);
							everything.add(e1);
							everything.add(e2);
							everything.add(e3);
							everything.add(e4);
							RenderableHolder.getInstance().getEntities().add(e1);
							RenderableHolder.getInstance().getEntities().add(e2);
							RenderableHolder.getInstance().getEntities().add(e3);
							RenderableHolder.getInstance().getEntities().add(e4);
						}
		
						else if (i1 == 1) {
							ParriedBall e1 = (ParriedBall) boss.create(new Position(1920, 150),0,-1,-50, 0);
							BossAttack e2 = (BossAttack) boss.create(new Position(1920, 100),1,-1,-50, 0);
							BossAttack e3 = (BossAttack) boss.create(new Position(1920, 200),1,-1,-50, 0);
							BossAttack e4 = (BossAttack) boss.create(new Position(1920, 250),1,-1,-50, 0);
							boss_Attack.add(e1);
							boss_Attack.add(e2);
							boss_Attack.add(e3);
							boss_Attack.add(e4);
							everything.add(e1);
							everything.add(e2);
							everything.add(e3);
							everything.add(e4);
							RenderableHolder.getInstance().getEntities().add(e1);
							RenderableHolder.getInstance().getEntities().add(e2);
							RenderableHolder.getInstance().getEntities().add(e3);
							RenderableHolder.getInstance().getEntities().add(e4);
						}
		
						else if (i1 == 2) {
							ParriedBall e1 = (ParriedBall) boss.create(new Position(1920, 200),0,-1,-50, 0);
							BossAttack e2 = (BossAttack) boss.create(new Position(1920, 100),1,-1,-50, 0);
							BossAttack e3 = (BossAttack) boss.create(new Position(1920, 150),1,-1,-50, 0);
							BossAttack e4 = (BossAttack) boss.create(new Position(1920, 250),1,-1,-50, 0);
							boss_Attack.add(e1);
							boss_Attack.add(e2);
							boss_Attack.add(e3);
							boss_Attack.add(e4);
							everything.add(e1);
							everything.add(e2);
							everything.add(e3);
							everything.add(e4);
							RenderableHolder.getInstance().getEntities().add(e1);
							RenderableHolder.getInstance().getEntities().add(e2);
							RenderableHolder.getInstance().getEntities().add(e3);
							RenderableHolder.getInstance().getEntities().add(e4);
						}
		
						else if (i1 == 3) {
							ParriedBall e1 = (ParriedBall) boss.create(new Position(1920, 250),0,-1,-50, 0);
							BossAttack e2 = (BossAttack) boss.create(new Position(1920, 100),1,-1,-50, 0);
							BossAttack e3 = (BossAttack) boss.create(new Position(1920, 150),1,-1,-50, 0);
							BossAttack e4 = (BossAttack) boss.create(new Position(1920, 200),1,-1,-50, 0);
							boss_Attack.add(e1);
							boss_Attack.add(e2);
							boss_Attack.add(e3);
							boss_Attack.add(e4);
							everything.add(e1);
							everything.add(e2);
							everything.add(e3);
							everything.add(e4);
							RenderableHolder.getInstance().getEntities().add(e1);
							RenderableHolder.getInstance().getEntities().add(e2);
							RenderableHolder.getInstance().getEntities().add(e3);
							RenderableHolder.getInstance().getEntities().add(e4);
		
						}
>>>>>>> 1744ad215e28e74f46172d896fdaa04f964e8412
					}
				}
		
		} else {

			switch (attackPattern.nextInt(1)) {
			case 1:
<<<<<<< HEAD
				for (int j = 0; j < 5; j++) {
					int i = attackPattern.nextInt(list.size());
					int k = i;
					list.remove(k);

||||||| merged common ancestors
				for (int j = 0; j < 5; j++) {
					int i = attackPattern.nextInt(list.size());
					int k = i;
					list.remove(k);
					
=======
				int i = attackPattern.nextInt(list.size());
				if(counter % 12 == 0) {
>>>>>>> 1744ad215e28e74f46172d896fdaa04f964e8412
					if (i == 0) {
						ParriedBall e = (ParriedBall) boss.create(new Position(1920, 100), 0, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					}
<<<<<<< HEAD

					else if (i == 1) {
						ParriedBall e = (ParriedBall) boss.create(new Position(1920, 100), 0, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					}

||||||| merged common ancestors
	
					else if (i == 1) {
						ParriedBall e = (ParriedBall) boss.create(new Position(1920, 100),0,-1,-50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					}
	
=======
		
>>>>>>> 1744ad215e28e74f46172d896fdaa04f964e8412
					else if (i == 2) {
						ParriedBall e = (ParriedBall) boss.create(new Position(1920, 250), 0, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					}
<<<<<<< HEAD

					else if (i == 3) {
						ParriedBall e = (ParriedBall) boss.create(new Position(1920, 250), 0, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					}

||||||| merged common ancestors
	
					else if (i == 3) {
						ParriedBall e = (ParriedBall) boss.create(new Position(1920, 250),0,-1,-50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					}
	
=======
		
>>>>>>> 1744ad215e28e74f46172d896fdaa04f964e8412
					else if (i == 4) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 100), 1, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					} else if (i == 5) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 100), 1, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
<<<<<<< HEAD
					} else if (i == 6) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 100), 1, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
||||||| merged common ancestors
					} else if (i == 6) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 100),1,-1,-50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
=======
		
>>>>>>> 1744ad215e28e74f46172d896fdaa04f964e8412
					} else if (i == 7) {
<<<<<<< HEAD
						BossAttack e = (BossAttack) boss.create(new Position(1920, 250), 1, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
||||||| merged common ancestors
						BossAttack e = (BossAttack) boss.create(new Position(1920, 250),1,-1,-50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
=======
							BossAttack e = (BossAttack) boss.create(new Position(1920, 250),1,-1,-50, 0);
							boss_Attack.add(e);
							everything.add(e);
							RenderableHolder.getInstance().getEntities().add(e);
>>>>>>> 1744ad215e28e74f46172d896fdaa04f964e8412
					} else if (i == 8) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 250), 1, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
<<<<<<< HEAD
					} else if (i == 7) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 250), 1, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					}
					try {
						wait(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
||||||| merged common ancestors
					} else if (i == 7) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 250),1,-1,-50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					}
					try {
						wait(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
=======
>>>>>>> 1744ad215e28e74f46172d896fdaa04f964e8412
					}
				}

			default:
<<<<<<< HEAD
				for (int j = 0; j < 3; j++) {
					int i = attackPattern.nextInt(list2.size());
					int k = i;
					list.remove(k);

					if (i == 0) {
						ParriedBall e1 = (ParriedBall) boss.create(new Position(1920, 100), 0, -1, -50, 0);
						BossAttack e2 = (BossAttack) boss.create(new Position(1920, 150), 1, -1, -50, 0);
						BossAttack e3 = (BossAttack) boss.create(new Position(1920, 200), 1, -1, -50, 0);
						BossAttack e4 = (BossAttack) boss.create(new Position(1920, 250), 1, -1, -50, 0);
||||||| merged common ancestors
				for (int j = 0; j < 3; j++) {
					int i = attackPattern.nextInt(list2.size());
					int k = i;
					list.remove(k);
	
					if (i == 0) {
						ParriedBall e1 = (ParriedBall) boss.create(new Position(1920, 100),0,-1,-50, 0);
						BossAttack e2 = (BossAttack) boss.create(new Position(1920, 150),1,-1,-50, 0);
						BossAttack e3 = (BossAttack) boss.create(new Position(1920, 200),1,-1,-50, 0);
						BossAttack e4 = (BossAttack) boss.create(new Position(1920, 250),1,-1,-50, 0);
=======
				int i1 = attackPattern.nextInt(list2.size());
				
				if (counter % 60 == 0) {
					if (i1 == 0) {
						ParriedBall e1 = (ParriedBall) boss.create(new Position(1920, 100),0,-1,-50, 0);
						BossAttack e2 = (BossAttack) boss.create(new Position(1920, 150),1,-1,-50, 0);
						BossAttack e3 = (BossAttack) boss.create(new Position(1920, 200),1,-1,-50, 0);
						BossAttack e4 = (BossAttack) boss.create(new Position(1920, 250),1,-1,-50, 0);
>>>>>>> 1744ad215e28e74f46172d896fdaa04f964e8412
						boss_Attack.add(e1);
						boss_Attack.add(e2);
						boss_Attack.add(e3);
						boss_Attack.add(e4);
						everything.add(e1);
						everything.add(e2);
						everything.add(e3);
						everything.add(e4);
						RenderableHolder.getInstance().getEntities().add(e1);
						RenderableHolder.getInstance().getEntities().add(e2);
						RenderableHolder.getInstance().getEntities().add(e3);
						RenderableHolder.getInstance().getEntities().add(e4);
					}
<<<<<<< HEAD

					else if (i == 1) {
						ParriedBall e1 = (ParriedBall) boss.create(new Position(1920, 150), 0, -1, -50, 0);
						BossAttack e2 = (BossAttack) boss.create(new Position(1920, 100), 1, -1, -50, 0);
						BossAttack e3 = (BossAttack) boss.create(new Position(1920, 200), 1, -1, -50, 0);
						BossAttack e4 = (BossAttack) boss.create(new Position(1920, 250), 1, -1, -50, 0);
||||||| merged common ancestors
	
					else if (i == 1) {
						ParriedBall e1 = (ParriedBall) boss.create(new Position(1920, 150),0,-1,-50, 0);
						BossAttack e2 = (BossAttack) boss.create(new Position(1920, 100),1,-1,-50, 0);
						BossAttack e3 = (BossAttack) boss.create(new Position(1920, 200),1,-1,-50, 0);
						BossAttack e4 = (BossAttack) boss.create(new Position(1920, 250),1,-1,-50, 0);
=======
	
					else if (i1 == 1) {
						ParriedBall e1 = (ParriedBall) boss.create(new Position(1920, 150),0,-1,-50, 0);
						BossAttack e2 = (BossAttack) boss.create(new Position(1920, 100),1,-1,-50, 0);
						BossAttack e3 = (BossAttack) boss.create(new Position(1920, 200),1,-1,-50, 0);
						BossAttack e4 = (BossAttack) boss.create(new Position(1920, 250),1,-1,-50, 0);
>>>>>>> 1744ad215e28e74f46172d896fdaa04f964e8412
						boss_Attack.add(e1);
						boss_Attack.add(e2);
						boss_Attack.add(e3);
						boss_Attack.add(e4);
						everything.add(e1);
						everything.add(e2);
						everything.add(e3);
						everything.add(e4);
						RenderableHolder.getInstance().getEntities().add(e1);
						RenderableHolder.getInstance().getEntities().add(e2);
						RenderableHolder.getInstance().getEntities().add(e3);
						RenderableHolder.getInstance().getEntities().add(e4);
					}
<<<<<<< HEAD

					else if (i == 2) {
						ParriedBall e1 = (ParriedBall) boss.create(new Position(1920, 200), 0, -1, -50, 0);
						BossAttack e2 = (BossAttack) boss.create(new Position(1920, 100), 1, -1, -50, 0);
						BossAttack e3 = (BossAttack) boss.create(new Position(1920, 150), 1, -1, -50, 0);
						BossAttack e4 = (BossAttack) boss.create(new Position(1920, 250), 1, -1, -50, 0);
||||||| merged common ancestors
	
					else if (i == 2) {
						ParriedBall e1 = (ParriedBall) boss.create(new Position(1920, 200),0,-1,-50, 0);
						BossAttack e2 = (BossAttack) boss.create(new Position(1920, 100),1,-1,-50, 0);
						BossAttack e3 = (BossAttack) boss.create(new Position(1920, 150),1,-1,-50, 0);
						BossAttack e4 = (BossAttack) boss.create(new Position(1920, 250),1,-1,-50, 0);
=======
	
					else if (i1 == 2) {
						ParriedBall e1 = (ParriedBall) boss.create(new Position(1920, 200),0,-1,-50, 0);
						BossAttack e2 = (BossAttack) boss.create(new Position(1920, 100),1,-1,-50, 0);
						BossAttack e3 = (BossAttack) boss.create(new Position(1920, 150),1,-1,-50, 0);
						BossAttack e4 = (BossAttack) boss.create(new Position(1920, 250),1,-1,-50, 0);
>>>>>>> 1744ad215e28e74f46172d896fdaa04f964e8412
						boss_Attack.add(e1);
						boss_Attack.add(e2);
						boss_Attack.add(e3);
						boss_Attack.add(e4);
						everything.add(e1);
						everything.add(e2);
						everything.add(e3);
						everything.add(e4);
						RenderableHolder.getInstance().getEntities().add(e1);
						RenderableHolder.getInstance().getEntities().add(e2);
						RenderableHolder.getInstance().getEntities().add(e3);
						RenderableHolder.getInstance().getEntities().add(e4);
					}
<<<<<<< HEAD

					else if (i == 3) {
						ParriedBall e1 = (ParriedBall) boss.create(new Position(1920, 250), 0, -1, -50, 0);
						BossAttack e2 = (BossAttack) boss.create(new Position(1920, 100), 1, -1, -50, 0);
						BossAttack e3 = (BossAttack) boss.create(new Position(1920, 150), 1, -1, -50, 0);
						BossAttack e4 = (BossAttack) boss.create(new Position(1920, 200), 1, -1, -50, 0);
||||||| merged common ancestors
	
					else if (i == 3) {
						ParriedBall e1 = (ParriedBall) boss.create(new Position(1920, 250),0,-1,-50, 0);
						BossAttack e2 = (BossAttack) boss.create(new Position(1920, 100),1,-1,-50, 0);
						BossAttack e3 = (BossAttack) boss.create(new Position(1920, 150),1,-1,-50, 0);
						BossAttack e4 = (BossAttack) boss.create(new Position(1920, 200),1,-1,-50, 0);
=======
	
					else if (i1 == 3) {
						ParriedBall e1 = (ParriedBall) boss.create(new Position(1920, 250),0,-1,-50, 0);
						BossAttack e2 = (BossAttack) boss.create(new Position(1920, 100),1,-1,-50, 0);
						BossAttack e3 = (BossAttack) boss.create(new Position(1920, 150),1,-1,-50, 0);
						BossAttack e4 = (BossAttack) boss.create(new Position(1920, 200),1,-1,-50, 0);
>>>>>>> 1744ad215e28e74f46172d896fdaa04f964e8412
						boss_Attack.add(e1);
						boss_Attack.add(e2);
						boss_Attack.add(e3);
						boss_Attack.add(e4);
						everything.add(e1);
						everything.add(e2);
						everything.add(e3);
						everything.add(e4);
						RenderableHolder.getInstance().getEntities().add(e1);
						RenderableHolder.getInstance().getEntities().add(e2);
						RenderableHolder.getInstance().getEntities().add(e3);
						RenderableHolder.getInstance().getEntities().add(e4);

					}
				}
			}
		}
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
<<<<<<< HEAD

	public void logicUpdate(long time) {
		BossAttackGen();
		MonstersGen();
		ObstacleBoxesGen();
		ItemGen();
		for(Hitbox e : everything) {
			
			if(e instanceof Monster || e instanceof BossAttack) {  //for monster
				if(e.collide(hero)) {
					hero.setDestroyed(true);
					setGameOver(true);
				}
			}else if(e instanceof Item) { //for item
				if(hero.collide(e)) {
					hero.tranform((Item) e); 
				}
			}else if(e instanceof Hero) {//for hero
				updateState();
				if (e instanceof Mage) {
					for (Hitbox hb : everything) {
						if(((Mage) e).getFireball().collide(hb)) {
							((Mage)e).getFireball().setDestroyed(true);
							if(hb instanceof Monster) {
								((Monster) hb).setDestroyed(true);
							}
						}
					}
				} else if (e instanceof Boomeranger) {
					for (Monster monster : monsters) {
						if(((Boomeranger)e).getBoomerang().collide(monster)) {
							monster.setDestroyed(true);
						}
					}
				} else if (e instanceof Swordman) {
					for(Monster monster : monsters) {
						if(((Swordman)e).getAttackBox().collide(monster)) {
							((Swordman)e).updateScore(monster);
							monster.setDestroyed(true);
						}
					}
				} else if (e instanceof Assassin) {
					for(Monster monster : monsters) {
						if(((Assassin)e).getAttackBox().collide(monster)) {
							((Assassin)e).updateScore(monster);
							monster.setDestroyed(true);
						}
					}				
				} else if(e instanceof ObstacleBox){
					if(e.collide(hero)) {
						hero.setDestroyed(true);
						setGameOver(true);
					}
				}
			}
			if(((Monster)e).isDestroyed() || e.getD().getX() < 0) {
				RenderableHolder.getInstance().getEntities().remove(e);
				everything.remove(e);
			}
		}
||||||| merged common ancestors
	
	public void update(long time) {
		
=======
	
	public static void update() {
		counter++;
		if(isMonsterGen.nextBoolean()) {
			MonstersGen();
		}
		if(counter % 30 == 0) {
			ObstacleBoxesGen();
		}
		if (boss.IsVisible()){
			if(counter % 40 == 0) {
				boss_Timer++;
				BossAttackGen();
				if (boss_Timer == 10) {
					boss.setAppeared(false);
					boss_Timer = 0;
				}
			}
		}
>>>>>>> 1744ad215e28e74f46172d896fdaa04f964e8412
	}

	public static boolean isJump() {
		return jump;
	}

	public static boolean isGameOver() {
		return gameOver;
	}

	public static void setGameOver(boolean gameOver) {
		GameLogic.gameOver = gameOver;
	}

	public static GameLogic getInstance() {
		return instance;
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
