import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class CanvasEditor implements MouseListener, Cloneable {
	private JButton selectedButton;
	private Shape currentShape;
	private Shape secondCurrentShape;
	private JRadioButton empty, filled;

	public CanvasEditor(Shape initialShape, JRadioButton empty, JRadioButton filled) {
		this.secondCurrentShape = initialShape;
		this.currentShape = initialShape;
		this.empty = empty;
		this.filled = filled;
	}
	
	public void setCurrentShape(Shape currentShape) {
		this.currentShape = currentShape;
	}
	
	public Shape getCuttentShape() {
		return currentShape;
	}



	public void actionPerformed(ActionEvent e) {
		
		
		selectedButton = (JButton) e.getSource();
		
		if (selectedButton.getText().compareToIgnoreCase("Rectangle") == 0)
		{
			System.out.println("");
		}


	}



	@Override
	public void mouseClicked(MouseEvent e) {

		if(empty.isSelected()) {
			Shape newShape = (Shape)currentShape.clone();
			newShape.setCenter(e.getX(),e.getY());
			DrawingCanvas drawingCanvas = (DrawingCanvas)e.getSource();
			drawingCanvas.isEmpty(true);
			drawingCanvas.addShape(newShape);
		} else {
			
			Shape newShape2 = (Shape)secondCurrentShape.clone();
			newShape2.setCenter(e.getX(),e.getY());
			DrawingCanvas drawingCanvas2 = (DrawingCanvas)e.getSource();
			drawingCanvas2.isEmpty(false);
			drawingCanvas2.addShape(newShape2);
		}

		
	}
	@Override
	public void mousePressed(MouseEvent e) {

	}
	@Override
	public void mouseReleased(MouseEvent e) {

	}
	@Override
	public void mouseEntered(MouseEvent e) {

	}
	@Override
	public void mouseExited(MouseEvent e) {

	}

}
