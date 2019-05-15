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
	protected double xSpeed;
	protected double ySpeed;
	protected double width;
	protected double height;
	protected boolean destroyed;
	
	public Position getA() {
		return A;
	}

	public void setA(Position a) {
		A = a;
	}

	public Position getB() {
		return B;
	}

	public double getySpeed() {
		return ySpeed;
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}
	
	public void setySpeed(double ySpeed) {
		this.ySpeed = ySpeed*GameLogic.getSpeedFactor();
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

	public double getxSpeed() {
		return xSpeed;
	}

	public void setxSpeed(double xSpeed) {
		this.xSpeed = xSpeed *GameLogic.getSpeedFactor();
	}

	//Obstacle has only X-velocity
	public Hitbox(Position position,int width,int height, double speed) {
		this(position, width, height);
		setxSpeed(speed);
		
	}
	
	public double getWidth() {
		return this.width;
	}

	public double getHeight() {
		return this.height;
	}

	//Hero has no velocity
	public Hitbox(Position a,int width,int height) {
		super();
		this.A = new Position(a.getX(), a.getY()+height);
		this.B = new Position(a.getX(), a.getY());
		this.C = new Position(a.getX()+width, a.getY());
		this.D = new Position(a.getX()+width, a.getY()+height);
		this.width = width;
		this.height = height;
	}
	
	//Monster has XY-velocity
	public Hitbox(Position a,int width,int height,double xSpeed, double ySpeed) {
		super();
		this.width = width;
		this.height = height;
		this.A = new Position(a.getX(), a.getY()+height);
		this.B = new Position(a.getX(), a.getY());
		this.C = new Position(a.getX()+width, a.getY());
		this.D = new Position(a.getX()+width, a.getY()+height);
		setxSpeed(xSpeed);
		setySpeed(ySpeed);
	}

	public boolean collide(Hitbox hitbox) {
		if (((this.A.getX() < hitbox.D.getX()) && (this.A.getX() > hitbox.A.getX()) && (this.B.getY() > hitbox.D.getY()))
				|| ((this.A.getX() < hitbox.C.getX()) && (this.D.getX() > hitbox.C.getX()) && (this.A.getY() < hitbox.C.getY()) && (this.B.getY() > hitbox.C.getY()))
				|| ((this.D.getX() > hitbox.A.getX() && (this.A.getX() < hitbox.A.getX()) && (this.C.getY() > hitbox.A.getY())))
				|| ((this.D.getX() > hitbox.B.getX() && (this.A.getX() < hitbox.B.getX()) && (this.C.getY() > hitbox.B.getY()) && (this.D.getY() < hitbox.B.getY())))
				) {
			System.out.println("hited");
			return true;
		}
		return false;
		}
	
	public void update() {
		for(Position i  : new Position[] {this.A, this.B, this.C, this.D}){
			i.setX(i.getX() + this.xSpeed);
			i.setY(i.getY() + this.ySpeed);
		}

	}
	
}
