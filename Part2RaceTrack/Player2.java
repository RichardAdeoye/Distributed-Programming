import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Player2 extends Players {

   double velocityX = 0, velocityY = 0;
   double speed = 2;//improve speed and add speed bumbs and dips
   boolean collisionStatus;
   public Player2(int x, int y) {
       super(x, y);
   }
   
   public void update(){
      y += velocityY;
      x += velocityX;
   }
  
   public void draw(Graphics2D icon2d) {
   
      icon2d.drawImage(getPlayer2Icon(), x, y, null);
   }
   
 public Image getPlayer2Icon() {
    
     ImageIcon currentIcon = new ImageIcon("BlueKart/BFrame13.png");
    
      if(velocityY == -speed){
          ImageIcon blueKartIcon = new ImageIcon("BlueKart/BFrame1.png");
          return blueKartIcon.getImage();
          
      } else if(velocityY == speed) { 
          ImageIcon blueKartIcon = new ImageIcon("BlueKart/BFrame9.png");
          return blueKartIcon.getImage();
          
      } else if(velocityX == -speed){
         ImageIcon blueKartIcon = new ImageIcon("BlueKart/BFrame5.png");
         return blueKartIcon.getImage();
          
      } else if(velocityX == speed) {
         ImageIcon blueKartIcon = new ImageIcon("BlueKart/BFrame13.png");
         return blueKartIcon.getImage();
      }
     
     return currentIcon.getImage();
   }
   
    public void keyPressed(KeyEvent e){
    int key = e.getKeyCode();
      
      Rectangle innerEdge = RacingGame.getInnerEdge();
      Rectangle outerEdge = RacingGame.getOuterEdge();
      
      if(key == KeyEvent.VK_UP){
      
        if(collisionStatus == true)
         velocityY  = velocityY + 3;
         else
         velocityY = -speed;
         
         if(getBounds().getY() < outerEdge.getBounds().getY())
         velocityY  = velocityY + 3;
         
         if(getBounds().intersects(innerEdge.getBounds()))
         velocityY  = velocityY + 6;

        
      } else if(key == KeyEvent.VK_DOWN){
      
         if(collisionStatus == true)
         velocityY = velocityY - 3;
         else
         velocityY = speed;
         
         if(getBounds().getY() > 850)
         velocityY  = velocityY - 3;
         
         if(getBounds().intersects(innerEdge.getBounds()))
         velocityY  = velocityY - 6;
         
      } else if(key == KeyEvent.VK_LEFT){
         
         if(collisionStatus == true)
         velocityX = velocityY + 3;
         else
         velocityX = -speed;
         
         if(getBounds().getX() < outerEdge.getBounds().getX())
         velocityX  = velocityX + 3;
         
         if(getBounds().intersects(innerEdge.getBounds()))
         velocityX  = velocityX + 6;
         
      } else if(key == KeyEvent.VK_RIGHT){
      
         if(collisionStatus == true)
         velocityX = velocityY - 3;
         else
         velocityX = speed;
         
         if(getBounds().getX() > 1000)
         velocityX  = velocityX - 3;
         
         if(getBounds().intersects(innerEdge.getBounds()))
         velocityX  = velocityX - 6;
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
   
     public boolean checkCollision(){
     Player1 player1 = RacingGame.getPlayer1();
     if(getBounds().intersects(player1.getBounds())){
        return collisionStatus = true;
     }
        return collisionStatus = false;
   }  
   
   
   public Rectangle getBounds() {
   return new Rectangle(x, y, getPlayer2Icon().getWidth(null), getPlayer2Icon().getHeight(null));
   }
   
}