package testManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TestFrame extends JFrame {

	private JPanel contentPane;
	private JTextField getRandom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					TestFrame frame = new TestFrame();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		getRandom = new JTextField();
		getRandom.setBounds(103, 125, 182, 40);
		contentPane.add(getRandom);
		getRandom.setColumns(10);
		
		JButton btnNewButton = new JButton("Weigth");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				TestManagement tm = new TestManagement();
				
				Double min = 0.0;  // Set To Your Desired Min Value
		        Double max = 10.0; // Set To Your Desired Max Value
		        double x = (Math.random() * ((max - min) + 1)) + min;   // This Will Create A Random Number Inbetween Your Min And Max.
		        double xrounded = Math.round(x * 100.0) / 100.0;   // Creates Answer To The Nearest 100 th, You Can Modify This To Change How It Rounds.
		        
		        String str = Double.toString(xrounded);
		        getRandom.setText(str);
			}
		});
		
		btnNewButton.setBounds(103, 40, 182, 50);
		contentPane.add(btnNewButton);
		
		
	}
}
