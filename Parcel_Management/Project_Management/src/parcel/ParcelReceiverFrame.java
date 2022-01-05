package parcel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

import java.sql.*;
import payment.PaymentFrame;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime; 

public class ParcelReceiverFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtReceiverName;
	private JTextField txtReceiverPhone;
	private JTextField txtReceiverAdd;
	private JTextField txtReceiverCity;
	private JTextField txtReceiverPostcode;
	private JTextField txtWeight;
	
	Parcel p = new Parcel();
	
	ParcelManager pm = new ParcelManager();
	Connection conn = pm.getConnection();

	/**
	 * Launch the application.
	 */
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParcelReceiverFrame frame = new ParcelReceiverFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 */
	public ParcelReceiverFrame() {
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
		
		JLabel lblNewLabel_3 = new JLabel("Please Enter Receiver Information:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(313, 289, 206, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("RECEIVER DETAILS");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4.setBounds(341, 314, 136, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1 = new JLabel("NAME          : ");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(192, 350, 73, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_6 = new JLabel("PHONE NO :");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_6.setBounds(192, 386, 73, 28);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("ADDRESS   :");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_7.setBounds(192, 425, 73, 28);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("CITY             :");
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_8.setBounds(192, 464, 73, 28);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("POSTCODE:");
		lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_9.setBounds(192, 503, 73, 29);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("STATE          :");
		lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_10.setBounds(192, 539, 73, 25);
		contentPane.add(lblNewLabel_10);
		
		txtReceiverName = new JTextField();
		txtReceiverName.setEditable(false);
		txtReceiverName.setBounds(265, 350, 330, 28);
		contentPane.add(txtReceiverName);
		txtReceiverName.setColumns(10);
		
		txtReceiverPhone = new JTextField();
		txtReceiverPhone.setEditable(false);
		txtReceiverPhone.setColumns(10);
		txtReceiverPhone.setBounds(265, 386, 330, 28);
		contentPane.add(txtReceiverPhone);
		
		txtReceiverAdd = new JTextField();
		txtReceiverAdd.setEditable(false);
		txtReceiverAdd.setColumns(10);
		txtReceiverAdd.setBounds(265, 425, 330, 28);
		contentPane.add(txtReceiverAdd);
		
		txtReceiverCity = new JTextField();
		txtReceiverCity.setEditable(false);
		txtReceiverCity.setColumns(10);
		txtReceiverCity.setBounds(265, 464, 330, 28);
		contentPane.add(txtReceiverCity);
		
		txtReceiverPostcode = new JTextField();
		txtReceiverPostcode.setEditable(false);
		txtReceiverPostcode.setColumns(10);
		txtReceiverPostcode.setBounds(265, 503, 330, 28);
		contentPane.add(txtReceiverPostcode);
		
		JComboBox optState = new JComboBox();
		optState.setModel(new DefaultComboBoxModel(new String[] {"JOHOR", "KEDAH", "KELANTAN", "MELAKA", "NEGERI SEMBILAN", "PAHANG", "PULAU PINANG", "PERAK", "PERLIS", "SABAH", "SARAWAK", "SELANGOR", "TERENGGANU", "WP KUALA LUMPUR", "WP LABUAN", "WP PUTRAJAYA"}));
		optState.setBounds(265, 539, 330, 28);
		contentPane.add(optState);
		
		txtWeight = new JTextField();
		txtWeight.setHorizontalAlignment(SwingConstants.CENTER);
		txtWeight.setFont(new Font("Arial", Font.BOLD, 17));
		txtWeight.setBounds(330, 226, 161, 38);
		contentPane.add(txtWeight);
		txtWeight.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Click The Button To Get Parcel Weight");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(295, 110, 232, 21);
		contentPane.add(lblNewLabel_2);
		
		JButton btnWeight = new JButton("WEIGHT PARCEL");
		btnWeight.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				double weight = p.getRandom();
				p.setWeight(weight);
				
				txtWeight.setText(Double.toString(p.getWeight()));
				
				btnWeight.setEnabled(false);
				txtWeight.setEditable(false);
				txtReceiverPostcode.setEditable(true);
				txtReceiverCity.setEditable(true);
				txtReceiverAdd.setEditable(true);
				txtReceiverPhone.setEditable(true);
				txtReceiverName.setEditable(true);
			}
		});
		btnWeight.setFont(new Font("Arial", Font.BOLD, 14));
		btnWeight.setBounds(330, 142, 161, 38);
		contentPane.add(btnWeight);
		
		
		
		JLabel lblNewLabel_4_1 = new JLabel("WEIGHT (KG) : ");
		lblNewLabel_4_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4_1.setBounds(358, 204, 102, 21);
		contentPane.add(lblNewLabel_4_1);
		
		JButton btnProceed = new JButton("PROCEED");
		btnProceed.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//Sender information
				String receiverName = txtReceiverName.getText();
				p.setReceiverName(receiverName);
				
				String receiverPhone = txtReceiverPhone.getText();
				p.setReceiverPhone(receiverPhone);
				
				String receiverAdd = txtReceiverAdd.getText();
				String receiverCity = txtReceiverCity.getText();
				String receiverPostcode = txtReceiverPostcode.getText();
				
				int state = (int)optState.getSelectedIndex();
				int state_id = state + 1;
				String receiverState = Integer.toString(state_id);
				
				Address r_add = new Address(receiverAdd, receiverCity, receiverPostcode, receiverState);
				p.setReceiverAdd(r_add);
				
				double parcel_weight = p.getWeight();
				System.out.println(parcel_weight);
				
				String rName = p.getReceiverName();
				String rPhone = p.getReceiverPhone();
				String rAdd = r_add.getAdd();
				String rCity = r_add.getCity();
				String rPostcode = r_add.getPostcode();
				String rState = r_add.getState();
				
				//query insert receiver data
				try
				{
					String q_receiver = 
							"INSERT INTO receiver (r_name, r_phone, r_add, r_city, r_postcode, r_state)"
							+ "VALUES (?, ?, ?, ?, ?, ?)";
					PreparedStatement stmt = conn.prepareStatement(q_receiver);
					stmt.setString(1, rName);
					stmt.setString(2, rPhone);
					stmt.setString(3, rAdd);
					stmt.setString(4, rCity);
					stmt.setString(5, rPostcode);
					stmt.setString(6, rState);
					stmt.execute();
					
					System.out.println("Insert Success");
				}
				catch(Exception ae)
				{
					System.out.println(ae.getMessage());
				}
				
				int sender_id = 0;
				int receiver_id = 0;
				int parcel_id = 0;
				int rate_id = 0;
				String state_iso = "";
				int sState = 0;
				int r_State = 0;
				double price_state = 0;
				double price_peninsular = 0;
				double price_sabah_sarawak = 0;
				double totalPrice = 0;
				
				//query get sender_id
				try
				{
					Statement stmt = conn.createStatement();
					ResultSet res = stmt.executeQuery("SELECT MAX(sender_id) FROM sender AS sender_id");
					
					res.next();
					int id = res.getInt("MAX(sender_id)");
					sender_id = id;
					
					System.out.println(sender_id);
				}
				catch(Exception ae)
				{
					System.out.println(ae.getMessage());
				}
				
				//query get receiver_id
				try
				{
					Statement stmt = conn.createStatement();
					ResultSet res = stmt.executeQuery("SELECT MAX(r_id) FROM receiver");
					
					res.next();
					int id = res.getInt("MAX(r_id)");
					receiver_id = id;
					
					System.out.println(receiver_id);
					
				}
				catch(Exception ae)
				{
					System.out.println(ae.getMessage());
				}
				
				//query insert parcel
				try
				{
					String q_parcel = 
							"INSERT INTO parcel (parcel_weight, parcel_sender, parcel_receiver)"
							+ "VALUES (?, ?, ?)";
					PreparedStatement stmt = conn.prepareStatement(q_parcel);
					stmt.setDouble(1, parcel_weight);
					stmt.setInt(2, sender_id);
					stmt.setInt(3, receiver_id);
					stmt.execute();
					
					System.out.println("Insert Success");
				}
				catch(Exception ae)
				{
					System.out.println(ae.getMessage());
				}
				
				//query get parcel_id
				try
				{
					Statement stmt = conn.createStatement();
					ResultSet res = stmt.executeQuery("SELECT MAX(parcel_id) FROM parcel");
					
					res.next();
					int id = res.getInt("MAX(parcel_id)");
					parcel_id = id;
					
					System.out.println(parcel_id);
					
				}
				catch(Exception ae)
				{
					System.out.println(ae.getMessage());
				}
				
				//query get rate id 
				try
				{
					Statement stmt = conn.createStatement();
					ResultSet res = 
							stmt.executeQuery("SELECT * FROM parcel "
									+ "INNER JOIN rate ON rate.rate_weight_min <= parcel.parcel_weight "
									+ "AND rate.rate_weight_max >= parcel.parcel_weight "
									+ "WHERE parcel.parcel_sender = '" + sender_id + "' && parcel.parcel_receiver = '" + receiver_id + "' ");
					
					res.next();
					int id = res.getInt("rate_id");
					rate_id = id;
					
					System.out.println(rate_id);
					
				}
				catch(Exception ae)
				{
					System.out.println(ae.getMessage());
				}
				
				//query get parcel_id
				try
				{
					Statement stmt = conn.createStatement();
					ResultSet res = stmt.executeQuery("SELECT * from state WHERE state_id = '" + rState + "' ");
					
					res.next();
					String iso = res.getString("state_iso");
					state_iso = iso;
					
					System.out.println(state_iso);
					
				}
				catch(Exception ae)
				{
					System.out.println(ae.getMessage());
				}
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
				LocalDateTime now = LocalDateTime.now();
				String tracking_no = state_iso + sender_id + dtf.format(now) + receiver_id;
				
				
				//query insert parcel_details
				try
				{
					String q_parcel_details = 
							"INSERT INTO parcel_details (pd_parcel, pd_rate, pd_tracking_no)"
							+ "VALUES (?, ?, ?)";
					PreparedStatement stmt = conn.prepareStatement(q_parcel_details);
					stmt.setDouble(1, parcel_id);
					stmt.setInt(2, rate_id);
					stmt.setString(3, tracking_no);
					stmt.execute();
					
					System.out.println(tracking_no);
					System.out.println("Insert Success");
				}
				catch(Exception ae)
				{
					System.out.println(ae.getMessage());
				}
				
				//query insert transaction
				try
				{
					Statement stmt = conn.createStatement();
					ResultSet res = 
							stmt.executeQuery("SELECT * FROM parcel "
									+ "INNER JOIN rate ON rate.rate_weight_min <= parcel.parcel_weight AND rate.rate_weight_max >= parcel.parcel_weight "
									+ "INNER JOIN sender ON sender.sender_id = parcel.parcel_sender "
									+ "INNER JOIN receiver ON receiver.r_id = parcel.parcel_receiver "
									+ "WHERE parcel.parcel_sender = '" + sender_id + "' && parcel.parcel_receiver = '" + receiver_id + "' ");
					
					res.next();
					double priceState = res.getDouble("rate_within_state");
					double pricePeninsular = res.getDouble("rate_within_peninsular");
					double priceSabahSarawak = res.getDouble("rate_sabah_sarawak");
					int senderState = res.getInt("sender_state");
					int receiver_State = res.getInt("r_state");
					
					price_state = priceState;
					price_peninsular = pricePeninsular;
					price_sabah_sarawak = priceSabahSarawak;
					sState = senderState;
					r_State = receiver_State;
					
					System.out.println(price_state + " " + price_peninsular + " " + price_sabah_sarawak);
					
					//dividing the price based on sender and receiver postcode
					
					
					if(r_State == sState)
					{
						totalPrice = price_state;
					}
					else if(r_State == 10 || r_State == 11 || r_State == 15)
					{
						totalPrice = price_sabah_sarawak;
					}
					else
					{
						totalPrice = price_peninsular;
					}
					
					System.out.println(r_State + "   " + sState);
					System.out.println(totalPrice);
					
				}
				catch(Exception ae)
				{
					System.out.println(ae.getMessage());
				}
				
				DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyHHmm");
				String trans_no = sender_id + df.format(now) + receiver_id;
				
				//insert into trans 
				try
				{
					String q_trans = 
							"INSERT INTO trans (trans_parcel, trans_no, trans_price)"
							+ "VALUES (?, ?, ?)";
					PreparedStatement stmt = conn.prepareStatement(q_trans);
					stmt.setDouble(1, parcel_id);
					stmt.setString(2, trans_no);
					stmt.setDouble(3, totalPrice);
					stmt.execute();
					
					System.out.println(tracking_no);
					
					stmt.close();
					conn.close(); 
					
					System.out.println("Insert Success");
				}
				catch(Exception ae)
				{
					System.out.println(ae.getMessage());
				}
				
				PaymentFrame rFrame = new PaymentFrame();
				rFrame.setVisible(true);
			}
		});
		btnProceed.setFont(new Font("Arial", Font.BOLD, 14));
		btnProceed.setBounds(493, 588, 102, 38);
		contentPane.add(btnProceed);
	}
}
