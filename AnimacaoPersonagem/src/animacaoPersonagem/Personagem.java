package animacaoPersonagem;

import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;

public class Personagem {
	
	private BufferedImage cicloCorrida[];
	private BufferedImage cicloParado [];
	private BufferedImage cicloPulo[];
	
	private int indiceImagemAtual = 0;
	private int timer = 0;               // usado p controlar a quantidade de frames
	
	private int largura = 80;
	private int altura = 80;
	private int x;
	private int y;
	private int velocidade;
	private int numeroDeFrames= 4;
	
	private int ultimaDirecao;
	private int direcao;
	private boolean pulando;
	
	public Personagem() {
		
		cicloCorrida = new BufferedImage[15];
		cicloParado = new BufferedImage[15];
		cicloPulo = new BufferedImage[15];
		velocidade = 3;
		direcao = 0;
		ultimaDirecao = 1; 
		x = 0;
		y = 50;
		pulando = false;
		
		String image;
		
		//CARREGA IMAGENS PERSONAGEM ANDANDO
		for (int i=0; i<15; i++) {  //carrega as imagens da corrida
			
			try {
				image = "imagem/Walk ("+ (i+1)+").png";
				//System.out.println("Carregou imagem: "+ image);
				cicloCorrida[i] = ImageIO.read(new File(image));
			} catch (IOException e) {
				System.out.println("Não foi possível carregar a imagem");
				e.printStackTrace();
			}
			
		}
		
		
		//CARREGA IMAGENS PERSONAGEM PARADO
		for (int i=0; i<15; i++) {  //carrega as imagens da parada
			
			try {
				image = "imagem/Idle ("+ (i+1)+").png";
				//System.out.println("Carregou imagem: "+ image);
				cicloParado[i] = ImageIO.read(new File(image));
			} catch (IOException e) {
				System.out.println("Não foi possível carregar a imagem");
				e.printStackTrace();
			}
			
		}
		
		
		//CARREGA IMAGENS PERSONAGEM PULANDO
		for (int i=0; i<15; i++) {  //carrega as imagens do pulo
					
			try {
				image = "imagem/Jump ("+ (i+1)+").png";
				//System.out.println("Carregou imagem: "+ image);
				cicloPulo[i] = ImageIO.read(new File(image));
				} catch (IOException e) {
				System.out.println("Não foi possível carregar a imagem");
					e.printStackTrace();
			}
					
		}
		
	}
	
	public void atualizar() {
		
		timer++;
		if (pulando) {
			
			if (timer >= numeroDeFrames) {      //troca a imagem a cada 3 frames
				indiceImagemAtual ++;
				if (indiceImagemAtual == 15) { //troca as imagens
					indiceImagemAtual = 0;
					pulando = false;
				}
				
				timer = 0;
			}
			if(indiceImagemAtual < 6) {
				y -= 2;
			}else if(indiceImagemAtual > 8){
				y += 2;
			}
			
				
		}else {
		
			if (timer >= numeroDeFrames) {      //troca a imagem a cada 3 frames
				indiceImagemAtual ++;
				if (indiceImagemAtual == 15) { //troca as imagens
					indiceImagemAtual = 0;
				}
				
				timer = 0;
				
				//movimento automático
				//if (x<940) {
				//	x++;
				//}
				//else if (x == 940 && y < 620) {
				//	y++;
				//}
				
			}
		}
			
		if (direcao == 1) {
			x += velocidade;
		}else if (direcao == -1) {
			x -= velocidade;
		}
			
		
	}
	
	public void pintar(Graphics2D g) {
		//System.out.println("pintando imagens!");
		if (pulando) {
			if (ultimaDirecao == 1) {
				g.drawImage(
						cicloPulo[indiceImagemAtual], //a imagem
						x, y,                            //posicao x e y da imagem
						x + largura, y + altura,     	 //posicao + tamanho da imagem
						0, 0,							 //canto da imagem original
						cicloCorrida[indiceImagemAtual].getWidth(), cicloCorrida[indiceImagemAtual].getHeight(),//tamanho da imagem original
						null);
			}else if (ultimaDirecao == -1) {
				g.drawImage(
						cicloPulo[indiceImagemAtual], //a imagem
						x, y,                            //posicao x e y da imagem
						x + largura, y + altura,     	 //posicao + tamanho da imagem
						cicloCorrida[indiceImagemAtual].getWidth(), 0,							 //canto da imagem original
						0, cicloCorrida[indiceImagemAtual].getHeight(),//tamanho da imagem original
						null);
			}
			
		}else if (ultimaDirecao == 1) {
			if (direcao == 0) {
				numeroDeFrames = 4;
				g.drawImage(
						cicloParado[indiceImagemAtual], //a imagem
						x, y,                            //posicao x e y da imagem
						x + largura, y + altura,     	 //posicao + tamanho da imagem
						0, 0,							 //canto da imagem original
						cicloCorrida[indiceImagemAtual].getWidth(), cicloCorrida[indiceImagemAtual].getHeight(),//tamanho da imagem original
						null);
			}else {
				numeroDeFrames = 2;
				g.drawImage(
						cicloCorrida[indiceImagemAtual], //a imagem
						x, y,                            //posicao x e y da imagem
						x + largura, y + altura,     	 //posicao + tamanho da imagem
						0, 0,							 //canto da imagem original
						cicloCorrida[indiceImagemAtual].getWidth(), cicloCorrida[indiceImagemAtual].getHeight(),//tamanho da imagem original
						null);
			}
			
		}else if (ultimaDirecao == -1) {
			if (direcao == 0) {
				numeroDeFrames = 4;
				g.drawImage(
						cicloParado[indiceImagemAtual], //a imagem
						x, y,                            //posicao x e y da imagem
						x + largura, y + altura,     	 //posicao + tamanho da imagem
						cicloCorrida[indiceImagemAtual].getWidth(), 0,							 //canto da imagem original
						0, cicloCorrida[indiceImagemAtual].getHeight(),//tamanho da imagem original
						null);
			}else {
				numeroDeFrames = 2;
				g.drawImage(
						cicloCorrida[indiceImagemAtual], //a imagem
						x, y,                            //posicao x e y da imagem
						x + largura, y + altura,     	 //posicao + tamanho da imagem
						cicloCorrida[indiceImagemAtual].getWidth(), 0,							 //canto da imagem original
						0, cicloCorrida[indiceImagemAtual].getHeight(),//tamanho da imagem original
						null);
			}
		}
	}
	
	public void setDirecao(int dir) {
		if (dir != 0) {
			ultimaDirecao = dir;
			this.direcao = dir;
		}else {
			this.direcao = dir;
		}
		
	}
	
	public void iniciaPulo ()  {
		if(!pulando) {
			pulando = true;
			timer = 0;
			numeroDeFrames = 3;
			indiceImagemAtual = 0;
		}
	}
	
}
