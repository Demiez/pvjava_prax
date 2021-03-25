import java.awt.Graphics;

public class Square extends Rectangle{

	public Square(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	public void draw(Graphics g) {
		g.drawRect(getX()-getWidth()/2, getY()-getHeight()/2,getWidth(), getHeight());
	}
}
