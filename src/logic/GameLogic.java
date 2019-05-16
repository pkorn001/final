package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import boss.Boss;
import boss.BossAttack;
import boss.ParriedBall;
import hero.action.Boomerang;
import hero.action.FireBall;
import hero.base.Assassin;
import hero.base.Boomeranger;
import hero.base.Hero;
import hero.base.Mage;
import hero.base.Swordman;
import item.Item;
import javafx.scene.media.AudioClip;
import obstacle.Bat;
import obstacle.EvilFairy;
import obstacle.FlyingFire;
import obstacle.Hornet;
import obstacle.Monster;
import obstacle.ObstacleBox;
import obstacle.Skeleton;
import obstacle.Slime;
import render.Irenderable;
import render.RenderableHolder;
import render.Resource;
import scene.Background;
import scene.StartScreen;

public class GameLogic {

	protected static Hero hero;
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
	private static int counter = 0;
	private static int boss_Timer = 0;
	private static Position heroPosition = new Position(100.0, 570.0);
	private static AudioClip deadSound = Resource.DeadSound;
	
	static {
		new GameLogic();
	}

	private GameLogic() {
		hero = new Assassin(heroPosition);
		boss = new Boss(new Position(1600, 0), 0, 0);
		speedFactor = 0.7;
		gameOver = false;
		everything.add(hero);
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
		if (counter % 48 == 0) {
			Random obstacleBox_Type = new Random();
			ObstacleBox e = new ObstacleBox(new Position(1600, hero.getB().getY()), 200, obstacleBox_Type.nextInt(2),
					0);
			obstacleBoxes.add(e);
			everything.add(e);

		}
	}

	public static void ItemGen() {
		if (counter % 48 == 0) {
			Random itemType = new Random();
			Item e = new Item(new Position(1600, hero.getA().getY() - 200), -20, itemType.nextInt(4));
			items.add(e);
			everything.add(e);

		}
	}

