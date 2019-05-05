package logic;

import java.awt.event.KeyEvent;
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
import obstacle.Bat;
import obstacle.EvilFairy;
import obstacle.FlyingFire;
import obstacle.Hornet;
import obstacle.Monster;
import obstacle.ObstacleBox;
import obstacle.Skeleton;
import obstacle.Slime;
import render.RenderableHolder;
import scene.GameScreen;
import scene.Background;

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
		
		RenderableHolder.getInstance().getEntities().add(hero);
		RenderableHolder.getInstance().getEntities().add(boss);
		everything.add(hero);
		everything.add(boss);
	}
	
	public static double getSpeedFactor() {
		return speedFactor;
	}

	public static void setSpeedFactor(double speedFactor) {
		GameLogic.speedFactor = speedFactor;
	}

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
		}
	}
	
	public void MonstersGen() {
		Random monsterType = new Random();
		while (true) {
			if (Hero.getStage() == 0) {
				Monster e = new Hornet(new Position(1600,hero.getHeight()* 2 / 3), 100, 100, 0, -50, 0);
				monsters.add(e);
				everything.add(e);
				RenderableHolder.getInstance().getEntities().add(e);
			}
			else if (Hero.getStage() == 1) {
				if(monsterType.nextInt(2) == 0) {
					Monster e = new Slime(new Position(1600,0), 100, 100, 0, -50, 0);
					monsters.add(e);
					everything.add(e);
					RenderableHolder.getInstance().getEntities().add(e);
				}
				else if(monsterType.nextInt(2) == 1) {
					Monster e = new FlyingFire(new Position(1600,250), 100, 100, 0, -50, 0);
					monsters.add(e);
					everything.add(e);
					RenderableHolder.getInstance().getEntities().add(e);
				}
			}
			else if (Hero.getStage() == 2) {
				if(monsterType.nextInt(2) == 0) {
					Monster e = new Hornet(new Position(1600,hero.getHeight()* 2 / 3), 100, 100, 0, -50, 0);
					monsters.add(e);
					everything.add(e);
					RenderableHolder.getInstance().getEntities().add(e);
				}
				else if(monsterType.nextInt(2) == 1) {
					Monster e = new EvilFairy(new Position(1600,250), 100, 100, 0, -50, 0);
					monsters.add(e);
					everything.add(e);
					RenderableHolder.getInstance().getEntities().add(e);
				}
				
			}
			else if (Hero.getStage() == 3) {
				if(monsterType.nextInt(2) == 0) {
					Monster e = new Hornet(new Position(1600,hero.getHeight()* 2 / 3), 100, 100, 0, -50, 0);
					monsters.add(e);
					everything.add(e);
					RenderableHolder.getInstance().getEntities().add(e);
				}
				else if(monsterType.nextInt(2) == 1) {
					Monster e = new Skeleton(new Position(1600,0), 100, 100, 0, -50, 0);
					monsters.add(e);
					everything.add(e);
					RenderableHolder.getInstance().getEntities().add(e);
				}
			}
			else if (Hero.getStage() == 4) {
				if(monsterType.nextInt(2) == 0) {
					Monster e = new Slime(new Position(1600,0), 100, 100, 0, -50, 0);
					monsters.add(e);
					everything.add(e);
					RenderableHolder.getInstance().getEntities().add(e);
				}
				else if(monsterType.nextInt(2) == 1) {
					Monster e = new Bat(new Position(1600,hero.getHeight()* 2 / 3), 100, 100, 0, -50, 0);
					monsters.add(e);
					everything.add(e);
					RenderableHolder.getInstance().getEntities().add(e);
				}
			}
			try {
				wait(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void BossAttackGen() {
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
	
			case 1:
				for (int j = 0; j < 5; j++) {
					int i = attackPattern.nextInt(list.size());
					int k = i;
					list.remove(k);
					
					if (i == 0) {
						ParriedBall e = (ParriedBall) boss.create(new Position(1920, 100),0,-1,-50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					}
	
					else if (i == 1) {
						ParriedBall e = (ParriedBall) boss.create(new Position(1920, 100),0,-1,-50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					}
	
					else if (i == 2) {
						ParriedBall e = (ParriedBall) boss.create(new Position(1920, 250),0,-1,-50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					}
	
					else if (i == 3) {
						ParriedBall e = (ParriedBall) boss.create(new Position(1920, 250),0,-1,-50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					}
	
					else if (i == 4) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 100),1,-1,-50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					} else if (i == 5) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 100),1,-1,-50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					} else if (i == 6) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 100),1,-1,-50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					} else if (i == 7) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 250),1,-1,-50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					} else if (i == 8) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 250),1,-1,-50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
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
					}
				}
	
			case 2:
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
					}

			default:
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
					}
				}
			}
		} else {
	
			switch (attackPattern.nextInt(1)) {
			case 1:
				for (int j = 0; j < 5; j++) {
					int i = attackPattern.nextInt(list.size());
					int k = i;
					list.remove(k);
					
					if (i == 0) {
						ParriedBall e = (ParriedBall) boss.create(new Position(1920, 100),0,-1,-50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					}
	
					else if (i == 1) {
						ParriedBall e = (ParriedBall) boss.create(new Position(1920, 100),0,-1,-50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					}
	
					else if (i == 2) {
						ParriedBall e = (ParriedBall) boss.create(new Position(1920, 250),0,-1,-50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					}
	
					else if (i == 3) {
						ParriedBall e = (ParriedBall) boss.create(new Position(1920, 250),0,-1,-50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					}
	
					else if (i == 4) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 100),1,-1,-50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					} else if (i == 5) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 100),1,-1,-50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					} else if (i == 6) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 100),1,-1,-50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					} else if (i == 7) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 250),1,-1,-50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
					} else if (i == 8) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 250),1,-1,-50, 0);
						boss_Attack.add(e);
						everything.add(e);
						RenderableHolder.getInstance().getEntities().add(e);
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
					}
				}
	
			default:
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
	
	public void update(long time) {
		
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
