package simple.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.Timestamp;

import parcel.Parcel;
import payment.Payment;
import payment.Staff;

public class SimplePaymentClientApp 
{
	public static void main(String args[]) {
		
		System.out.println("Launching SimplePaymentClientApp program");
		
		
		// Create new parcel
		Parcel parcel = new Parcel();
		parcel.setWeight(1.2);
		
		Staff staff = new Staff();
		staff.setUserId("B032110013");
		staff.setName("Nurul Aisyah binti Aris");
		
		Payment payment = new Payment();
		payment.setPaymentId(1001);
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		payment.setTransactionDate(timestamp);
		
		payment.setRecordedBy(staff);
		Staff user1 = payment.getRecordedBy();
		
		
		try {
			
			// Connect to server-side program
			Socket socket = new Socket(InetAddress.getLocalHost(), 4228);

			// Send object to be processed by the server-side application
			ObjectOutputStream oos = 
					new ObjectOutputStream (socket.getOutputStream());
			oos.writeObject(parcel);
			System.out.println("\nSending Weight " + parcel.getWeight() + " kg and " + payment.getPaymentId() +" to server-side application");
			
			// Receive processed object
			ObjectInputStream ois =
					new ObjectInputStream(socket.getInputStream());
			Parcel processedParcel = (Parcel) ois.readObject();
			
			// Manipulate processed object
			System.out.println("\nPayment ID       :  " + payment.getPaymentId());
			System.out.println("Transaction Date :  " + payment.getTransactionDate());
			System.out.println("Recorded By      :  " + user1.getName()  + " (" + user1.getUserId() + ")");
			System.out.println("\nWeight of Parcel :  " + processedParcel.getWeight());
			System.out.println("Price of Parcel  :  RM " + processedParcel.getPrice());
			
			
			// Close all streams
			ois.close();
			oos.close();
			socket.close();

		} catch (Exception ex) {

		}
		
		
	}
}
