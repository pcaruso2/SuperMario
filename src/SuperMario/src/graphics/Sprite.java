package graphics;

import java.awt.image.BufferedImage;

public class Sprite {

	public SpriteSheet sheet;
	public BufferedImage image;
	public int x, y;
	
	public Sprite(SpriteSheet sheet, int x, int y){
		this.sheet = sheet;
		this.x = x;
		this.y = y;
		image = sheet.getSprite(x, y);
	}
	
	public BufferedImage getBufferedImage(){
		return image;
	}
}
