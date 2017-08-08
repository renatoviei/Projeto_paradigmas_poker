package beans;

//import paradigmas.Carta;
//import paradigmas.Jogador;

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
	
	public Carta[] identificaUmPar (Jogador jogador) {
		Carta retorno[] = new Carta[4];
		int idRetorno = 1;
		
		for (int i = 0; i < jogador.getMao().getCartas().length - 1; i++) {
			for (int j = i + 1; j < jogador.getMao().getCartas().length; j++) {
				if (jogador.getMao().getCartas()[i].getNumero() == jogador.getMao().getCartas()[j].getNumero()) {
					retorno[0] = jogador.getMao().getCartas()[i];
					break;
				}
			}
		}
		if (!retorno[0].equals(null)) {
			for(int a = 0 ; a < jogador.getMao().getCartas().length; a++) {
				if(jogador.getMao().getCartas()[a].getNumero() != retorno[0].getNumero()) {
					retorno[idRetorno] = jogador.getMao().getCartas()[a];
					idRetorno++;
				}
			}
		}
		return retorno;
	}
	
	public Carta[] identifica2Pares (Jogador jogador) {
		Carta retorno[] = new Carta[3];
		char aux = '+';
		char dif = '-';
		for (int i = 0; i < jogador.getMao().getCartas().length - 1; i++) {
			for (int j = i + 1; j < jogador.getMao().getCartas().length; j++) {
				if (jogador.getMao().getCartas()[i].getNumero() == jogador.getMao().getCartas()[j].getNumero()) {
					// ARMAZENA O VALOR DA CARTA PARA VERIFICAR SE ELE NÃO SE REPETE NO SEGUNDO
					// TESTE
					aux = jogador.getMao().getCartas()[i].getNumero();
				}
			}
		}
		if (aux != '+') {
			for (int i = 0; i < jogador.getMao().getCartas().length - 1; i++) {
				for (int j = i + 1; j < jogador.getMao().getCartas().length; j++) {
					if ((jogador.getMao().getCartas()[i].getNumero() == jogador.getMao().getCartas()[j].getNumero()) 
							&& (jogador.getMao().getCartas()[i].getNumero() != aux) && (jogador.getMao().getCartas()[j].getNumero() != aux)) {
						retorno[0] = jogador.getMao().getCartas()[i];
						Carta a = new Carta(aux, '-');
						a.atribuirPeso(a);
						retorno[1] =  a;
					}
				}
			}
			if(retorno[1].getNumero() == aux) {
				for (int i = 0; i < jogador.getMao().getCartas().length; i++) {
					if (jogador.getMao().getCartas()[i].getNumero() != retorno[0].getNumero() && jogador.getMao().getCartas()[i].getNumero() != retorno[1].getNumero())
						retorno [2] = jogador.getMao().getCartas()[i];
				}
			}
		}
		
		return retorno;
	}
	
	//MAO DEVE ESTA ORDENADA
	public void verificarMao (Jogador j) {
		boolean royalFlush = j.getMao().royalFlush(j.getMao());
		if (royalFlush == true) 
			j.setRoyalFlush(royalFlush);
		
		else {
			boolean strgFlush = j.getMao().straightFlush(j.getMao());
			if (strgFlush == true) 
				j.setStrFlush(strgFlush);
			
			else {
				boolean quadra = j.getMao().quadra(j.getMao());
				if (quadra == true) 
					j.setQuadra(quadra);
				
				else {
					boolean fullHouse = j.getMao().fullHouse(j.getMao());
					if (fullHouse == true) 
						j.setFullHouse(quadra);
						
					else {
						boolean flush = j.getMao().flush(j.getMao());
						if (flush == true) 
							j.setFlush(flush);
						
						else {
							boolean strgt = j.getMao().sequenciaStraight(j.getMao());
							if (strgt == true)
								j.setStraight(strgt);
							
							else {
								boolean trinca = j.getMao().trinca(j.getMao());
								if (trinca == true)
									j.setTrinca(trinca);
								
								else {
									boolean doisPares = j.getMao().doisPares(j.getMao());
									if (doisPares == true)
										j.setDoisPares(doisPares);
									
									else {
										boolean par = j.getMao().umPar(j.getMao());
										if (par == true)
											j.setPar(par);
										else {
											j.setCartaAlta(true);
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	public static void main (String[] args) {
		Carta a0 = new Carta ('2', 'H');
		a0.atribuirPeso(a0);
		Carta a1 = new Carta ('4', 'H');
		a1.atribuirPeso(a1);
		Carta a2 = new Carta ('2', 'H');
		a2.atribuirPeso(a2);
		Carta a3 = new Carta ('A', 'H');
		a3.atribuirPeso(a3);
		Carta a4 = new Carta ('K', 'H');
		a4.atribuirPeso(a4);
		
		Carta cards[] = new Carta[5];
		cards[0] = a0;
		cards[1] = a1;
		cards[2] = a2;
		cards[3] = a3;
		cards[4] = a4;
		
		Mao m = new Mao(cards);
		m.ordena(m);
		Jogador j = new Jogador(m);
		
		Poker p = new Poker(j, null);
		//Carta doisParesEExtra[] = p.identifica2Pares(p.getJogador1());
		Carta ParEExtras[] = p.identificaUmPar(p.getJogador1());
		
		for(int i = 0; i < ParEExtras.length; i++)
			System.out.println(ParEExtras[i].getNumero() + " " + ParEExtras[i].getPeso());
		
		
	}
}
	