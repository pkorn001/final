package hero.base;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.media.AudioClip;
import logic.GameLogic;
import logic.Hitbox;
import logic.Position;
import obstacle.Monster;
import render.Irenderable;
import render.Resource;

public class Hero extends Hitbox implements Irenderable {

	public static int score = 0;
	private static int stage = 0;
	protected int z;
	protected Position position;
	protected boolean isDestroyed = false;
	protected boolean isJumped = false;
	protected double ground = 550;
	private double i;
	private AudioClip sound;

	public Hero(Position a) {
		super(a, 130, 250);
		this.z = Integer.MAX_VALUE;
		this.position = a;
		stage = 0 ;
	}

	@Override
	public boolean isDestroyed() {
		return isDestroyed;
	}

	@Override
	public void draw(GraphicsContext g2d) {
		// TODO Auto-generated method stub
		g2d.drawImage(Resource.Hero0, this.getB().getX(), this.getB().getY(), this.getWidth(), this.getHeight());
	}

	@Override
	public boolean IsVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 5;
	}
	
	public void jump() {
		if(!isJumped) {
			Resource.Jump_Sound.play();
			isJumped = true;
		}
		getA().setY(ground - 400 * Math.sin(Math.toRadians(i)) + this.getHeight());
		getB().setY(ground - 400 * Math.sin(Math.toRadians(i)));
		getC().setY(ground - 400 * Math.sin(Math.toRadians(i)));
		getD().setY(ground - 400 * Math.sin(Math.toRadians(i)) + this.getHeight());
		i += GameLogic.getSpeedFactor()*6;
		if (i > 180) {
			i = 0;
			GameLogic.setJump(false);
			isJumped = false;
		}
		System.out.println("did jump! at : " + this.getB().getX() + ", " + this.getB().getY() );
	}

	public void updateScore(Monster monster) {
		setScore(getScore() + monster.getMonsterPoint());
	}
	
	public boolean isJumped() {
		return isJumped;
	}

	public void setJumped(boolean isJumped) {
		this.isJumped = isJumped;
	}

	public double getxSpeed() {
		return xSpeed;
	}

	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public static int getScore() {
		return Hero.score;
	}

	public static void setScore(int score) {
		Hero.score = score;
	}

	public static int getStage() {
		return Hero.stage;
	}

	public static void setStage(int stage) {
		Hero.stage = stage;
	}

	public void setDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}

	public AudioClip getSound() {
		return sound;
	}

	public void setSound(AudioClip sound) {
		this.sound = sound;
	}

}
