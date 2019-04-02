import java.awt.event.*;

public class KeyAdaptPlayer2 extends KeyAdapter{
   
   Player2 p2;

   public KeyAdaptPlayer2(Player2 player2){
      p2 = player2;

   }
   
   public void keyPressed(KeyEvent e){//CREATE SEPERATE KEY EVENTS
       p2.keyPressed(e);

   }
   
   public void keyReleased(KeyEvent e){
       p2.keyReleased(e); 
   }
   
}