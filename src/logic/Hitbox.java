package logic;

public abstract class Hitbox {
	// down-left
	protected Position A;
	// up-left
	protected Position B;
	// up-right
	protected Position C;
	// down-right
	protected Position D;
	protected double xSpeed;
	protected double ySpeed;
	protected double width;
	protected double height;

	// Obstacle has only X-velocity
	public Hitbox(Position position, int width, int height, double speed) {
		this(position, width, height);
		setxSpeed(speed);

	}

	// Obstacle has only X-velocity
	public Hitbox(Position position, double speed) {
		setxSpeed(speed);

	}

	// Hero has no velocity
	public Hitbox(Position a, int width, int height) {
		super();
		this.A = new Position(a.getX(), a.getY());
		this.B = new Position(a.getX(), a.getY() + height);
		this.C = new Position(a.getX() + width, a.getY() + height);
		this.D = new Position(a.getX() + width, a.getY());
		this.width = width;
		this.height = height;
	}

	// Monster has XY-velocity
	public Hitbox(Position a, int width, int height, double xSpeed, double ySpeed) {
		super();
		this.width = width;
		this.height = height;
		this.A = new Position(a.getX(), a.getY());
		this.B = new Position(a.getX(), a.getY() + height);
		this.C = new Position(a.getX() + width, a.getY() + height);
		this.D = new Position(a.getX() + width, a.getY());
		setxSpeed(xSpeed);
		setySpeed(ySpeed);
	}

	public boolean collide(Hitbox hitbox) {
		if (((this.A.getX() < hitbox.D.getX()) && (this.A.getX() > hitbox.A.getX())
				&& (this.B.getY() > hitbox.D.getY()))
				|| ((this.A.getX() < hitbox.C.getX()) && (this.D.getX() > hitbox.C.getX())
						&& (this.A.getY() < hitbox.C.getY()) && (this.B.getY() > hitbox.C.getY()))
				|| ((this.D.getX() > hitbox.A.getX() && (this.A.getX() < hitbox.A.getX())
						&& (this.C.getY() > hitbox.A.getY())))
				|| ((this.D.getX() > hitbox.B.getX() && (this.A.getX() < hitbox.B.getX())
						&& (this.C.getY() > hitbox.B.getY()) && (this.D.getY() < hitbox.B.getY())))) {
			return true;
		}
		return false;
	}

	public void update(long time) {
		for (Position i : new Position[] { this.A, this.B, this.C, this.D }) {
			i.setX(i.getX() + this.xSpeed * time);
			i.setY(i.getY() + this.ySpeed * time);
		}

	}

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

	public void setySpeed(double ySpeed) {
		this.ySpeed = ySpeed * GameLogic.getSpeedFactor();
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
		this.xSpeed = xSpeed * GameLogic.getSpeedFactor();
	}

	public double getWidth() {
		return this.width;
	}

	public double getHeight() {
		return this.height;
	}

}
