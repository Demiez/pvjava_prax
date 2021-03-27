import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.*;
public class DrawingFrame extends JFrame {
	private DrawingCanvas drawingCanvas;
	private CanvasEditor canvasEditor;
	private JTextField status;


	public DrawingFrame() {
		this.setTitle("Додаток для малювання");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		drawingCanvas = new DrawingCanvas();
		JPanel toolBarPanel = getToolStatusPanel();
		this.add(drawingCanvas, BorderLayout.CENTER);
		this.add(toolBarPanel, BorderLayout.SOUTH);

	}
	private JPanel getToolStatusPanel() {
		JPanel toolBarPanel = new JPanel();

		JPanel radioPanel = new JPanel();

		JRadioButton empty = new JRadioButton("пустий", true);
		JRadioButton filled = new JRadioButton("повний", false);

		ButtonGroup bg = new ButtonGroup();
		bg.add(empty);
		bg.add(filled);


		radioPanel.add(empty);
		radioPanel.add(filled);
		

		Dimension buttonSize = new Dimension(100,30);


		JButton ellipse = new JButton("Еліпс");
		ellipse.setPreferredSize(buttonSize);

		JButton square = new JButton("Квадрат");
		square.setPreferredSize(buttonSize);

		JButton rectangle = new JButton("4-кутник");
		rectangle.setPreferredSize(buttonSize);

		JButton circle = new JButton("Коло");
		circle.setPreferredSize(buttonSize);

		JButton clear = new JButton("Очистка");
		clear.setPreferredSize(buttonSize);

		toolBarPanel.add(ellipse);
		toolBarPanel.add(circle);
		toolBarPanel.add(rectangle);
		toolBarPanel.add(square);
		toolBarPanel.add(clear);

		JPanel toolStatusPanel = new JPanel();
		toolStatusPanel.setLayout(new BorderLayout());
		JTextField status = new JTextField(20);
		
		
		
		status.setPreferredSize(new Dimension(200,40));
		toolStatusPanel.add(toolBarPanel, BorderLayout.CENTER);

		toolStatusPanel.add(radioPanel, BorderLayout.NORTH);
		toolStatusPanel.add(status,BorderLayout.SOUTH);

		canvasEditor = new CanvasEditor(new Ellipse(0,0,100,60), empty, filled);
		status.setText("Еліпс обраний");
		System.out.println("*********8" + canvasEditor.getClass().getTypeName());
		
		ellipse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvasEditor.setCurrentShape(new Ellipse(0,0,100,60));
				status.setText("Еліпс обраний");
			}
		});
		circle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvasEditor.setCurrentShape(new Circle(0,0,60,60));
				status.setText("Коло обране");
			}
		});
		rectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvasEditor.setCurrentShape(new Rectangle(0,0,120,60));
				status.setText("Квадрат обраний");
			}
		});
		square.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvasEditor.setCurrentShape(new Square(0,0,60,60));
				status.setText("4-кутник обраний");
			}
		});
		
		clear.addActionListener(new ActionListener() {	
			
			public void actionPerformed(ActionEvent e) {
				drawingCanvas.clearShapes();
				status.setText("Все очищено");
			}

		});

		drawingCanvas.addMouseListener(canvasEditor);
		return toolStatusPanel;
	}

}
