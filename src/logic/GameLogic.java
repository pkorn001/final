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
import item.Item;
import obstacle.Bat;
import obstacle.Evil;
import obstacle.FlyingFire;
import obstacle.Hornet;
import obstacle.Monster;
import obstacle.ObstacleBox;
import obstacle.Skeleton;
import obstacle.Slime;
import render.Irenderable;
import render.RenderableHolder;
import scene.Background;

public class GameLogic {
	
	
	private static Hero hero;
	protected static Boss boss;
	protected static List<Item> items = new ArrayList<Item>();
	protected static List<Hitbox> trashes = new ArrayList<Hitbox>();
	protected static List<Monster> monsters = new ArrayList<Monster>();
	protected static List<ObstacleBox> obstacleBoxes = new ArrayList<ObstacleBox>();
	protected static List<Hitbox> boss_Attack = new ArrayList<Hitbox>();
	protected static List<Hitbox> everything = new ArrayList<Hitbox>();
	protected static boolean jump;
	protected static boolean attack;
	protected static boolean gameOver;
	protected static double speedFactor;
	private static Background bg = new Background();;
	static Random isMonsterGen = new Random();
	private static int counter = 1698;
	

	static {
		new GameLogic();
	}
	
	private GameLogic() {
		hero = new Hero (new Position(100.00,550));
		boss = new Boss(new Position(1100,200), 0, 0);
		speedFactor = 0.9;
		gameOver = false;
		everything.add(getHero());
		everything.add(boss);
	}
	
	public static boolean isGameOver() {
		return gameOver;
	}

	public static void setGameOver(boolean gameOver) {
		GameLogic.gameOver = gameOver;
	}

	public static double getSpeedFactor() {
		return speedFactor;
	}

	public static void setSpeedFactor(double speedFactor) {
		GameLogic.speedFactor = speedFactor;
	}

	public static void ObstacleBoxesGen() {
		Random obstacleBox_Type = new Random();
		if(obstacleBox_Type.nextInt(2) == 0) {
			ObstacleBox e = new ObstacleBox(new Position(1600,700),200,0,0);
			obstacleBoxes.add(e);
			everything.add(e);
		}else {
			ObstacleBox e = new ObstacleBox(new Position(1600,600),200,1,0);
			obstacleBoxes.add(e);
			everything.add(e);
		}
	}
	
	public static void ItemGen() {
		Random itemType = new Random();
		Item e = new Item(new Position(1600,hero.getA().getY()-200),-20,0);
		items.add(e);
		everything.add(e);
	}

