import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Player1 extends Players {

   int velocityX = 0, velocityY = 0;
   
   public Player1(int x, int y) {
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
   
      ImageIcon redKartIcon = new ImageIcon("RedKart/RFrame13.png");
      return redKartIcon.getImage();
     
   }
   
   public void keyPressed(KeyEvent e){
      int key = e.getKeyCode();
      
      if(key == KeyEvent.VK_W){
         velocityY = -2;
      } else if(key == KeyEvent.VK_S){
         velocityY = 2;
      } else if(key == KeyEvent.VK_A){
         velocityX = -2;
      } else if(key == KeyEvent.VK_D){
         velocityX = 2;
      }
   }
   
   public void keyReleased(KeyEvent e){
      int key = e.getKeyCode();
      
         if(key == KeyEvent.VK_W){
         velocityY = 0;
      } else if(key == KeyEvent.VK_S){
         velocityY = 0;
      } else if(key == KeyEvent.VK_A){
         velocityX = 0;
      } else if(key == KeyEvent.VK_D){
         velocityX = 0;
      }
   }
   
}