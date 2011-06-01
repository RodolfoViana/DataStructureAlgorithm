package eda.linearADT;

import java.util.Scanner;

public class EstruturasLineares {
	
	// 8 ESTRUTURAS
	
	// SINGLE LINKED LIST NON-RECURSIVE
	private static SingleLinkedListNonRecursiveImpl<Integer> singleLinkedListNonRecursive = new SingleLinkedListNonRecursiveImpl<Integer>();;	
	
	// SINGLE LINKED LIST RECURSIVE
	private static SingleLinkedListRecursiveImpl<Integer> singleLinkedListRecursive = new SingleLinkedListRecursiveImpl<Integer>();

	// DOUBLE LINKED LIST NON-RECURSIVE
	private static DoubleLinkedListNonRecursiveImpl<Integer> doubleLinkedListNonRecursive = new DoubleLinkedListNonRecursiveImpl<Integer>();
	
	// DOUBLE LINKED LIST RECURSIVE
	private static DoubleLinkedListRecursiveImpl<Integer> doubleLinkedListRecursive = new DoubleLinkedListRecursiveImpl<Integer>();
	
	// QUEUE
	private static QueueImpl<Integer> queue = new QueueImpl<Integer>();
	
	// STACK
	private static StackImpl<Integer> stack = new StackImpl<Integer>();
	
	// STACK LINKED LIST
	private static StackLinkedListImpl<Integer> stackLinkedList = new StackLinkedListImpl<Integer>();
	
	// STACK QUEUE
	private static StackQueueImpl<Integer> stackQueue = new StackQueueImpl<Integer>();
	
	
	static Scanner sc = new Scanner(System.in);
	public static void limpaScanner() {
		sc = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
			head();
			menu();
	}

	/**
	 * Cabecalho
	 */
	public static void head() {
		System.out.print("        Universidade Federal de Campina Grande\n"
				+ "        Disciplina: Laboratorio de Estrutura de Dados\n"
				+ "        Projeto Implementacao das Estruturas Lineares\n"
				+ "        Lista Ligada (Simples e Dupla), Fila, Pilha\n\n");
	}
	
	/**
	 * Menu da Estrutura a ser escolhida
	 */
	public static void menu() {
		limpaScanner();
		System.out.println("\n        ...........:  Menu  :...........\n");
		System.out.println("Selecione qual estrutura deseja usar: \n");
		System.out.println
			   ("1) Lista Simples Nao-Recursiva     5) Fila \n" +
				"2) Lista Simples Recursiva         6) Pilha \n" +
				"3) Lista Dupla Nao-Recursiva       7) Pilha Implementada com Filas\n" +
				"4) Lista Dupla Recursiva           8) Pilha Implementada com Lista Simples");
		
		int estrutura = sc.nextInt();
		seleciona(estrutura);
	}
	
	/**
	 * 
	 * @param estrutura Que foi escolhida
	 */
	public static void seleciona(int estrutura) {
		switch (estrutura) {

		case 1:
			menuListaSimplesN();
			break;
		case 2:
			menuListaSimplesR();
			break;
		case 3:
			menuListaDuplaN();
			break;
		case 4:
			menuListaDuplaR();
			break;
		case 5:
			menuFila();
			break;
		case 6:
			menuPilha();
			break;
		case 7:
			menuPilhaComFilas();
			break;
		case 8:
			menuPilhaComLista();
			break;
		case 9:
			System.out.println("O programa foi encerrado com sucesso.\n" +
					           "Desenvolvido por: Talita, Layse, Rodolfo e Renan\n" +
					           "Ciencia da Computacao - Prof. Adalberto");
			System.exit(0);
		default:
			System.out.println("O programa foi encerrado com sucesso.\n");
			break;
		}
	}

	
	/**
	 * opcoes de manejar a pilha implementada com lista
	 * PILHA COM LISTAS
	 */
	private static void menuPilhaComLista() {
		System.out.println("\n\n        ...........:  Pilha Com Lista  :...........\n");
		System.out.println("        O que deseja fazer: \n");
		System.out.print
			   ("        1) Inserir Elemento     3) Topo da Estrutura \n" +
				"        2) Remover Elemento     4) Exibir Estrutura \n" +
				"        5) Menu de Estruturas   Sua Escolha: ");
		limpaScanner();
		int escolha = sc.nextInt();
		operacoesPilhaComLista(escolha);
		
	}
	
