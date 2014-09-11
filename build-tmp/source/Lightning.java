import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Lightning extends PApplet {

bolt[] zap = new bolt[10];


public void setup()
{
	size(300,300);
	background(0);
	noLoop();
}

public void draw()
{
	for(int i = 0; i < 10; i++)
	{
		zap[i] = new bolt();
		zap[i].show();
	}
}

public void mousePressed()
{
	background(0);
	redraw();
}

class bolt
{
	int x, y, x2, y2;
	bolt()
	{
	}
	public void show()
	{
		stroke(255);
		
		x = mouseX;
		x2 = mouseX;
		y = mouseY;
		y2 = mouseY;
		while(x < 300)
		{
			stroke((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
			
			int plusX, plusY;
			plusX = (int)(Math.random()*10) + 5;
			plusY = (int)(Math.random()*20) -10;
			
			line(x, y, x+ plusX, y+ plusY);
			
			x += plusX;
			y += plusY;
		}
		while(x2 > 0)
		{
			stroke((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
			
			int plusX2, plusY2;
			plusX2 = (int)(Math.random()*10) - 15;
			plusY2 = (int)(Math.random()*20) -10;
			
			line(x2, y2, x2 + plusX2, y2 + plusY2);
			
			x2 += plusX2;
			y2 += plusY2;
		}
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Lightning" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
