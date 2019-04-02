import java.awt.event.*;

public class KeyAdaptPlayer1 extends KeyAdapter{
   
   Player1 p1;

   public KeyAdaptPlayer1(Player1 player1){
      p1 = player1;

   }
   
   public void keyPressed(KeyEvent e){//CREATE SEPERATE KEY EVENTS
       p1.keyPressed(e);

   }
   
   public void keyReleased(KeyEvent e){
       p1.keyReleased(e); 
   }
   
}