	private static void operacoesPilhaComLista(int escolha) {		
		switch(escolha) {
		
		case 1: 
			limpaScanner();
			try {
				System.out.print("\n        Elemento a ser inserido: ");
				int elemento = sc.nextInt();
				stackLinkedList.push(elemento);
				menuPilha();	
			} catch (Exception e) {
				menuPilha();
			}
			
		case 2:
			try { // retorna o elemento removido
				System.out.print("\n        Elemento Removido: " + stackLinkedList.pop());
				menuPilha();
			} catch (Exception e) {
				menuPilha();
			}
			
		case 3:
			try { // retorna o topo da pilha
				System.out.print("        O topo da Pilha eh: " + stackLinkedList.top()); //  ");
				menuPilha();
			} catch (Exception e) {
				menuPilha();	
			}
			
		case 4: // informacoes presentes na estrutura
			 System.out.println("\n        " + stackLinkedList.toString());
		     
			menuPilha();
			
		case 5:
			menu();
			
		default:
			System.out.println("\n        O programa foi encerrado com sucesso.\n");
			break;
		}
	}

	
	/**
	 * PILHA COM DUAS FILAS
	 */
	private static void menuPilhaComFilas() {

		System.out.println("\n\n        ...........:  Pilha Com Filas  :...........\n");
		System.out.println("        O que deseja fazer: \n");
		System.out.print
			   ("        1) Inserir Elemento     3) Topo da Estrutura \n" +
				"        2) Remover Elemento     4) Exibir Estrutura \n" +
				"        5) Menu de Estruturas   Sua Escolha: ");
		limpaScanner();
		int escolha = sc.nextInt();
		operacoesPilhaComFilas(escolha);
	}
	
	private static void operacoesPilhaComFilas(int escolha) {
		
		switch(escolha) {
		
		case 1:
			limpaScanner();
			try {
				System.out.print("\n        Elemento a ser inserido: ");
				int elemento = sc.nextInt();
				stackQueue.push(elemento);
				menuPilha();	
			} catch (Exception e) {
				menuPilha();
			}
			
		case 2:
			try {
				System.out.print("\n        Elemento Removido: " + stackQueue.pop());
				menuPilha();
			} catch (Exception e) {
				menuPilha();
			}
			
		case 3:
			try {
				System.out.print("        O topo da Pilha eh: ");  stackQueue.top();
				menuPilha();
			} catch (Exception e) {
				menuPilha();	
			}
			
		case 4:
			 System.out.println("\n        " + stackQueue.toString());
			menuPilha();
			
		case 5:
			menu();
			
		default:
			System.out.println("\n        O programa foi encerrado com sucesso.\n");
			break;
		}
	}

	/**
	 * PILHA 
	 */
	private static void menuPilha() {

		System.out.println("\n\n        ...........:  Pilha  :...........\n");
		System.out.println("        O que deseja fazer: \n");
		System.out.print
			   ("        1) Inserir Elemento     3) Topo da Estrutura \n" +
				"        2) Remover Elemento     4) Exibir Estrutura \n" +
				"        5) Menu de Estruturas   Sua Escolha: ");
		limpaScanner();
		int escolha = sc.nextInt();
		operacoesPilha(escolha);
	}

	private static void operacoesPilha(int escolha) {
		switch(escolha) {
		
		case 1:
			limpaScanner();
			try {
				System.out.print("\n        Elemento a ser inserido: ");
				int elemento = sc.nextInt();
				stack.push(elemento);
				menuPilha();	
			} catch (Exception e) {
				menuPilha();
			}
			
		case 2:
			try {
				System.out.print("\n        Elemento Removido: " + stack.pop()); 
				menuPilha();
			} catch (Exception e) {
				menuPilha();
			}
			
		case 3:
			try {
				System.out.print("\n        O topo da Pilha eh: " + stack.top());  
				menuPilha();
			} catch (Exception e) {
				menuPilha();	
			}
			
		case 4:
			 System.out.println("\n        " + stack.toString());
			menuPilha();
			
		case 5:
			menu();
		default:
			System.out.println("\n        O programa foi encerrado com sucesso.\n");
			break;
		}
	}
	
	
	/**
	 * FILA ok
	 */
	private static void menuFila() {

		
		System.out.println("\n\n        ...........:  Fila  :...........\n");
		System.out.println("        O que deseja fazer: \n");
		System.out.print
			   ("        1) Inserir Elemento     3) Cabeca da Estrutura \n" +
				"        2) Remover Elemento     4) Exibir Estrutura \n" +
				"        5) Menu de Estruturas   Sua Escolha: ");
		limpaScanner();
		int escolha = sc.nextInt();
		operacoesFila(escolha);
	}
	
