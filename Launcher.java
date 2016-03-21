package shapes;

public class Launcher {

	public static void main(String[] args){
		ShapesTemplate st = new ShapesTemplate(new AbstractShape[]{new Circle(), new Rectangle(), new Triangle()});
//		st = new ShapesTemplate(new Shape[]{new Square()});
	}
}
