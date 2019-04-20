import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Player1 extends Players {

   double velocityX = 0, velocityY = 0;
   double speed = 2;
   boolean collisionStatus;
   
   public Player1(int x, int y) {
      super(x, y);
   }
   
   public void update(){
     y += velocityY;
     x += velocityX;
   }
   
   public void draw(Graphics2D icon2d) {
      
     
      icon2d.drawImage(getPlayer1Icon(), x, y, null);
      
     // if(collisionStatus == true){
      //  icon2d.drawString("COLLISION! That's Gotta Hurt...", 500, 150); // add sound  
           // System.exit(0); add restart or exit
     // }
      icon2d.draw(getBounds());
   }
   
       
   public Image getPlayer1Icon() {
    
     ImageIcon currentIcon = new ImageIcon("RedKart/RFrame13.png");
    
      if(velocityY == -speed){
          ImageIcon redKartIcon = new ImageIcon("RedKart/RFrame1.png");
          return redKartIcon.getImage();
          
      } else if(velocityY == speed) { 
          ImageIcon redKartIcon = new ImageIcon("RedKart/RFrame9.png");
          return redKartIcon.getImage();
          
      } else if(velocityX == -speed){
         ImageIcon redKartIcon = new ImageIcon("RedKart/RFrame5.png");
         return redKartIcon.getImage();
          
      } else if(velocityX == speed) {
         ImageIcon redKartIcon = new ImageIcon("RedKart/RFrame13.png");
         return redKartIcon.getImage();
      }
     
     return currentIcon.getImage();
   }
  
  
  
   public void keyPressed(KeyEvent e){
   
      int key = e.getKeyCode();
      
      Rectangle innerEdge = RacingGame.getInnerEdge();
      Rectangle outerEdge = RacingGame.getOuterEdge();
      
      if(key == KeyEvent.VK_W){
      
        //if(collisionStatus == true)
        // velocityY  = velocityY + 3;
         //else
         velocityY = -speed;
         
         if(getBounds().getY() < outerEdge.getBounds().getY())
         velocityY  = velocityY + 3;
         
         if(getBounds().intersects(innerEdge.getBounds()))
         velocityY  = velocityY + 6;

        
      } else if(key == KeyEvent.VK_S){
      
        // if(collisionStatus == true)
        // velocityY = velocityY - 3;
        // else
         velocityY = speed;
         
         if(getBounds().getY() > 850)
         velocityY  = velocityY - 3;
         
         if(getBounds().intersects(innerEdge.getBounds()))
         velocityY  = velocityY - 6;
         
      } else if(key == KeyEvent.VK_A){
         
        // if(collisionStatus == true)
         //velocityX = velocityY + 3;
         //else
         velocityX = -speed;
         
         if(getBounds().getX() < outerEdge.getBounds().getX())
         velocityX  = velocityX + 3;
         
         if(getBounds().intersects(innerEdge.getBounds()))
         velocityX  = velocityX + 6;
         
      } else if(key == KeyEvent.VK_D){
      
         //if(collisionStatus == true)
        // velocityX = velocityY - 3;
        // else
         velocityX = speed;
         
         if(getBounds().getX() > 1000)
         velocityX  = velocityX - 3;
         
         if(getBounds().intersects(innerEdge.getBounds()))
         velocityX  = velocityX - 6;
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
   
  // public boolean checkCollision(){
     //Player2 player2 = RacingGame.getPlayer2();
    // if(getBounds().intersects(player2.getBounds())){
      //  return collisionStatus = true;
    // }
      //  return collisionStatus = false;
  // } 
   
       
   public Rectangle getBounds(){
      return new Rectangle(x, y, getPlayer1Icon().getWidth(null), getPlayer1Icon().getHeight(null));
   }
}