package versao3;

//import paradigmas.Mao;

public class Jogador {
	private Mao mao;
	//private int vitorias;
	private boolean royalFlush;
	private boolean strFlush;
	private boolean flush;
	private boolean quadra;
	private boolean trinca;
	private boolean par;
	private boolean fullHouse;
	private boolean doisPares;
	private boolean straight;
	private boolean cartaAlta;
	
	

	public Jogador(Mao mao) {
		this.mao = mao;
		//this.setVitorias(vitorias);
		this.royalFlush = false;
		this.strFlush =false;
		this.flush = false;
		this.quadra = false;
		this.trinca = false;
		this.par = false;
		this.fullHouse = false;
		this.doisPares = false;
		this.straight = false;
		this.cartaAlta = false;
	}

	public Mao getMao() {
		return mao;
	}

	public void setMao(Mao mao) {
		this.mao = mao;
	}

//	public int getVitorias() {
//		return vitorias;
//	}
//
//	public void setVitorias(int vitorias) {
//		this.vitorias = vitorias;
//	}

	public boolean isRoyalFlush() {
		return royalFlush;
	}

	public void setRoyalFlush(boolean royalFlush) {
		this.royalFlush = royalFlush;
	}

	public boolean isStrFlush() {
		return strFlush;
	}

	public void setStrFlush(boolean strFlush) {
		this.strFlush = strFlush;
	}

	public boolean isFlush() {
		return flush;
	}

	public void setFlush(boolean flush) {
		this.flush = flush;
	}

	public boolean isQuadra() {
		return quadra;
	}

	public void setQuadra(boolean quadra) {
		this.quadra = quadra;
	}

	public boolean isTrinca() {
		return trinca;
	}

	public void setTrinca(boolean trinca) {
		this.trinca = trinca;
	}

	public boolean isPar() {
		return par;
	}

	public void setPar(boolean par) {
		this.par = par;
	}

	public boolean isFullHouse() {
		return fullHouse;
	}

	public void setFullHouse(boolean fullHouse) {
		this.fullHouse = fullHouse;
	}

	public boolean isDoisPares() {
		return doisPares;
	}

	public void setDoisPares(boolean doisPares) {
		this.doisPares = doisPares;
	}

	public boolean isStraight() {
		return straight;
	}

	public void setStraight(boolean straight) {
		this.straight = straight;
	}

	public boolean isCartaAlta() {
		return cartaAlta;
	}

	public void setCartaAlta(boolean cartaAlta) {
		this.cartaAlta = cartaAlta;
	}
	
}

