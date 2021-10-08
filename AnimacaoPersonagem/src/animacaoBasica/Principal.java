package animacaoBasica;

import java.util.Timer;

import javax.swing.JFrame;

public class Principal {

	public static void main(String[] args) {
		JFrame janela = new JFrame("Animação");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//janela.setSize(500 , 500);
		
		
		MeuCanvas mc = new MeuCanvas();
		janela.add(mc);
		
		janela.pack();
		janela.setVisible(true);
		
		Timer umTimer = new Timer();
		AnimaTask meuLoop = new AnimaTask(mc);
		umTimer.scheduleAtFixedRate(meuLoop, 0, 25);;
		
	}

}
