package mechanic;

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
	
	public Hitbox(int speed) {
		this.xSpeed = speed;
	}
	
	public Hitbox(Position a,int width,int height,int speed) {
		super();
		Position A = new Position(a.getX(), a.getY());
		Position B = new Position(a.getX(), a.getY()+height);
		Position C = new Position(a.getX()+width, a.getY()+height);
		Position D = new Position(a.getX()+width, a.getY());
		this.xSpeed = speed;
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
	
	public void update() {
		this.A.setX(this.A.getX() - xSpeed);
		this.B.setX(this.B.getX() - xSpeed);
		this.C.setX(this.C.getX() - xSpeed);
		this.D.setX(this.D.getX() - xSpeed);
		
	}
	
}
