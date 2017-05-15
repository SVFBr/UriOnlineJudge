import java.util.Scanner;

public class J1024Criptografia {

	/*
	 * Solicitaram para que você construisse um programa simples de
	 * criptografia. Este programa deve possibilitar enviar mensagens
	 * codificadas sem que alguém consiga lê-las. O processo é muito simples.
	 * São feitas três passadas em todo o texto.
	 * 
	 * Na primeira passada, somente caracteres que sejam letras minúsculas e
	 * maiúsculas devem ser deslocadas 3 posições para a direita, segundo a
	 * tabela ASCII: letra 'a' deve virar letra 'd', letra 'y' deve virar
	 * caractere '|' e assim sucessivamente. Na segunda passada, a linha deverá
	 * ser invertida. Na terceira e última passada, todo e qualquer caractere a
	 * partir da metade em diante (truncada) devem ser deslocados uma posição
	 * para a esquerda na tabela ASCII. Neste caso, 'b' vira 'a' e 'a' vira '`'.
	 * 
	 * Por exemplo, se a entrada for “Texto #3”, o primeiro processamento sobre
	 * esta entrada deverá produzir “Wh{wr #3”. O resultado do segundo
	 * processamento inverte os caracteres e produz “3# rw{hW”. Por último, com
	 * o deslocamento dos caracteres da metade em diante, o resultado final deve
	 * ser “3# rvzgV”.
	 * 
	 * Para cada entrada, deve-se apresentar a mensagem criptografada. 
	 * 
	 * Exemplo  de Entrada : 4 Texto #3 abcABC1 vxpdylY .ph vv.xwfxo.fd 
	 * Exemplo de Saída : 3# rvzgV 1FECedc ks. \n{frzx gi.r{hyz-xx
	 * ..
	 */
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String[] input = new String[n];

		for (int iRe = 0; iRe < n; iRe++) {
			input[iRe] = sc.nextLine();
		}

		for (int iPrWr = 0; iPrWr < n; iPrWr++) {

			// Primeira passagem
			StringBuilder txtPri = new StringBuilder();
			for (int i = 0; i < input[iPrWr].length(); i++) {
				int aux = 0;
				char c = input[iPrWr].charAt(i);
				if (Character.isLetter(c)) {
					aux = (int) c + 3;
					txtPri.append((char) aux);
				} else {
					aux = (int) c;
					txtPri.append((char) aux);
				}
			}
			// Segunda Passagem
			StringBuilder txtSeg = new StringBuilder(txtPri).reverse();

			// Terceira Passagem
			int truncar = txtSeg.length() / 2;
			StringBuilder txtTer = new StringBuilder();
			for (int i = 0; i < txtSeg.length(); i++) {
				int aux = 0;
				char c = txtSeg.charAt(i);
				if (i >= truncar) {
					aux = (int) c - 1;
					txtTer.append((char) aux);
				} else {
					aux = (int) c;
					txtTer.append((char) aux);
				}
			}
			System.out.println(txtTer);

		}
	}
}