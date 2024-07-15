import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Janela extends JFrame {
	// Propriedades da classe
	private static final long serialVersionUID = 1L;
	private HashMap<String, String> aeroportos = new HashMap<String, String>();
	private ArrayList<Rota> colecaoDeRotas = new ArrayList<Rota>();
	private Painel objPainel = new Painel(colecaoDeRotas);
	
	// Método principal de execução da classe
	public static void main(String[] args) {
		new Janela().setVisible(true);
	}
	
	// Método construtor da classe
	public Janela() {
		// Configuração da janela
		setTitle("Sistema de Controle de Tráfego Aéreo");
		setSize(1280, 1024);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		// Configuração do painel
		setContentPane(objPainel);
		
		// Configuração da posição dos aeroportos
		aeroportos.put("BSB", "390,530");
		aeroportos.put("MIA", "280,390");
		aeroportos.put("JFK", "300,350");
		aeroportos.put("CDG", "590,300");
		aeroportos.put("GRU", "410,560");
		aeroportos.put("LIS", "550,330");
		aeroportos.put("DXB", "780,380");
		aeroportos.put("HAN", "1080,365");
		aeroportos.put("KIM", "690,580");
		aeroportos.put("SYD", "1100,600");
		
		// Leitura do arquivo de rotas
		try {
			BufferedReader leitor = new BufferedReader(new FileReader("rotas.txt"));
			String linha = "";
			while ((linha = leitor.readLine()) != null) {
				String posicaoAeroportoOrigem = aeroportos.get(linha.split(",")[0]);
				String posicaoAeroportoDestino = aeroportos.get(linha.split(",")[1]);
				
		        colecaoDeRotas.add(
		        	new Rota(
		        		new Ponto(Double.parseDouble(posicaoAeroportoOrigem.split(",")[0]),
		        				  Double.parseDouble(posicaoAeroportoOrigem.split(",")[1])),
		        		new Ponto(Double.parseDouble(posicaoAeroportoDestino.split(",")[0]),
		        				  Double.parseDouble(posicaoAeroportoDestino.split(",")[1])),
		        		new Ponto(Double.parseDouble(posicaoAeroportoOrigem.split(",")[0]) - 5,
		        				  Double.parseDouble(posicaoAeroportoOrigem.split(",")[1]) - 5)));
			}
			leitor.close();
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
		}
		
		// Configuração da Thread
		new Voo(objPainel, colecaoDeRotas).start();
	}
}
