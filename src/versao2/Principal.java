package versao2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

//import paradigmas.Carta;
//import paradigmas.Jogador;
//import paradigmas.Mao;
//import paradigmas.Poker;

public class Principal {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Date data1 = new Date();
		long inicio = data1.getTime();
		long fim = 0;
		long tempoDeExec = 0;
		//MUDAR O NOME DO ARQUIVO NA PROXIMA LINHA, PARA O ARQUIVO DESEJADO -> "artefatos\\NomeDoArquivo.txt"
		FileReader file = new FileReader("artefatos\\pokerM.txt");
		BufferedReader arq = new BufferedReader(file);

		String linha = "";
		String maos[];

		char numero = '0';
		char nipe = '0';
		int ind = 0;

		Carta carta = null;
		Carta cartas1[] = new Carta[5];
		Carta cartas2[] = new Carta[5];
		Mao mao1 = null;
		Mao mao2 = null;
		Jogador j1 = null;
		Jogador j2 = null;
		Poker jogo = null;
		int vitorias1 = 0;
		int vitorias2 = 0;
		int empate = 0;

		while ((linha = arq.readLine()) != null) {
			maos = linha.split(" ");
			for (int i = 0; i < 10; i++) {
				numero = maos[i].charAt(0);
				nipe = maos[i].charAt(1);
				carta = new Carta(numero, nipe);
				carta.atribuirPeso(carta);
				if (i < 5) {
					cartas1[ind] = carta;
				}
				if (i == 5) {
					ind = 0;
				}
				if (i > 4) {
					cartas2[ind] = carta;
				}
				ind++;
			}
			ind = 0;

			mao1 = new Mao(cartas1);
			mao1.ordena(mao1);
			mao2 = new Mao(cartas2);
			mao2.ordena(mao2);

			j1 = new Jogador(mao1);
			j2 = new Jogador(mao2);

			jogo = new Poker(j1, j2);
			jogo.verificarMao(j1);
			jogo.verificarMao(j2);
			
			//Verifica royalFlush
			if(jogo.getJogador1().isRoyalFlush() == true && jogo.getJogador2().isRoyalFlush() == false) {
				vitorias1++;
			}
			else if (jogo.getJogador1().isRoyalFlush() == false && jogo.getJogador2().isRoyalFlush() == true) {
				vitorias2++;
			}
			else if (jogo.getJogador1().isRoyalFlush() == false && jogo.getJogador2().isRoyalFlush() == false) { //SE NAO TIVER ROYALFLUSH VERIFICA SE TEM STRAIGHTFLUSH
				if (jogo.getJogador1().isStrFlush() == true && jogo.getJogador2().isStrFlush() == false) {
					vitorias1++;
				}
				else if (jogo.getJogador1().isStrFlush() == false && jogo.getJogador2().isStrFlush() == true) {
					vitorias2++;
				}
				else if (jogo.getJogador1().isStrFlush() == true && jogo.getJogador2().isStrFlush() == true) { //CHECAGEM DE CARTA ALTA
					if (jogo.getJogador1().getMao().getCartas()[4].getPeso() > jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
						vitorias1++;
					}
					else if (jogo.getJogador1().getMao().getCartas()[4].getPeso() < jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
						vitorias2++;
					}
					else {//SE A ULTIMA CARTA DOS VETORES FOREM IGUAIS, ENTAO DA EMPATE, POIS SE EH UM STRAIGHT FLUSH, AS DEMAIS TB SERAO IGUAIS 
						empate++;
					}
				}
				else if (jogo.getJogador1().isStrFlush() == false && jogo.getJogador2().isStrFlush() == false) { //SE TAMBÉM NAO TIVER STRAIGHT FLUSH, VERIFICA SE TEM QUADRA
					if(jogo.getJogador1().isQuadra() == true && jogo.getJogador2().isQuadra() == false) {
						vitorias1++;
					}
					else if (jogo.getJogador1().isQuadra() == false && jogo.getJogador2().isQuadra() == true) {
						vitorias2++;
					}
					else if (jogo.getJogador1().isQuadra() == true && jogo.getJogador2().isQuadra() == true) {//CHECAGEM EM CASO DE EMPATE NA QUADRA
						//VERIFICA ONDE A QUADRA ESTÁ (COMEÇO OU FIM) DE AMBOS OS VETORES E EM SEGUIDA PEGA O MAIOR PARA DIZER QUEM GANHOU
						if(jogo.getJogador1().getMao().getCartas()[0].getPeso() == jogo.getJogador1().getMao().getCartas()[1].getPeso()) {
							if(jogo.getJogador2().getMao().getCartas()[0].getPeso() == jogo.getJogador2().getMao().getCartas()[1].getPeso()) {
								if(jogo.getJogador1().getMao().getCartas()[0].getPeso() > jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
									vitorias1++;
								}
								else if (jogo.getJogador1().getMao().getCartas()[0].getPeso() < jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
									vitorias2++;
								}
								else {
									if(jogo.getJogador1().getMao().getCartas()[4].getPeso() > jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
										vitorias1++;
									}
									else if(jogo.getJogador1().getMao().getCartas()[4].getPeso() < jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
										vitorias2++;
									}
									else {
										empate++;
									}
								}
							}
							else {
								if (jogo.getJogador1().getMao().getCartas()[0].getPeso() > jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
									vitorias1++;
								}
								else if (jogo.getJogador1().getMao().getCartas()[0].getPeso() < jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
									vitorias2++;
								}
								else {
									if(jogo.getJogador1().getMao().getCartas()[4].getPeso() > jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
										vitorias1++;
									}
									else if(jogo.getJogador1().getMao().getCartas()[4].getPeso() < jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
										vitorias2++;
									}
									else {
										empate++;
									}
								}
							}
						}
						else {  //cartas[4] será igual a posicao 3, 2 e 1, pois está ordenado
							if(jogo.getJogador2().getMao().getCartas()[0].getPeso() == jogo.getJogador2().getMao().getCartas()[1].getPeso()) {
								if (jogo.getJogador1().getMao().getCartas()[4].getPeso() > jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
									vitorias1++;
								}				
								else if (jogo.getJogador1().getMao().getCartas()[4].getPeso() < jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
									vitorias2++;
								}
								else {
									if (jogo.getJogador1().getMao().getCartas()[0].getPeso() > jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
										vitorias1++;
									}
									else if (jogo.getJogador1().getMao().getCartas()[0].getPeso() < jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
										vitorias2++;
									}
									else {
										empate++;
									}
								}
							}
							else {
								if (jogo.getJogador1().getMao().getCartas()[4].getPeso() > jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
									vitorias1++;
								}
								else if (jogo.getJogador1().getMao().getCartas()[4].getPeso() < jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
									vitorias2++;
								}
								else {
									if (jogo.getJogador1().getMao().getCartas()[0].getPeso() > jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
										vitorias1++;
									}
									else if (jogo.getJogador1().getMao().getCartas()[0].getPeso() < jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
										vitorias2++;
									}
									else {
										empate++;
									}
								}
							}
						}
					}
					else if (jogo.getJogador1().isQuadra() == false && jogo.getJogador2().isQuadra() == false) { //SE TAMBÉM NAO FOR QUADRA, ENTAO VERIFICA FULLHOUSE
						if(jogo.getJogador1().isFullHouse() == true && jogo.getJogador2().isFullHouse() == false) {
							vitorias1++;
						}
						else if(jogo.getJogador1().isFullHouse() == false && jogo.getJogador2().isFullHouse() == true) {
							vitorias2++;
						}
						else if(jogo.getJogador1().isFullHouse() == true && jogo.getJogador2().isFullHouse() == true) {//EMPATE, ENTAO VERIFICA A TRINCA E CASO PERMANEÇA VERIFICA O PAR
							//VERIFICANDO A TRINCA
							if(jogo.getJogador1().getMao().getCartas()[2].getPeso() > jogo.getJogador2().getMao().getCartas()[2].getPeso()) {
								vitorias1++;
							}
							else if(jogo.getJogador1().getMao().getCartas()[2].getPeso() < jogo.getJogador2().getMao().getCartas()[2].getPeso()) {
								vitorias2++;
							}
							//VERIFICA O PAR
							else {
								if(jogo.getJogador1().getMao().getCartas()[2].getPeso() == jogo.getJogador1().getMao().getCartas()[1].getPeso()) {//PAR ESTÁ NO FINAL DO VETOR
									if(jogo.getJogador2().getMao().getCartas()[2].getPeso() == jogo.getJogador2().getMao().getCartas()[1].getPeso()) {
										if(jogo.getJogador1().getMao().getCartas()[4].getPeso() > jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
											vitorias1++;
										}
										else if(jogo.getJogador1().getMao().getCartas()[4].getPeso() < jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
											vitorias2++;
										}
										else {
											empate++;
										}
									}
									else {
										if(jogo.getJogador1().getMao().getCartas()[4].getPeso() > jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
											vitorias1++;
										}
										else if(jogo.getJogador1().getMao().getCartas()[4].getPeso() < jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
											vitorias2++;
										}
										else {
											empate++;
										}
										
									}
								}
								else { //PAR NO COMEÇO DO VETOR
									if(jogo.getJogador2().getMao().getCartas()[2].getPeso() == jogo.getJogador2().getMao().getCartas()[1].getPeso()) {
										if(jogo.getJogador1().getMao().getCartas()[0].getPeso() > jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
											vitorias1++;
										}
										else if(jogo.getJogador1().getMao().getCartas()[0].getPeso() < jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
											vitorias2++;
										}
										else {
											empate++;
										}
									}
									else {
										if(jogo.getJogador1().getMao().getCartas()[0].getPeso() > jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
											vitorias1++;
										}
										else if(jogo.getJogador1().getMao().getCartas()[0].getPeso() < jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
											vitorias2++;
										}
										else {
											empate++;
										}										
									}
								}								
							}
						}
						else if (jogo.getJogador1().isFullHouse() == false && jogo.getJogador2().isFullHouse() == false) { //TAMBÉM NAO TEM FULLHOUSE, ENTAO VERIFICA FLUSH
							if(jogo.getJogador1().isFlush() == true && jogo.getJogador2().isFlush() == false) {
								vitorias1++;
							}
							else if(jogo.getJogador1().isFlush() == false && jogo.getJogador2().isFlush() == true) {
								vitorias2++;
							}
							else if(jogo.getJogador1().isFlush() == true && jogo.getJogador2().isFlush() == true) {//EMPATE NO FLUSH
								if (jogo.getJogador1().getMao().getCartas()[4].getPeso() > jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
									vitorias1++;
								}
								else if (jogo.getJogador1().getMao().getCartas()[4].getPeso() < jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
									vitorias2++;
								}
								else {
									if(jogo.getJogador1().getMao().getCartas()[3].getPeso() > jogo.getJogador2().getMao().getCartas()[3].getPeso()) {
										vitorias1++;
									}
									else if(jogo.getJogador1().getMao().getCartas()[3].getPeso() < jogo.getJogador2().getMao().getCartas()[3].getPeso()) {
										vitorias2++;
									}
									else {
										if(jogo.getJogador1().getMao().getCartas()[2].getPeso() > jogo.getJogador2().getMao().getCartas()[2].getPeso()) {
											vitorias1++;
										}
										else if(jogo.getJogador1().getMao().getCartas()[2].getPeso() < jogo.getJogador2().getMao().getCartas()[2].getPeso()) {
											vitorias2++;
										}
										else {
											if(jogo.getJogador1().getMao().getCartas()[1].getPeso() > jogo.getJogador2().getMao().getCartas()[1].getPeso()) {
												vitorias1++;
											}
											else if(jogo.getJogador1().getMao().getCartas()[1].getPeso() < jogo.getJogador2().getMao().getCartas()[1].getPeso()) {
												vitorias2++;
											}
											else {
												if(jogo.getJogador1().getMao().getCartas()[0].getPeso() > jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
													vitorias1++;
												}
												else if(jogo.getJogador1().getMao().getCartas()[0].getPeso() < jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
													vitorias2++;
												}
												else {
													empate++;
												}
											}
										}
									}
								}
							}
							else if(jogo.getJogador1().isFlush() == false && jogo.getJogador2().isFlush() == false) { //CASO TAMBÉM NAO TENHA FLUSH, VERIFICA SE TEM STRAIGHT
								if(jogo.getJogador1().isStraight() == true && jogo.getJogador2().isStraight() == false) {
									vitorias1++;
								}
								else if(jogo.getJogador1().isStraight() == false && jogo.getJogador2().isStraight() == true) {
									vitorias2++;
								}
								else if(jogo.getJogador1().isStraight() == true && jogo.getJogador2().isStraight() == true) {//CASO DE EMPATE NO STRAIGHT
									if(jogo.getJogador1().getMao().getCartas()[4].getPeso() > jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
										vitorias1++;
									}
									else if(jogo.getJogador1().getMao().getCartas()[4].getPeso() < jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
										vitorias2++;
									}
									else {
										if(jogo.getJogador1().getMao().getCartas()[3].getPeso() > jogo.getJogador2().getMao().getCartas()[3].getPeso()) {
											vitorias1++;
										}
										else if(jogo.getJogador1().getMao().getCartas()[3].getPeso() < jogo.getJogador2().getMao().getCartas()[3].getPeso()) {
											vitorias2++;
										}
										else {
											if(jogo.getJogador1().getMao().getCartas()[2].getPeso() > jogo.getJogador2().getMao().getCartas()[2].getPeso()) {
												vitorias1++;
											}
											else if(jogo.getJogador1().getMao().getCartas()[2].getPeso() < jogo.getJogador2().getMao().getCartas()[2].getPeso()) {
												vitorias2++;
											}
											else {
												if(jogo.getJogador1().getMao().getCartas()[1].getPeso() > jogo.getJogador2().getMao().getCartas()[1].getPeso()) {
													vitorias1++;
												}
												else if(jogo.getJogador1().getMao().getCartas()[1].getPeso() < jogo.getJogador2().getMao().getCartas()[1].getPeso()) {
													vitorias2++;
												}
												else {
													if(jogo.getJogador1().getMao().getCartas()[0].getPeso() > jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
														vitorias1++;
													}
													else if(jogo.getJogador1().getMao().getCartas()[0].getPeso() < jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
														vitorias2++;
													}
													else {
														empate++;
													}
												}
											}
										}
									}
								}
								else if(jogo.getJogador1().isStraight() == false && jogo.getJogador2().isStraight() == false) { //NAO TEVE STRAIGHT TAMBÉM, ENTAO VERIFICA SE TEM TRINCA 
									if(jogo.getJogador1().isTrinca() == true && jogo.getJogador2().isTrinca() == false) {
										vitorias1++;
									}
									else if(jogo.getJogador1().isTrinca() == false && jogo.getJogador2().isTrinca() == true) {
										vitorias2++;
									}
									else if(jogo.getJogador1().isTrinca() == true && jogo.getJogador2().isTrinca() == true) {
										//VERIFICA ONDE A TRINCA SE ENCONTRA PARA PODER COMPARAR OS OUTROS 2 VALORES 
										if(jogo.getJogador1().getMao().getCartas()[0].getPeso() == jogo.getJogador1().getMao().getCartas()[1].getPeso() && jogo.getJogador1().getMao().getCartas()[0].getPeso() == jogo.getJogador1().getMao().getCartas()[2].getPeso()) {//TRINCA NO INICIO
											if (jogo.getJogador2().getMao().getCartas()[0].getPeso() == jogo.getJogador2().getMao().getCartas()[1].getPeso() && jogo.getJogador2().getMao().getCartas()[0].getPeso() == jogo.getJogador2().getMao().getCartas()[2].getPeso()) {
												if (jogo.getJogador1().getMao().getCartas()[2].getPeso() > jogo.getJogador2().getMao().getCartas()[2].getPeso()) {
													vitorias1++;
												}
												else if (jogo.getJogador1().getMao().getCartas()[2].getPeso() < jogo.getJogador2().getMao().getCartas()[2].getPeso()) {
													vitorias2++;
												}
												else {
													if (jogo.getJogador1().getMao().getCartas()[4].getPeso() > jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
														vitorias1++;
													}
													else if (jogo.getJogador1().getMao().getCartas()[4].getPeso() < jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
														vitorias2++;
													}
													else {
														if (jogo.getJogador1().getMao().getCartas()[3].getPeso() > jogo.getJogador2().getMao().getCartas()[3].getPeso()) {
															vitorias1++;
														}
														else if (jogo.getJogador1().getMao().getCartas()[3].getPeso() < jogo.getJogador2().getMao().getCartas()[3].getPeso()) {
															vitorias2++;
														}
														else {
															empate++;
														}
													}
												}
											}
											else if (jogo.getJogador2().getMao().getCartas()[2] == jogo.getJogador2().getMao().getCartas()[3] && jogo.getJogador2().getMao().getCartas()[2] == jogo.getJogador2().getMao().getCartas()[1]){
												if (jogo.getJogador1().getMao().getCartas()[2].getPeso() > jogo.getJogador2().getMao().getCartas()[2].getPeso()) {
													vitorias1++;
												}
												else if (jogo.getJogador1().getMao().getCartas()[2].getPeso() < jogo.getJogador2().getMao().getCartas()[2].getPeso()) {
													vitorias2++;
												}
												else {
													if (jogo.getJogador1().getMao().getCartas()[4].getPeso() > jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
														vitorias1++;
													}
													else if (jogo.getJogador1().getMao().getCartas()[4].getPeso() < jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
														vitorias2++;
													}
													else {
														if (jogo.getJogador1().getMao().getCartas()[3].getPeso() > jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
															vitorias1++;
														}
														else if (jogo.getJogador1().getMao().getCartas()[3].getPeso() > jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
															vitorias2++;
														}
														else {
															empate++;
														}
													}
												}
											}
											else if (jogo.getJogador2().getMao().getCartas()[2] == jogo.getJogador2().getMao().getCartas()[3] && jogo.getJogador2().getMao().getCartas()[2] == jogo.getJogador2().getMao().getCartas()[4]) {
												if (jogo.getJogador1().getMao().getCartas()[2].getPeso() > jogo.getJogador2().getMao().getCartas()[2].getPeso()) {
													vitorias1++;
												}
												else if (jogo.getJogador1().getMao().getCartas()[2].getPeso() < jogo.getJogador2().getMao().getCartas()[2].getPeso()) {
													vitorias2++;
												}
												else {
													if(jogo.getJogador1().getMao().getCartas()[4].getPeso() > jogo.getJogador2().getMao().getCartas()[1].getPeso()) {
														vitorias1++;
													}
													else if(jogo.getJogador1().getMao().getCartas()[4].getPeso() < jogo.getJogador2().getMao().getCartas()[1].getPeso()) {
														vitorias2++;
													}
													else {
														if(jogo.getJogador1().getMao().getCartas()[3].getPeso() > jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
															vitorias1++;
														}
														else if(jogo.getJogador1().getMao().getCartas()[3].getPeso() < jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
															vitorias2++;
														}
														else {
															empate++;
														}
													}
												}
											}
										}
										else  if(jogo.getJogador1().getMao().getCartas()[2].getPeso() == jogo.getJogador1().getMao().getCartas()[3].getPeso() && jogo.getJogador1().getMao().getCartas()[2].getPeso() == jogo.getJogador1().getMao().getCartas()[1].getPeso()){//TRINCA NO MEIO
											if (jogo.getJogador2().getMao().getCartas()[2].getPeso() == jogo.getJogador2().getMao().getCartas()[1].getPeso() && jogo.getJogador2().getMao().getCartas()[2].getPeso() == jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
												if (jogo.getJogador1().getMao().getCartas()[2].getPeso() > jogo.getJogador2().getMao().getCartas()[2].getPeso()) {
												vitorias1++;
												}
												else if (jogo.getJogador1().getMao().getCartas()[2].getPeso() < jogo.getJogador2().getMao().getCartas()[2].getPeso()) {
													vitorias2++;
												}
												else {
													if(jogo.getJogador1().getMao().getCartas()[4].getPeso() > jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
														vitorias1++;
													}
													else if(jogo.getJogador1().getMao().getCartas()[4].getPeso() < jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
														vitorias2++;
													}
													else {
														if(jogo.getJogador1().getMao().getCartas()[0].getPeso() > jogo.getJogador2().getMao().getCartas()[3].getPeso()) {
															vitorias1++;
														}
														else if(jogo.getJogador1().getMao().getCartas()[0].getPeso() < jogo.getJogador2().getMao().getCartas()[3].getPeso()) {
															vitorias2++;
														}
														else {
															empate++;
														}
													}
												}
											}
											else if (jogo.getJogador2().getMao().getCartas()[2].getPeso() == jogo.getJogador2().getMao().getCartas()[3].getPeso() && jogo.getJogador2().getMao().getCartas()[2].getPeso() == jogo.getJogador2().getMao().getCartas()[1].getPeso()){
												if (jogo.getJogador1().getMao().getCartas()[2].getPeso() > jogo.getJogador2().getMao().getCartas()[2].getPeso()) {
													vitorias1++;
												}
												else if (jogo.getJogador1().getMao().getCartas()[2].getPeso() < jogo.getJogador2().getMao().getCartas()[2].getPeso()) {
													vitorias2++;
												}
												else {
													if(jogo.getJogador1().getMao().getCartas()[4].getPeso() > jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
														vitorias1++;
													}
													else if(jogo.getJogador1().getMao().getCartas()[4].getPeso() < jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
														vitorias2++;
													}
													else {
														if(jogo.getJogador1().getMao().getCartas()[0].getPeso() > jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
															vitorias1++;
														}
														else if(jogo.getJogador1().getMao().getCartas()[0].getPeso() < jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
															vitorias2++;
														}
														else {
															empate++;
														}
													}
												}
											}
											else if (jogo.getJogador2().getMao().getCartas()[2].getPeso() == jogo.getJogador2().getMao().getCartas()[3].getPeso() && jogo.getJogador2().getMao().getCartas()[2].getPeso() == jogo.getJogador2().getMao().getCartas()[4].getPeso()) { //trinca do j2 no final
												if (jogo.getJogador1().getMao().getCartas()[2].getPeso() > jogo.getJogador2().getMao().getCartas()[2].getPeso()) {
													vitorias1++;
												}
												else if (jogo.getJogador1().getMao().getCartas()[2].getPeso() < jogo.getJogador2().getMao().getCartas()[2].getPeso()) {
													vitorias2++;
												}
												else {
													if(jogo.getJogador1().getMao().getCartas()[4].getPeso() > jogo.getJogador2().getMao().getCartas()[1].getPeso()) {
														vitorias1++;
													}
													else if(jogo.getJogador1().getMao().getCartas()[4].getPeso() < jogo.getJogador2().getMao().getCartas()[1].getPeso()) {
														vitorias2++;
													}
													else {
														if(jogo.getJogador1().getMao().getCartas()[0].getPeso() > jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
															vitorias1++;
														}
														else if(jogo.getJogador1().getMao().getCartas()[0].getPeso() < jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
															vitorias2++;
														}
														else {
															empate++;
														}
													}
												}
											}
										}
										else if (jogo.getJogador1().getMao().getCartas()[2].getPeso() == jogo.getJogador1().getMao().getCartas()[3].getPeso() && jogo.getJogador1().getMao().getCartas()[2].getPeso() == jogo.getJogador1().getMao().getCartas()[4].getPeso()) { //TRINCA NO FINAL
											if (jogo.getJogador2().getMao().getCartas()[2].getPeso() == jogo.getJogador2().getMao().getCartas()[1].getPeso() && jogo.getJogador2().getMao().getCartas()[2].getPeso() == jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
												if (jogo.getJogador1().getMao().getCartas()[2].getPeso() > jogo.getJogador2().getMao().getCartas()[2].getPeso()) {
													vitorias1++;
												}
												else if (jogo.getJogador1().getMao().getCartas()[2].getPeso() < jogo.getJogador2().getMao().getCartas()[2].getPeso()) {
													vitorias2++;
												}
												else {
													if (jogo.getJogador1().getMao().getCartas()[1].getPeso() > jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
														vitorias1++;
													}
													else if (jogo.getJogador1().getMao().getCartas()[1].getPeso() < jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
														vitorias2++;
													}
													else {
														if (jogo.getJogador1().getMao().getCartas()[0].getPeso() > jogo.getJogador2().getMao().getCartas()[3].getPeso()) {
															vitorias1++;
														}
														else if (jogo.getJogador1().getMao().getCartas()[0].getPeso() < jogo.getJogador2().getMao().getCartas()[3].getPeso()) {
															vitorias2++;
														}
														else {
															empate++;
														}
													}
												}
											}
											else if (jogo.getJogador2().getMao().getCartas()[2].getPeso() == jogo.getJogador2().getMao().getCartas()[1].getPeso() && jogo.getJogador2().getMao().getCartas()[2].getPeso() == jogo.getJogador2().getMao().getCartas()[3].getPeso()) {
												if (jogo.getJogador1().getMao().getCartas()[2].getPeso() > jogo.getJogador2().getMao().getCartas()[2].getPeso()) {
													vitorias1++;
												}
												else if (jogo.getJogador1().getMao().getCartas()[2].getPeso() < jogo.getJogador2().getMao().getCartas()[2].getPeso()) {
													vitorias2++;
												}
												else {
													if(jogo.getJogador1().getMao().getCartas()[1].getPeso() > jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
														vitorias1++;
													}
													else if(jogo.getJogador1().getMao().getCartas()[1].getPeso() < jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
														vitorias2++;
													}
													else {
														if(jogo.getJogador1().getMao().getCartas()[0].getPeso() > jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
															vitorias1++;
														}
														else if(jogo.getJogador1().getMao().getCartas()[0].getPeso() < jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
															vitorias2++;
														}
														else {
															empate++;
														}
													}
												}
											}
											else if (jogo.getJogador2().getMao().getCartas()[2].getPeso() == jogo.getJogador2().getMao().getCartas()[3].getPeso() && jogo.getJogador2().getMao().getCartas()[2].getPeso() == jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
												if (jogo.getJogador1().getMao().getCartas()[2].getPeso() > jogo.getJogador2().getMao().getCartas()[2].getPeso()) {
													vitorias1++;
												}
												else if (jogo.getJogador1().getMao().getCartas()[2].getPeso() < jogo.getJogador2().getMao().getCartas()[2].getPeso()) {
													vitorias2++;
												}
												else {
													if (jogo.getJogador1().getMao().getCartas()[1].getPeso() > jogo.getJogador2().getMao().getCartas()[1].getPeso()) {
														vitorias1++;
													}
													else if (jogo.getJogador1().getMao().getCartas()[1].getPeso() < jogo.getJogador2().getMao().getCartas()[1].getPeso()) {
														vitorias2++;
													}
													else {
														if (jogo.getJogador1().getMao().getCartas()[0].getPeso() > jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
															vitorias1++;
														}
														else if (jogo.getJogador1().getMao().getCartas()[0].getPeso() < jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
															vitorias2++;
														}
														else {
															empate++;
														}
													}
												}
											}
										}
									}
									else if(jogo.getJogador1().isTrinca() == false && jogo.getJogador2().isTrinca() == false) {//TAMBÉM NAO TEVE TRINCA, ENTAO VERIFICA SE TEM 2 PARES
										if(jogo.getJogador1().isDoisPares() == true && jogo.getJogador2().isDoisPares() == false) {
											vitorias1++;
										}
										else if(jogo.getJogador1().isDoisPares() == false && jogo.getJogador2().isDoisPares() == true) {
											vitorias2++;
										}
										else if(jogo.getJogador1().isDoisPares() == true && jogo.getJogador2().isDoisPares() == true) {//EMPATE NOS PARES
											Carta paresEExtraDe1[] = jogo.identifica2Pares(jogo.getJogador1());
											Carta paresEExtraDe2[] = jogo.identifica2Pares(jogo.getJogador2());
											if(paresEExtraDe1[1].getPeso() > paresEExtraDe2[1].getPeso()) {
												vitorias1++;
											}
											else if(paresEExtraDe1[1].getPeso() < paresEExtraDe2[1].getPeso()) {
												vitorias2++;
											}
											else {
												if(paresEExtraDe1[0].getPeso() > paresEExtraDe2[0].getPeso()) {
													vitorias1++;
												}
												else if(paresEExtraDe1[0].getPeso() < paresEExtraDe2[0].getPeso()) {
													vitorias2++;
												}
												else {
													if(paresEExtraDe1[2].getPeso() > paresEExtraDe2[2].getPeso()) {
														vitorias1++;
													}
													else if(paresEExtraDe1[2].getPeso() < paresEExtraDe2[2].getPeso()) {
														vitorias2++;
													}
													else {
														empate++;
													}
												}
											}											
										}
										else if(jogo.getJogador1().isDoisPares() == false && jogo.getJogador2().isDoisPares() == false) { //TAMBÉM NAO TEM 2 PARES, ENTAO VERIFICA SE TEM UM PAR
											if(jogo.getJogador1().isPar() == true && jogo.getJogador2().isPar() == false) {
												vitorias1++;
											}
											else if(jogo.getJogador1().isPar() == false && jogo.getJogador2().isPar() == true) {
												vitorias2++;
											}
											else if(jogo.getJogador1().isPar() == true && jogo.getJogador2().isPar() == true) {//EMPATE NOS PARES
												Carta parEExtras1 []= jogo.identificaUmPar(jogo.getJogador1());
												Carta parEExtras2 [] = jogo.identificaUmPar(jogo.getJogador2());
												
												if(parEExtras1[0].getPeso() > parEExtras2[0].getPeso()) {
													vitorias1++;
												}
												else if(parEExtras1[0].getPeso() < parEExtras2[0].getPeso()) {
													vitorias2++;
												}
												else {
													if(parEExtras1[3].getPeso() > parEExtras2[3].getPeso()) {
														vitorias1++;
													}
													else if(parEExtras1[3].getPeso() < parEExtras2[3].getPeso()) {
														vitorias2++;
													}
													else {
														if(parEExtras1[2].getPeso() > parEExtras2[2].getPeso()) {
															vitorias1++;
														}
														else if(parEExtras1[2].getPeso() < parEExtras2[2].getPeso()) {
															vitorias2++;
														}
														else {
															if(parEExtras1[1].getPeso() > parEExtras2[1].getPeso()) {
																vitorias1++;
															}
															else if(parEExtras1[1].getPeso() < parEExtras2[1].getPeso()) {
																vitorias2++;
															}
															else {
																empate++;
															}
														}
													}
												}
											}
											else if(jogo.getJogador1().isPar() == false && jogo.getJogador2().isPar() == false) { //TAMBÉM NAO TEM PAR, ENTAO VAI PARA A CARTA ALTA
												//COMO NAO TEM NENHUMA JOGADA NA MAO, VERIFICA A CARTA MAIS ALTA PARA DECIDIR QUEM GANHA
												if(jogo.getJogador1().getMao().getCartas()[4].getPeso() > jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
													vitorias1++;
												}
												else if(jogo.getJogador1().getMao().getCartas()[4].getPeso() < jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
													vitorias2++;
												}
												else {
													if(jogo.getJogador1().getMao().getCartas()[3].getPeso() > jogo.getJogador2().getMao().getCartas()[3].getPeso()) {
														vitorias1++;
													}
													else if(jogo.getJogador1().getMao().getCartas()[3].getPeso() < jogo.getJogador2().getMao().getCartas()[3].getPeso()) {
														vitorias2++;
													}
													else {
														if(jogo.getJogador1().getMao().getCartas()[2].getPeso() > jogo.getJogador2().getMao().getCartas()[2].getPeso()) {
															vitorias1++;
														}
														else if(jogo.getJogador1().getMao().getCartas()[2].getPeso() < jogo.getJogador2().getMao().getCartas()[2].getPeso()) {
															vitorias2++;
														}
														else {
															if(jogo.getJogador1().getMao().getCartas()[1].getPeso() > jogo.getJogador2().getMao().getCartas()[1].getPeso()) {
																vitorias1++;
															}
															else if(jogo.getJogador1().getMao().getCartas()[1].getPeso() < jogo.getJogador2().getMao().getCartas()[1].getPeso()) {
																vitorias2++;
															}
															else {
																if(jogo.getJogador1().getMao().getCartas()[0].getPeso() > jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
																	vitorias1++;
																}
																else if(jogo.getJogador1().getMao().getCartas()[0].getPeso() < jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
																	vitorias2++;
																}
																else {
																	empate++;
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
					}
				}
			}
			else {
				empate++;
			}
		
		}

		arq.close();
		file.close();
		System.out.println("O jogador 1 venceu: " + vitorias1);
		//System.out.println("O jogador 2 venceu: " + vitorias2);
		//System.out.println("Empates: " + empate);
		Date data2 = new Date();
		fim = data2.getTime();
		tempoDeExec = fim -inicio;
		System.out.println("Tempo de Execucao: "+tempoDeExec+"ms");

	}

}




//char numero1 = '-';
//char nipe1 = '+';
//char numero2 = '-';
//char nipe2 = '+';
//
//System.out.print("jogador 1: ");
//for (int i = 0; i < 5; i++) {
//	numero1 = jogo.getJogador1().getMao().getCartas()[i].getNumero();
//	nipe1 = jogo.getJogador1().getMao().getCartas()[i].getNipe();
//	System.out.print(numero1);
//	System.out.print(nipe1);
//	System.out.print(" ");
//}
//System.out.print("\t" + jogo.getJogador1().isRoyalFlush());
//System.out.print("    " + jogo.getJogador1().isStrFlush());
//System.out.print("    " + jogo.getJogador1().isQuadra());
//System.out.print("    " + jogo.getJogador1().isFullHouse());
//System.out.print("    " + jogo.getJogador1().isFlush());
//System.out.print("    " + jogo.getJogador1().isStraight());
//System.out.print("    " + jogo.getJogador1().isTrinca());
//System.out.print("    " + jogo.getJogador1().isDoisPares());
//System.out.print("    " + jogo.getJogador1().isPar());
//System.out.println("    " + jogo.getJogador1().isCartaAlta());
//System.out.println();
//
//
//System.out.print("jogador 2: ");
//for (int i = 0; i < 5; i++) {
//	numero2 = jogo.getJogador2().getMao().getCartas()[i].getNumero();
//	nipe2 = jogo.getJogador2().getMao().getCartas()[i].getNipe();
//	System.out.print(numero2);
//	System.out.print(nipe2);
//	System.out.print(" ");
//}
//System.out.print("\t" + jogo.getJogador2().isRoyalFlush());
//System.out.print("    " + jogo.getJogador2().isStrFlush());
//System.out.print("    " + jogo.getJogador2().isQuadra());
//System.out.print("    " + jogo.getJogador2().isFullHouse());
//System.out.print("    " + jogo.getJogador2().isFlush());
//System.out.print("    " + jogo.getJogador2().isStraight());
//System.out.print("    " + jogo.getJogador2().isTrinca());
//System.out.print("    " + jogo.getJogador2().isDoisPares());
//System.out.print("    " + jogo.getJogador2().isPar());
//System.out.println("    " + jogo.getJogador2().isCartaAlta());
//System.out.println();
//System.out.println();



//char numero1 = '-';
//char nipe1 = '+';
//char numero2 = '-';
//char nipe2 = '+';
//
//System.out.print("jogador 1: ");
//for (int i = 0; i < 5; i++) {
//	numero1 = jogo.getJogador1().getMao().getCartas()[i].getNumero();
//	nipe1 = jogo.getJogador1().getMao().getCartas()[i].getNipe();
//	System.out.print(numero1);
//	System.out.print(nipe1);
//	System.out.print(" ");
//}
//System.out.println();
//
//System.out.print("jogador 2: ");
//for (int i = 0; i < 5; i++) {
//	numero2 = jogo.getJogador2().getMao().getCartas()[i].getNumero();
//	nipe2 = jogo.getJogador2().getMao().getCartas()[i].getNipe();
//	System.out.print(numero2);
//	System.out.print(nipe2);
//	System.out.print(" ");
//}
//System.out.println();
//System.out.println();








////VERIFICA SE QUEM GANHA POR ROYALFLUSH... CASO ACONTEÇA O EMPATE, NAO TEM COMO DESEMPATAR POR MAIOR CARTA
//if (jogo.getJogador1().getMao().royalFlush(jogo.getJogador1().getMao()) == true && jogo.getJogador2().getMao().royalFlush(jogo.getJogador2().getMao()) == false) {
//	vitorias1++;
//}
//
//else if (jogo.getJogador1().getMao().royalFlush(jogo.getJogador1().getMao()) == false && jogo.getJogador2().getMao().royalFlush(jogo.getJogador2().getMao()) == true) {
//	vitorias2++;
//}
//
//else if(jogo.getJogador1().getMao().royalFlush(jogo.getJogador1().getMao()) == false && jogo.getJogador2().getMao().royalFlush(jogo.getJogador2().getMao()) == false){ 			//SE NAO TIVER ROYALFLUSH, VERIFICA SE ALGUM TEM STRAIGHTFLUSH
//	
//	if(jogo.getJogador1().getMao().straightFlush(jogo.getJogador1().getMao()) == true && jogo.getJogador2().getMao().straightFlush(jogo.getJogador2().getMao()) == false) {
//		vitorias1++;
//	}
//	
//	else if(jogo.getJogador1().getMao().straightFlush(jogo.getJogador1().getMao()) == false && jogo.getJogador2().getMao().straightFlush(jogo.getJogador2().getMao()) == true) {
//		vitorias2++;
//	}
//	
//	else if (jogo.getJogador1().getMao().straightFlush(jogo.getJogador1().getMao()) == false && jogo.getJogador2().getMao().straightFlush(jogo.getJogador2().getMao()) == false) { // SE TAMBÉM NAO TIVER STRAIGHTFLUSH, VERIFICA SE TEM UM FLUSH
//		if (jogo.getJogador1().getMao().flush(jogo.getJogador1().getMao()) == true && jogo.getJogador2().getMao().flush(jogo.getJogador2().getMao()) == false) {
//			vitorias1++;
//		}
//		else if (jogo.getJogador1().getMao().flush(jogo.getJogador1().getMao()) == false && jogo.getJogador2().getMao().flush(jogo.getJogador2().getMao()) == true) {
//			vitorias2++;
//		}
//		else if (jogo.getJogador1().getMao().flush(jogo.getJogador1().getMao()) == true && jogo.getJogador2().getMao().flush(jogo.getJogador2().getMao()) ==  true) {//DESEMPATE PARA FLUSH
//			if (jogo.getJogador1().getMao().getCartas()[4].getPeso() > jogo.getJogador2().getMao().getCartas()[4].getPeso()) {
//				vitorias1++;
//			}
//			else if (jogo.getJogador1().getMao().getCartas()[3].getPeso() > jogo.getJogador2().getMao().getCartas()[3].getPeso()) {
//				vitorias1++;
//			}
//			else if (jogo.getJogador1().getMao().getCartas()[2].getPeso() > jogo.getJogador2().getMao().getCartas()[2].getPeso()) {
//				vitorias1++;
//			}
//			else if (jogo.getJogador1().getMao().getCartas()[1].getPeso() > jogo.getJogador2().getMao().getCartas()[1].getPeso()) {
//				vitorias1++;
//			}
//			else if (jogo.getJogador1().getMao().getCartas()[0].getPeso() > jogo.getJogador2().getMao().getCartas()[0].getPeso()) {
//				vitorias1++;
//			}
//			else {
//				empate++;
//			}
//		}
//		else if (jogo.getJogador1().getMao().flush(jogo.getJogador1().getMao()) == false && jogo.getJogador2().getMao().flush(jogo.getJogador2().getMao()) == false) { //SE TAMBÉM NAO TEM FLUSH, VERIFICA SE TEM
//			
//		}
//	}
//	
//	else {
//		empate++;
//	}
//}
//
//else {
//	empate++;
//}	
