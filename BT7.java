package Quadrants;

import java.awt.Graphics;

public class BT7 extends AbstractTank{
	
	private int speed = 2;
	
	public BT7(ActionField actionField, BattleField battleField, int x, int y, Direction direction){
		super(actionField, battleField, x, y, direction);
		this.speed = speed;
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
