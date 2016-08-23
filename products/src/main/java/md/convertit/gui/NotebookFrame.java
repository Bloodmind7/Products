package md.convertit.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NotebookFrame extends JFrame {

	private JPanel mainPanel;
	private JTextField typeNameTextField;
	private JTextField infoNameTextField;
	private JTextField priceNameTextField;
	private JButton saveButton;

	public void start() {
		initGUI();

		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void initGUI() {
		setTitle("Notebooks");
		setSize(800, 400);
	setMinimumSize(new Dimension(800, 200));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainPanel = new JPanel(new BorderLayout());

		JPanel leftPanel = createLeftPanel();
		mainPanel.add(leftPanel, BorderLayout.WEST);
		
		JPanel rightPanel = createRightPanel();
		mainPanel.add(rightPanel, BorderLayout.CENTER);
		

		getContentPane().add(mainPanel);
	}

	private JPanel createRightPanel() {
		FlowLayout layout = new FlowLayout(FlowLayout.RIGHT);
		layout.setHgap(15);
		
		JPanel panel = new JPanel(layout);
		panel.setBackground(Color.LIGHT_GRAY);
		
		

		return panel;
	}

	private JPanel createLeftPanel() {

		JPanel bigPanel = new JPanel();
		bigPanel.setLayout(new BoxLayout(bigPanel, BoxLayout.Y_AXIS));
	
		JPanel panelType = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelType.add(new JLabel("Type"));
		typeNameTextField = new JTextField(10);
		panelType.add(typeNameTextField);
		
		bigPanel.add(panelType);
		
		JPanel panelInfo = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelInfo.add(new JLabel("Info"));
		typeNameTextField = new JTextField(15);
		panelInfo.add(typeNameTextField );
		bigPanel.add(panelInfo);
		
		JPanel panelPrice = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelInfo.add(new JLabel("Price"));
		typeNameTextField = new JTextField(10);
		panelPrice.add(typeNameTextField );
		bigPanel.add(panelPrice);
		
		
		
		
		
//		FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
//		layout.setHgap(15);
//
//		
//		JPanel panel = new JPanel(new BoxLayout(, BoxLayout.Y_AXIS));
//		panel.setPreferredSize(new Dimension(200, 400));
//		
//		
//		typeNameTextField = new JTextField(10);
//		panel.add(typeNameTextField);
//		
//		panel.add(new JLabel("Info"));
//		typeNameTextField = new JTextField(10);
//		panel.add(typeNameTextField);
//		
		
		return bigPanel;
	}

}
