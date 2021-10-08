package animacaoBasica;

import java.util.TimerTask;

public class AnimaTask extends TimerTask{

	private MeuCanvas componente;
	
	public AnimaTask(MeuCanvas componente) {
		super();
		this.componente = componente;
	}

	@Override
	public void run() {
		componente.atualiza();
		componente.repaint();
		componente.getToolkit().sync();
		
	}

	
	
}
