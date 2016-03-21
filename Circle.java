package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends AbstractShape{

	public void draw(Graphics g) throws IllegalStateException{
		g.setColor(new Color(255, 0, 0));
		g.fillOval(50, 50, 100, 100);
	}
}
