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
	
	public Carta idPosicaoDe2Pares (Jogador jogador) {
		Carta retorno = null;
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
}
	