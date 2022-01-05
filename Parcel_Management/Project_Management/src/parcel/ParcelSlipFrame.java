package parcel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.math.BigDecimal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

import java.sql.*;

public class ParcelSlipFrame extends JFrame {

	private JPanel contentPane;
	ParcelManager pm = new ParcelManager();
	Connection conn = pm.getConnection();

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParcelSlipFrame frame = new ParcelSlipFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ParcelSlipFrame() 
	{
		setTitle("PARCEL SLIP & PAYMENT SLIP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 698);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		try
		{
			String parcelDetails = "SELECT * FROM parcel_details WHERE pd_id=(SELECT max(pd_id) FROM parcel_details);";
			PreparedStatement stmt = conn.prepareStatement(parcelDetails);
			ResultSet rs = stmt.executeQuery();
			
			String parcelWeight = "SELECT * FROM parcel WHERE parcel_id=(SELECT max(parcel_id) FROM parcel);";
			PreparedStatement stmtWeight = conn.prepareStatement(parcelWeight);
			ResultSet rsWeight = stmtWeight.executeQuery();
			
			
			String senderDetails = "SELECT * FROM sender WHERE sender_id=(SELECT max(sender_id) FROM sender);";
			PreparedStatement stmt1 = conn.prepareStatement(senderDetails);
			ResultSet rs1 = stmt1.executeQuery();
			
			String receiverDetails = "SELECT * FROM receiver WHERE r_id=(SELECT max(r_id) FROM receiver);";
			PreparedStatement stmt2 = conn.prepareStatement(receiverDetails);
			ResultSet rs2 = stmt2.executeQuery();
			
			
			String senderState = "SELECT sender.sender_id,state.state_name FROM sender INNER JOIN state ON state.state_id=sender.sender_state WHERE sender_id=(SELECT max(sender_id) FROM sender);";
			PreparedStatement stmt3 = conn.prepareStatement(senderState);
			ResultSet rs3 = stmt3.executeQuery();
			
			String receiverState = "SELECT receiver.r_id,state.state_name FROM receiver INNER JOIN state ON state.state_id=receiver.r_state WHERE r_id=(SELECT max(r_id) FROM receiver);";
			PreparedStatement stmt4 = conn.prepareStatement(receiverState);
			ResultSet rs4 = stmt4.executeQuery();

			String paymentTransaction = "SELECT * FROM payment WHERE payment_id=(SELECT max(payment_id) FROM payment);";
			PreparedStatement stmtTransaction = conn.prepareStatement(paymentTransaction);
			ResultSet rsPayment = stmtTransaction.executeQuery();
			
			while(rs.next() && rs1.next() && rs2.next() && rs3.next() && rs4.next() && rsWeight.next() && rsPayment.next())
			{
				
				
			JTextArea textArea 
			= new JTextArea("\n===============\n    Parcel Details\n==============="
					+ "\nParcel ID\t\t: " + rs.getInt(1)
					+ "\nParcel Weight\t\t: " + rsWeight.getDouble(2) + " kg"
					+ "\nTracking Number\t: " + rs.getString(4) 
					
					+ "\n\nSender Details "
					+ "\nSender Name\t\t: "+rs1.getString(2)
					+ "\nSender Address\t: " + rs1.getString(5) +", "+ rs1.getString(6) +", "+ rs1.getString(7) +" "+ rs3.getString(2)
					+"\nSender Phone\t\t: " + rs1.getString(4) 
			
					
					+ "\n\nReceiver Details "
					+ "\nReceiver Name\t\t: " + rs2.getString(2) 
					+ "\nReceiver Address\t: " + rs2.getString(4) + ", " + rs2.getString(5) + ", " + rs2.getString(6) +" "+ rs4.getString(2) 
					+ "\nReceiver Phone\t: " + rs2.getString(3)
					
					+"\n\n\n==============="
					+"\n   Payment Details"
					+"\n==============="
					+ "\nDate & Time\t\t:" + rsPayment.getDate(8) + "  " + rsPayment.getTime(8)
					+ "\nStatus Of Payment\t: " + rsPayment.getString(9)
					+ "\nPayment Reference ID\t: " + rsPayment.getString(3)
					+ "\nAmount\t\t: RM " + rsPayment.getBigDecimal(4)
					+ "\nBank\t\t: " + rsPayment.getString(7));
			
			
			contentPane.add(textArea, BorderLayout.CENTER);
			textArea.setEditable(false);
			
			}
			
		
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

}
