package publishSub;

public class PublishSubDemo {

	public static void main(String[] args) {
		
		NewsPaper np1 = new NewsPaper("np1");
		NewsPaper np2 = new NewsPaper("np2");
		Journal j1 = new Journal("j1");

		Subscriber s1 = new Subscriber("Subscr1");
		np1.addObserver(s1);
		np2.addObserver(s1);
		j1.addObserver(s1);

		Subscriber s2 = new Subscriber("Subscr2");
		np2.addObserver(s2);
		j1.addObserver(s2);

		System.out.println(np1.countObservers());

		np1.notifyObservers();

		System.out.println(np2.countObservers());

		np2.notifyObservers();

		System.out.println(j1.countObservers());

		j1.notifyObservers();


	}
}
