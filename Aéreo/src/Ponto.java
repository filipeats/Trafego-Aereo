public class Ponto {
	// Propriedades da classe
	private double x = 0;
	private double y = 0;
	
	// Métodos construtores da classe
	public Ponto() {
		super();
	}

	public Ponto(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	// Métodos get/set da classe
	public final double getX() {
		return x;
	}

	public final void setX(double x) {
		this.x = x;
	}

	public final double getY() {
		return y;
	}

	public final void setY(double y) {
		this.y = y;
	}
}