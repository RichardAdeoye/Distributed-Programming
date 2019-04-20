import javax.swing.JFrame;

public class GameMain {

 static RacingGame game;
 public void LoadGame(RacingGame game) {
 
   this.game = game;
   //player1 = new Player1(370, 700);
	//RacingGame game = new RacingGame(player1);

	JFrame f = new JFrame();
	f.add(game);
	f.setSize(1100, 1000);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);
 }
 
 
}
