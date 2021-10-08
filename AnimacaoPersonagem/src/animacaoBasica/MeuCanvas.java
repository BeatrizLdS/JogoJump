package animacaoBasica;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MeuCanvas extends JPanel {
	
	private int x;
	private int y;

	public MeuCanvas () {
		setPreferredSize(new Dimension(200, 100));	
		x = y = 0;
	}
	
	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		g.fillRect(x, y, 10, 10);	
	}
	
	public void atualiza() {
		x++;
		y++;
	}
	
}
