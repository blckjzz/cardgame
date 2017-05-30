package controle;

import java.util.Random;
import java.util.Scanner;

import dominio.ListaDuplamenteCircular;
import dominio.ListaDuplamenteCircular.Node;

public class ProgramaJogoCarta {

	static Scanner input = new Scanner(System.in);
	private static int carta;
	private static Node jogadorAnterior;
	private static Node jogador;
	private static boolean inverter = false;
	static ListaDuplamenteCircular lista = new ListaDuplamenteCircular();

	public static void main(String[] args) {

		iniciaJogo();

		System.out.println("Jogo começa com: " + jogador.getData());

		do {
			int carta = verificaCarta();
			System.out.println("Carta escolhida:" + carta);
			// jogador;

			switch (carta) {

			case 1:
				System.out.println("Carta #1: Pula o próximo jogador e passa a vez para o seguinte. ");
				jogador = pula2Jogadores(inverter);
				break;

			case 3:
				System.out.println("Carta #3: Elimina o terceiro jogador contado a partir do jogador atual.  ");
				System.out.println("Jogador atual:" + jogador.getData());
				Node eliminado = pula3Jogadores(inverter);
				System.out.println("O jogador a ser removido será: " + eliminado.getData());
				int pos = lista.buscarElemento(eliminado.getData());
				lista.deleteAtPos(pos);
				passaVez(inverter);
				break;

			case 9:
				System.out.println("Carta #9: Elimina o jogador anterior na roda.  ");

				System.out.println("Jogador da rodada Anterior:" + jogadorAnterior.getData());

				pos = lista.buscarElemento(jogadorAnterior.getData());
				lista.deleteAtPos(pos);
				passaVez(inverter);

				break;

			case 12:
				System.out.println("Carta #12: Inverte o sentido do jogo.");
				if (inverter) {
					inverter = false;
				} else {
					inverter = true;
				}
				passaVez(inverter);

				System.out.println("Inverter está " + ((inverter) ? "ATIVO" : "INATIVO"));
				break;

			default:
				carta = verificaCarta();
				break;
			}

			System.out.println("# PROXIMO JOGADOR: " + jogador.getData() + " # ");
			/* exibir listagem de jogadores */

			System.out.println("\n\n# ---------  Jogadores  ------------ #\n \n ");
			lista.display();

			System.out.println("\n\n# ---------  FIM Jogadores  ------------ #\n \n ");
		} while (lista.size > 1);

		System.out.println("Vencedor foi:" + lista.getStart().getData());
	}

	private static Node pula2Jogadores(boolean inverter) {
		if (!inverter) {
			jogador = jogador.getLinkNext().getLinkNext();
		} else {
			jogador = jogador.getLinkPrev().getLinkPrev();
		}
		return jogador;
	}

	private static Node pula3Jogadores(boolean inverter) {
		if (!inverter) {
			jogador = jogador.getLinkNext().getLinkNext().getLinkNext();
		} else {
			jogador = jogador.getLinkPrev().getLinkPrev().getLinkPrev();
		}
		return jogador;
	}

	private static void passaVez(boolean inverter) {
		System.out.println("#PASSANDO A VEZ#");
		jogadorAnterior = jogador;
		if (!inverter) {
			jogador = jogador.getLinkNext();
		} else {
			jogador = jogador.getLinkPrev();
		}
		// System.out.println("Jogador anterior:" + jogadorAnterior.getData());
		// System.out.println("Agora é vez de [" + jogador.getData() + "]");
	}

	private static int verificaCarta() {
		System.out.println("Informe a Carta da rodada {1-3-9-12}: ");
		carta = input.nextInt();
		while (carta < 0 || carta > 12) {
			System.err.println("Carta inválida");
			System.out.println("Informe a Carta da rodada {1-3-9-12}: ");
			carta = input.nextInt();
		}
		return carta;
	}

	private static void iniciaJogo() {
		lista.insertAtEnd("Maria");
		lista.insertAtEnd("Max");
		lista.insertAtEnd("Rodrigo");
		lista.insertAtEnd("Luciane");
		lista.insertAtEnd("Milena");
		lista.insertAtEnd("Diego");
		lista.insertAtEnd("Matheus");
		lista.insertAtEnd("Luciene");
		lista.insertAtEnd("Michele");
		lista.insertAtEnd("Gabriel");

		jogador = lista.getStart();
		jogadorAnterior = jogador;
		System.out.println("Os jogadores estão dispostos na seguinte ordem:");

		lista.display();
	}
}
