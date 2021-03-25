import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.*;
public class DrawingCanvas extends JPanel {
	private ShapeModel ShapeModel;
	private ArrayList<Boolean> isFilledStatus = new ArrayList<Boolean>();

	private boolean isEmpty = true;

	public DrawingCanvas(){
		this.setPreferredSize(new Dimension(800,600));
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setBackground(Color.LIGHT_GRAY);
		ShapeModel = new ShapeModel();

	}
	
	public void updateStatus(boolean state) {
		isFilledStatus.add(state);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Iterator<Shape> it = ShapeModel.iterator();
		
		if(isEmpty) {
			isFilledStatus.add(false);
		} else if (!isEmpty) {
			isFilledStatus.add(true);
		}
		
		int i = 0;
		while(it.hasNext()) {
			Shape shape = (Shape)it.next();
			
			System.out.print(i);
			if(isFilledStatus.get(i)) {
				shape.draw(g);
			} else {
				shape.fill(g);
			}
			i++;
		}
		
		System.out.print("\n");
	}
	public void addShape(Shape newShape) {
		ShapeModel.addShape(newShape);
		repaint();
	}

	public void isEmpty(boolean t) {isEmpty = t;}

	public void clearShapes() {

		Iterator<Shape> it = ShapeModel.iterator();

		while(it.hasNext()) {
			it.next();
			it.remove();
		}

		repaint();
	}
}
