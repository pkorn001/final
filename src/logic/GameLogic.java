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
import scene.Background;

public class GameLogic {
	
	static {
		new GameLogic();
	}
	
	protected static Hero hero;
	protected static Boss boss;
	protected static List<Monster> monsters = new ArrayList<Monster>();
	protected static List<ObstacleBox> obstacleBoxes = new ArrayList<ObstacleBox>();
	protected static List<Hitbox> boss_Attack = new ArrayList<Hitbox>();
	protected static List<Hitbox> everything = new ArrayList<Hitbox>();
	protected static boolean jump;
	protected static boolean attack;
	protected static double speedFactor;
	private Background bg;
	static Random isMonsterGen = new Random();
	private static int counter = 0;
	private static int boss_Timer = 0;
	
	private GameLogic() {
		hero = new Hero(new Position(50.00,0.00));
			
		bg = new Background();
		boss = new Boss(new Position(1600,0), 0, 0);
		speedFactor = 1;
		
		
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

	public static void ObstacleBoxesGen() {
		if (counter % 48 == 0) {
			Random obstacleBox_Type = new Random();
			ObstacleBox e = new ObstacleBox(new Position(1000,0),50, obstacleBox_Type.nextInt(2),0);
			obstacleBoxes.add(e);
			everything.add(e);
			RenderableHolder.getInstance().getEntities().add(e);
		}
	}
	
	public static void MonstersGen() {
		Random monsterType = new Random();
		if(counter % 48 == 0) {
			if (Hero.getStage() == 0) {
				Monster e = new Hornet(new Position(1000,hero.getHeight()* 2 / 3), 100, 100, 0, -50, 0);
				monsters.add(e);
				everything.add(e);
				RenderableHolder.getInstance().getEntities().add(e);
			}
			else if (Hero.getStage() == 1) {
				if(monsterType.nextInt(2) == 0) {
					Monster e = new Slime(new Position(1000,0), 100, 100, 0, -50, 0);
					monsters.add(e);
					everything.add(e);
					RenderableHolder.getInstance().getEntities().add(e);
				}
				else if(monsterType.nextInt(2) == 1) {
					Monster e = new FlyingFire(new Position(1000,250), 100, 100, 0, -50, 0);
					monsters.add(e);
					everything.add(e);
					RenderableHolder.getInstance().getEntities().add(e);
				}
			}
			else if (Hero.getStage() == 2) {
				if(monsterType.nextInt(2) == 0) {
					Monster e = new Hornet(new Position(1000,hero.getHeight()* 2 / 3), 100, 100, 0, -50, 0);
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
			case 1:
				int i = attackPattern.nextInt(list.size());
				if(counter % 12 == 0) {
					if (i == 0) {
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
					}
				}
	
			case 2:
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
					}

			default:
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
					}
				}
		
		} else {
	
			switch (attackPattern.nextInt(1)) {
			case 1:
				int i = attackPattern.nextInt(list.size());
				if(counter % 12 == 0) {
					if (i == 0) {
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
					}
				}
	
			default:
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
