package clientText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTextApplication 
{
	public static void main(String[] args) throws UnknownHostException, 
	IOException 
	{
		// Launch client-side frame
		ClientTextFrame clientTextFrame = new ClientTextFrame();
		clientTextFrame.setVisible(true);
		
		// Connect to the server at localhost, port 4228
		Socket socket = new Socket(InetAddress.getLocalHost(), 4228);
		
		// Update the status of the connection
		clientTextFrame.updateConnectionStatus(socket.isConnected());
		
		// Create input stream - filter and chain
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		
		
		// Read from the network and display the current date
		String word = bufferedReader.readLine();
		clientTextFrame.updateServerText(word);
		
		// Close everything
		bufferedReader.close();
		socket.close();
	

	}
}

