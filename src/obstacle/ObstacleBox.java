package obstacle;

import hero.base.Hero;
import javafx.scene.canvas.GraphicsContext;
import logic.Hitbox;
import logic.Position;
import move.ForwardMove;
import move.Move;
import render.Irenderable;
import render.Resource;

public class ObstacleBox extends Hitbox implements Irenderable {

	// 0 = stone 1 = tree
	private int obstacleBox_Type;

	/*
	 * 0 = normal 1 = red 2 = green 3 = black 4 = purple
	 */
	private int z;
	private final static int[] OBSTACLE_HEIGHT = { 20, 40 };
	private Move movePattern;

	public ObstacleBox(Position a, double speed, int obstacleBox_Type, int width) {
		super(a, speed);
		z = Integer.MAX_VALUE;
		this.obstacleBox_Type = obstacleBox_Type;
		super.A = new Position(a.getX(), a.getY());
		super.B = new Position(a.getX(), a.getY() + ObstacleBox.setHeight(obstacleBox_Type));
		super.C = new Position(a.getX() + width, a.getY() + ObstacleBox.setHeight(obstacleBox_Type));
		super.D = new Position(a.getX() + width, a.getY());
		movePattern = new ForwardMove(this);
		// TODO Auto-generated constructor stub
	}

	public static int setHeight(int obstacleBox_Type) {
		return OBSTACLE_HEIGHT[obstacleBox_Type];
	}

	public int getObstacleBox_Type() {
		return obstacleBox_Type;
	}

	public void setObstacleBox_Type(int obstacleBox_Type) {
		this.obstacleBox_Type = obstacleBox_Type;
	}

	@Override
	public void draw(GraphicsContext g2d, long time) {
		switch (Hero.getStage()) {

		case 1: {
			switch (this.obstacleBox_Type) {
			case 0: {
				g2d.drawImage(Resource.Obstacle_1, this.getB().getX(), this.getB().getY(), this.getWidth(),
						this.getHeight());
			}
			case 1: {
				g2d.drawImage(Resource.ObstacleTall_1, this.getB().getX(), this.getB().getY(), this.getWidth(),
						this.getHeight());
			}
			}
		}

		case 2: {
			switch (this.obstacleBox_Type) {
			case 0: {
				g2d.drawImage(Resource.Obstacle_2, this.getB().getX(), this.getB().getY(), this.getWidth(),
						this.getHeight());
			}
			case 1: {
				g2d.drawImage(Resource.ObstacleTall_2, this.getB().getX(), this.getB().getY(), this.getWidth(),
						this.getHeight());
			}
			}
		}

		case 3: {
			switch (this.obstacleBox_Type) {
			case 0: {
				g2d.drawImage(Resource.Obstacle_3, this.getB().getX(), this.getB().getY(), this.getWidth(),
						this.getHeight());
			}
			case 1: {
				g2d.drawImage(Resource.ObstacleTall_3, this.getB().getX(), this.getB().getY(), this.getWidth(),
						this.getHeight());
			}
			}
		}

		case 4: {
			switch (this.obstacleBox_Type) {
			case 0: {
				g2d.drawImage(Resource.Obstacle_4, this.getB().getX(), this.getB().getY(), this.getWidth(),
						this.getHeight());
			}
			case 1: {
				g2d.drawImage(Resource.ObstacleTall_4, this.getB().getX(), this.getB().getY(), this.getWidth(),
						this.getHeight());
			}
			}
		}

		default: {
			switch (this.obstacleBox_Type) {
			case 0: {
				g2d.drawImage(Resource.Obstacle_0, this.getB().getX(), this.getB().getY(), this.getWidth(),
						this.getHeight());
			}
			case 1: {
				g2d.drawImage(Resource.ObstacleTall_0, this.getB().getX(), this.getB().getY(), this.getWidth(),
						this.getHeight());
			}
			}
		}
		}
	}

	@Override
	public boolean IsVisible() {
		return true;
	}

	@Override
	public int getZ() {
		return z--;
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(double xSpeed, double ySpeed, long time) {
		for (Position i : new Position[] { this.A, this.B, this.C, this.D }) {
			i.setX(i.getX() + this.movePattern.move(time).getX());
			i.setY(i.getY() + this.movePattern.move(time).getY());
		}
	}

}