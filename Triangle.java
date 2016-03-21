package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends AbstractShape {

	public void draw(Graphics g) throws IllegalStateException{
		g.setColor(new Color(0, 0, 255));
		int[] xPoints = {350,400,450};
        int[] yPoints = {150,50,150};
        g.fillPolygon(xPoints, yPoints, 3);
	}
}
