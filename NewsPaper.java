package publishSub;

import java.util.ArrayList;
import java.util.List;

public class NewsPaper implements Subject {

private List<Observer> observers;
	
	public NewsPaper() {
		observers = new ArrayList<>();
	}
	
	public void doTheJob(){
		double d = Math.random();
		if (d < 0.5 || d > 10){
			System.out.println("Job done");
			notifyObservers();
		} else {
			System.out.println("Job Failed");
		}
	}

	@Override
	public void addObserver(Observer o) {
		observers.add(o);
		
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
		
	}

	@Override
	public void notifyObservers() {
		for (Observer o: observers){
			o.update();
		}
		
	}

}
