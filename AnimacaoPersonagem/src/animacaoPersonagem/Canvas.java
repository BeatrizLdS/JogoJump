package animacaoPersonagem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class Canvas extends JPanel implements Runnable, KeyListener{   //classe que desenha

	private Personagem p1;
	
	/**
	 GAMELOOP:
	 -atualiza
	 -pinta
	 -dorme 
	**/
	
	public Canvas () {
		p1 = new Personagem();
		Thread gameloop = new Thread(this);
		gameloop.start();
		
	}
	
	@Override
	public void run () {   //isso é uma thread
		while(true) {
			//atualiza
			atualiza();
			
			//pinta
			repaint();  //chama o paintComponent
			
			//dorme
			dorme();
		}
	}
	
	private void atualiza() {
		//atualiza o estado do jogo
		p1.atualizar();
	}
	
	private void dorme(){
		try {
			Thread.sleep(16);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void paintComponent (Graphics g2) {  //metodo coloca algo na tela para printar
		super.paintComponent(g2);  //limpa tela sempre que essa função for chamada
		
		Graphics2D g = (Graphics2D) g2.create();
		
		//desenha o fundo branco
		g.setColor(Color.white);
		g.fillRect(0, 0, 1000, 230);
		
		g.setColor(new Color(0, 160, 0));
		g.fillRect(0, 121, 1000, 230);
		
		//desenha o personagem
		p1.pintar(g);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_D) {  //vai para a direita
			
			p1.setDirecao(1);
			
		} else if (e.getKeyCode() == KeyEvent.VK_A) { //esuqerda
			
			p1.setDirecao(-1);
			
		} else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			
			p1.iniciaPulo();
			
		} else if(e.getKeyCode() == KeyEvent.VK_SHIFT) {
			
			p1.morra();
			
		}
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_A) { 
			
			p1.setDirecao(0);
			
		}
		
	}
	
}
