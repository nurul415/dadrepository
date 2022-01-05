package parcel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;
import payment.PaymentFrame;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;

public class ParcelFrame extends JFrame
{

	private JPanel contentPane;
	private JTextField txtSenderName;
	private JTextField txtSenderPhone;
	
	Parcel p = new Parcel();
	ParcelManager pm = new ParcelManager();
	Connection conn = pm.getConnection();
	
	private JTextField txtSenderAdd;
	private JTextField txtSenderCity;
	private JTextField txtSenderPostcode;
	private JTextField txtSenderMykad;

	/**
	 * Launch the application.
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					ParcelFrame frame = new ParcelFrame();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}*/
                                  
	/**
	 * Create the frame.
	 */
	public ParcelFrame() {
		setFont(new Font("Arial", Font.BOLD, 12));
		setTitle("PARCEL MANAGEMENT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 698);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel compName = new JLabel("PARCEL MANAGEMENT SYSTEM");
		compName.setFont(new Font("Arial", Font.BOLD, 16));
		compName.setBounds(270, 33, 257, 28);
		contentPane.add(compName);
		
		JLabel managerName = new JLabel("EMMASOFT SOLUTION");
		managerName.setFont(new Font("Arial", Font.BOLD, 14));
		managerName.setBounds(330, 60, 161, 21);
		contentPane.add(managerName);
		
		JLabel lblNewLabel_3 = new JLabel("Please Enter Sender Information:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(318, 112, 200, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("SENDER DETAILS");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4.setBounds(353, 137, 118, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel("NAME          : ");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(191, 183, 73, 26);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("MYKAD NO :");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_5.setBounds(191, 223, 73, 28);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("PHONE NO :");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_6.setBounds(191, 261, 73, 28);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("ADDRESS   :");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_7.setBounds(191, 300, 73, 28);
		contentPane.add(lblNewLabel_7);
		
		txtSenderName = new JTextField();
		txtSenderName.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtSenderName.setBounds(264, 183, 375, 28);
		contentPane.add(txtSenderName);
		txtSenderName.setColumns(10);
		
		txtSenderMykad = new JTextField();
		txtSenderMykad.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtSenderMykad.setColumns(10);
		txtSenderMykad.setBounds(264, 222, 375, 28);
		contentPane.add(txtSenderMykad);
		
		txtSenderPhone = new JTextField();
		txtSenderPhone.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtSenderPhone.setColumns(10);
		txtSenderPhone.setBounds(264, 263, 375, 28);
		contentPane.add(txtSenderPhone);
		
		txtSenderAdd = new JTextField();
		txtSenderAdd.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtSenderAdd.setColumns(10);
		txtSenderAdd.setBounds(264, 302, 375, 28);
		contentPane.add(txtSenderAdd);
		
		JLabel lblNewLabel_8 = new JLabel("CITY             :");
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_8.setBounds(191, 339, 73, 28);
		contentPane.add(lblNewLabel_8);
		
		txtSenderCity = new JTextField();
		txtSenderCity.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtSenderCity.setColumns(10);
		txtSenderCity.setBounds(264, 341, 375, 28);
		contentPane.add(txtSenderCity);
		
		JLabel lblNewLabel_9 = new JLabel("POSTCODE:");
		lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_9.setBounds(191, 378, 73, 28);
		contentPane.add(lblNewLabel_9);
		
		txtSenderPostcode = new JTextField();
		txtSenderPostcode.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtSenderPostcode.setColumns(10);
		txtSenderPostcode.setBounds(264, 380, 375, 28);
		contentPane.add(txtSenderPostcode);
		
		JLabel lblNewLabel_10 = new JLabel("STATE          :");
		lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_10.setBounds(191, 422, 73, 27);
		contentPane.add(lblNewLabel_10);
		
		JComboBox optState = new JComboBox();
		optState.setToolTipText("Choose State");
		optState.setFont(new Font("Monospaced", Font.PLAIN, 13));
		optState.setMaximumRowCount(20);
		optState.setModel(new DefaultComboBoxModel(new String[] {"JOHOR", "KEDAH", "KELANTAN", "MELAKA", "NEGERI SEMBILAN", "PAHANG", "PULAU PINANG", "PERAK", "PERLIS", "SABAH", "SARAWAK", "SELANGOR", "TERENGGANU", "WP KUALA LUMPUR", "WP LABUAN", "WP PUTRAJAYA"}));
		optState.setBounds(264, 421, 375, 28);
		contentPane.add(optState);
		
		JButton btnAddSender = new JButton("PROCEED");
		btnAddSender.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				//Sender information
				String senderName = txtSenderName.getText();
				p.setSenderName(senderName);
				
				String senderMykad = txtSenderMykad.getText();
			    p.setSenderMykad(senderMykad);
				
				String SenderPhone = txtSenderPhone.getText();
				p.setSenderPhone(SenderPhone);
				
				String senderAdd = txtSenderAdd.getText();
				String senderCity = txtSenderCity.getText();
				String senderPostcode = txtSenderPostcode.getText();
				
				int state = (int)optState.getSelectedIndex();
				int state_id = state + 1;
				String senderState = Integer.toString(state_id);
				
				Address s_add = new Address(senderAdd, senderCity, senderPostcode, senderState);
				p.setSenderAdd(s_add);
				
				String sName = p.getSenderName();
				String sMykad = p.getSenderMykad();
				String sPhone = p.getSenderPhone();
				String sAdd = s_add.getAdd();
				String sCity = s_add.getCity();
				String sPostcode = s_add.getPostcode();
				String sState = s_add.getState();
				
				try
				{
					String q_sender = 
							"INSERT INTO sender (sender_name, sender_mykad, sender_phone, sender_add, sender_city, sender_postcode, sender_state)"
							+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
					PreparedStatement stmt = conn.prepareStatement(q_sender);
					stmt.setString(1, sName);
					stmt.setString(2, sMykad);
					stmt.setString(3, sPhone);
					stmt.setString(4, sAdd);
					stmt.setString(5, sCity);
					stmt.setString(6, sPostcode);
					stmt.setString(7, sState);
					stmt.execute();
					
					conn.close();
					
					System.out.println("Insert Success");
				}
				catch(Exception ae)
				{
					System.out.println(ae.getMessage());
				}
				
				ParcelReceiverFrame rFrame = new ParcelReceiverFrame();
				rFrame.setVisible(true);
			}
		});
		
		btnAddSender.setFont(new Font("Arial", Font.BOLD, 14));
		btnAddSender.setBounds(497, 474, 143, 36);
		contentPane.add(btnAddSender);
		
	}
	
	
}
