package render;

import java.awt.Graphics2D;

public interface Irenderable {
	public void draw(Graphics2D g2d);
	public boolean IsVisible();
	public int getZ();
	public boolean isDestroyed();

}
