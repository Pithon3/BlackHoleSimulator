package blackhole;

import java.awt.Color;
import java.util.Random;

public class Star extends Object{
	
	private Random rand = new Random();
	
	private int radius;
	private int hydrogen;
	Color color;
	private int life;
	
	public Star() {
		x = rand.nextInt(960);
		y = rand.nextInt(720);
		xd = ( (double) (rand.nextInt(21)) - 10) / 100;
		yd = ( (double) (rand.nextInt(21)) + 90) / 100;
		
		
		
		int num = rand.nextInt(7);
		
		if (num < 2) {
			color = new Color(255, 203, 151);
			mass = 1;
		} else if (1 < num & num < 6) {
			color = Color.WHITE;
			mass = 1.5;
		} else if (num == 6) {
			color = new Color(153, 217, 234);
			mass = 2.5;
		}
	}
	
	public void update(Object obj) {
		gravity(obj.mass, obj.x, obj.y);
		y += yd;
		x += xd - (y - 320)/1000;
		
		if (y > 639) {
			y = 0;
		} if (x > 959) {
			x = 0;
		} if (x < 0) {
			x = 959;
		}
	}
	
}
