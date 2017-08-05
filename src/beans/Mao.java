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

	// FUNÇAO QUE RETORNA A MAO ORDENADA DO MENOR VALOR ATE O MAIOR
	public Mao ordena(Mao mao)

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
		Mao ordenada = ordena(mao);
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
	public boolean trinca(Mao mao) {
		boolean teste = false;
		Mao ordenada = ordena(mao);
		for (int i = 0; i < ordenada.getCartas().length - 2; i++) {
			// VERIFICA 3 POSIÇOES COM O MESMO VALOR
			if (ordenada.getCartas()[i].getNumero() == ordenada.getCartas()[i + 1].getNumero()
					&& ordenada.getCartas()[i + 1].getNumero() == ordenada.getCartas()[i + 2].getNumero()) {

				teste = true;
				break;
			}
		}
		return teste;
	}

	// METODO QUE VERIFICA SE A MAO POSSUI UM FULL HOUSE, UMA TRINCA E UM PAR, O VALOR NAO IMPORTA
	public boolean fullHouse(Mao mao) {
		boolean teste = false;
		Mao ordenada = ordena(mao);
		if (umPar(ordenada) == true && trinca(ordenada) == true) {
			
			teste = true;
		}
		return teste;
	}

	// METODO QUE VERIFICA SE A MAO POSSUI UMA SEQUENCIA COM 5 VALORES CONSECUTIVOS
	public boolean sequenciaStraight(Mao mao) {
		boolean teste = false;
		Mao ordenada = ordena(mao);

		for (int i = 0; i < ordenada.getCartas().length - 1; i++) {
			if (ordenada.getCartas()[i].getPeso() < ordenada.getCartas()[i + 1].getPeso()) {

				teste = true;
			}
		}
		return teste;
	}

	// METODO QUE VERIFICA SE A MAO POSSUI AS CINCO CARTAS COM O MESMO NIPE
	public boolean flush(Mao mao) {
		boolean teste = false;
		Mao ordenada = ordena(mao);
		for (int j = 1; j < ordenada.getCartas().length; j++) {
			if (ordenada.getCartas()[0].getNipe() == ordenada.getCartas()[j].getNipe()) {
				teste = true;
			}
		}

		return teste;
	}

	// METODO QUE VERIFICA SE A MAO POSSUI AS CINCO CARTAS COM O MESMO NIPE E COM
	// VALORES CONSECUTIVOS
	public boolean straightFlush(Mao mao) {
		boolean teste = false;
		Mao ordenada = ordena(mao);
		if (sequenciaStraight(ordenada) == true && flush(ordenada) == true) {
			teste = true;
		}
		return teste;
	}

	// METODO QUE VERIFICA SE É UM ROYAL FLASH
	public boolean royalFlash(Mao mao) {
		boolean teste = false;
		Mao ordenada = ordena(mao);
		if (flush(mao) == true) { // FALTA A CONDIÇÃO PARA VER SE TEM 10, Valete, Dama, Rei e Ás
			if (ordenada.getCartas()[0].getNumero() == 'T' && ordenada.getCartas()[1].getNumero() == 'J'
					&& ordenada.getCartas()[2].getNumero() == 'Q' && ordenada.getCartas()[3].getNumero() == 'K'
					&& ordenada.getCartas()[4].getNumero() == 'A') {
				teste = true;
			}
		}
		return teste;
	}
}
