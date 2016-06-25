package publishSub;

public class PublishSubDemo {

	public static void main(String[] args) {

		NewsPaper cs = new NewsPaper();

		Observer o1 = new Subscriber();
		Observer o2 = new Subscriber();

		cs.addObserver(o1);
		cs.addObserver(o2);

		for (int i=0; i<10; i++){
			cs.doTheJob();
			System.out.println();
		}

		cs.removeObserver(o2);

		for (int i=0; i<10; i++){
			cs.doTheJob();
		}

	}

}
