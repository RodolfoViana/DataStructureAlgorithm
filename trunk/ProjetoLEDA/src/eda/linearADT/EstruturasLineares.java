package eda.linearADT;
import java.util.Scanner;


public class EstruturasLineares {
	
	private int estrutura;
	
	public static void main(String[] args) {

	}
	
	public void head() {
		System.out.print("    Universidade Federal de Campina Grande\n" +
	         	 "        Disciplina: Laboratorio de Estrutura de Dados\n" +
		         "        Projeto Implementacao das Estruturas Lineares\n" +
		         "        Lista Ligada (Simples e Dupla), Fila, Pilha");
	}
		
	/**
	 * Menu com as opcoes das implementacoes das Estruturas Lineares.
	 */
	public void menuEstruturas(int estrutura) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("================ Menu ===============");
		System.out.println(" 1 - Pilha");
		System.out.println(" 2 - Fila");
		System.out.println(" 3 - Linked List Simples");
		System.out.println(" 4 - Linked List Dupla");
		System.out.println(" 5 - Sair");
		System.out.println("Digite a Opção: ");
		System.out.println("=====================================");
		int opcao = sc.nextInt();
		
		switch (estrutura) {

		case 1:
			menuPilha();

		case 2:
			menuFila();
			
		case 3:
			menuListaSimples();
			
		case 4:
			menuListaDupla();
          
		case 5:
			System.out.println("FIM");
			System.exit(0);

		default:
			System.out.println("Opção inválida!");
			break;
		}

	}

	/**
	 * Menu com as opcoes da implementacao de Pilha.
	 */
	public void menuPilha() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("=============== PILHA ===============");
		System.out.println(" ");
		System.out.println(" 1 - Implementação da Pilha");
		System.out.println(" 2 - Implementação da Pilha usando Linked List");
		System.out.println(" 3 - Implementação da Pilha usando Fila");
		System.out.println(" 4 - Retornar ao menu");
		System.out.println("Digite a Opção: ");
		System.out.println("=====================================");
		int opcao = sc.nextInt();
		
		switch (estrutura) {

		case 1:
//			implPilha();

		case 2:
//			implPilhaComLinkedList();
			
		case 3:
//          implPilhaComFila();
			
		case 4:
			main(null);

		default:
			System.out.println("Opção inválida!");
			break;
		}
		
	}
	
	/**
	 * Menu com as opcoes da implementacao de Fila.
	 */
	public void menuFila() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=============== FILA ================");
		System.out.println(" ");
		System.out.println(" 1 - Implementação da Fila");
		System.out.println(" 2 - Retornar ao menu");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Digite a Opção: ");
		System.out.println("=====================================");
		int opcao = sc.nextInt();
		
		switch (estrutura) {

		case 1:
//			implFila();

		case 2:
			main(null);

		default:
			System.out.println("Opção inválida!");
			break;
		}
		
	}

	/**
	 * Menu com as opcoes da implementacao de Linked List Simples.
	 */
	public void menuListaSimples() {
		Scanner sc = new Scanner(System.in);
		System.out.println("======== LINKED LIST SIMPLES ========");
		System.out.println(" ");
		System.out.println(" 1 - Implementação Recursiva");
		System.out.println(" 2 - Implementação Não-Recursiva");
		System.out.println(" 3 - Retornar ao menu");
		System.out.println(" ");
		System.out.println("Digite a Opção: ");
		System.out.println("=====================================");
		int opcao = sc.nextInt();
		
		switch (estrutura) {

		case 1:
//			implSingleLinkedListRecursive();

		case 2:
//			implSingleLinkedListNonRecursive();
			
		case 3:
			main(null);

		default:
			System.out.println("Opção inválida!");
			break;
		}
		
	}
	
	/**
	 * Menu com as opcoes da implementacao de Linked List Dupla.
	 */
	public void menuListaDupla() {
		Scanner sc = new Scanner(System.in);
		System.out.println("========= LINKED LIST DUPLA ========");
		System.out.println(" ");
		System.out.println(" 1 - Implementação Recursiva");
		System.out.println(" 2 - Implementação Não-Recursiva");
		System.out.println(" 3 - Retornar ao menu");
		System.out.println(" ");
		System.out.println("Digite a Opção: ");
		System.out.println("=====================================");
		int opcao = sc.nextInt();
		
		switch (estrutura) {

		case 1:
//			implDoubleLinkedListRecursive();

		case 2:
//			implDoubleLinkedListNonRecursive();
			
		case 3:
			main(null);

		default:
			System.out.println("Opção inválida!");
			break;
		}
		
	}
		
	
}
