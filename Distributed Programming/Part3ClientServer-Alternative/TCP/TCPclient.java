import java.io.*;
import java.net.*;
import java.util.*;

public class TCPclient
{
   public static void main(String[] args)
	{
   
      // Declare client socket
      Socket clientSocket = null; 		

	   // Declare output stream and string to send to server 
      DataOutputStream os = null;
		String request;
				
      // Declare input stream from server and string to store input received from server
		BufferedReader is = null;
		String responseLine;
												  
      // Create a socket on port 5000 and open input and output streams on that socket
      try
		{
         clientSocket = new Socket("localhost", 5000);
         os = new DataOutputStream(clientSocket.getOutputStream());			
			is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      } 
		catch (UnknownHostException e)
		{
         System.err.println("Don't know about host: hostname");
      }
		catch (IOException e)
		{
         System.err.println("Couldn't get I/O for the connection to: hostname");
      }

      // Write data to the socket
      if (clientSocket != null && os != null && is != null)
		{
         try
			{         		  
				//request = "Hello server\n";
            System.out.println("Input a string:");
  
            Scanner user_input = new Scanner( System.in );
            request = user_input.nextLine();
            
            os.writeBytes( request + "\n" );
				System.out.println("CLIENT: " + request);
								
            while((responseLine = is.readLine()) != null)
				{
               System.out.println("SERVER: " + responseLine);
               System.out.println("Input a string:");
               request = user_input.nextLine();
               os.writeBytes( request + "\n" );
		      }
								
            // Close the input/output streams and socket
            os.close();
            is.close();
            clientSocket.close();  
         }
			catch (UnknownHostException e)
			{
            System.err.println("Trying to connect to unknown host: " + e);
         }
			catch (IOException e)
			{
            System.err.println("IOException:  " + e);
         }
      }
   }          
}
