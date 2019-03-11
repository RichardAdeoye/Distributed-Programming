import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class goKart extends JPanel implements ActionListener{
private ImageIcon imageArray[];
private Timer animator;
private int delay = 70, totalFrames = 15, currentFrame = 0;

 public goKart() {
	imageArray = new ImageIcon[totalFrames];
	for(int i = 0; i < imageArray.length; i++) {
		imageArray[i] = new ImageIcon("RFrame" + i + ".png");
	}
	
	animator = new Timer(delay,this);
	animator.start();
 }
 
 public void paintComponent(Graphics g) {
	 super.paintComponent(g);
	 if(currentFrame >= imageArray.length) {
		 currentFrame = 0;
	 }
	 currentFrame++;
	 imageArray[currentFrame].paintIcon(this, g, 150, 150);
 }
 
 public void actionPerformed(ActionEvent e) {
	 repaint();
 }
}
