import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.*;


// A kind of JPanel that contains buttons/labal/fields
public class DataPanel extends JPanel implements ActionListener

{

    private ImageIcon jimage;
    private JButton local_IP;          // Button to retrieve local IP info
    private JLabel outputLabel;        // Label over output
    private JTextField outputLocal_IP; // Area to display local info
    private JLabel remoteLabel;
    private JTextField input_IP;
    private JLabel remote_name;
    private JTextField outputhost;
    
	 public DataPanel()    
	 {
	     this.setLayout(null);                       // Suppress panel layout features
        
         
		  local_IP = new JButton("Local host:");      // Create button to obtain local info
        local_IP.setBounds(0,200,100,30);           // x, y, w, h within this JPanel
        this.add(local_IP);                         // Add button to this JPanel              
 
        local_IP.addActionListener(this);

        outputLabel = new JLabel("address:name");
        outputLabel.setBounds(190, 170, 160,30);    // x, y, w, h within this JPanel        
        this.add(outputLabel);
        
        outputLocal_IP = new JTextField();          // Create output area for local info
        outputLocal_IP.setBounds(150, 200, 160,30);  // x, y, w, h within this JPanel
        outputLocal_IP.setEditable(false);          // Prevent modification
        this.add(outputLocal_IP);                   // Add JTextField to this JPanel  
           
        remoteLabel = new JLabel("Remote address:");
        remoteLabel.setBounds(0, 270, 100,30);
        this.add(remoteLabel);     
        
        input_IP = new JTextField();
        input_IP.setBounds(0,300,100,30);
        this.add(input_IP);
        input_IP.addActionListener(this);
     
        
        remote_name = new JLabel("Remote name:");
        remote_name.setBounds(180, 270, 100,30);
        this.add(remote_name);     
              
        outputhost = new JTextField();
        outputhost.setEditable(false);                      
        outputhost.setBounds(150,300,150,30);
        this.add(outputhost);     
	 }
    
    public void paintComponent(Graphics g)
    {
       super.paintComponent(g);
       // Can use tools to draw line, shapes, add images etc
       jimage = new ImageIcon("Java-logo.png"); // image is 300x158
       jimage.paintIcon( this, g, 0, 0 ); // 0,0 is origin of JPanel in JFrame
    }
    
    public void actionPerformed(ActionEvent eve)
    {
      InetAddress host = null;
      if( eve.getSource() == local_IP) 
      {
         try
         {
           
           host = InetAddress.getLocalHost();
           outputLocal_IP.setText("Host name: " + host.getHostName() + " , " + "IP address: " + host.getHostAddress());          
         }
           catch(UnknownHostException e)
      
         {
      
            System.out.println("Unable to resolve name and address " );
      
         }
      }
      
       if( eve.getSource() == input_IP) 
      {
         InetAddress ipName = null;
         try
         {
            String text = input_IP.getText();
            ipName = InetAddress.getByName(text);
         
            outputhost.setText("Output Host: " + ipName.getHostName());
          }
           catch(UnknownHostException e)
      
          {
      
            System.out.println("Cannot resolve" );
      
          }
      }
      
   }

}