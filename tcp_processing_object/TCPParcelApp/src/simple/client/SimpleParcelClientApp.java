
package simple.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import parcel.Parcel;

public class SimpleParcelClientApp 
{
	public static void main(String args[]) {
		
		System.out.println("Launching SimpleParcelClientApp program");
		
		
		// Create new object
		Parcel parcel = new Parcel();
		parcel.setWeight(1.2);
		
		try {
			
			// Connect to server-side program
			Socket socket = new Socket(InetAddress.getLocalHost(), 4228);

			// Send object to be processed by the server-side application
			ObjectOutputStream oos = 
					new ObjectOutputStream (socket.getOutputStream());
			oos.writeObject(parcel);
			System.out.println("\nSending Weight " + parcel.getWeight() + " kg to server-side application");
			
			// Receive processed object
			ObjectInputStream ois =
					new ObjectInputStream(socket.getInputStream());
			Parcel processedParcel = (Parcel) ois.readObject();
			
			// Manipulate processed object
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
