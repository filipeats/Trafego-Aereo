public class Rota {
	// Propriedades da classe
	private Ponto aeroportoOrigem = null;
	private Ponto aeroportoDestino = null;
	private Ponto aviao = null;
	
	// Métodos construtores da classe
	public Rota() {
		super();
	}

	public Rota(Ponto aeroportoOrigem, Ponto aeroportoDestino, Ponto aviao) {
		super();
		this.aeroportoOrigem = aeroportoOrigem;
		this.aeroportoDestino = aeroportoDestino;
		this.aviao = aviao;
	}

	// Métodos get/set da classe
	public final Ponto getAeroportoOrigem() {
		return aeroportoOrigem;
	}

	public final void setAeroportoOrigem(Ponto aeroportoOrigem) {
		this.aeroportoOrigem = aeroportoOrigem;
	}

	public final Ponto getAeroportoDestino() {
		return aeroportoDestino;
	}

	public final void setAeroportoDestino(Ponto aeroportoDestino) {
		this.aeroportoDestino = aeroportoDestino;
	}

	public final Ponto getAviao() {
		return aviao;
	}

	public final void setAviao(Ponto aviao) {
		this.aviao = aviao;
	}
}