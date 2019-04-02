import java.awt.event.*;

public class KeyAdaptPlayer extends KeyAdapter{
   
   Player p;

   public KeyAdaptPlayer(Player player){
      p = player;

   }
   
   public void keyPressed(KeyEvent e){//CREATE SEPERATE KEY EVENTS
       p.keyPressed(e);

   }
   
   public void keyReleased(KeyEvent e){
       p.keyReleased(e); 
   }
   
}