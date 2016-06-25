package publishSub;

import java.util.Observable;
import java.util.Observer;


public class Subscriber implements Observer {

	private  String  name;

	public String getName() {
		return name;
	}

	public Subscriber(String name) {

		this.name = name;
	}

	@Override
	public void update(Observable o, Object arg) {

	}
}
