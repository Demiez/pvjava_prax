import java.awt.Graphics;

public class Circle extends Ellipse{

	public Circle(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}
	
	public void draw(Graphics g) {
		g.drawOval(getX()-getWidth()/2,getY()-getHeight()/2 , getWidth(), getHeight());
	}
}
 