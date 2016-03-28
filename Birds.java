package Quadrants;

import java.util.Arrays;

public class Birds {
	static String[][] data = new String[4][];

	public static void main(String[] args) {
		init();
		saled();
		existance("Utka");
		lower3();
		typeBirds();
		birdList();
		sale("Uarabei", 2);
		purchase("Varona", 3, 50);
		purchase("Saroka", 5, 55);
		purchase("Utka", 3, 100);
		purchase("Orel", 1, 500);
		purchase("Varona", 3, 50);
		birdList();
		priceChange("Saroka", 65);
		birdList();

	}
	
	static void init(){
		String[][] mag = new String[][] {
			{"Orel", "2", "500", "1"},
			{"Utka", "5", "100", "3"},
			{"Uarabei", "10", "25", "5"} 
		};
		data = mag;
	}

	static void saled(){
		int count = 0;
		for (int i=0; i<data.length; i++){
			count += Integer.valueOf(data[i][3]);
		}
		System.out.println("Saled birds: "+count);
		System.out.println("----------------");
	}

	static void existance(String type){
		checkTypeBird(type);
		String bird;
		for (int i=0; i<data.length; i++){
			bird = data[i][0];
			if(bird==type){
				System.out.println(bird+": "+data[i][1]);
			}
		}
		System.out.println("----------------");
	}

	static void checkTypeBird(String type){
		int count = 0;
		for (int i=0; i<data.length; i++){ 
			if(type == null || type != data[i][0]){
				count += 1;
			}
			if (count == data.length){
				System.out.println("Invalid Input");
			}
		}
		return;
	}

	static void typeBirds(){
			String[] type = new String[data.length];
			for (int i=0; i<data.length; i++){
				type[i] = data[i][0];
			}
			System.out.println(Arrays.toString(type));
		}

	static void lower3(){
		int count;
		for (int i=0; i<data.length; i++){
			count = Integer.valueOf(data[i][1]);
			if (count <= 3){
				System.out.println(data[i][0]+": "+count);
			}
		}
		System.out.println("----------------");
	}
	
	static void birdList(){
		for (int i=0; i<data.length; i++){
			System.out.println(Arrays.toString(data[i]));
		}
		System.out.println("----------------");
	}
	
	static String[][] sale(String type, int amount){
		checkTypeBird(type);
		if (checkAmount(type) < amount){
			System.out.println("Not enough Birds");
			return data;
		}
		String bird;
		int exis;
		int sls;
		for (int i=0; i<data.length; i++){
			bird = data[i][0];
			if (bird == type){
				exis = Integer.valueOf(data[i][1]) - amount;
				sls =  Integer.valueOf(data[i][3]) + amount;
				data[i][1] = String.valueOf(exis);
				data[i][3] = String.valueOf(sls);
				System.out.println("Payment amount: "+Integer.valueOf(data[i][2])*amount);
			}
		}
		System.out.println("----------------");
		return data;
		
	}
	
	static int checkAmount(String type){
		String bird;
		int amount = 0;
		for (int i=0; i<data.length; i++){
			bird = data[i][0];
			if (bird == type){
				amount = Integer.valueOf(data[i][1]);
			}
		}
		return amount;
	}
	
	static String[][] purchase(String type, int amount, int price){
		String bird;
		int exis;
		int count = 0;
		for (int i=0; i<data.length; i++){
			bird = data[i][0];
			if (bird == type){
				exis = Integer.valueOf(data[i][1])+amount;
				data[i][1]=String.valueOf(exis);
			} else if (bird != type){
				count +=1;
				if (count == data.length){
				updata();
				String[] newBird = {type, String.valueOf(amount), String.valueOf(price), "0"};
				data[data.length-1] = newBird;
				return data;
				}
			}
		}
		return data;
		 
	}
	
	static String[][] updata(){
		String[][] updata = new String[data.length+1][4];
		for (int i=0;i<data.length;i++){
			for (int j=0;j<data[i].length;j++){
				updata[i][j]=data[i][j];
			}
		}
		data = updata;
		return data;
		
	}
	
	static String[][] priceChange(String type, int newPrice){
		checkTypeBird(type);
		String bird;
		for (int i=0;i<data.length;i++){
			bird = data[i][0];
			if (bird == type){
				data[i][2] = String.valueOf(newPrice);
			}
		}
		return data;
		
	}

}