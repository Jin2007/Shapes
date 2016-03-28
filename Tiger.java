package Quadrants;

public class Tiger extends AbstractTank{
	
	private int armor = 1;
	
	public Tiger(ActionField actionField, BattleField battleField){
		super(actionField, battleField);
		speed = 7;
	}

	public Tiger(ActionField actionField, BattleField battleField, int x, int y, Direction direction){
		super(actionField, battleField, x, y, direction);
		speed = 7;
	}
}
