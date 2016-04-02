package Quadrants;

import java.awt.Color;
import java.awt.Graphics;

public abstract class AbstractTexture implements Drawable {

	protected Color tColor;
	protected int x;
	protected int y;
	
	public AbstractTexture(){
	}
	
	public void draw(Graphics g){
		g.setColor(tColor);
		g.fillRect(x, y, 64, 64);
	}
}
