package Quadrants;

import java.awt.Graphics;

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

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
