package beans;

public class Mao {
	private Carta[] cartas;

	public Mao(Carta[] mao) {
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

	// METODO QUE RETORNA A CARTA DE MAIOR VALOR DA MAO
	public Carta cartaAlta(Mao mao) {
		int i = 0;
		return mao.getCartas()[i];
	}

	// METODO QUE VERIFICA SE A MAO POSSUI UM PAR, DUAS CARTAS COM MESMO VALOR
	public boolean umPar(Mao mao) {
		boolean teste = false;
		// ACHO QUE É IMPPORTANTE TIRAR O PAR DO VETOR SE EXISTIR E ARMAZENAR ESSE VALOR NUMA VARIAVEL GLOBAL 
		//PARA OS OUTROS TESTES NOS OUTROS METODOS
		for(int i = 0; i < mao.getCartas().length - 1; i++) {
			for(int j = i+1; j < mao.getCartas().length; j++) {
				if(mao.getCartas()[i].getNumero() == mao.getCartas()[j].getNumero()) {
					
					teste = true;
					break;
				}
			}
			//FALTA O CODIGO QUE RETIRA ESSE PAR DO VETOR E ARMAZENA O VALOR
		}
		return teste;
	}
	
	// METODO QUE VERIFICA SE A MAO POSSUI DOIS PARES
	public boolean doisPares(Mao mao) {
		boolean teste = false;
		if(umPar(mao) == true) {
			//VALORES DIFERENTES
			teste = true;
		}
		return teste;
	}
	
	// METODO QUE VERIFICA SE A MAO POSSUI UMA QUADRA
	public boolean quadra(Mao mao) {
		boolean teste = false;
		if(umPar(mao) == true) {
			//VALORES IGUAIS
			teste = true;
		}
		return teste;
	}
	
	// METODO QUE VERIFICA SE A MAO POSSUI UMA TRINCA
		public boolean trinca(Mao mao) {
			boolean teste = false;
			if(umPar(mao) == false) {
				//VERIFICA SE A MAO POSSUI TRÊS CARTAS COM O MESMO VALOR 
				teste = true;
			}
			return teste;
		}
	
	// METODO QUE VERIFICA SE A MAO POSSUI UM FULL HOUSE
	public boolean fullHouse(Mao mao) {
		boolean teste = false;
		if(umPar(mao) == true) {
			//SE EXISTE UM PAR, VERIFICA SE O RESTANTE DAS CARTAS FORMAM UMA TRINCA
			teste = true;
		}
		return teste;
	}
	
	// METODO QUE VERIFICA SE A MAO POSSUI UMA SEQUENCIA COM 5 VALORES CONSECUTIVOS
	public boolean sequenciaStraight(Mao mao) {
		boolean teste = false;
		if((umPar(mao) == false && doisPares(mao)  == false) && (fullHouse(mao) == false && quadra(mao) == false)){
			//VERIFICA SE AS CINCO CARTAS TEM VALORES CONSECUTIVOS, AQUI ACHO QUE SE DEVE USAR ENUM QUEM SOUBER USAR
			//PARA TENTAR COMPARAR COMO SE FOSSEM INTEIROS, UM MAIOR QUE O OUTRO E TAL...
			teste = true;
		}
		return teste;
	}
	
	// METODO QUE VERIFICA SE A MAO POSSUI AS CINCO CARTAS COM O MESMO NIPE
	public boolean flush(Mao mao) {
		boolean teste = false;
		for(int i = 0; i < mao.getCartas().length - 1; i++) {
			for(int j = i+1; j < mao.getCartas().length; j++) {
				if(mao.getCartas()[i].getNipe() == mao.getCartas()[j].getNipe()) {
					teste = true;
				}
			}
		}
		return teste;
	}
	
	//METODO QUE VERIFICA SE A MAO POSSUI AS CINCO CARTAS COM O MESMO NIPE E COM VALORES CONSECUTIVOS
	public boolean straightFlush(Mao mao) {
		boolean teste = false;
		if(sequenciaStraight(mao) == true && flush(mao) == true) {
			teste = true;
		}
		return teste;
	}
	
	// METODO QUE VERIFICA SE É UM ROYAL FLASH
	public boolean royalFlash(Mao mao) {
		boolean teste = false;
		if(flush(mao) == true) { // FALTA A CONDIÇÃO PARA VER SE TEM 10, Valete, Dama, Rei e Ás
			teste = true;
		}
		return teste;
	}
}
