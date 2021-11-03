package translateServer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTranslationApplication 
{
	public static void main(String[] args) throws IOException{
		
		ServerSocket serverSocket = null;
		
		try 
		{
			// Bind Serversocket to a port
			int portNo = 4228;
			serverSocket = new ServerSocket(portNo);
			
			String text1 = "Good Afternoon!";
			System.out.println("Waiting for Request");

			// Server need to be alive forever
			while (true) 
			{

				// Accept client request for connection
				Socket clientSocket = serverSocket.accept();

				// Get translation
				

				// Create stream to write data on the network
				DataOutputStream outputStream = 
						new DataOutputStream(clientSocket.getOutputStream());

				// Send current date back to the client
				outputStream.writeUTF(text1);

				// Close the socket
				clientSocket.close();
			}
			
		} 
		catch (IOException ioe) 
		{
			if(serverSocket != null)
				serverSocket.close();
			
			ioe.printStackTrace();
		}
	}
}