	private static void operacoesFila(int escolha) {
		
		switch(escolha) {
		
		case 1:
			try {
				limpaScanner();
				System.out.print("\n        Elemento a ser inserido: ");
				int elemento = sc.nextInt();
				queue.enqueue(elemento);
				menuFila();	
			} catch (Exception e) {
				menuFila();
			}
			
		case 2:
			try {
				System.out.print("\n        Elemento Removido: " + queue.dequeue());
				menuFila();	
			} catch (Exception e) {
				menuFila();
			}
			
		case 3:
			try {
				System.out.print("\n        O Topo da Estrutura eh: " + queue.head());
				menuFila();
			} catch (Exception e) {
				menuFila();	
			}
			
		case 4:
			System.out.println("\n        " + queue.toString());
			menuFila();
			
		case 5:
			menu();
			
		default:
			System.out.println("\n        O programa foi encerrado com sucesso.\n");
			break;
		}
	}

	
	/**
	 *  LISTA DUPLA RECURSIVA
	 */
	private static void menuListaDuplaR() {
		System.out.println("\n\n        ...........:  Lista Dupla Recursiva  :...........\n");
		System.out.println("        O que deseja fazer: \n");
		System.out.print
			   ("        1) Inserir                       6) Remover Elemento Da Cabeca \n" +
				"        2) Remover                       7) Minimo/Maximo \n" +
				"        3) Inserir Elemento Na Cabeca    8) Procurar Elemento\n" +
				"        4) Inserir Elemento Na Calda     9) Exibir Estrutura\n" +
				"        5) Remover Elemento Da Calda    10) Menu de Estruturas\n" +
				"       Sua Escolha: ");
		limpaScanner();
		int escolha = sc.nextInt();
		operacoesListaDuplaR(escolha);
	}
	
	private static void operacoesListaDuplaR(int escolha) {

		switch(escolha) {
		
		case 1: // INSERE 
			try {
				limpaScanner();
				System.out.print("\n        Elemento a ser inserido: ");
				int elemento = sc.nextInt();
				doubleLinkedListRecursive.insert(elemento);
				menuListaDuplaN();	
			} catch (Exception e) {
				menuListaDuplaN();
			}
			
		case 2: // REMOVE
			try {
				limpaScanner();
				System.out.print("\n        Elemento a ser Removido: ");
				int removido = sc.nextInt();
				doubleLinkedListRecursive.remove(removido);		
				menuListaDuplaN();
			} catch (Exception e) {
				menuListaDuplaN();
			}
			
		case 3: // INSERIR NA CABECA
			try {
				limpaScanner();
				System.out.print("\n        Elemento a ser inserido: ");
				int elemento = sc.nextInt();
				doubleLinkedListRecursive.addFirst(elemento);
				menuListaDuplaN();	
			} catch (Exception e) {
				menuListaDuplaN();
			}
			
		case 4: // INSERIR NA CALDA
			try {
				limpaScanner();
				System.out.print("\n        Elemento a ser inserido: ");
				int elemento = sc.nextInt();
				doubleLinkedListRecursive.addLast(elemento);
				menuListaDuplaN();	
			} catch (Exception e) {
				menuListaDuplaN();
			}
			
		case 5: // REMOVER ELEMENTO DA CALDA
			try {
				doubleLinkedListRecursive.removeLast();				
				menuListaDuplaN();
			} catch (Exception e) {
				menuListaDuplaN();
			}
			
		case 6: // REMOVER ELEMENTO DA CABECA
			try {
				doubleLinkedListRecursive.removeFirst();
				
				menuListaDuplaN();
			} catch (Exception e) {
				menuListaDuplaN();
			}
			
		case 7: // MINIMO E MAXIMO
			try {
				System.out.print("\n        Elemento Minimo: " + doubleLinkedListRecursive.minimum()); // + 
				System.out.println("\n        Elemento Maximo: " + doubleLinkedListRecursive.maximum());
				menuListaDuplaN();
			} catch (Exception e) {
				menuListaDuplaN();
			}
			
		case 8: // PESQUISA
			try {
				limpaScanner();
				System.out.print("\n        Elemento a ser pesquisado: ");
				int elemento = sc.nextInt();
				System.out.println("\n        " + doubleLinkedListRecursive.search(elemento));
				menuListaDuplaN();
			} catch (Exception e) {
				menuListaDuplaN();
			}
			
		case 9:
			System.out.println("\n        " + doubleLinkedListRecursive.toString());
			menuListaDuplaN();
			
		case 10:
			menu();
		default:
			System.out.println("\n        O programa foi encerrado com sucesso.\n");
			break;
		}
	}

	
	/**
	 * LISTA DUPLA NAO RECURSIVA
	 */
	private static void menuListaDuplaN() {
		System.out.println("\n\n        ...........:  Lista Dupla Nao-Recursiva  :...........\n");
		System.out.println("        O que deseja fazer: \n");
		System.out.print
			   ("        1) Inserir                       6) Remover Elemento Da Cabeca \n" +
				"        2) Remover                       7) Minimo/Maximo \n" +
				"        3) Inserir Elemento Na Cabeca    8) Procurar Elemento\n" +
				"        4) Inserir Elemento Na Calda     9) Exibir Estrutura\n" +
				"        5) Remover Elemento Da Calda    10) Menu de Estruturas\n" +
				"       Sua Escolha: ");
		limpaScanner();
		int escolha = sc.nextInt();
		operacoesListaDuplaN(escolha);
	}
	
