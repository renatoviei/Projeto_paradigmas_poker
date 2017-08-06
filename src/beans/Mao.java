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
			System.out.println("TAMANHO DA MAO DIFERENTE DE 5");
	}

	// FUNÇAO QUE RETORNA A MAO ORDENADA DO MENOR VALOR ATE O MAIOR
	public Mao ordena(Mao mao) //ok

	{
		Mao maoAux = mao;
		int atribuiPeso = 0;
		while (atribuiPeso < mao.getCartas().length) {
			maoAux.getCartas()[atribuiPeso].atribuirPeso(maoAux.getCartas()[atribuiPeso]);
			atribuiPeso++;
		}
		int i, j, min;
		Carta x;
		for (i = 0; i < maoAux.getCartas().length - 1; ++i) {
			min = i;
			for (j = i + 1; j < mao.getCartas().length; ++j) {
				if (maoAux.getCartas()[j].getPeso() < maoAux.getCartas()[min].getPeso()) {
					min = j;
					x = maoAux.getCartas()[i];
					maoAux.getCartas()[i] = maoAux.getCartas()[min];
					maoAux.getCartas()[min] = x;

				}
			}
		}
		return maoAux;

	}

	// METODO QUE RETORNA A CARTA DE MAIOR VALOR DA MAO, O INT N É O NUMERO DE VEZES
	// NECESSARIAS QUE O METODO FOI CHAMADO ATE DESEMPATAR O JOGO
	public Carta cartaAlta(Mao mao, int n) {
		//Mao ordenada = ordena(mao);        //NAO PRECISA ESTÁ AQUI... POIS QUANDO O METODO FOR CHAMADO, A MAO JA TEM Q ESTÁ ORDENADA (VAI SER DESPERDICIO DE PROCESSAMENTO)
		Mao ordenada = mao;
		return ordenada.getCartas()[4 - n];
	}

	// METODO QUE VERIFICA SE A MAO POSSUI UM PAR, DUAS CARTAS COM MESMO VALOR
	public boolean umPar(Mao mao) {
		boolean teste = false;
		Mao ordenada = ordena(mao);

		for (int i = 0; i < ordenada.getCartas().length - 1; i++) {
			for (int j = i + 1; j < mao.getCartas().length; j++) {
				if (ordenada.getCartas()[i].getNumero() == ordenada.getCartas()[j].getNumero()) {

					teste = true;
					break;
				}
			}
		}
		return teste;
	}

	// METODO QUE VERIFICA SE A MAO POSSUI DOIS PARES
	public boolean doisPares(Mao mao) {
		boolean teste = false;
		Mao ordenada = ordena(mao);

		char aux = '+';
		for (int i = 0; i < ordenada.getCartas().length - 1; i++) {
			for (int j = i + 1; j < mao.getCartas().length; j++) {
				if (ordenada.getCartas()[i].getNumero() == ordenada.getCartas()[j].getNumero()) {
					
					//ARMAZENA O VALOR DA CARTA PARA VERIFICAR SE ELE NÃO SE REPETE NO SEGUNDO TESTE
					aux = ordenada.getCartas()[i].getNumero();
					continue;

				}
				if ((ordenada.getCartas()[i].getNumero() == ordenada.getCartas()[j].getNumero())
						&& (ordenada.getCartas()[i].getNumero() != aux && ordenada.getCartas()[j].getNumero() != aux)) {
					teste = true;
				}
			}

		}
		return teste;
	}

	// METODO QUE VERIFICA SE A MAO POSSUI UMA QUADRA
	public boolean quadra(Mao mao) {
		boolean teste = false;
		Mao ordenada = ordena(mao);
		for (int i = 0; i < ordenada.getCartas().length - 3; i++) {
			// VERIFICA 4 POSIÇOES COM O MESMO VALOR
			if (ordenada.getCartas()[i].getNumero() == ordenada.getCartas()[i + 1].getNumero()
					&& ordenada.getCartas()[i + 1].getNumero() == ordenada.getCartas()[i + 2].getNumero()
					&& ordenada.getCartas()[i + 2].getNumero() == ordenada.getCartas()[i + 3].getNumero()) {

				teste = true;
				break;
			}
		}
		return teste;
	}

	// METODO QUE VERIFICA SE A MAO POSSUI UMA TRINCA
	public boolean trinca(Mao mao) { //ok
		boolean teste = false;
		int cont1 = 0;
		int cont2 = 0;
		int cont3 = 0;
		int cont4 = 0;
		int cont5 = 0;
		char primeiro = mao.getCartas()[0].getNumero();
		char segundo = mao.getCartas()[1].getNumero();
		char terceiro = mao.getCartas()[2].getNumero();
		char quarto = mao.getCartas()[3].getNumero();
		char quinto = mao.getCartas()[4].getNumero();;
		//Mao ordenada = ordena(mao);
		for (int i = 0; i < mao.getCartas().length; i++) {
			// VERIFICA 3 POSIÇOES COM O MESMO VALOR
			if ((i != 0) && primeiro == mao.getCartas()[i].getNumero())
				cont1++;
			if ((i != 1) && segundo == mao.getCartas()[i].getNumero())
				cont2++;
			if((i != 2) && terceiro == mao.getCartas()[i].getNumero())
				cont3++;
			if((i != 3) && quarto == mao.getCartas()[i].getNumero())
				cont4++;
			if ((i != 4) && quinto == mao.getCartas()[i].getNumero())
				cont5++;
		}
		if (cont1 == 3 || cont2 == 3 || cont3 == 3 || cont4 == 3 || cont5 == 3)
			teste= true;
		return teste;
	}

	// METODO QUE VERIFICA SE A MAO POSSUI UM FULL HOUSE, UMA TRINCA E UM PAR, O VALOR NAO IMPORTA
	public boolean fullHouse(Mao mao) { //ok
		boolean teste = false;
		Mao ordenada = ordena(mao);
		if ((umPar(ordenada) == true) && (trinca(ordenada) == true)) {
			teste = true;
		}
		return teste;
	}

	// METODO QUE VERIFICA SE A MAO POSSUI UMA SEQUENCIA COM 5 VALORES CONSECUTIVOS
	public boolean sequenciaStraight(Mao mao) { //ok
		boolean teste = false;
		//Mao ordenada = ordena(mao);
		int primeira = mao.getCartas()[0].getPeso();
		int segunda = mao.getCartas()[1].getPeso();
		int terceira = mao.getCartas()[2].getPeso();
		int quarta = mao.getCartas()[3].getPeso();
		int quinta = mao.getCartas()[4].getPeso();
		
		primeira++;
		if(primeira == segunda){
			primeira--;
			segunda++;
			if(segunda == terceira){
				segunda--;
				terceira++;
				if(terceira == quarta){
					terceira--;
					quarta++;
					if(quarta == quinta){
						quarta--;
						teste = true;							
					}
				}
			}
		}
		return teste;
	}

	// METODO QUE VERIFICA SE A MAO POSSUI AS CINCO CARTAS COM O MESMO NIPE
	public boolean flush(Mao mao) { //OK
		boolean teste = true;
		//Mao ordenada = ordena(mao);
		for (int j = 1; j < mao.getCartas().length; j++) {
			if (mao.getCartas()[0].getNipe() != mao.getCartas()[j].getNipe()) {  //CASO ALGUMA CARTA TENHA NIPE DIFERENTE DAS DEMAIS, RETORNA FALSE. SE FOREM TODAS DO MESMO NIPE, RETORNA TRUE
				teste = false;
			}
		}

		return teste;
	}

	// METODO QUE VERIFICA SE A MAO POSSUI AS CINCO CARTAS COM O MESMO NIPE E COM
	// VALORES CONSECUTIVOS
	public boolean straightFlush(Mao mao) { //ok
		boolean teste = false;
		//Mao ordenada = ordena(mao);
		if ((this.flush(mao) == true) && (this.sequenciaStraight(mao) == true)) {
			teste = true;	 
		}
		return teste;
	}

	// METODO QUE VERIFICA SE É UM ROYAL FLASH
	public boolean royalFlash(Mao mao) { //OK
		boolean teste = false;
		//Mao ordenada = ordena(mao);
		if (this.flush(mao) == true) { // FALTA A CONDIÇÃO PARA VER SE TEM 10, Valete, Dama, Rei e Ás
			if (mao.getCartas()[0].getNumero() == 'T' && mao.getCartas()[1].getNumero() == 'J'
					&& mao.getCartas()[2].getNumero() == 'Q' && mao.getCartas()[3].getNumero() == 'K'
					&& mao.getCartas()[4].getNumero() == 'A') {
				teste = true;
			}
		}
		return teste;
	}
	
	public static void main (String[] args){
		//Carta a = new Carta ();
		
	}
}
