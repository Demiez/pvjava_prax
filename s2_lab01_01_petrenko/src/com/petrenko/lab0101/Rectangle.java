import java.awt.*;

public class Rectangle extends Shape {

	public Rectangle(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	public void draw(Graphics g) {
		g.drawRect(getX()-getWidth()/2,getY()-getHeight()/2 , getWidth(), getHeight());
	}
	
	public void fill(Graphics g) {
		g.fillRect(getX()-getWidth()/2,getY()-getHeight()/2 , getWidth(), getHeight());
	}

}
