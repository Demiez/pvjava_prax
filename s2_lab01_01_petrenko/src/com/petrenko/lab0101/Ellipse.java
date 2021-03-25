import java.awt.Graphics;

public class Ellipse extends Shape{

	public Ellipse(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void draw(Graphics g) {
		g.drawOval(getX()-getWidth()/2, getY()-getHeight()/2, getWidth(), getHeight());
	}

	@Override
	public void fill(Graphics g) {
		g.fillOval(getX()-getWidth()/2, getY()-getHeight()/2, getWidth(), getHeight());
		
	}
	

}
