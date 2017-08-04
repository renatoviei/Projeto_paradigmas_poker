package beans;

public class Mao {
	private Carta[] cartas;
	
	public Mao (Carta[] mao){
		this.setCartas(mao);
	}

	public Carta[] getCartas() {
		return cartas;
	}

	public void setCartas(Carta[] mao) {
		if (mao.length == 5)
			this.cartas = mao;
		else
			System.out.println("TAMANHO DA MAO MAIOR QUE 5");
	}
}
