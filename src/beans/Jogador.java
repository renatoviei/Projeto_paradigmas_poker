package beans;

public class Jogador {
	private Mao mao;
	
	public Jogador(Mao mao){
		this.mao = mao;
	}

	public Mao getMao() {
		return mao;
	}

	public void setMao(Mao mao) {
		this.mao = mao;
	}
}
