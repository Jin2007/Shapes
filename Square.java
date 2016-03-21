package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends AbstractShape {

	public void draw(Graphics g){
		g.setColor(new Color(0,0,0));
		g.fillRect(50, 200, 50, 50);
	}
}
