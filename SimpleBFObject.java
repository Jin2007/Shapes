package com.midgardabc.day7.tanks.bf;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;


public abstract class SimpleBFObject implements BFObject {

	// current position on BF
	private int x;
	private int y;
	
	protected String imgName;
	protected Image img;
	protected Color color;

	private boolean isDestroyed = false;
	
	public SimpleBFObject(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void destroy() {
		isDestroyed = true;
	}
	
	@Override
	public void draw(Graphics g) {
		if (!isDestroyed) {
			//g.setColor(this.color);
			g.fillRect(this.getX(), this.getY(), 64, 64);
		}
		g.drawImage(img, getX(), getY(), new ImageObserver(){

			@Override
			public boolean imageUpdate(Image img, int infoflags, int x,
					int y, int width, int height) {
				return false;
			}
			
		});
	}
	
	public boolean isDestroyed() {
		return isDestroyed;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
