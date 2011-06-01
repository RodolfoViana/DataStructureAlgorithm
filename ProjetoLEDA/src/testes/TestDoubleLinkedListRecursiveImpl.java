package testes;

import eda.linearADT.DoubleLinkedListRecursiveImpl;
import eda.util.ADTNoSuchElement;
import eda.util.ADTOverflowException;
import eda.util.ADTUnderflowException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Universidade Federal de Campina Grande
 * Projetos de Laboratorio de Estrutura de Dados
 * 
 * Equipe:  Layse Sobreira
 * 			Renan Pinto
 * 			Rodolfo Viana
 * 			Talita Lobo
 * 
 * 	Implementacao das Estruturas Lineares
 * 		Lista Dupla, Lista Simples, Fila e Pilha
 * 			Testes da Classe DoubleLinkedListRecursive.java
 */

public class TestDoubleLinkedListRecursiveImpl {
	
	private DoubleLinkedListRecursiveImpl<Integer> linkedList;
	
	@Before public void construtor(){
		linkedList = new DoubleLinkedListRecursiveImpl<Integer>();
	}
	
	@Test public void isEmpty(){
		Assert.assertTrue(linkedList.isEmpty());
	}
	
	@Test public void insert() throws ADTOverflowException{
		linkedList.insert(10);
		Assert.assertEquals("Nao ta inserindo", 1, linkedList.size());
		linkedList.insert(15);
		Assert.assertEquals("Nao ta inserindo", 2, linkedList.size());
	}
	
	@Test public void search() throws ADTOverflowException, ADTNoSuchElement{
		linkedList.insert(20);
		linkedList.insert(30);
		linkedList.insert(40);
		
		Assert.assertEquals("Nao ta procurando", 40, linkedList.search(40));
		Assert.assertEquals("Nao ta procurando", 30, linkedList.search(30));
		Assert.assertEquals("Nao ta procurando", 20, linkedList.search(20));
	}
	
	@Test public void remove() throws ADTOverflowException {
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		
		Assert.assertEquals("Nao ta inserindo", 3, linkedList.size());
		linkedList.remove(4);
		Assert.assertEquals("Nao ta removendo", 2, linkedList.size());
		linkedList.remove(3);
		Assert.assertEquals("Nao ta removendo", 1, linkedList.size());
		linkedList.remove(2);
		Assert.assertEquals("Nao ta removendo", 0, linkedList.size());
		
	}
	
	@Test public void revert() throws ADTOverflowException{
		Integer n1 = new Integer(2);
		Integer n2 = new Integer(3);
		Integer n3 = new Integer(4);
		
		
		linkedList.insert(n1);
		linkedList.insert(n2);
		linkedList.insert(n3);
		
		DoubleLinkedListRecursiveImpl<Integer> linkedList2 = new DoubleLinkedListRecursiveImpl<Integer>();
		linkedList2.insert(n3);
		linkedList2.insert(n2);
		linkedList2.insert(n1);
				
		Assert.assertTrue("Revert errado", linkedList2.equals(linkedList.revert()) );
		
	}
	
	@Test public void isHead() throws ADTOverflowException{
		Assert.assertFalse(linkedList.isHead());
		linkedList.insert(10);
		Assert.assertTrue(linkedList.isHead());
	}
	
	@Test public void addFirst() throws ADTOverflowException{
		
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		
		Integer[] aux = new Integer[3];
		aux[0] = 2;
		aux[1] = 3;
		aux[2] = 4;
		
		Assert.assertArrayEquals(aux, linkedList.toArray());
		
		linkedList.addFirst(10);
		
		aux = new Integer[4];
		aux[0] = 10;
		aux[1] = 2;
		aux[2] = 3;
		aux[3] = 4;
		
		Assert.assertArrayEquals(aux, linkedList.toArray());

		
		DoubleLinkedListRecursiveImpl<Integer> linkedList2 = new DoubleLinkedListRecursiveImpl<Integer>();
		linkedList2.insert(2);
		linkedList2.insert(3);
		linkedList2.insert(4);
		
		
		
	}
	
	@Test public void addLast() throws ADTOverflowException{
		
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		
		Integer[] aux = new Integer[3];
		aux[0] = 2;
		aux[1] = 3;
		aux[2] = 4;
		
		Assert.assertArrayEquals(aux, linkedList.toArray());
		
		linkedList.addLast(10);
		
		aux = new Integer[4];
		aux[0] = 2;
		aux[1] = 3;
		aux[2] = 4;
		aux[3] = 10;
		
		Assert.assertArrayEquals(aux, linkedList.toArray());
	}
	
