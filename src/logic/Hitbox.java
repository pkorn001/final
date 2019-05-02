package logic;

public abstract class Hitbox {
	//down-left
	protected Position A;
	//up-left
	protected Position B;
	//up-right
	protected Position C;
	//down-right
	protected Position D;
	protected int xSpeed;
	protected int ySpeed;
	
	public Position getA() {
		return A;
	}

	public void setA(Position a) {
		A = a;
	}

	public Position getB() {
		return B;
	}

	public int getySpeed() {
		return ySpeed;
	}

	public void setySpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}

	public void setB(Position b) {
		B = b;
	}

	public Position getC() {
		return C;
	}

	public void setC(Position c) {
		C = c;
	}

	public Position getD() {
		return D;
	}

	public void setD(Position d) {
		D = d;
	}

	public int getxSpeed() {
		return xSpeed;
	}

	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}

	//Obstacle has only X-velocity
	public Hitbox(Position position, int speed) {
		this.xSpeed = speed;
		
	}
	
	//Hero has no velocity
	public Hitbox(Position a,int width,int height) {
		super();
		Position A = new Position(a.getX(), a.getY());
		Position B = new Position(a.getX(), a.getY()+height);
		Position C = new Position(a.getX()+width, a.getY()+height);
		Position D = new Position(a.getX()+width, a.getY());
	}
	
	//Monster has XY-velocity
	public Hitbox(Position a,int width,int height,int xSpeed, int ySpeed) {
		super();
		Position A = new Position(a.getX(), a.getY());
		Position B = new Position(a.getX(), a.getY()+height);
		Position C = new Position(a.getX()+width, a.getY()+height);
		Position D = new Position(a.getX()+width, a.getY());
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}

	public boolean collide(Hitbox hitbox) {
		if (((this.A.getX() < hitbox.D.getX()) && (this.A.getX() > hitbox.A.getX()) && (this.B.getY() > hitbox.D.getY()))
				|| ((this.A.getX() < hitbox.C.getX()) && (this.D.getX() > hitbox.C.getX()) && (this.A.getY() < hitbox.C.getY()) && (this.B.getY() > hitbox.C.getY()))
				|| ((this.D.getX() > hitbox.A.getX() && (this.A.getX() < hitbox.A.getX()) && (this.C.getY() > hitbox.A.getY())))
				|| ((this.D.getX() > hitbox.B.getX() && (this.A.getX() < hitbox.B.getX()) && (this.C.getY() > hitbox.B.getY()) && (this.D.getY() < hitbox.B.getY())))
				) {
			return true;
		}
		return false;
		}
	
	public void update(int xSpeed, int ySpeed, double time) {
		for(Position i  : new Position[] {this.A, this.B, this.C, this.D}){
			i.setX(i.getX() + xSpeed * (int)time);
			i.setY(i.getY() + ySpeed * (int)time);
		}

	}
	
}
