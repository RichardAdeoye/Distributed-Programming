import java.net.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class  AFrame extends JFrame
{ 
   AFrame()
   {
     this.setBounds(100, 100, 300, 300);
     
      InetAddress host = null;
      System.out.println("Looking up host");
      
      try
      {
         host = InetAddress.getLocalHost();// host = InetAddress.getByName( "hostname" );
         Container cp = getContentPane();
           
         JLabel hostName = new JLabel("Host name: " + host.getHostName(), JLabel.LEFT );
         JLabel IPAddress = new JLabel("IP address: " + host.getHostAddress(), JLabel.CENTER);
         
         cp.add( hostName );
         cp.add( IPAddress );
      }
      
      catch(UnknownHostException e)
      
      {
         Container cp = getContentPane();
           
         JLabel tryCatchExc = new JLabel("Unable to resolve name and address");
         cp.add( tryCatchExc );
      }

    

   }
   
   public static void main( String[ ] args)
   {
     AFrame w = new AFrame();
     w.setVisible(true);
 
   }
}