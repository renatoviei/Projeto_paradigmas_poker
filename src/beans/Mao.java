package beans;

public class Mao {
	private Carta[] mao;
	
	public Mao (){
		mao = new Carta[5];
	}

	public Carta[] getMao() {
		return mao;
	}

	public void setMao(Carta[] mao) {
		this.mao = mao;
	}
}
