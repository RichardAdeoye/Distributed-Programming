import javax.swing.JFrame;

public class goKartFrame {
public static void main(String args[]) {
	goKart kart = new goKart();
	JFrame f = new JFrame();
	f.add(kart);
	f.setSize(400, 400);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);
}
}
