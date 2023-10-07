import java.lang.Thread;

public class main {
	public static void main(String[] args) {
		gameboard g = new gameboard();
		g.init();
		for (int i = 0; i < 100; i++) {
			System.out.println("n." + (i+1));
			g.play();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
