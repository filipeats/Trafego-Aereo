import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Painel extends JPanel {
	// Propriedades da classe
	private static final long serialVersionUID = 1L;
	private ArrayList<Rota> colecaoDeRotas = null;
	
	// Método construtor cheio da classe
	public Painel(ArrayList<Rota> colecaoDeRotas) {
		super();
		this.colecaoDeRotas = colecaoDeRotas;
	}

	// Método sobrescrito da classe
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.black);
		
		g.drawImage(new ImageIcon("mapa.jpg").getImage(), 0, 0, 1280, 1024, null);
		
		for (Rota objRota : colecaoDeRotas) {
			// Aeroporto origem
			g.fillOval((int) objRota.getAeroportoOrigem().getX(),
					   (int) objRota.getAeroportoOrigem().getY(), 20, 20);
			
			// Aeroporto destino
			g.fillOval((int) objRota.getAeroportoDestino().getX(),
					   (int) objRota.getAeroportoDestino().getY(), 20, 20);
			
			// Rota
			g.drawLine((int) objRota.getAeroportoOrigem().getX() + 10,
					   (int) objRota.getAeroportoOrigem().getY() + 10,
					   (int) objRota.getAeroportoDestino().getX() + 10,
					   (int) objRota.getAeroportoDestino().getY() + 10);
			
			// Aviao
			g.drawImage(new ImageIcon("aviao.png").getImage(),
					    (int) objRota.getAviao().getX(),
					    (int) objRota.getAviao().getY(),
					   30, 30, null);
		}
	}
}