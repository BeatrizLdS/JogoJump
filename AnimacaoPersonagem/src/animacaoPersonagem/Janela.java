package animacaoPersonagem;

import javax.swing.JFrame;

public class Janela {

	public static void main(String[] args) {
		
		JFrame janela = new JFrame("Personagem 2D");
		janela.pack();                                          //centraliza a tela
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setResizable(false);
		janela.setSize(1000, 230);
		janela.setLocationRelativeTo(null);						//centraliza a tela
		
		Canvas canvas = new Canvas();
		canvas.setVisible(true);
		janela.add(canvas);
		
		janela.addKeyListener(canvas);
		
		janela.setVisible(true);

	}

}
