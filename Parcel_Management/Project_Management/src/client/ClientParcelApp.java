package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import parcel.ParcelFrame;
import parcel.Parcel;
import parcel.ParcelManager;
import payment.SuccessFrame;

public class ClientParcelApp 
{
	public static void main (String args []) throws UnknownHostException, IOException, Exception
	{
		SuccessFrame sf = new SuccessFrame();
		sf.setVisible(true);
		
		// Connect to the server at localhost, port 4228
		Socket socket = new Socket(InetAddress.getLocalHost(), 4228);
		
		// Update the status of the connection
		sf.updateConnectionStatus(socket.isConnected());
		
		// Create input stream - filter and chain
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		
		
		// Read from the network and display the current date
		String parcel_id = bufferedReader.readLine();
		
		
		sf.updateServerText(parcel_id);
		
		// Close everything
		bufferedReader.close();
		socket.close();
				
	}
}
