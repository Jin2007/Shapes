package com.midgardabc.day7.tanks.bf.tanks;

import java.awt.Color;

import com.midgardabc.day7.tanks.Direction;
import com.midgardabc.day7.tanks.bf.BattleField;

public class BT7 extends AbstractTank {
	
	public BT7(BattleField bf) {
		super(bf);
		tankColor = new Color(255, 0, 0);
		towerColor = new Color(0, 255, 0);
		movePath = 2;
	}
	
	public BT7(BattleField bf, int x, int y, Direction direction) {
		super(bf, x, y, direction);
		tankColor = new Color(255, 0, 0);
		towerColor = new Color(0, 255, 0);
		movePath = 2;
	}
	
	public void moveToEagle() throws Exception{
		this.moveToQuadrant(9, 5);
	}
	
	@Override
	public Action setUp() {
		return Action.ATTACK;
	}
}
