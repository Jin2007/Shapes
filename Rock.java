package com.midgardabc.day7.tanks.bf;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Rock extends SimpleBFObject {
	
	public Rock(int x, int y) {
		super(x, y);
	//	color = new Color(255, 255, 255);
		imgName = "block.jpg";
		try{
			img = ImageIO.read(new File(imgName));
		} catch (IOException e){
			System.out.println("can't find image "+img);
		}
	}
	

}
