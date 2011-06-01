package testes;

import eda.linearADT.QueueImpl;
import eda.linearADT.StackImpl;
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
 * 			Testes da Classe QueueImpl.java
 */


public class TestQueueImpl {
	QueueImpl<String> q1;
	
	@Before
	public void instancia() {
		q1 = new QueueImpl<String>();
	}
	
	@Test
	public void testFilaVazia() {
		Assert.assertTrue(q1.isEmpty());
		Assert.assertEquals("Array deve ser vazio", q1.toString(), "[]");
	}

	@Test
	public void testEqueue() throws ADTOverflowException, ADTUnderflowException {
		Assert.assertTrue(q1.isEmpty());
		Assert.assertEquals("Array deve ser vazio", q1.toString(), "[]");
		
		System.out.println("Teste Enqueue");
		q1.enqueue("elemento1");q1.enqueue("elemento2");q1.enqueue("elemento3");
		System.out.println(q1.toString());
		q1.enqueue("elemento4");q1.enqueue("elemento5");q1.enqueue("elemento6");
		System.out.println(q1.toString());
		q1.enqueue("elemento7");q1.enqueue("elemento8");q1.enqueue("elemento9");
		System.out.println(q1.toString());
		System.out.println("\n"); 
		
		Assert.assertEquals("Array tem 9 elementos",  "[elemento1, elemento2, elemento3, elemento4, elemento5, elemento6, elemento7, elemento8, elemento9]", q1.toString());
	}
	
	@Test
	public void testDequeue() throws ADTUnderflowException, ADTOverflowException {
		q1.enqueue("elemento1");
		q1.enqueue("elemento2");
		q1.enqueue("elemento3");
		q1.enqueue("elemento4");
		q1.enqueue("elemento5");
		q1.enqueue("elemento6");
		q1.enqueue("elemento7");
		
		System.out.println("Teste Dequeue");
		System.out.println(q1.toString());
		
		q1.dequeue();
		System.out.println(q1.toString());
		q1.dequeue();
		System.out.println(q1.toString());
		q1.dequeue();
		System.out.println(q1.toString());
		q1.dequeue();
		System.out.println(q1.toString());
		System.out.println("\n"); 
		
	}
	
	@Test
	public void testHead() throws ADTOverflowException, ADTUnderflowException {
		q1.enqueue("elemento5");
		q1.enqueue("elemento6");
		q1.enqueue("elemento7");
		
		System.out.println("Teste Head");
		System.out.print("Head 1: ");
		System.out.println(q1.head());
		
		q1.dequeue();
		System.out.print("Head 2: ");
		System.out.println(q1.head());
	}
	@Test
	public void aumentaTamanhoFila() throws ADTOverflowException{
		
		for (int i = 0; i < 29; i++){
			q1.enqueue("teste " + i);
		}
		
		Assert.assertEquals("Erro no aumentaTamanho", 29, q1.size());
		q1.enqueue("teste " + 30);
		Assert.assertEquals("Erro no aumentaTamanho", 30, q1.size());
		
	}
	
	@Test public void toStringTeste() throws ADTOverflowException{
		q1.enqueue("elemento1");
		q1.enqueue("elemento2");
		q1.enqueue("elemento3");
		q1.enqueue("elemento4");
		q1.enqueue("elemento5");
		q1.enqueue("elemento6");
		q1.enqueue("elemento7");
		
		Assert.assertEquals("Erro no toString", "[elemento1, elemento2, elemento3, elemento4, elemento5, elemento6, elemento7]", q1.toString());
	}
	
	@Test public void toArray()  throws ADTOverflowException{
		String n1 = "elemento1";
		String n2 = "elemento2";
		String n3 = "elemento3";
		
		q1.enqueue(n1);
		q1.enqueue(n2);
		q1.enqueue(n3);
		
		String[] array = new String[30];
		array[0] = n1;
		array[1] = n2;
		array[2] = n3;
		
		Assert.assertArrayEquals(array, q1.toArray());
		
		
	}
	
	@Test public void enqueueException() {
		Assert.assertTrue(q1.isEmpty());
		
		try {
			for (int i = 0; i < 200; i++){
				q1.enqueue("teste" + i);
			}
			
		} catch (ADTOverflowException e) {
			Assert.assertEquals("Structure is full", e.getMessage());
		}
	}
	
	@Test public void dequeueException() throws ADTUnderflowException {
		Assert.assertTrue(q1.isEmpty());
		
		try {
			q1.dequeue();
		} catch (ADTUnderflowException e) {
			Assert.assertEquals("Structure is empty", e.getMessage());
		}
	}
	
	@Test public void headException() throws ADTUnderflowException {
		Assert.assertTrue(q1.isEmpty());
		
		try {
			q1.head();
		} catch (ADTUnderflowException e) {
			Assert.assertEquals("Structure is empty", e.getMessage());
		}
	}
	
}
