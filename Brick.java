package com.midgardabc.day7.tanks.bf;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Brick extends SimpleBFObject {

	public Brick(int x, int y) {
		super(x, y);
//		color = new Color(130, 10, 0);
		imgName = "brick.png";
		try{
			img = ImageIO.read(new File(imgName));
		} catch (IOException e){
			System.out.println("can't find image "+img);
		}
	}
}
