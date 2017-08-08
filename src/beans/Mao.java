package beans;

//import paradigmas.Carta;
//import paradigmas.Mao;

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
	public Mao ordena(Mao mao)

	{
		Mao maoAux = mao;

		int i, j, min;
		Carta x;
		for (i = 0; i < maoAux.getCartas().length - 1; ++i) {
			min = i;
			for (j = i + 1; j < maoAux.getCartas().length; ++j) {
				if (maoAux.getCartas()[j].getPeso() < maoAux.getCartas()[min].getPeso())
					min = j;
			}
			if (maoAux.getCartas()[i] != maoAux.getCartas()[min]) {
				x = maoAux.getCartas()[i];
				maoAux.getCartas()[i] = maoAux.getCartas()[min];
				maoAux.getCartas()[min] = x;

			}
		}
		return maoAux;
	}

	// METODO QUE RETORNA A CARTA DE MAIOR VALOR DA MAO, O INT N É O NUMERO DE VEZES
	// NECESSARIAS QUE O METODO FOI CHAMADO ATE DESEMPATAR O JOGO
	public Carta cartaAlta(Mao mao, int n) { //ok
		Mao ordenada = ordena(mao);
		return ordenada.getCartas()[4 - n];
	}

	// METODO QUE VERIFICA SE A MAO POSSUI UM PAR, DUAS CARTAS COM MESMO VALOR
	public boolean umPar(Mao mao) { //ok
		boolean teste = false;
		//Mao ordenada = ordena(mao);

		for (int i = 0; i < mao.getCartas().length - 1; i++) {
			for (int j = i + 1; j < mao.getCartas().length; j++) {
				if (mao.getCartas()[i].getNumero() == mao.getCartas()[j].getNumero()) {

					teste = true;
					break;
				}
			}
		}
		return teste;
	}

	// METODO QUE VERIFICA SE A MAO POSSUI DOIS PARES
	public boolean doisPares(Mao mao) { //ok
		boolean teste = false;
		//Mao ordenada = ordena(mao);

		char aux = '+';
		for (int i = 0; i < mao.getCartas().length - 1; i++) {
			for (int j = i + 1; j < mao.getCartas().length; j++) {
				if (mao.getCartas()[i].getNumero() == mao.getCartas()[j].getNumero()) {
					// ARMAZENA O VALOR DA CARTA PARA VERIFICAR SE ELE NÃO SE REPETE NO SEGUNDO
					// TESTE
					aux = mao.getCartas()[i].getNumero();
				}
			}
		}
		if (aux != '+') {
			for (int i = 0; i < mao.getCartas().length - 1; i++) {
				for (int j = i + 1; j < mao.getCartas().length; j++) {
					if ((mao.getCartas()[i].getNumero() == mao.getCartas()[j].getNumero()) 
							&& (mao.getCartas()[i].getNumero() != aux) && (mao.getCartas()[j].getNumero() != aux)) {
						teste = true;
					}
				}
			}
		}
		return teste;
	}

	// METODO QUE VERIFICA SE A MAO POSSUI UMA QUADRA
	public boolean quadra(Mao mao) { //ok
		boolean teste = false;
		//Mao ordenada = ordena(mao);
		for (int i = 0; i < mao.getCartas().length - 3; i++) {
			// VERIFICA 4 POSIÇOES COM O MESMO VALOR
			if (mao.getCartas()[i].getNumero() == mao.getCartas()[i + 1].getNumero()
					&& mao.getCartas()[i + 1].getNumero() == mao.getCartas()[i + 2].getNumero()
					&& mao.getCartas()[i + 2].getNumero() == mao.getCartas()[i + 3].getNumero()) {

				teste = true;
				break;
			}
		}
		return teste;
	}

	// METODO QUE VERIFICA SE A MAO POSSUI UMA TRINCA
	public boolean trinca(Mao mao) { //ok
		boolean teste = false;
		//Mao ordenada = ordena(mao);
		int cont1 = 0;
		int cont2 = 0;
		int cont3 = 0;
		int cont4 = 0;
		int cont5 = 0;
		char primeiro = mao.getCartas()[0].getNumero();
		char segundo = mao.getCartas()[1].getNumero();
		char terceiro = mao.getCartas()[2].getNumero();
		char quarto = mao.getCartas()[3].getNumero();
		char quinto = mao.getCartas()[4].getNumero();
		
		for (int i = 0; i < mao.getCartas().length; i++) {
			// VERIFICA 3 POSIÇOES COM O MESMO VALOR
			if (primeiro == mao.getCartas()[i].getNumero())
				cont1++;
			if (segundo == mao.getCartas()[i].getNumero())
				cont2++;
			if (terceiro == mao.getCartas()[i].getNumero())
				cont3++;
			if (quarto ==  mao.getCartas()[i].getNumero())
				cont4++;
			if (quinto == mao.getCartas()[i].getNumero())
				cont5++;
		}
		
		if ((cont1 == 3) || (cont2 == 3) || (cont3 == 3) || (cont4 == 3) || (cont5 == 3))
			teste = true;
		return teste;
	}

	// METODO QUE VERIFICA SE A MAO POSSUI UM FULL HOUSE, UMA TRINCA E UM PAR, O
	// VALOR NAO IMPORTA
	public boolean fullHouse(Mao mao) { //ok
		boolean teste = false;
		//Mao ordenada = ordena(mao);
		boolean par = false;
		boolean trinca = false;
		char aux = '+';
		
		//VERIFICA O TRINCA
		int cont1 = 0;
		int cont2 = 0;
		int cont3 = 0;
		int cont4 = 0;
		int cont5 = 0;
		char primeiro = mao.getCartas()[0].getNumero();
		char segundo = mao.getCartas()[1].getNumero();
		char terceiro = mao.getCartas()[2].getNumero();
		char quarto = mao.getCartas()[3].getNumero();
		char quinto = mao.getCartas()[4].getNumero();
		
		for (int i = 0; i < mao.getCartas().length; i++) {
			if (primeiro == mao.getCartas()[i].getNumero())
				cont1++;
			if (segundo == mao.getCartas()[i].getNumero())
				cont2++;
			if (terceiro == mao.getCartas()[i].getNumero())
				cont3++;
			if (quarto ==  mao.getCartas()[i].getNumero())
				cont4++;
			if (quinto == mao.getCartas()[i].getNumero())
				cont5++;
		}
		
		if (cont1 == 3){
			trinca = true;
			aux = primeiro;
		}
		else if (cont2 == 3) {
			trinca = true;
			aux = segundo;
		}
		else if (cont3 == 3) {
			trinca = true;
			aux = terceiro;
		}
		else if (cont4 == 3) {
			trinca = true;
			aux = quarto;
		}
		else if (cont5 == 3) {
			trinca = true;
			aux = quinto;
		}
		
		//VERIFICA A PAR, CONTANDO QUE NAO SEJA O MESMO NUMERO DO PAR
		if (aux != '+' && trinca == true) {			
			if ((mao.getCartas()[0].getNumero() == aux)) {
				if (((mao.getCartas()[3].getNumero() == mao.getCartas()[4].getNumero())) && (mao.getCartas()[3].getNumero() != mao.getCartas()[2].getNumero())) {
					par = true;					
				}
			}
			else {
				if (((mao.getCartas()[0].getNumero()) == mao.getCartas()[1].getNumero()) && (mao.getCartas()[0].getNumero() != mao.getCartas()[2].getNumero())){
					par = true;
				}
			}
		}
		
		if (par == true && trinca == true)
			teste = true;	
		
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
	public boolean flush(Mao mao) { //ok
		boolean teste = true;
		//Mao ordenada = ordena(mao);
		for (int j = 1; j < mao.getCartas().length; j++) {
			if (mao.getCartas()[0].getNipe() != mao.getCartas()[j].getNipe()) {	//CASO ALGUMA CARTA TENHA NIPE DIFERENTE DAS DEMAIS, RETORNA FALSE. SE FOREM TODAS DO MESMO NIPE, RETORNA TRUE
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
		if ((sequenciaStraight(mao) == true) && (flush(mao) == true)) {
			teste = true;
		}
		return teste;
	}

	// METODO QUE VERIFICA SE É UM ROYAL FLASH
	public boolean royalFlush(Mao mao) { //ok
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
		Carta a0 = new Carta ('T', 'H');
		a0.atribuirPeso(a0);
		Carta a1 = new Carta ('Q', 'H');
		a1.atribuirPeso(a1);
		Carta a2 = new Carta ('K', 'H');
		a2.atribuirPeso(a2);
		Carta a3 = new Carta ('J', 'H');
		a3.atribuirPeso(a3);
		Carta a4 = new Carta ('A', 'H');
		a4.atribuirPeso(a4);
		
		Carta cards[] = new Carta[5];
		cards[0] = a0;
		cards[1] = a1;
		cards[2] = a2;
		cards[3] = a3;
		cards[4] = a4;
		
		Mao mao = new Mao(cards);
		mao.ordena(mao);
		
		System.out.println(mao.royalFlush(mao));
		
		
		
		
			
	}	
}