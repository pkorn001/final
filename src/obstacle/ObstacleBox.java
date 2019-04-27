package obstacle;

import logic.Hitbox;
import logic.Position;

public class ObstacleBox extends Hitbox{
	
	// 0 = stone 1 = tree
	private int obstacleBox_Type;
	
	/* 0 = normal 
	 1 = red 
	 2 = green*/
	private int obstacleBox_Size;
	
	/* 0 = normal 
	 1 = red 
	 2 = green
	 3 = black
	 4 = purple */
	private int Stage;
	private final static int[] OBSTACLE_HEIGHT = {20,40};
	private final static int[] OBSTACLE_WIDTH = {20,40,60};

	public ObstacleBox(Position a,int speed,int obstacleBox_Type,int obstacleBox_Size,int Stage) {
		super(speed);
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
	
	

}
