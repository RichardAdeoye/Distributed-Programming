import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Player2 extends Players {

   int velocityX = 0, velocityY = 0;

   public Player2(int x, int y) {
       super(x, y);
   }
   
   public void update(){
      y += velocityY;
      x += velocityX;
   }
  
   public void draw(Graphics2D icon2d) {
   
      icon2d.drawImage(getPlayerIcon(), x, y, null);
  
   }
   
   public Image getPlayerIcon() {
   
     ImageIcon blueKartIcon = new ImageIcon("BlueKart/BFrame13.png");
     return blueKartIcon.getImage();
     
   }
   
    public void keyPressed(KeyEvent e){
      int key = e.getKeyCode();
      
      if(key == KeyEvent.VK_UP){
         velocityY = -2;
      } else if(key == KeyEvent.VK_DOWN){
         velocityY = 2;
      } else if(key == KeyEvent.VK_LEFT){
         velocityX = -2;
      } else if(key == KeyEvent.VK_RIGHT){
         velocityX = 2;
      }
   }
   
   public void keyReleased(KeyEvent e){
      int key = e.getKeyCode();
      
         if(key == KeyEvent.VK_UP){
         velocityY = 0;
      } else if(key == KeyEvent.VK_DOWN){
         velocityY = 0;
      } else if(key == KeyEvent.VK_LEFT){
         velocityX = 0;
      } else if(key == KeyEvent.VK_RIGHT){
         velocityX = 0;
      }
   }

}