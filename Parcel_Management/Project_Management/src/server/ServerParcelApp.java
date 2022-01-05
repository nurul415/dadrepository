package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerParcelApp 
{
	public static void main(String[] args) 
	{
	
		// Launch the server frame
		ServerParcelFrame serverFrame = new ServerParcelFrame();
		serverFrame.setVisible(true);
		
		try 
		{
			// Bind Serversocket to a port
			int portNo = 4228;
			ServerSocket serverSocket = new ServerSocket(portNo);

			DataGenerator dataGenerator = new DataGenerator();

			// Counter to keep track the number of requested connection
			int totalRequest = 0;

			// Server need to be alive forever
			while (true) 
			{

				// Accept client request for connection
				Socket clientSocket = serverSocket.accept();
				
				//Get Parcel ID
				int parcel_id = dataGenerator.getParcelID();

				// Create stream to write data on the network
				DataOutputStream outputStream = 
						new DataOutputStream(clientSocket.getOutputStream());

				// Send data back to the client
				outputStream.writeInt(parcel_id);

				// Close the socket
				clientSocket.close();


				// Update the request status
				serverFrame.updateRequestStatus("Data sent to the client: " + dataGenerator.getParcelID());
				serverFrame.updateRequestStatus(
						"Accepted connection from the client.   "
						+ "Total request =" + ++totalRequest);
			}
			
		} 
		catch (Exception exception) 
		{
			System.out.println("OOOPS, We got problem.");
			exception.printStackTrace();
		}
	}
}
