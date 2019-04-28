package obstacle;

import java.awt.Graphics2D;



import logic.Hitbox;
import logic.Position;
import render.Renderable;
import render.Resource;

public class ObstacleBox extends Hitbox implements Renderable{
	
	
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
	private int Stage;
	private int z;
	private final static int[] OBSTACLE_HEIGHT = {20,40};
	private final static int[] OBSTACLE_WIDTH = {20,40,60};

	public ObstacleBox(Position a,int speed,int obstacleBox_Type,int obstacleBox_Size,int Stage) {
		super(speed);
		z = Integer.MAX_VALUE;
		this.obstacleBox_Type = obstacleBox_Type;
		this.Stage = Stage;
		Position A = new Position(a.getX(), a.getY());
		Position B = new Position(a.getX(), a.getY()+ ObstacleBox.setHeight(obstacleBox_Type));
		Position C = new Position(a.getX()+ ObstacleBox.setWidth(obstacleBox_Size), a.getY()+ ObstacleBox.setHeight(obstacleBox_Type));
		Position D = new Position(a.getX()+ ObstacleBox.setWidth(obstacleBox_Size), a.getY());
		
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

	public int getStage() {
		return Stage;
	}

	public void setStage(int stage) {
		Stage = stage;
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		switch(this.getStage()) {
		
		case 1 :{
			switch(this.obstacleBox_Type) {
			case 0:{
				switch(this.obstacleBox_Size) {
				case 0: g2d.drawImage(Resource.Obstacle_11,this.getB().getX(),this.getB().getY(),null);
				case 1: g2d.drawImage(Resource.Obstacle_12,this.getB().getX(),this.getB().getY(),null);
				case 2: g2d.drawImage(Resource.Obstacle_13,this.getB().getX(),this.getB().getY(),null);
				}
			}
			case 1:{
				switch(this.obstacleBox_Size) {
				case 0: g2d.drawImage(Resource.ObstacleTall_11,this.getB().getX(),this.getB().getY(),null);
				case 1: g2d.drawImage(Resource.ObstacleTall_12,this.getB().getX(),this.getB().getY(),null);
				case 2: g2d.drawImage(Resource.ObstacleTall_13,this.getB().getX(),this.getB().getY(),null);
			}
			}
		}
		}
		
		case 2 : {
			switch(this.obstacleBox_Type) {
			case 0:{
				switch(this.obstacleBox_Size) {
				case 0: g2d.drawImage(Resource.Obstacle_21,this.getB().getX(),this.getB().getY(),null);
				case 1: g2d.drawImage(Resource.Obstacle_22,this.getB().getX(),this.getB().getY(),null);
				case 2: g2d.drawImage(Resource.Obstacle_23,this.getB().getX(),this.getB().getY(),null);
				}
			}
			case 1:{
				switch(this.obstacleBox_Size) {
				case 0: g2d.drawImage(Resource.ObstacleTall_21,this.getB().getX(),this.getB().getY(),null);
				case 1: g2d.drawImage(Resource.ObstacleTall_22,this.getB().getX(),this.getB().getY(),null);
				case 2: g2d.drawImage(Resource.ObstacleTall_23,this.getB().getX(),this.getB().getY(),null);
			}
			}
			}
		}
			
		case 3 : {
			switch(this.obstacleBox_Type) {
			case 0:{
				switch(this.obstacleBox_Size) {
				case 0: g2d.drawImage(Resource.Obstacle_31,this.getB().getX(),this.getB().getY(),null);
				case 1: g2d.drawImage(Resource.Obstacle_32,this.getB().getX(),this.getB().getY(),null);
				case 2: g2d.drawImage(Resource.Obstacle_33,this.getB().getX(),this.getB().getY(),null);
				}
			}
			case 1:{
				switch(this.obstacleBox_Size) {
				case 0: g2d.drawImage(Resource.ObstacleTall_31,this.getB().getX(),this.getB().getY(),null);
				case 1: g2d.drawImage(Resource.ObstacleTall_32,this.getB().getX(),this.getB().getY(),null);
				case 2: g2d.drawImage(Resource.ObstacleTall_33,this.getB().getX(),this.getB().getY(),null);
			}
			}
			}
		}
		
		case 4 : {
			switch(this.obstacleBox_Type) {
			case 0:{
				switch(this.obstacleBox_Size) {
				case 0: g2d.drawImage(Resource.Obstacle_41,this.getB().getX(),this.getB().getY(),null);
				case 1: g2d.drawImage(Resource.Obstacle_42,this.getB().getX(),this.getB().getY(),null);
				case 2: g2d.drawImage(Resource.Obstacle_43,this.getB().getX(),this.getB().getY(),null);
				}
			}
			case 1:{
				switch(this.obstacleBox_Size) {
				case 0: g2d.drawImage(Resource.ObstacleTall_41,this.getB().getX(),this.getB().getY(),null);
				case 1: g2d.drawImage(Resource.ObstacleTall_42,this.getB().getX(),this.getB().getY(),null);
				case 2: g2d.drawImage(Resource.ObstacleTall_43,this.getB().getX(),this.getB().getY(),null);
			}
			}
			}
		}
		
		default : {
			switch(this.obstacleBox_Type) {
			case 0:{
				switch(this.obstacleBox_Size) {
				case 0: g2d.drawImage(Resource.Obstacle_01,this.getB().getX(),this.getB().getY(),null);
				case 1: g2d.drawImage(Resource.Obstacle_02,this.getB().getX(),this.getB().getY(),null);
				case 2: g2d.drawImage(Resource.Obstacle_03,this.getB().getX(),this.getB().getY(),null);
				}
			}
			case 1:{
				switch(this.obstacleBox_Size) {
				case 0: g2d.drawImage(Resource.ObstacleTall_01,this.getB().getX(),this.getB().getY(),null);
				case 1: g2d.drawImage(Resource.ObstacleTall_02,this.getB().getX(),this.getB().getY(),null);
				case 2: g2d.drawImage(Resource.ObstacleTall_03,this.getB().getX(),this.getB().getY(),null);
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
	
	

}
