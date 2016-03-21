package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends AbstractShape{

	public void draw(Graphics g) throws IllegalStateException{
		g.setColor(new Color(0, 255, 0));
		g.drawRect(200, 50, 100, 100);
	}
}
