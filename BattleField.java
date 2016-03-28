package Quadrants;

public class BattleField{
	private int BF_WIDTH = 576;
	private final int BF_HEIGHT = 576;
	private String[][] battleField = {
			{"B", "B", "B", "B", "B", "B", "B", "B", "B"},
			{"B", "B", "B", "B", "B", "B", "B", "B", "B"},
			{"B", "B", "B", "B", "B", "B", "B", "B", "B"},
			{"B", "B", "B", "B", "B", "B", "B", "B", "B"},
			{"B", "B", "B", "B", "B", "B", "B", "B", "B"},
			{"B", "B", "B", "B", "B", "B", "B", "B", "B"},
			{"B", "B", " ", " ", " ", " ", " ", "B", "B"},
			{"B", "B", " ", "B", "B", "B", " ", "B", "B"},
			{"B", "B", " ", "B", " ", "B", " ", "B", "B"}};

    public BattleField() {
    }
    
    public BattleField(String[][] battleField){
    	this.battleField = battleField;
    }

    public int getBF_WIDTH() {
        return BF_WIDTH;
    }

    public int getBF_HEIGHT() {
        return BF_HEIGHT;
    }

    public String scanQuadrant(int x, int y){
       return battleField[x][y];
    }

    public void updateQuadrant(int x , int y , String field){
        this.battleField[x][y] = field;
    }

    public int getDimentionX(){
        return  battleField.length;
    }

    public int getDimentionY(){
        return  battleField.length;
    }

}