	private static void operacoesListaDuplaN(int escolha) {
		
		switch(escolha) {
		
		case 1: // INSERE 
			try {
				limpaScanner();
				System.out.print("\n        Elemento a ser inserido: ");
				int elemento = sc.nextInt();
				doubleLinkedListNonRecursive.insert(elemento);
				menuListaDuplaN();	
			} catch (Exception e) {
				menuListaDuplaN();
			}
			
		case 2: // REMOVE
			try {
				limpaScanner();
				System.out.print("\n        Elemento a ser Removido: ");
				int removido = sc.nextInt();
				doubleLinkedListNonRecursive.remove(removido);				
				menuListaDuplaN();
			} catch (Exception e) {
				menuListaDuplaN();
			}
			
		case 3: // INSERIR NA CABECA
			try {
				limpaScanner();
				System.out.print("\n        Elemento a ser inserido: ");
				int inserido = sc.nextInt();
				doubleLinkedListNonRecursive.addFirst(inserido);
				menuListaDuplaN();	
			} catch (Exception e) {
				menuListaDuplaN();
			}
			
		case 4: // INSERIR NA CALDA
			try {
				limpaScanner();
				System.out.print("\n        Elemento a ser inserido: ");
				int inserido = sc.nextInt();
				doubleLinkedListNonRecursive.addLast(inserido);
				menuListaDuplaN();	
			} catch (Exception e) {
				menuListaDuplaN();
			}
			
		case 5: // REMOVER ELEMENTO DA CALDA
			try {
				doubleLinkedListNonRecursive.removeLast();				
				menuListaDuplaN();
			} catch (Exception e) {
				menuListaDuplaN();
			}
			
		case 6: // REMOVER ELEMENTO DA CABECA
			try {
				doubleLinkedListNonRecursive.removeFirst();
				menuListaDuplaN();
			} catch (Exception e) {
				menuListaDuplaN();
			}
			
		case 7: // MINIMO E MAXIMO
			try {
				System.out.print("\n        Elemento Minimo: " + doubleLinkedListNonRecursive.minimum());
				System.out.println("\n        Elemento Maximo: " + doubleLinkedListNonRecursive.maximum());
				menuListaDuplaN();
			} catch (Exception e) {
				menuListaDuplaN();
			}
			
		case 8: // PESQUISA
			try {
				limpaScanner();
				System.out.print("\n        Elemento a ser pesquisado: ");
				int elemento = sc.nextInt();
				System.out.println(doubleLinkedListNonRecursive.search(elemento));
				menuListaDuplaN();
			} catch (Exception e) {
				menuListaDuplaN();
			}
		case 9:
			System.out.println("\n        " + doubleLinkedListNonRecursive.toString());
			menuListaDuplaN();
			
		case 10:
			menu();
		default:
			System.out.println("\n        O programa foi encerrado com sucesso.\n");
			break;
		}
	}

	
	/**
	 * LISTA SIMPLES RECURSIVA
	 */
	private static void menuListaSimplesR() {
		System.out.println("\n\n        ...........:  Lista Simples Recursiva  :...........\n");
		System.out.println("        O que deseja fazer: \n");
		System.out.print
			   ("        1) Inserir Elemento     4) Pesquisar Elemento \n" +
				"        2) Remover Elemento     5) Exibir Estrutura \n" +
				"        3) Minimo/Maximo        6) Menu de Estruturas" +
				"       Sua Escolha: ");
		limpaScanner();
		int escolha = sc.nextInt();
		operacoesListaSimplesR(escolha);
	}
	
