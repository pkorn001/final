package obstacle;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.Hitbox;
import logic.Position;

public class Sprite extends Hitbox {
	
	private Image image;
    private double posX;
    private double posY;    
    private double xSpeed;
    private double ySpeed;
    private double width;
    private double height;
    private Position position;
 
	public Sprite(Position a, int width, int height, int xSpeed, int ySpeed) {
		super(a, width, height, xSpeed, ySpeed);
		this.posX = this.C.getX();
		this.posY = this.C.getY();
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
		this.width = width;
		this.height = height;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}
	
	public void update(int time) {
		posX += xSpeed * time;
		posY += ySpeed * time;
	}
 
    public void render(GraphicsContext gc){
        gc.drawImage( image, posX, posY );
    }
 
}
