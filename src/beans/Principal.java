package beans;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader file = new FileReader("artefatos\\pokerK.txt");
		BufferedReader arq = new BufferedReader(file);
		
		String linha = "";
		String maos[];
		
		char numero = '0';
		char nipe = '0';
		int ind1 = 0;
		int ind = 0;
		
		Carta carta = null;
		Carta cartas1[] = new Carta[5];
		Carta cartas2[] = new Carta[5];
		Mao mao1 = null;
		Mao mao2 = null;
		Jogador j1 = null;
		Jogador j2 = null;
		Poker jogo = null;
		
		
		while  ((linha = arq.readLine()) != null) {
			maos = linha.split(" ");
			for (int i = 0; i < 10; i++) {
				numero = maos[i].charAt(0);
				nipe = maos[i].charAt(1);
				carta = new Carta(numero, nipe);
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
			mao2 = new Mao(cartas2);
			j1 = new Jogador (mao1);
			j2 = new Jogador (mao2);
			
			jogo = new Poker(j1, j2);
			
			char numero1 = '-';
			char nipe1 = '+';
			char numero2 = '-';
			char nipe2 = '+';
			
			System.out.print("jogador 1: ");
			for (int i = 0; i < 5; i++) {
				numero1 = jogo.getJogador1().getMao().getCartas()[i].getNumero(); 
				nipe1 = jogo.getJogador1().getMao().getCartas()[i].getNipe();
				System.out.print(numero1);
				System.out.print(nipe1);
				System.out.print(" ");
			}
			System.out.println();
			
			System.out.print("jogador 2: ");
			for (int i = 0; i < 5; i++) {
				numero2 = jogo.getJogador2().getMao().getCartas()[i].getNumero();
				nipe2 = jogo.getJogador1().getMao().getCartas()[i].getNipe();
				System.out.print(numero2);
				System.out.print(nipe2);
				System.out.print(" ");
			}
			System.out.println();
			System.out.println();
			
		}
		
		arq.close();
		file.close();

	}

}