	public static void MonstersGen() {
		Random monsterType = new Random();
		if (Hero.getStage() == 0) {
			Monster e = new Hornet(new Position(1600,hero.getB().getY()+60), 100, 100, 1, -50, 0);
			monsters.add(e);
			everything.add(e);	
		}
		else if (Hero.getStage() == 1) {
			if(monsterType.nextInt(3) == 0) {
				System.out.println("------------------------------");
				Monster e = new Slime(new Position(1600,700), 100, 100, 6, -50, 0);
				monsters.add(e);
				everything.add(e);	
			}
			else{
				Monster e = new FlyingFire(new Position(1600,hero.getB().getY()+60), 150, 150, 2, -50, 0);
				monsters.add(e);
				everything.add(e);
				
			}
		}
		else if (Hero.getStage() == 2) {
			if(monsterType.nextInt(3) == 0) {
				Monster e = new Hornet(new Position(1600,hero.getB().getY()+60), 100, 100, 1, -50, 0);
				monsters.add(e);
				everything.add(e);	
			}
			else{
				Monster e = new Evil(new Position(1600,hero.getB().getY()), 200, 200, 3, -50, 0);
				monsters.add(e);
				everything.add(e);		
			}	
		}
		else if (Hero.getStage() == 3) {
			if(monsterType.nextInt(3) == 0) {
				Monster e = new Hornet(new Position(1600,hero.getB().getY()+60), 100, 100, 1, -50, 0);
				monsters.add(e);
				everything.add(e);
			}else{
				Monster e = new Skeleton(new Position(1600,550), 250, 250, 4, -50, 0);
				if(monsterType.nextInt(3) == 1) {
					Monster e1 = new Skeleton(new Position(1750,550), 250, 250, 4, -50, 0);
					monsters.add(e1);
					everything.add(e1);
			}
				monsters.add(e);
				everything.add(e);
				}
		}
		else if (Hero.getStage() == 4) {
			if(monsterType.nextInt(3) == 0) {
				Monster e = new Slime(new Position(1600,700), 100, 100, 6, -50, 0);
				monsters.add(e);
				everything.add(e);
			}else{
				Monster e = new Bat(new Position(1600,hero.getB().getY()+60), 100, 100, 5, -50, 0);
				if(monsterType.nextInt(3) == 0) {
					Monster e1 = new Bat(new Position(3000,hero.getB().getY()+60), 100, 100, 5, -50, 0);
					monsters.add(e1);
					everything.add(e1);
				}else if(monsterType.nextInt(3) == 1) {
					Monster e1 = new Bat(new Position(1750,hero.getB().getY()+60), 100, 100, 5, -50, 0);
					monsters.add(e1);
					everything.add(e1);
				}
				monsters.add(e);
				everything.add(e);
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
			switch (attackPattern.nextInt(3)) {
			case 1:
				int i = attackPattern.nextInt(list.size());
				if(counter % 120 == 0) {
					if (i == 0) {
						ParriedBall e = (ParriedBall) boss.create(new Position(boss.getA().getX()+100,700),0,-1,-20, 0);
						boss_Attack.add(e);
						everything.add(e);
						
					}
		
					else if (i == 2) {
						ParriedBall e = (ParriedBall) boss.create(new Position(boss.getA().getX()+100, 700),0,-1,-20, 0);
						boss_Attack.add(e);
						everything.add(e);
						
					}
		
					else if (i == 4) {
						BossAttack e = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 700),1,-1,-20, 0);
						boss_Attack.add(e);
						everything.add(e);
						
					} else if (i == 5) {
						BossAttack e = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 700),1,-1,-20, 0);
						boss_Attack.add(e);
						everything.add(e);
						
		
					} else if (i == 7) {
							BossAttack e = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 450),1,-1,-20, 0);
							boss_Attack.add(e);
							everything.add(e);
							
					} else if (i == 8) {
						BossAttack e = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 450),1,-1,-20, 0);
						boss_Attack.add(e);
						everything.add(e);
						
					}
				}
				break;
	
			case 2:
						/*
						 * 0 = parried 1 = boss_fireball 2 = monster
						 */
					if (counter % 480 == 0) {
						if (attackType.nextInt(3) == 0) {
							ParriedBall e = (ParriedBall) boss.create(new Position(boss.getA().getX(),hero.getA().getY()+100),0,-1,-20, 0);
							boss_Attack.add(e);
							everything.add(e);
							
						} else if (attackType.nextInt(3) == 1) {
							BossAttack e = (BossAttack) boss.create(new Position(boss.getB().getX(),hero.getB().getY()-100),1,-1,-20, 0);
							boss_Attack.add(e);
							everything.add(e);
							
						} else if (attackType.nextInt(3) == 2) {
							Monster e = (Monster) boss.create(new Position(boss.getB().getX(),hero.getA().getY()+100),2,monsterType.nextInt(6)+1,-20, 0);
							boss_Attack.add(e);
							everything.add(e);
							
						}
					}
					break;

			default:
					int i1 = attackPattern.nextInt(list2.size());
					
					if (counter % 360 == 0) {
						if (i1 == 0) {
							ParriedBall e1 = (ParriedBall) boss.create(new Position(boss.getA().getX()+100, 760),0,-1,-5, 0);
							BossAttack e2 = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 710),1,-1,-5, 0);
							BossAttack e3 = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 660),1,-1,-5, 0);
							BossAttack e4 = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 610),1,-1,-5, 0);
							boss_Attack.add(e1);
							boss_Attack.add(e2);
							boss_Attack.add(e3);
							boss_Attack.add(e4);
							everything.add(e1);
							everything.add(e2);
							everything.add(e3);
							everything.add(e4);
						}
		
						else if (i1 == 1) {
							ParriedBall e1 = (ParriedBall) boss.create(new Position(boss.getA().getX()+100, 710),0,-1,-5, 0);
							BossAttack e2 = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 760),1,-1,-5, 0);
							BossAttack e3 = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 660),1,-1,-5, 0);
							BossAttack e4 = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 610),1,-1,-5, 0);
							boss_Attack.add(e1);
							boss_Attack.add(e2);
							boss_Attack.add(e3);
							boss_Attack.add(e4);
							everything.add(e1);
							everything.add(e2);
							everything.add(e3);
							everything.add(e4);
						}
		
						else if (i1 == 2) {
							ParriedBall e1 = (ParriedBall) boss.create(new Position(boss.getA().getX()+100, 660),0,-1,-5, 0);
							BossAttack e2 = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 760),1,-1,-5, 0);
							BossAttack e3 = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 710),1,-1,-5, 0);
							BossAttack e4 = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 610),1,-1,-5, 0);
							boss_Attack.add(e1);
							boss_Attack.add(e2);
							boss_Attack.add(e3);
							boss_Attack.add(e4);
							everything.add(e1);
							everything.add(e2);
							everything.add(e3);
							everything.add(e4);
						}
		
						else if (i1 == 3) {
							ParriedBall e1 = (ParriedBall) boss.create(new Position(boss.getA().getX()+100, 610),0,-1,-5, 0);
							BossAttack e2 = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 760),1,-1,-5, 0);
							BossAttack e3 = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 660),1,-1,-5, 0);
							BossAttack e4 = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 710),1,-1,-5, 0);
							boss_Attack.add(e1);
							boss_Attack.add(e2);
							boss_Attack.add(e3);
							boss_Attack.add(e4);
							everything.add(e1);
							everything.add(e2);
							everything.add(e3);
							everything.add(e4);
		
						}
					}
					break;
				}
		
		} else {
	
			switch (attackPattern.nextInt(2)) {
			case 1:
				int i = attackPattern.nextInt(list.size());
				if(counter % 120 == 0) {
					if (i == 0) {
						ParriedBall e = (ParriedBall) boss.create(new Position(boss.getA().getX()+100,700),0,-1,-20, 0);
						boss_Attack.add(e);
						everything.add(e);
						
					}
		
					else if (i == 2) {
						ParriedBall e = (ParriedBall) boss.create(new Position(boss.getA().getX()+100, 700),0,-1,-20, 0);
						boss_Attack.add(e);
						everything.add(e);
						
					}
		
					else if (i == 4) {
						BossAttack e = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 700),1,-1,-20, 0);
						boss_Attack.add(e);
						everything.add(e);
						
					} else if (i == 5) {
						BossAttack e = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 700),1,-1,-20, 0);
						boss_Attack.add(e);
						everything.add(e);
						
		
					} else if (i == 7) {
							BossAttack e = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 450),1,-1,-20, 0);
							boss_Attack.add(e);
							everything.add(e);
							
					} else if (i == 8) {
						BossAttack e = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 450),1,-1,-20, 0);
						boss_Attack.add(e);
						everything.add(e);
						
					}
				}
				
				break;
	
			default:
				int i1 = attackPattern.nextInt(list2.size());
				
				if (counter % 360 == 0) {
					if (i1 == 0) {
						ParriedBall e1 = (ParriedBall) boss.create(new Position(boss.getA().getX()+100, 760),0,-1,-5, 0);
						BossAttack e2 = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 710),1,-1,-5, 0);
						BossAttack e3 = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 660),1,-1,-5, 0);
						BossAttack e4 = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 610),1,-1,-5, 0);
						boss_Attack.add(e1);
						boss_Attack.add(e2);
						boss_Attack.add(e3);
						boss_Attack.add(e4);
						everything.add(e1);
						everything.add(e2);
						everything.add(e3);
						everything.add(e4);
					}
	
					else if (i1 == 1) {
						ParriedBall e1 = (ParriedBall) boss.create(new Position(boss.getA().getX()+100, 710),0,-1,-5, 0);
						BossAttack e2 = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 760),1,-1,-5, 0);
						BossAttack e3 = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 660),1,-1,-5, 0);
						BossAttack e4 = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 610),1,-1,-5, 0);
						boss_Attack.add(e1);
						boss_Attack.add(e2);
						boss_Attack.add(e3);
						boss_Attack.add(e4);
						everything.add(e1);
						everything.add(e2);
						everything.add(e3);
						everything.add(e4);
					}
	
					else if (i1 == 2) {
						ParriedBall e1 = (ParriedBall) boss.create(new Position(boss.getA().getX()+100, 660),0,-1,-5, 0);
						BossAttack e2 = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 760),1,-1,-5, 0);
						BossAttack e3 = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 710),1,-1,-5, 0);
						BossAttack e4 = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 610),1,-1,-5, 0);
						boss_Attack.add(e1);
						boss_Attack.add(e2);
						boss_Attack.add(e3);
						boss_Attack.add(e4);
						everything.add(e1);
						everything.add(e2);
						everything.add(e3);
						everything.add(e4);
					}
	
					else if (i1 == 3) {
						ParriedBall e1 = (ParriedBall) boss.create(new Position(boss.getA().getX()+100, 610),0,-1,-5, 0);
						BossAttack e2 = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 760),1,-1,-5, 0);
						BossAttack e3 = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 660),1,-1,-5, 0);
						BossAttack e4 = (BossAttack) boss.create(new Position(boss.getA().getX()+100, 710),1,-1,-5, 0);
						boss_Attack.add(e1);
						boss_Attack.add(e2);
						boss_Attack.add(e3);
						boss_Attack.add(e4);
						everything.add(e1);
						everything.add(e2);
						everything.add(e3);
						everything.add(e4);
					}
				}
				break;
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
	
	public static void logicUpdate() {
		
		counter++;
		speedFactor = Math.min(speedFactor + 0.00008, 2);
		bg.update();
		System.out.println(counter);
		if(counter % 6 == 0){
			Hero.setScore(Hero.getScore() + 1); //score increase every second
		}
		
		if (counter == 5410) {
			boss.setAppeared(true);
		}
		if(!boss.IsVisible()) {

			if(counter % 1701 == 0) {
				ItemGen();
			}else if(counter % 300 == 0) {
				MonstersGen();
			}else if(counter % 150 == 0) {
				ObstacleBoxesGen();
			}
		}else{
			if(counter % 120 == 0) {
				BossAttackGen();
			}
			else if(counter % 180 == 0) {
				BossAttackGen();
				if (counter > 7220) {
					boss.setAppeared(false);
					counter = 0;
				}
			}
		}
		
		for (ObstacleBox e : obstacleBoxes) {
			if (hero.collide(e)) {
				hero.setDestroyed(true);
				setGameOver(true);
			}
		}
		
		for (Monster e : monsters) {
			if (hero.collide(e)) {
				hero.setDestroyed(true);
				setGameOver(true);
			}
		}
		
		for (Hitbox e : boss_Attack) {
			if (hero.collide(e)) {
				hero.setDestroyed(true);
				setGameOver(true);
			}
		}
	
		for (Item e :items) { // for item
			//e.update(time);s
			if (hero.collide(e)) {
				switch (((Item) e).getItemType()) {
				case ("Mage"):
					everything.remove(hero);
					hero = new Mage(new Position(100.00,550));
					everything.add(hero);
					hero.setStage(1);
					trashes.add(e);
					break;
				case ("Boomeranger"):
					everything.remove(hero);
					hero = new Boomeranger(new Position(100.00,550));
					everything.add(hero);
					hero.setStage(2);
					trashes.add(e);
					break;
				case ("Swordman"):
					everything.remove(hero);
					hero = new Swordman(new Position(100.00,550));
					everything.add(hero);
					hero.setStage(3);
					trashes.add(e);
					break;
				case ("Assassin"):
					everything.remove(hero);
					hero = new Assassin(new Position(100.00,550));
					everything.add(hero);
					hero.setStage(4);
					trashes.add(e);
					break;
				}
			}
		}
		
		if (isJump()) {
			hero.jump();
		}
		if (isAttack()) {
			if (getHero() instanceof Mage) {
				((Mage) getHero()).attack();
			} else if (getHero() instanceof Boomeranger) {
				((Boomeranger) getHero()).attack();
			} else if (getHero() instanceof Swordman) {
				((Swordman) getHero()).attack();
			} else if (getHero() instanceof Assassin) {
				((Assassin) getHero()).attack();
			}
		}
			//e.update(time);
			/*if (getHero() instanceof Mage) {
				for (Monster monster : monsters) {
					if (((Mage) getHero()).getFireball().collide(monster)) {
						//TODO: new Fireball
						((Mage) getHero()).getFireball().setDestroyed(true);
						hero.updateScore(monster);
						monster.setDestroyed(true);
					}
				}
			} else if (getHero() instanceof Boomeranger) {
				for (Monster monster : monsters) {
					if (((Boomeranger) getHero()).getBoomerang().collide(monster)){
						hero.updateScore(monster);
						monster.setDestroyed(true);
					}
					if (((Boomeranger) getHero()).getBoomerang().collide(getHero())){
					}
				}
			} else if (getHero() instanceof Swordman) {
				for (Monster monster : monsters) {
					if (((Swordman) getHero()).getAttackBox().collide(monster)) {
						((Swordman) getHero()).updateScore(monster);
						monster.setDestroyed(true);
					}
				}
				
			} else if (getHero() instanceof Assassin) {
				for (Monster monster : monsters) {
					if (((Assassin) getHero()).getAttackBox().collide(monster)) {
						((Assassin) getHero()).updateScore(monster);
						monster.setDestroyed(true);
					}
				}
			}*/
	
		for (Hitbox e : everything) {
			e.update();
			if (e.getD().getX() < -300) {
				trashes.add(e);
				e.setDestroyed(true);
			}
		}
		
		for (Hitbox e : trashes) {
			everything.remove(e);
			if (e instanceof Item) {
				items.remove(e);
			}
			if (e instanceof Monster) {
				monsters.remove(e);
			}if (e instanceof BossAttack) {
				boss_Attack.remove(e);
			}if(e instanceof ObstacleBox) {
				obstacleBoxes.remove(e);
			}
		}
		
		trashes.clear();
			
		RenderableHolder.getInstance().getEntities().clear();
		RenderableHolder.getInstance().getEntities().add(bg);
		for (Hitbox e : everything) {
			Irenderable i = (Irenderable) e;
			RenderableHolder.getInstance().getEntities().add(i);
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

	public static Hero getHero() {
		return hero;
	}

	public static void setHero(Hero hero) {
		GameLogic.hero = hero;
	}
}