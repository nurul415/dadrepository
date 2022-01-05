package TranslateServer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTranslateApplication 
{
	
		public static void main(String[] args) 
		{
		
			// Launch the server frame
			ServerTranslateFrame serverFrame = new ServerTranslateFrame();
			serverFrame.setVisible(true);
			
			try 
			{
				// Bind Serversocket to a port
				int portNo = 4228;
				ServerSocket serverSocket = new ServerSocket(portNo);
	
				TranslateGenerator translateGenerator = new TranslateGenerator();
	
				// Counter to keep track the number of requested connection
				int totalRequest = 0;
	
				// Server need to be alive forever
				while (true) 
				{
	
					// Accept client request for connection
					Socket clientSocket = serverSocket.accept();
	
					// Get translation
					String word = "How Are You?";
					
					//for malay
					String translateMalay  = translateGenerator.getMalay(word);
					
					//for arabic 
					//String translateArabic = translateGenerator.getArabic(word);
					
					//for korean
					//String translateKorean = translateGenerator.getKorean(word);
	
					// Create stream to write data on the network
					DataOutputStream outputStream = 
							new DataOutputStream(clientSocket.getOutputStream());
	
					// Send translation back to the client
					outputStream.writeBytes(translateMalay);
					//outputStream.writeBytes(translateArabic);
					//outputStream.writeBytes(translateKorean);
	
					// Close the socket
					clientSocket.close();
	
	
					// Update the request status
					serverFrame.updateRequestStatus("Data sent to the client: " + word);
					serverFrame.updateRequestStatus(
							"Accepted connection from the client.  "
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
