package Quadrants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ActionField extends JPanel{

	final boolean COLORDED_MODE = false;

	private BattleField battleField;
	private AbstractTank defender;
	private Bullet bullet;

	void runTheGame() throws Exception {
		defender.clean();

	}

	private boolean processInterception() {
		String str = getQuadrant(bullet.getX(), bullet.getY());
		int x = Integer.valueOf(str.substring(0, str.indexOf("_")));
		int y = Integer.valueOf(str.substring(str.indexOf("_") + 1));
		 if ((x >= 0 && x < 9) && (y  >= 0 && y < 9)){
		if (!battleField.scanQuadrant(x, y).trim().isEmpty()) {
			battleField.updateQuadrant(x, y, " ");
			return true;
		}
		}
		return false;
	}

	String getQuadrant(int x, int y) {
		return y/64+"_"+x/64;
	}

	String getQuadrantXY(int v, int h) {
		return (v - 1) * 64 + "_" + (h - 1) * 64;
	}

	public ActionField() throws Exception{
		battleField = new BattleField();
		defender = new T34(this, battleField);
		bullet = new Bullet(-100, -100, Direction.NONE);

		JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
		frame.setLocation(750, 150);
		frame.setMinimumSize(new Dimension(battleField.getBF_WIDTH(), battleField.getBF_HEIGHT() + 22));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int i = 0;
		Color cc;
		for (int v = 0; v < 9; v++) {
			for (int h = 0; h < 9; h++) {
				if (COLORDED_MODE) {
					if (i % 2 == 0) {
						cc = new Color(252, 241, 177);
					} else {
						cc = new Color(233, 243, 255);
					}
				} else {
					cc = new Color(180, 180, 180);
				}
				i++;
				g.setColor(cc);
				g.fillRect(h * 64, v * 64, 64, 64);
			}
		}

		for (int j = 0; j < battleField.getDimentionY(); j++) {
			for (int k = 0; k < battleField.getDimentionX(); k++) {
				if (battleField.scanQuadrant(j, k).equals("B")) {
					String coordinates = getQuadrantXY(j + 1, k + 1);
					int separator = coordinates.indexOf("_");
					int y = Integer.parseInt(coordinates.substring(0, separator));
					int x = Integer.parseInt(coordinates.substring(separator + 1));
					g.setColor(new Color(0, 0, 255));
					g.fillRect(x, y, 64, 64);
				}
			}
		}

		g.setColor(new Color(255, 0, 0));
		g.fillRect(defender.getX(), defender.getY(), 64, 64);

		g.setColor(new Color(0, 255, 0));
		if (defender.getDirection() == Direction.UP) {
			g.fillRect(defender.getX() + 20, defender.getY(), 24, 34);
		} else if (defender.getDirection() == Direction.DOWN) {
			g.fillRect(defender.getX() + 20, defender.getY() + 30, 24, 34);
		} else if (defender.getDirection() == Direction.LEFT) {
			g.fillRect(defender.getX(), defender.getY() + 20, 34, 24);
		} else {
			g.fillRect(defender.getX() + 30, defender.getY() + 20, 34, 24);
		}

		g.setColor(new Color(255, 255, 0));
		g.fillRect(bullet.getX(), bullet.getY(), 14, 14);
	}

	void processTurn(AbstractTank abstractTank) throws Exception{
		repaint();
	}

	void processMove(AbstractTank abstractTank) throws Exception {
		this.defender = abstractTank;
		Direction direction = abstractTank.getDirection();
		
		int step = 1;
		int covered = 0;

		// check limits x: 0, 513; y: 0, 513
		if ((direction == Direction.UP && abstractTank.getY() == 0) || (direction == Direction.DOWN && abstractTank.getY() >= 512)
				|| (direction == Direction.LEFT && abstractTank.getX() == 0) || (direction == Direction.RIGHT && abstractTank.getX() >= 512)) {
			System.out.println("[illegal move] direction: " + direction + " tankX: " + abstractTank.getX() + ", tankY: " + abstractTank.getY());
			return;
		}

		abstractTank.turn(direction);

		while (covered < 64) {
			if (direction == Direction.UP) {
				abstractTank.updateY(-step);
				System.out.println("[move up] direction: " + direction + " tankX: " + abstractTank.getX() + ", tankY: " + abstractTank.getY());
			} else if (direction == Direction.DOWN) {
				abstractTank.updateY(step);
				System.out.println("[move down] direction: " + direction + " tankX: " + abstractTank.getX() + ", tankY: " + abstractTank.getY());
			} else if (direction == Direction.LEFT) {
				abstractTank.updateX(-step);
				System.out.println("[move left] direction: " + direction + " tankX: " + abstractTank.getX() + ", tankY: " + abstractTank.getY());
			} else {
				abstractTank.updateX(step);
				System.out.println("[move right] direction: " + direction + " tankX: " + abstractTank.getX() + ", tankY: " + abstractTank.getY());
			}
			covered += step;

			repaint();
			Thread.sleep(abstractTank.getSpeed());
		}
	}

	void processFire(Bullet bullet) throws Exception {
		this.bullet = bullet;
		int step = 1;

		while (bullet.getX() > -14 && bullet.getX() < 590 && bullet.getY() > -14 && bullet.getY() < 590) {
			if (bullet.getDirection() == Direction.UP) {
				bullet.updateY(-step);
			}
			else if (bullet.getDirection() == Direction.DOWN) {
				bullet.updateY(step);
			}
			else if (bullet.getDirection() == Direction.LEFT) {
				bullet.updateX(-step);
			}
			else {
				bullet.updateX(step);
			}
			if(processInterception()){
				bullet.destroy();
			}
			repaint();
			Thread.sleep(bullet.getSpeed());
		}
	}

}