package beans;

public class Poker {
	private Jogador jogador1;
	private Jogador jogador2;
	
	public Poker (Jogador j1, Jogador j2) {
		this.jogador1 = j1;
		this.jogador2 = j2;
	}

	public Jogador getJogador1() {
		return jogador1;
	}

	public void setJogador1(Jogador jogador1) {
		this.jogador1 = jogador1;
	}

	public Jogador getJogador2() {
		return jogador2;
	}

	public void setJogador2(Jogador jogador2) {
		this.jogador2 = jogador2;
	}
}
