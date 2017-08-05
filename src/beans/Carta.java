package beans;

public class Carta {
	private char numero;
	private char nipe;
	private int peso;

	public Carta(char numero, char nipe, int peso) {
		this.numero = numero;
		this.nipe = nipe;
		this.setPeso(peso);
	}

	public char getNumero() {
		return numero;
	}

	public void setNumero(char numero) {
		this.numero = numero;
	}

	public char getNipe() {
		return nipe;
	}

	public void setNipe(char nipe) {
		this.nipe = nipe;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public void atribuirPeso(Carta carta) {
		if (carta.getNumero() == '2') {
			this.setPeso(1);
		} else if (carta.getNumero() == '3') {
			this.setPeso(2);
		} else if (carta.getNumero() == '4') {
			this.setPeso(3);
		} else if (carta.getNumero() == '5') {
			this.setPeso(4);
		} else if (carta.getNumero() == '6') {
			this.setPeso(5);
		} else if (carta.getNumero() == '7') {
			this.setPeso(6);
		} else if (carta.getNumero() == '8') {
			this.setPeso(7);
		} else if (carta.getNumero() == '9') {
			this.setPeso(8);
		} else if (carta.getNumero() == 'T') {
			this.setPeso(9);
		} else if (carta.getNumero() == 'J') {
			this.setPeso(10);
		} else if (carta.getNumero() == 'Q') {
			this.setPeso(11);
		} else if (carta.getNumero() == 'K') {
			this.setPeso(12);
		} else if (carta.getNumero() == 'A') {
			this.setPeso(13);
		}

	}
}
