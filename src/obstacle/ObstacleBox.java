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
	private boolean destroyed;
	private final static int[] OBSTACLE_HEIGHT = { 100, 200 };
	private Move movePattern;

	public ObstacleBox(Position a, int width, int obstacleBox_Type, double speed) {
		super(a, width, ObstacleBox.setHeight(obstacleBox_Type), speed);
		z = Integer.MAX_VALUE;
		this.obstacleBox_Type = obstacleBox_Type;
		super.A = new Position(a.getX(), a.getY() + ObstacleBox.setHeight(obstacleBox_Type));
		super.B = new Position(a.getX(), a.getY() );
		super.C = new Position(a.getX() + width, a.getY());
		super.D = new Position(a.getX() + width, a.getY() + ObstacleBox.setHeight(obstacleBox_Type));
		movePattern = new ForwardMove(this);
		destroyed = false;
	}
	
	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
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
	public void draw(GraphicsContext g2d) {
		g2d.drawImage(Resource.BossAttack,A.getX(),A.getY(),5,5);
		g2d.drawImage(Resource.BossAttack,B.getX(),B.getY(),5,5);
		g2d.drawImage(Resource.BossAttack,C.getX(),C.getY(),5,5);
		g2d.drawImage(Resource.BossAttack,D.getX(),D.getY(),5,5);
		if (Hero.getStage() == 1) {
			if(this.obstacleBox_Type == 0) {
				g2d.drawImage(Resource.Obstacle_1, this.getB().getX(), this.getB().getY(), this.getWidth(),
						this.getHeight());
			}
			if(this.obstacleBox_Type == 1) {
				g2d.drawImage(Resource.ObstacleTall_1, this.getB().getX(), this.getB().getY(), this.getWidth(),
						this.getHeight());
			}
		}
		
		else if (Hero.getStage() == 2) {
			if(this.obstacleBox_Type == 0) {
				g2d.drawImage(Resource.Obstacle_2, this.getB().getX(), this.getB().getY(), this.getWidth(),
						this.getHeight());
			}
			if(this.obstacleBox_Type == 1) {
				g2d.drawImage(Resource.ObstacleTall_2, this.getB().getX(), this.getB().getY(), this.getWidth(),
						this.getHeight());
			}
		}

		else if (Hero.getStage() == 3) {
			if(this.obstacleBox_Type == 0) {
				g2d.drawImage(Resource.Obstacle_3, this.getB().getX(), this.getB().getY(), this.getWidth(),
						this.getHeight());
			}
			if(this.obstacleBox_Type == 1) {
				g2d.drawImage(Resource.ObstacleTall_3, this.getB().getX(), this.getB().getY(), this.getWidth(),
						this.getHeight());
			}
		}

		else if (Hero.getStage() == 4) {
			if(this.obstacleBox_Type == 0) {
				g2d.drawImage(Resource.Obstacle_4, this.getB().getX(), this.getB().getY(), this.getWidth(),
						this.getHeight());
			}
			if(this.obstacleBox_Type == 1) {
				g2d.drawImage(Resource.ObstacleTall_4, this.getB().getX(), this.getB().getY(), this.getWidth(),
						this.getHeight());
			}
		}
		
		else if (Hero.getStage() == 0) {
			if(this.obstacleBox_Type == 0) {
				g2d.drawImage(Resource.Obstacle_0, this.getB().getX(), this.getB().getY(), this.getWidth(),
						this.getHeight());
			}
			if(this.obstacleBox_Type == 1) {
				g2d.drawImage(Resource.ObstacleTall_0, this.getB().getX(), this.getB().getY(), this.getWidth(),
						this.getHeight());
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
	public void update() {
		for (Position i : new Position[] { this.A, this.B, this.C, this.D }) {
			i.setX(i.getX() + this.movePattern.move().getX());
			i.setY(i.getY() + this.movePattern.move().getY());
		}
	}


@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return destroyed;
	}
}