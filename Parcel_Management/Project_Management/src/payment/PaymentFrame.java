package payment;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import parcel.ParcelFrame;
import parcel.ParcelManager;
import client.ClientParcelApp;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class PaymentFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtCreditCard;
	private JTextField txtCCV;
	private String total;
	ParcelManager pm = new ParcelManager();
	Connection conn = pm.getConnection();
	Payment p = new Payment();
	private JTextField txtTotalPrice;
	JComboBox comboBox = new JComboBox();

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
					PaymentFrame frame = new PaymentFrame();
					frame.setVisible(true);
					
					ParcelFrame parcelFrame = new ParcelFrame();
					parcelFrame.setVisible(false);
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
	
	public void BankComboBox()
	{
		try 
		{
			String q_bank = "SELECT * FROM bank";
			PreparedStatement stmt = conn.prepareStatement(q_bank);
			ResultSet res = stmt.executeQuery();
			
			while(res.next())
			{
				comboBox.addItem(res.getString("bank_name"));
			}
		}
		catch(Exception ae)
		{
			ae.printStackTrace();
		}
	}
	
	public void TotalPrice()
	{
		try 
		{
			String q_tprice = "SELECT trans_price FROM trans ORDER BY trans_id DESC LIMIT 1 ";
			PreparedStatement stmt = conn.prepareStatement(q_tprice);
			ResultSet res = stmt.executeQuery();
			
			res.next();
			double id = res.getDouble("trans_price");
			total=String.valueOf(id);

			
		}
		catch(Exception ae)
		{
			ae.printStackTrace();
		}
	}
	
	
	public PaymentFrame() 
	{
		TotalPrice();
		setFont(new Font("Arial", Font.BOLD, 12));
		setTitle("PARCEL MANAGEMENT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 698);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel compName = new JLabel("PARCEL MANAGEMENT SYSTEM");
		compName.setHorizontalAlignment(SwingConstants.CENTER);
		compName.setFont(new Font("Arial", Font.BOLD, 16));
		compName.setBounds(270, 33, 257, 28);
		contentPane.add(compName);
		
		JLabel managerName = new JLabel("EMMASOFT SOLUTION");
		managerName.setHorizontalAlignment(SwingConstants.CENTER);
		managerName.setFont(new Font("Arial", Font.BOLD, 14));
		managerName.setBounds(270, 60, 257, 21);
		contentPane.add(managerName);
		
		JLabel lblNewLabel_3 = new JLabel("TOTAL PRICE (RM) :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3.setBounds(270, 119, 257, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnConfirmPrice = new JButton("PROCEED");
		btnConfirmPrice.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				BankComboBox();
				btnConfirmPrice.setEnabled(false);
			}
		});
		btnConfirmPrice.setFont(new Font("Arial", Font.BOLD, 14));
		btnConfirmPrice.setBounds(341, 201, 125, 36);
		contentPane.add(btnConfirmPrice);
		
		JLabel lblNewLabel_1_1 = new JLabel("Please Enter Your Payment Information : ");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(293, 275, 247, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("PAYMENT");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4.setBounds(367, 307, 73, 14);
		contentPane.add(lblNewLabel_4);
		

		JLabel lblNewLabel_6 = new JLabel("CC NO     : ");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_6.setBounds(184, 342, 69, 25);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("CCV NO  : ");
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_8.setBounds(184, 378, 69, 25);
		contentPane.add(lblNewLabel_8);
		
		txtCreditCard = new JTextField();
		txtCreditCard.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtCreditCard.setBounds(251, 342, 350, 28);
		contentPane.add(txtCreditCard);
		txtCreditCard.setColumns(10);
		
		txtCCV = new JTextField();
		txtCCV.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtCCV.setColumns(10);
		txtCCV.setBounds(251, 378, 350, 28);
		contentPane.add(txtCCV);
		
		txtTotalPrice = new JTextField();
		txtTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalPrice.setFont(new Font("Arial", Font.BOLD, 17));
		txtTotalPrice.setBounds(331, 144, 140, 36);
		contentPane.add(txtTotalPrice);
		txtTotalPrice.setColumns(10);
		txtTotalPrice.setText(total);
		
		JLabel lblNewLabel_7 = new JLabel("BANK      : ");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_7.setBounds(184, 417, 69, 28);
		contentPane.add(lblNewLabel_7);
		comboBox.setFont(new Font("Monospaced", Font.PLAIN, 12));
		comboBox.setEditable(true);
		
		comboBox.setBounds(251, 417, 350, 28);
		contentPane.add(comboBox);
		
		JButton btnPay = new JButton("PAY");
		btnPay.setFont(new Font("Arial", Font.BOLD, 14));
		btnPay.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				//Card information
				String creditCard = txtCreditCard.getText();
				p.setCreditCard(creditCard);
				
				String CCV = txtCCV.getText();
				p.setCcv(CCV);
				
				String Bank = comboBox.getSelectedItem().toString();
				p.setBank(Bank);
				
				String creditcard = p.getCreditCard();
				String ccv = p.getCcv();
				String bank = p.getBank();
				
				int transid = 0;
				int status = 0;
				
				//check card
				
			
				
				if(creditcard.length() != 16 && ccv.length() != 3 ) 
				{
					toBack();
					ErrorFrame rFrame = new ErrorFrame();
					rFrame.setVisible(true);
					rFrame.toFront();
				}
				
				else if(creditcard.length() != 16 || ccv.length() != 3)
				{
					toBack();
					ErrorFrame rFrame = new ErrorFrame();
					rFrame.setVisible(true);
					rFrame.toFront();
				}
				
				else
				{
					status = 1;
					creditcard = p.getCreditCard();
					
					//get trans id
					try
					{
						String q_trans = "SELECT trans_id FROM trans ORDER BY trans_id DESC LIMIT 1";
						PreparedStatement stmt = conn.prepareStatement(q_trans);
						ResultSet res = stmt.executeQuery();	
						
						res.next();
						int trans = res.getInt("trans_id");
						transid = trans;
					}
					catch(Exception ae)
					{
						System.out.println(ae.getMessage());
					}
					
					//get timestamp
					java.util.Date utilDate = new java.util.Date();
					java.sql.Timestamp sqlTS = new java.sql.Timestamp(utilDate.getTime());
					
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
					LocalDateTime now = LocalDateTime.now();
					
					//get paymentrefid
					
					String ref = String.valueOf(transid) + dtf.format(now);
					
					//Sent information
					try
					{
						String q_payment = 
								"INSERT INTO payment (payment_trans, payment_ref_id, payment_amount, payment_cc, payment_cvv, payment_bank, payment_status)"
								+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
						PreparedStatement stmt = conn.prepareStatement(q_payment);
						stmt.setInt(1, transid);
						stmt.setString(2, ref);
						stmt.setString(3, total);
						stmt.setString(4, creditcard);
						stmt.setString(5, ccv);
						stmt.setString(6, bank);
						stmt.setInt(7,status);
						stmt.execute();
						
						conn.close();
						
						System.out.println("Insert Success");
					}
					catch(Exception ae)
					{
						System.out.println(ae.getMessage());
					}
					
					ClientParcelApp cpa = new ClientParcelApp();
					try 
					{
						cpa.main(null);
					} 
					catch (Exception e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnPay.setBounds(499, 475, 102, 36);
		contentPane.add(btnPay);
		
		
		
		
	}
}
