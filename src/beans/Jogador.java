package beans;

public class Jogador {
	private Mao mao;
	private int vitorias;

	public Jogador(Mao mao, int vitorias) {
		this.mao = mao;
		this.setVitorias(vitorias);
	}

	public Mao getMao() {
		return mao;
	}

	public void setMao(Mao mao) {
		this.mao = mao;
	}

	public int getVitorias() {
		return vitorias;
	}

	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}

}
