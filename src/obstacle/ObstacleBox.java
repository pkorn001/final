package obstacle;

import hero.base.Hero;
import javafx.scene.canvas.GraphicsContext;
import logic.Hitbox;
import logic.Position;
import move.ForwardMove;
import move.Move;
import render.Irenderable;
import render.Resource;

public class ObstacleBox extends Hitbox implements Irenderable{
	
	// 0 = stone 1 = tree
	private int obstacleBox_Type;
	
	/* 0 = normal 
	 1 = 2 blocks 
	 2 = 3 blocks*/
	private int obstacleBox_Size;
	
	/* 0 = normal 
	 1 = red 
	 2 = green
	 3 = black
	 4 = purple */
	private int z;
	private final static int[] OBSTACLE_HEIGHT = {20,40};
	private final static int[] OBSTACLE_WIDTH = {20,40,60};
	private Move movePattern;
	
	public ObstacleBox(Position a,int speed,int obstacleBox_Type,int obstacleBox_Size,int Stage) {
		super(a, speed);
		z = Integer.MAX_VALUE;
		this.obstacleBox_Type = obstacleBox_Type;
		Hero.setStage(Stage);
		super.A = new Position(a.getX(), a.getY());
		super.B = new Position(a.getX(), a.getY()+ ObstacleBox.setHeight(obstacleBox_Type));
		super.C = new Position(a.getX()+ ObstacleBox.setWidth(obstacleBox_Size), a.getY()+ ObstacleBox.setHeight(obstacleBox_Type));
		super.D = new Position(a.getX()+ ObstacleBox.setWidth(obstacleBox_Size), a.getY());
		movePattern = new ForwardMove(this);
		// TODO Auto-generated constructor stub
	}
	
	public static int setHeight(int obstacleBox_Type) {
		return OBSTACLE_HEIGHT[obstacleBox_Type];
	}
	
	public static int setWidth(int obstacleBox_Size) {
		return OBSTACLE_WIDTH[obstacleBox_Size];
	}

	public int getObstacleBox_Type() {
		return obstacleBox_Type;
	}

	public void setObstacleBox_Type(int obstacleBox_Type) {
		this.obstacleBox_Type = obstacleBox_Type;
	}

	public int getObstacleBox_Size() {
		return obstacleBox_Size;
	}

	public void setObstacleBox_Size(int obstacleBox_Size) {
		this.obstacleBox_Size = obstacleBox_Size;
	}
	
	@Override
	public void draw(GraphicsContext g2d) {
		switch(Hero.getStage()) {
		
		case 1 :{
			switch(this.obstacleBox_Type) {
			case 0:{
				switch(this.obstacleBox_Size) {
				case 0: g2d.drawImage(Resource.Obstacle_11,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight()); break;
				case 1: g2d.drawImage(Resource.Obstacle_12,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight()); break;
				case 2: g2d.drawImage(Resource.Obstacle_13,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight()); break;
				}
			}
			case 1:{
				switch(this.obstacleBox_Size) {
				case 0: g2d.drawImage(Resource.ObstacleTall_11,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight()); break;
				case 1: g2d.drawImage(Resource.ObstacleTall_12,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight()); break;
				case 2: g2d.drawImage(Resource.ObstacleTall_13,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight()); break;
			}
			}
		}
		}
		
		case 2 : {
			switch(this.obstacleBox_Type) {
			case 0:{
				switch(this.obstacleBox_Size) {
				case 0: g2d.drawImage(Resource.Obstacle_21,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight()); break;
				case 1: g2d.drawImage(Resource.Obstacle_22,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight()); break;
				case 2: g2d.drawImage(Resource.Obstacle_23,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight()); break;
				}
			}
			case 1:{
				switch(this.obstacleBox_Size) {
				case 0: g2d.drawImage(Resource.ObstacleTall_21,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight()); break;
				case 1: g2d.drawImage(Resource.ObstacleTall_22,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight()); break;
				case 2: g2d.drawImage(Resource.ObstacleTall_23,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight()); break;
			}
			}
			}
		}
			
		case 3 : {
			switch(this.obstacleBox_Type) {
			case 0:{
				switch(this.obstacleBox_Size) {
				case 0: g2d.drawImage(Resource.Obstacle_31,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight()); break;
				case 1: g2d.drawImage(Resource.Obstacle_32,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight()); break;
				case 2: g2d.drawImage(Resource.Obstacle_33,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight()); break;
				}
			}
			case 1:{
				switch(this.obstacleBox_Size) {
				case 0: g2d.drawImage(Resource.ObstacleTall_31,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight()); break;
				case 1: g2d.drawImage(Resource.ObstacleTall_32,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight()); break;
				case 2: g2d.drawImage(Resource.ObstacleTall_33,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight()); break;
			}
			}
			}
		}
		
		case 4 : {
			switch(this.obstacleBox_Type) {
			case 0:{
				switch(this.obstacleBox_Size) {
				case 0: g2d.drawImage(Resource.Obstacle_41,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight()); break;
				case 1: g2d.drawImage(Resource.Obstacle_42,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight()); break;
				case 2: g2d.drawImage(Resource.Obstacle_43,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight()); break;
				}
			}
			case 1:{
				switch(this.obstacleBox_Size) {
				case 0: g2d.drawImage(Resource.ObstacleTall_41,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight()); break;
				case 1: g2d.drawImage(Resource.ObstacleTall_42,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight()); break;
				case 2: g2d.drawImage(Resource.ObstacleTall_43,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight()); break;
			}
			}
			}
		}
		
		default : {
			switch(this.obstacleBox_Type) {
			case 0:{
				switch(this.obstacleBox_Size) {
				case 0: g2d.drawImage(Resource.Obstacle_01,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight()); break;
				case 1: g2d.drawImage(Resource.Obstacle_02,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight()); break;
				case 2: g2d.drawImage(Resource.Obstacle_03,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight()); break;
				}
			}
			case 1:{
				switch(this.obstacleBox_Size) {
				case 0: g2d.drawImage(Resource.ObstacleTall_01,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight()); break;
				case 1: g2d.drawImage(Resource.ObstacleTall_02,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight()); break;
				case 2: g2d.drawImage(Resource.ObstacleTall_03,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight()); break;
			}
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
		for(Position i  : new Position[] {this.A, this.B, this.C, this.D}){
			i.setX(i.getX()+this.movePattern.move(time).getX());
			i.setY(i.getY()+this.movePattern.move(time).getY());
		}
	}

}
