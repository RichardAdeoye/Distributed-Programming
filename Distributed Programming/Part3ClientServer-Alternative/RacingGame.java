import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.awt.geom.AffineTransform;
public class RacingGame extends JPanel implements ActionListener{

  Timer racingGameTimer;
  static Player1 player1;
  static Player2 player2;
  
  static Rectangle OuterEdge;
  static Rectangle InnerEdge;
  
  static Player1 playerData;
  
  static Line2D  StartLine;
  
 public RacingGame(Player1 player1, Player2 player2){ // make this take in a colour
 
    setFocusable(true);
    //if client loaded add player
    this.player1 = player1;
    this.player2 = player2;
   
    //player2 = new Player1(370, 820);
   
    addKeyListener(new KeyAdaptPlayer1(player1));
    addKeyListener(new KeyAdaptPlayer2(player2));
    
    racingGameTimer = new Timer(10,this);//How many millisecond timer should run
    racingGameTimer.start();
 
 }
 public void paintComponent(Graphics g) {
 
	 super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
  
   
    Color c2 = Color.black;
    OuterEdge = new Rectangle( 40, 100, 1000, 800); // Outer edge
    g.setColor( c2 );
    g2.draw(OuterEdge);
    g.setColor( Color.gray );
    g.fillRect( 40, 100, 1000, 800 ); 
    
    InnerEdge = new Rectangle( 260, 350, 550, 300); // Inner edge INCREASE THEN ADD COLLISIONS
    g.setColor( c2 );
    g2.draw(InnerEdge);
    
    Rectangle Grass = new Rectangle( 260, 350, 550, 300); //Grass
    g.setColor( Color.green );
    g.fillRect( 260, 350, 550, 300 ); // grass
    g2.draw(Grass);
    
   
    
    StartLine = new Line2D.Double (435, 900, 435, 650); //Start line
    g2.setColor( Color.white );
    g2.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0));
    g2.draw(StartLine);
     
    g2.setColor( Color.yellow );
    g2.drawRect( 155, 220, 765, 565 ); // Mid-lane marker INCREASE
    //g2.drawLine( 425, 500, 425, 600 ); // start line INCREASE AND SET LAP
     
    player1.draw(g2);
    player2.draw(g2);
    

       
   
 }

 public void actionPerformed(ActionEvent e) {
 
    player1.update();
    //playerData = getPlayer1(player1);
    //System.out.println("X: " + playerData.getBounds().getX() + "| Y:"+playerData.getBounds().getY());
    player2.update();
    //collision();
    //player1.checkCollision();
    //player2.checkCollision();
   
 
    
	 repaint(); //repaint window every 10 milliseconds
 }
 
 

 public static Player1 getPlayer1(Player1 player1 ){
    player1 = player1;
    return player1;
 }
 
  //public static Player1 getPlayerData(Player1 player1 ){
   // player1 = player1;
   // return player1;
 //}
 
 //public static Player1 getPlayer2(){
    //return player2;
 //}
 
 public static Rectangle getOuterEdge(){
     return new Rectangle(40, 100, 1000, 800);
 }
 
 public static Rectangle getInnerEdge(){
    return new Rectangle(260, 350, 550, 300);
 }
 
}
