package beans;

public class Carta {
	private char numero;
	private char nipe;
	
	public Carta (char numero, char nipe){
		this.numero = numero;
		this.nipe = nipe;
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

}
