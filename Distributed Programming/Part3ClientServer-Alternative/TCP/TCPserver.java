import java.io.*;
import java.net.*;

public class TCPserver implements Runnable
{
   private boolean done = false;
   static ServerSocket service = null;
   static Socket server = null;
   static int threadnumber;
   
   public TCPserver(Socket server, int threadnumber) {
     
     this.server = server;
     this.threadnumber = threadnumber;
   }
   
   public static void main( String args[] )
	{
     
     
      // Declare a server socket and a client socket for the server
      


      try
	   {
         service = new ServerSocket(5000);
         server = service.accept();
      }
      catch (IOException e)
	   {
         System.out.println(e);
      }  

      TCPserver serverObject = new TCPserver(server,1);
      TCPserver serverObject2 = new TCPserver(server,2);	
      Thread t1 = new Thread(serverObject);
      Thread t2 = new Thread(serverObject2);
      t1.start();		
      t2.start();		
      

      	

	
 		
   }
    
   public void run(){
   String thr = Integer.toString(threadnumber);
   while(  done == false ){ 
   
   // Create a socket object from the ServerSocket to listen and accept
      // connections. Open input and output streams
      
      // Declare an input stream and String to store message from client		
		BufferedReader is;
		String line;
		
		// Declare an output stream to client		
      DataOutputStream os; // Could alternatively use a DataOutputStream
     
      // Try to open a server socket on port 5000
      
      try
	   {
     
        
			is = new BufferedReader( new InputStreamReader(
			                             server.getInputStream()));
			
         os = new DataOutputStream(server.getOutputStream());
        
		   while( (line = is.readLine()) != null )
			{
            os.writeBytes(line + ":" + thr +"\n");
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

       // operations that eventually cause done == true; 
      }      
      
   }
}