	private static void operacoesListaSimplesR(int escolha) {
		
		switch(escolha) {
		
		case 1: // INSERE 
			try {
				limpaScanner();
				System.out.print("\n        Elemento a ser inserido: ");
				int elemento = sc.nextInt();
				singleLinkedListRecursive.insert(elemento);
				menuListaSimplesR();	
			} catch (Exception e) {
				menuListaSimplesR();
			}
			
		case 2: // REMOVE
			try {
				System.out.print("\n        Elemento a ser Removido: ");
				int elemento = sc.nextInt();
				singleLinkedListRecursive.remove(elemento);
				menuListaSimplesR();
			} catch (Exception e) {
				menuListaSimplesR();
			}
			
		case 3: // MINIMO E MAXIMO
			try {
				System.out.println("Elemento Minimo: " + singleLinkedListRecursive.minimum()); 
				System.out.println("Elemento Maximo: " + singleLinkedListRecursive.maximum());
				menuListaSimplesR();
			} catch (Exception e) {
				menuListaSimplesR();
			}
			
		case 4: // PESQUISA
			try {
				limpaScanner();
				System.out.print("\n        Elemento a ser pesquisado: ");
				int elemento = sc.nextInt();
				System.out.println(singleLinkedListNonRecursive.search(elemento));
				menuListaSimplesR();
			} catch (Exception e) {
				menuListaSimplesR();
			}
			
		case 5: // INFORMACOES NA ESTRUTURAS
			System.out.println("\n        " + singleLinkedListNonRecursive.toString());
			menuListaSimplesR();
			
		case 6:
			menu();
		default:
			System.out.println("\n        O programa foi encerrado com sucesso.\n");
			break;
		}
	}

	
	/**
	 * LISTA SIMPLES NAO RECURSIVA ok
	 */
	private static void menuListaSimplesN() {
		System.out.println("\n\n        ...........:  Lista Simples Nao-Recursiva  :...........\n");
		System.out.println("        O que deseja fazer: \n");
		System.out.print
			   ("        1) Inserir Elemento     4) Pesquisar Elemento \n" +
				"        2) Remover Elemento     5) Exibir Estrutura \n" +
				"        3) Minimo/Maximo        6) Menu de Estruturas" +
				"       Sua Escolha: ");
		limpaScanner();
		int escolha = sc.nextInt();
		operacoesListaSimplesN(escolha);
	}
	
	private static void operacoesListaSimplesN(int  escolha) {
		
		switch(escolha) {
		
		case 1: // INSERE 
			try {
				limpaScanner();
				System.out.print("\n        Elemento a ser inserido: ");
				int elemento = sc.nextInt();
				singleLinkedListNonRecursive.insert(elemento);
				menuListaSimplesN();	
			} catch (Exception e) {
				menuListaSimplesN();
			}
			
		case 2: // REMOVE
			try {
				limpaScanner();
				System.out.print("\n        Elemento a ser Removido: ");
				int elemento = sc.nextInt();
				singleLinkedListNonRecursive.remove(elemento);
				menuListaSimplesN();
			} catch (Exception e) {
				menuListaSimplesN();
			}
			
		case 3: // MINIMO E MAXIMO
			try {
				System.out.println("\n        Elemento Minimo: " + singleLinkedListNonRecursive.minimum());
				System.out.println("\n        Elemento Maximo: " + singleLinkedListNonRecursive.maximum());
				menuListaSimplesN();
			} catch (Exception e) {
				menuListaSimplesN();
			}
			
		case 4: // PESQUISA
			try {
				limpaScanner();
				System.out.print("\n        Elemento a ser pesquisado: ");
				int elemento = sc.nextInt();
				System.out.println(singleLinkedListNonRecursive.search(elemento));
				menuListaSimplesN();
			} catch (Exception e) {
				menuListaSimplesN();
			}
			
		case 5:
			System.out.println("\n        " + singleLinkedListNonRecursive.toString());
			menuListaSimplesN();
			
		case 6:
			menu();
		default:
			System.out.println("\n        O programa foi encerrado com sucesso.\n");
			break;
		}
	}
}