	@Test public void removeLast() throws ADTOverflowException, ADTUnderflowException{
		
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		
		Assert.assertEquals("Erro ao adicionar", 3, linkedList.size());
		
		linkedList.removeLast();
		
		Assert.assertEquals("Erro ao remover", 2, linkedList.size());
		
		Integer[] aux = new Integer[2];
		aux[0] = 2;
		aux[1] = 3;
		
		Assert.assertArrayEquals(aux, linkedList.toArray());
	}
	
	@Test public void removeFirt() throws ADTOverflowException, ADTUnderflowException{
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		
		Assert.assertEquals("Erro ao adicionar", 3, linkedList.size());
		
		linkedList.removeFirst();
		
		Assert.assertEquals("Erro ao remover", 2, linkedList.size());
		

		Integer[] aux = new Integer[2];
		aux[0] = 3;
		aux[1] = 4;
		
		Assert.assertArrayEquals(aux, linkedList.toArray());
	}
	
	@Test public void testToString() throws ADTOverflowException{
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		
		Assert.assertEquals("Erro no toString", "{2,3,4}", linkedList.toString());
	}

	@Test public void minimum() throws ADTOverflowException{
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(0);
		linkedList.insert(4);
		linkedList.insert(1);
		
		Assert.assertEquals("Minimum esta errado", 0, linkedList.minimum());
	} 
	
	@Test public void maximum() throws ADTOverflowException{
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(30);
		linkedList.insert(4);
		
		Assert.assertEquals("Minimum esta errado", 30, linkedList.maximum());
	} 
	
	@Test public void full() throws ADTOverflowException{
		
		for (int i = 0; i < 99; i++){
			linkedList.insert(i);
		}
		
		Assert.assertFalse(linkedList.full());
		linkedList.insert(100);
		Assert.assertTrue(linkedList.full());
	}
	
	@Test public void insertException() throws ADTOverflowException{
		for (int i = 0; i < 99; i++){
			linkedList.insert(i);
		}
		
		Assert.assertFalse(linkedList.full());
		linkedList.insert(100);
		
		
		try {
			Assert.assertTrue(linkedList.full());
			Assert.assertEquals("Erro no size", 100, linkedList.size());
			linkedList.insert(101);
		} catch (ADTOverflowException e){
			Assert.assertEquals("Structure is full", e.getMessage());
		}
	} 
	
	@Test public void searchException() throws ADTOverflowException{
		Assert.assertTrue(linkedList.isEmpty());
		
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(30);
		linkedList.insert(4);
		
		Assert.assertEquals("Erro no toString", "{2,3,30,4}", linkedList.toString());
		Assert.assertEquals("Erro no size", 4, linkedList.size());
		Assert.assertFalse(linkedList.isEmpty());
		
		try {
			linkedList.search(10);
		} catch (ADTNoSuchElement e){
			Assert.assertEquals("No such element is in the structure", e.getMessage());
		}
	}
	
	@Test public void addFirstException() throws ADTOverflowException {
		for (int i = 0; i < 99; i++){
			linkedList.addFirst(i);
		}
		
		Assert.assertFalse(linkedList.full());
		linkedList.addFirst(100);
		
		
		try {
			Assert.assertTrue(linkedList.full());
			Assert.assertEquals("Erro no size", 100, linkedList.size());
			linkedList.addFirst(101);
		} catch (ADTOverflowException e){
			Assert.assertEquals("Structure is full", e.getMessage());
		}
	}
	
	@Test public void addLastException() throws ADTOverflowException {
		for (int i = 0; i < 99; i++){
			linkedList.addLast(i);
		}
		
		Assert.assertFalse(linkedList.full());
		linkedList.addLast(100);
		
		
		try {
			Assert.assertTrue(linkedList.full());
			Assert.assertEquals("Erro no size", 100, linkedList.size());
			linkedList.addLast(101);
		} catch (ADTOverflowException e){
			Assert.assertEquals("Structure is full", e.getMessage());
		}
	}
	
	@Test public void removeFirstException() {
		Assert.assertTrue(linkedList.isEmpty());
		
		try {
			linkedList.removeFirst();
		} catch (ADTUnderflowException e) {
			Assert.assertEquals("Structure is empty", e.getMessage());
		}
	}
	
	@Test public void removeLastException() {
		Assert.assertTrue(linkedList.isEmpty());
		
		try {
			linkedList.removeLast();
		} catch (ADTUnderflowException e) {
			Assert.assertEquals("Structure is empty", e.getMessage());
		}
	}


}
