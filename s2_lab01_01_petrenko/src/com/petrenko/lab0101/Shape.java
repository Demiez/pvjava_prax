import java.awt.Graphics;

public abstract class Shape implements Cloneable {
	private int x, y, width, height;
	
	public Shape(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public int getX() {
		return x;
	}
	public void setCenter(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public abstract void draw(Graphics g);
	public abstract void fill(Graphics g);

	public Object clone() {
		try {
			return super.clone();
		}
		catch(CloneNotSupportedException e){
			return null;
			
		}
	}
}
