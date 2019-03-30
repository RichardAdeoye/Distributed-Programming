import javax.swing.JFrame;

public class GameMain {

 public static void main(String args[]) {
 
	RacingGame game = new RacingGame();

	JFrame f = new JFrame();
	f.add(game);
	f.setSize(875, 800);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);
 }
 
 
}