	public static void MonstersGen() {
		Random monsterType = new Random();
		if (counter % 48 == 0) {
			if (Hero.getStage() == 0) {
				Monster e = new Hornet(new Position(1600, hero.getB().getY()), 150, 150, 0, -50, 0);
				monsters.add(e);
				everything.add(e);

			} else if (Hero.getStage() == 1) {

				if (monsterType.nextInt(2) == 0) {
					Monster e = new Slime(new Position(1600, hero.getB().getY()), 300, 300, 0, -50, 0);
					monsters.add(e);
					everything.add(e);

				} else if (monsterType.nextInt(2) == 1) {
					Monster e = new FlyingFire(new Position(1600, hero.getB().getY()), 300, 300, 0, -50, 0);
					monsters.add(e);
					everything.add(e);

				}
			} else if (Hero.getStage() == 2) {
				if (monsterType.nextInt(2) == 0) {
					Monster e = new Hornet(new Position(1600, hero.getB().getY()), 150, 150, 0, -50, 0);
					monsters.add(e);
					everything.add(e);

				} else if (monsterType.nextInt(2) == 1) {
					Monster e = new EvilFairy(new Position(1600, hero.getB().getY()), 150, 150, 0, -50, 0);
					monsters.add(e);
					everything.add(e);

				}

			} else if (Hero.getStage() == 3) {
				if (monsterType.nextInt(2) == 0) {
					Monster e = new Hornet(new Position(1600, hero.getB().getY()), 150, 150, 0, -50, 0);
					monsters.add(e);
					everything.add(e);

				} else if (monsterType.nextInt(2) == 1) {
					Monster e = new Skeleton(new Position(1600, hero.getB().getY()), 150, 150, 0, -50, 0);
					monsters.add(e);
					everything.add(e);

				}
			} else if (Hero.getStage() == 4) {
				if (monsterType.nextInt(2) == 0) {
					Monster e = new Slime(new Position(1600, hero.getB().getY()), 150, 150, 0, -50, 0);
					monsters.add(e);
					everything.add(e);

				} else if (monsterType.nextInt(2) == 1) {
					Monster e = new Bat(new Position(1600, hero.getB().getY()), 150, 150, 0, -50, 0);
					monsters.add(e);
					everything.add(e);

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
				if (counter % 12 == 0) {
					if (i == 0) {
						ParriedBall e = (ParriedBall) boss.create(new Position(1920, 100), 0, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);

					}

					else if (i == 2) {
						ParriedBall e = (ParriedBall) boss.create(new Position(1920, 250), 0, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);

					}

					else if (i == 4) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 100), 1, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);

					} else if (i == 5) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 100), 1, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);

					} else if (i == 7) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 250), 1, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);

					} else if (i == 8) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 250), 1, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);

					}
				}

			case 2:
				/*
				 * 0 = parried 1 = boss_fireball 2 = monster
				 */
				if (counter % 60 == 0) {
					if (attackType.nextInt(3) == 0) {
						ParriedBall e = (ParriedBall) boss
								.create(new Position(boss.getB().getX(), hero.getA().getY() + 100), 0, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);

					} else if (attackType.nextInt(3) == 1) {
						BossAttack e = (BossAttack) boss
								.create(new Position(boss.getB().getX(), hero.getB().getY() - 100), 1, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);

					} else if (attackType.nextInt(3) == 2) {
						Monster e = (Monster) boss.create(new Position(boss.getB().getX(), hero.getA().getY() + 100), 2,
								monsterType.nextInt(6) + 1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);

					}
				}

			default:
				int i1 = attackPattern.nextInt(list2.size());

				if (counter % 60 == 0) {
					if (i1 == 0) {
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

					else if (i1 == 1) {
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

					else if (i1 == 2) {
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

					else if (i1 == 3) {
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
					}
				}
			}

		} else {

			switch (attackPattern.nextInt(1)) {
			case 1:
				int i = attackPattern.nextInt(list.size());
				if (counter % 12 == 0) {
					if (i == 0) {
						ParriedBall e = (ParriedBall) boss.create(new Position(1920, 100), 0, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);

					}

					else if (i == 2) {
						ParriedBall e = (ParriedBall) boss.create(new Position(1920, 250), 0, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);

					}

					else if (i == 4) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 100), 1, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);

					} else if (i == 5) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 100), 1, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);

					} else if (i == 7) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 250), 1, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);

					} else if (i == 8) {
						BossAttack e = (BossAttack) boss.create(new Position(1920, 250), 1, -1, -50, 0);
						boss_Attack.add(e);
						everything.add(e);

					}
				}

			default:
				int i1 = attackPattern.nextInt(list2.size());

				if (counter % 60 == 0) {
					if (i1 == 0) {
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
					}

					else if (i1 == 1) {
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
					}

					else if (i1 == 2) {
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
					}

					else if (i1 == 3) {
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
					}
				}
			}
		}
	}

	public static void logicUpdate() {
		bg.update();
		RenderableHolder.getInstance().getEntities().add(hero);
		if (StartScreen.isStart()) {
			counter++;
			speedFactor = Math.min(speedFactor + 0.00005, 2);

			if (counter % 6 == 0) {
				Hero.setScore(Hero.getScore() + 1); // score increase every second
			}

			if (counter % (int) (1701 - speedFactor) == 0) {
				ItemGen();
			}

			else if (counter % (int) (43 - speedFactor) == 0) {
				MonstersGen();
			}

			else if (counter % (int) (31 - speedFactor) == 0) {
				ObstacleBoxesGen();
			}

			if (boss.IsVisible()) {
				if (counter % 40 == 0) {
					boss_Timer++;
					BossAttackGen();
					if (boss_Timer == 10) {
						boss.setAppeared(false);
						boss_Timer = 0;
					}
				}
			}

			for (Monster e : monsters) { // for monster
				// e.update(time);
				if (e.collide(hero)) {
					hero.setDestroyed(true);
					deadSound.play();
					setGameOver(true);
				}
			}

			for (Hitbox e : boss_Attack) {
				if (e.collide(hero)) {
					hero.setDestroyed(true);
					deadSound.play();
					setGameOver(true);
				}
			}
			
			for (ObstacleBox e : obstacleBoxes) {
				if (e.collide(hero)) {
					hero.setDestroyed(true);
					deadSound.play();
					setGameOver(true);
				}
			}

			for (Item e : items) { // for item
				// e.update(time);s
				if (hero.collide(e)) {
					switch (((Item) e).getItemType()) {
					case ("Mage"):
						hero = new Mage(heroPosition);
						break;
					case ("Boomeranger"):
						hero = new Boomeranger(heroPosition);
						break;
					case ("Swordman"):
						hero = new Swordman(heroPosition);
						break;
					case ("Assassin"):
						hero = new Assassin(heroPosition);
						break;
					}
				}
			}

			if (isJump()) {
				hero.jump();
			}
			if (isAttack()) {
				// e.update(time);
				
				if (hero instanceof Mage) {// just create fireball, have to calculate thr movement in AnimationTimer to
											// finish.
					FireBall fireball = ((Mage) hero).getAttack();
					everything.add(fireball);
					for (Monster monster : monsters) {
						if (fireball.collide(monster)) {
							// TODO: new Fireball
							fireball.setDestroyed(true);
							hero.updateScore(monster);
							monster.setDestroyed(true);
						}
					}
					for (ObstacleBox obstacle : obstacleBoxes) {
						if (fireball.collide(obstacle)) {
							fireball.setDestroyed(true);
						}
					}
				} else if (hero instanceof Boomeranger) { // just create boomerang, have to calculate the movement in
															// AnimationTimer to finish.
					Boomerang boomerang = ((Boomeranger) hero).getAttack();
					everything.add(boomerang);
					for (Monster monster : monsters) {
						if (boomerang.collide(monster)) {
							hero.updateScore(monster);
							monster.setDestroyed(true);
						}
						if (boomerang.isReturn()) {
							everything.remove(boomerang);
						}
					}
				} else if (hero instanceof Swordman) {
					((Swordman) hero).attack();
					for (Monster monster : monsters) {
						if (((Swordman) hero).getAttack().collide(monster)) {
							((Swordman) hero).updateScore(monster);
							monster.setDestroyed(true);
						}
					}

				} else if (hero instanceof Assassin) {
					((Assassin) hero).attack();
					for (Monster monster : monsters) {
						if (((Assassin) hero).getAttack().collide(monster)) {
							((Assassin) hero).updateScore(monster);
							monster.setDestroyed(true);
						}
					}
				}
			}

			for (Hitbox e : everything) {
				e.update();
				if (e.getD().getX() < -300) {
					trashes.add(e);
					e.setDestroyed(true);
				}
			}

			for (Hitbox e : trashes) {
				everything.remove(e);
			}

			trashes.clear();
		}
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
}