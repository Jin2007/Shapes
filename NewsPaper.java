package publishSub;

import java.util.Observable;

public class NewsPaper extends Observable {

	private  String newsPapeName;

	public NewsPaper(String newsPapeName) {
		this.newsPapeName = newsPapeName;
		setChanged();
	}

	public String getNewsPapeName() {
		return newsPapeName;
	}

}
