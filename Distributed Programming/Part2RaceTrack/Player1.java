import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Player1 extends Players {

   double velocityX = 0, velocityY = 0;
   double speed = 2;
   double deceleration = -0.5;//improve speed
   boolean collisionStatus;
   
   public Player1(int x, int y) {
      super(x, y);
   }
   
   public void update(){
     y += velocityY;
     x += velocityX;
   }
  
   public void draw(Graphics2D icon2d) {
      
      //boolean collisionStatus = RacingGame.getCollisionStatus();
      icon2d.drawImage(getPlayer1Icon(), x, y, null);
      
      if(collisionStatus == true){
        icon2d.drawString("COLLISION", 500, 600);
      }
          //g2.drawString("COLLISION", 500, 600);
      icon2d.draw(getBounds());
   }
   
   public Image getPlayer1Icon() {
   
      ImageIcon redKartIcon = new ImageIcon("RedKart/RFrame13.png");
      return redKartIcon.getImage();
     
   }
  
   public void keyPressed(KeyEvent e){
   
      //boolean collisionStatus = RacingGame.getCollisionStatus();
      int key = e.getKeyCode();
      
      if(key == KeyEvent.VK_W){
      
        if(collisionStatus == true)
         velocityY  = 1;
         else
         velocityY = -speed;
         
      } else if(key == KeyEvent.VK_S){
      
         if(collisionStatus == true)
         velocityY = 1;
         else
         velocityY = speed;
         
      } else if(key == KeyEvent.VK_A){
         
         if(collisionStatus == true)
         velocityX = 1;
         else
         velocityX = -speed;
         
      } else if(key == KeyEvent.VK_D){
      
         if(collisionStatus == true)
         velocityX = 1;
         else
         velocityX = speed;
         
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
   
   public boolean checkCollision(){
     Player2 player2 = RacingGame.getPlayer2();
     if(getBounds().intersects(player2.getBounds())){
        return collisionStatus = true;
     }
        return collisionStatus = false;
   }    
   
   public Rectangle getBounds(){
      return new Rectangle(x, y + 10, getPlayer1Icon().getWidth(null), 30);//collision
   }
}