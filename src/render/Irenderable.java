package render;

import javafx.scene.canvas.GraphicsContext;

public interface Irenderable {
	public void draw(GraphicsContext g2d);
	public boolean IsVisible();
	public int getZ();
	public boolean isDestroyed();

}
