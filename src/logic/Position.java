package logic;

public class Position {
	protected double x;
	protected double y;
	
	public Position(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return  x;
	}

	public void setX(double d) {
		this.x = d;
	}

	public double getY() {
		return y;
	}

	public void setY(double d) {
		this.y = d;
	}
	
	
}
