import java.io.*;
import java.net.*;

public class TCPserver
{
   public static void main( String args[] )
	{
      // Declare a server socket and a client socket for the server
      ServerSocket service = null;
      Socket server = null;

      // Declare an input stream and String to store message from client		
		BufferedReader is;
		String line;
		
		// Declare an output stream to client		
      DataOutputStream os; // Could alternatively use a DataOutputStream
     
      // Try to open a server socket on port 5000
      try
	   {
         service = new ServerSocket(5000);
      }
      catch (IOException e)
	   {
         System.out.println(e);
      }  

      // Create a socket object from the ServerSocket to listen and accept
      // connections. Open input and output streams
      try
	   {
         server = service.accept();
        
			is = new BufferedReader( new InputStreamReader(
			                             server.getInputStream()));
			
         os = new DataOutputStream(server.getOutputStream());
        
		   if( (line = is.readLine()) != null )
			{
            os.writeBytes(line + "\n");
			}
			
			// Comment out/remove the stream and socket closes if server is to remain live. 
		   os.close();
         is.close();
         server.close();				
      }  
      catch (IOException e)
	   {
         System.out.println(e);			
      }
				
 		
   }
}
