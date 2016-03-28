package beverageMenu;

public class Ingridient {

	private String name;
	private String ingr;
	private int price;
	
	public void addBlackTea(){
		this.ingr = " Black Tea ";
		this.price += 5;
	}
	
	public void addWater(){
		this.price += 1;
	}
	
	public void addSugar(){
		this.ingr += " Sugar ";
		this.price += 3;
	}
	
	public void addMilk(){
		this.ingr += " Milk ";
		this.price += 3;
	}
	
	public String getIngr() {
		return ingr;
	}

	public void setIngr(String ingr) {
		this.ingr = ingr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
