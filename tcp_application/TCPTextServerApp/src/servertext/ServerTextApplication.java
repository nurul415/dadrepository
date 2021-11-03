package servertext;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTextApplication 
{
	public static void main(String[] args) {
		
		// Launch the server frame
		ServerTextFrame serverFrame = new ServerTextFrame();
		serverFrame.setVisible(true);
		
		try 
		{
			// Bind Serversocket to a port
			int portNo = 4228;
			ServerSocket serverSocket = new ServerSocket(portNo);

			TextGenerator textGenerator = new TextGenerator();

			// Counter to keep track the number of requested connection
			int totalRequest = 0;

			// Server need to be alive forever
			while (true) 
			{

				// Accept client request for connection
				Socket clientSocket = serverSocket.accept();

				// Get current date
				String word = "Hello, My Name is Nurul Aisyah.";
				int count = textGenerator.getCountText(word);


				// Create stream to write data on the network
				DataOutputStream outputStream = 
						new DataOutputStream(clientSocket.getOutputStream());

				// Send current date back to the client
				outputStream.writeBytes(word);

				// Close the socket
				clientSocket.close();


				// Update the request status
				serverFrame.updateRequestStatus("Data sent to the client: " 
						+ count + " words");
				serverFrame.updateRequestStatus(
						"Accepted connection from the client.  "
						+ "Total request =" + ++totalRequest);
			}
			
		} 
		catch (Exception exception) 
		{
			System.out.println("Batu Berendam, we got problem.");
			exception.printStackTrace();
		}
	}
}
