import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
public class RacingGame extends JPanel implements ActionListener{

  Timer racingGameTimer;
  static Player1 player1;
  static Player2 player2;
  
  static Rectangle OuterEdge;
  static Rectangle InnerEdge;
  
  static Line2D  StartLine;
  
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
  
   
    Color c2 = Color.black;
    OuterEdge = new Rectangle( 50, 100, 750, 500); // Outer edge
    g.setColor( c2 );
    g2.draw(OuterEdge);
    g.setColor( Color.gray );
    g.fillRect( 50, 100, 750, 500 ); 
    
    InnerEdge = new Rectangle( 150, 200, 550, 300); // Inner edge INCREASE THEN ADD COLLISIONS
    g.setColor( c2 );
    g2.draw(InnerEdge);
    
    Rectangle Grass = new Rectangle( 150, 200, 550, 300); //Grass
    g.setColor( Color.green );
    g.fillRect( 150, 200, 550, 300 ); // grass
    g2.draw(Grass);
    
    
    g.setColor( Color.yellow );
    g.drawRect( 100, 150, 650, 400 ); // Mid-lane marker INCREASE
    
    StartLine = new Line2D.Double (425, 500, 425, 600); //Start line
    g2.setColor( Color.white );
    //g2.setStroke(new BasicStroke(10));
    g2.draw(StartLine);
    
    //g2.drawLine( 425, 500, 425, 600 ); // start line INCREASE AND SET LAP
     
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
    
    player1.checkEnvironmentCollision();
    player2.checkEnvironmentCollision();
    
	 repaint(); //repaint window every 10 milliseconds
 }
 

 
 public static Player1 getPlayer1(){
    return player1;
 }
 
 public static Player2 getPlayer2(){
    return player2;
 }
 
 public static Rectangle getOuterEdge(){
     return new Rectangle(50, 100, 750, 500);
 }
 
 public static Rectangle getInnerEdge(){
    return new Rectangle(150, 200, 550, 300);
 }
 
}
