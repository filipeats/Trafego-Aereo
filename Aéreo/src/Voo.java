import java.util.ArrayList;

public class Voo extends Thread {
	// Propriedades da classe
	private Painel objPainel = null;
	private ArrayList<Rota> colecaoDeRotas = null;
	
	// Método construtor cheio da classe
	public Voo(Painel objPainel, ArrayList<Rota> colecaoDeRotas) {
		super();
		this.objPainel = objPainel;
		this.colecaoDeRotas = colecaoDeRotas;
	}
	
	// Método de execução paralela da classe
	public void run() {
		while (true) {
			for (Rota objRota : colecaoDeRotas) {
				// Descoberta do sentido
				boolean esquerda = (objRota.getAeroportoDestino().getX() -
								    objRota.getAeroportoOrigem().getX() > 0);
				
				// Deslocamento eixo X
				if (esquerda) {
					if (objRota.getAviao().getX() < objRota.getAeroportoDestino().getX()) {
						objRota.getAviao().setX(objRota.getAviao().getX() + 1);
					}
				} else {
					if (objRota.getAviao().getX() > objRota.getAeroportoDestino().getX()) {
						objRota.getAviao().setX(objRota.getAviao().getX() - 1);
					}
				}
				
				// Deslocamento eixo Y
				double m = ((objRota.getAeroportoDestino().getY() - objRota.getAeroportoOrigem().getY()) /
							(objRota.getAeroportoDestino().getX() - objRota.getAeroportoOrigem().getX()));
				objRota.getAviao().setY(m * (objRota.getAviao().getX() -
											 objRota.getAeroportoDestino().getX()) +
										objRota.getAeroportoDestino().getY()); 
			}
			
			objPainel.repaint();
			
			try {sleep(30);} catch (Exception e) {}
		}
	}
}