import java.net.*;
import java.util.*;

class NetworkAndGuis
{
   public static void main(String[ ] args)
   {
      InetAddress host = null;
      System.out.println("Looking up host");
      
      try
      {
          host = InetAddress.getLocalHost();// host = InetAddress.getByName( "hostname" );
          System.out.println("Host name: " + host.getHostName() );
          System.out.println("IP address: " + host.getHostAddress() );
      }
      
      catch(UnknownHostException e)
      
      {
      
      System.out.println("Unable to resolve name and address " );
      
      }
   }
}

