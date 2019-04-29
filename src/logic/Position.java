package logic;

public class Position {
	protected int x;
	protected int y;
	
	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return  x;
	}

	public void setX(double d) {
		this.x = (int) d;
	}

	public int getY() {
		return y;
	}

	public void setY(double d) {
		this.y = (int) d;
	}
	
	
}
