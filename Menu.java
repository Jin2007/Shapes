package beverageMenu;

public class Menu {

	Ingridient[] menu = {
			new BlackTea()};

	public Menu() {
		System.out.println();
		System.out.println("   Name         " + "           Ingridietns                 " + "         Price      ");
		System.out.println();
		for (Ingridient men : menu) {
			System.out.print(men.getName() + "		");
			System.out.print(men.getIngr() + "		");
			System.out.println(men.getPrice() + " UAH");
		}
	}

}
