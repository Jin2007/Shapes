package Quadrants;

import java.util.Random;

public abstract class AbstractTank {
    
	protected int speed;
	private int x;
	private int y;
	private Direction direction;
	
	private ActionField af;
	private BattleField bf;
	
	public AbstractTank(){
	}
	
	public AbstractTank(ActionField actionField, BattleField battleField){
		this(actionField, battleField, 128, 512, Direction.UP);
	}

	public AbstractTank(ActionField actionField, BattleField battleField, int x, int y, Direction i) {
		this.af = actionField;
		this.bf = battleField;
		this.x = x;
		this.y = y;
		this.direction = i;
	}

	public int getSpeed() {
		return speed;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void updateX(int x){
		this.x+=x;
	}
	
	public void updateY(int y){
		this.y+=y;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public void turn(Direction direction) throws Exception{
		this.direction = direction;
		af.processTurn(this);
	}
	
	public void move() throws Exception{
		af.processMove(this);
	}
	
	public void fire() throws Exception{
		Bullet bullet = new Bullet(x+25, y+25, direction);
		af.processFire(bullet);
	}
	
//	void moveRandom() throws Exception {
//		Random r = new Random();
//		while (true){
//			direction = r.nextInt(5);
//			if (direction.getId() > 0){
//				fire();
//				af.processMove(this);
//				fire();
//			}
//		}
//    }

    void moveToQuadrant(int v, int h) throws Exception {
    	String str = af.getQuadrantXY(v, h);
    	int y = Integer.parseInt(str.substring(0, str.indexOf("_")));
    	int x = Integer.parseInt(str.substring(str.indexOf("_")+1));
    	
    	while(this.x != x){
    		if (this.x < x){
    			turn(Direction.RIGHT);
    			fire();
    			move();
    		} else {
    			turn(Direction.LEFT);
    			fire();
    			move();
    		}
    	}
    	while(this.y != y){
    		if (this.y < y){
    			turn(Direction.DOWN);
    			fire();
    			move();
    		} else {
    			turn(Direction.UP);
    			fire();
    			move();
    		}
    	}
    }

    void clean()throws Exception{
    	for(int j=1; j<=bf.getDimentionX(); j++){
			for (int i=1; i<=bf.getDimentionY(); i++){
				moveToQuadrant(j, i);
			}
    	}
    }
	
}