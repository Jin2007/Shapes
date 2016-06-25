package publishSub;

import java.util.Observable;

public class Journal extends Observable {
	private String name;

	public Journal (String name){
		this.name = name;
		setChanged();
	}

	public String getName() {
		return name;
	}
}
