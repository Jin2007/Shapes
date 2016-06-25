package publishSub;

public class Subscriber implements Observer{

	@Override
	public void update() {
		System.out.println(this.toString() + " notified");
		
	}
	
	

}
