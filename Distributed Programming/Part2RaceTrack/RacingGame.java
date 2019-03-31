import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RacingGame extends JPanel implements ActionListener{

  Timer racingGameTimer;
  static Player1 player1;
  static Player2 player2;
 // static boolean collision = false;
  
 public RacingGame(){
 
    setFocusable(true);
    
    player1 = new Player1(370, 500);
    player2 = new Player2(370, 550);
    
    addKeyListener(new KeyAdaptPlayer1(player1));
    addKeyListener(new KeyAdaptPlayer2(player2));
   
    
    racingGameTimer = new Timer(10,this);//How many millisecond timer should run
    racingGameTimer.start();
 
 }
 public void paintComponent(Graphics g) {
 
	 super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
  
    
    Color c1 = Color.green; // set these as rectangles
    g.setColor( c1 );
    g.fillRect( 150, 200, 550, 300 ); // grass
    
    Color c2 = Color.black;
    g.setColor( c2 );
    g.drawRect(50, 100, 750, 500);  // outer edge
    g.drawRect(150, 200, 550, 300); // inner edge
    
    Color c3 = Color.yellow;
    g.setColor( c3 );
    g.drawRect( 100, 150, 650, 400 ); // mid-lane marker
    
    Color c4 = Color.white;
    g2.setColor( c4 );
    //g2.setStroke(new BasicStroke(10));
    g2.drawLine( 425, 500, 425, 600 ); // start line
     
    player1.draw(g2);
    player2.draw(g2);
    
    //if(collision)
    //g2.drawString("COLLISION", 500, 600);     
   
 }
 
 public void actionPerformed(ActionEvent e) {
 
    player1.update();
    player2.update();
    //collision();
    player1.checkCollision();
    player2.checkCollision();
	 repaint(); //repaint window every 10 milliseconds
 }
 
 //public void collision(){
    
   //Rectangle player1Bounds = player1.getBounds();
   //Rectangle player2Bounds = player2.getBounds();
    
    //if (player1Bounds.intersects(player2Bounds)) {
    //collision = true;
    //}
    //else {
    //collision = false;
    //}
       
 //}
 
 //public static boolean getCollisionStatus(){
   // return collision;
 //}
 
 public static Player1 getPlayer1(){
    return player1;
 }
 
 public static Player2 getPlayer2(){
    return player2;
 }
 
}
