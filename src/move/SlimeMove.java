package move;

import logic.Hitbox;
import logic.Position;

public class SlimeMove implements Move {

	private double xSpeed;
	private double ySpeed;
	private Hitbox obj;
	private long time;
	private double ground = 0;
	private double gravity = 2400;
	private boolean hasJumped;
	private boolean hasJumpedDown;
	
	public SlimeMove(Hitbox obj) {
		this.obj = obj;
		this.xSpeed = -50;
		this.ySpeed = 0;
		obj.setxSpeed(xSpeed); 
		obj.setySpeed(ySpeed); 
	}
	
	public void jump(long time) {
		hasJumped = false;
		this.ySpeed = 1200;
		if (hasJumped) {
			if(obj.getA().getY() == ground) {
				obj.setySpeed(0);
				hasJumped = false;
				hasJumpedDown = false;
			}
		}else {
			hasJumped = true;
			obj.setySpeed(this.ySpeed - (gravity * time));
			if (obj.getySpeed() < 0) {
				hasJumpedDown = true;
			}
		}
	}
	
	public boolean isHasJumped() {
		return hasJumped;
	}
	
	public boolean isHasJumpedDown() {
		return hasJumpedDown;
	}

	@Override
	public Position move(long time) {
		jump(time);
		double x = this.xSpeed * time;
		double y = this.ySpeed * time;
		return new Position(x, y);
	}

}
