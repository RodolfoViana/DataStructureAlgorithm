package testes;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eda.linearADT.StackQueueImpl;
import eda.util.ADTOverflowException;
import eda.util.ADTUnderflowException;

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
 * 			Testes da Classe StackQueueImpl.java
 */

public class TestStackQueueImpl {
	
	StackQueueImpl<Integer> pilha;
	
	@Before public void construtor(){
		pilha = new StackQueueImpl<Integer>();
	}
	
	@Test public void push() throws ADTOverflowException{
		Assert.assertTrue("Erro no isEmpty", pilha.isEmpty());
		pilha.push(10);
		Assert.assertEquals("Erro no push", 1, pilha.size());
		Assert.assertFalse("Erro no isEmpty", pilha.isEmpty());
		pilha.push(20);
		Assert.assertEquals("Erro no push", 2, pilha.size());
		Assert.assertFalse("Erro no isEmpty", pilha.isEmpty());
		pilha.push(30);
		Assert.assertEquals("Erro no push", 3, pilha.size());
		Assert.assertFalse("Erro no isEmpty", pilha.isEmpty());
		pilha.push(40);
		Assert.assertEquals("Erro no push", 4, pilha.size());
	}
	
	@Test public void pop() throws ADTOverflowException, ADTUnderflowException{
		Integer n1 = 10;
		Integer n2 = 20;
		Integer n3 = 30;
		Integer n4 = 40;
		
		pilha.push(n1);
		pilha.push(n2);
		pilha.push(n3);
		pilha.push(n4);
		
		Assert.assertEquals("Erro no push", 4, pilha.size());
		Assert.assertEquals("Erro no pop", n4, pilha.pop());
		
		Assert.assertEquals("Erro no push", 3, pilha.size());
		Assert.assertEquals("Erro no pop", n3, pilha.pop());
		
		Assert.assertEquals("Erro no push", 2, pilha.size());
		Assert.assertEquals("Erro no pop", n2, pilha.pop());
	}
	
	@Test public void top() throws ADTOverflowException, ADTUnderflowException{
		Integer n1 = 10;
		Integer n2 = 20;
		Integer n3 = 30;
		Integer n4 = 40;
		
		pilha.push(n1);
		pilha.push(n2);
		pilha.push(n3);
		pilha.push(n4);
		
		Assert.assertEquals("Erro no push", 4, pilha.size());
		Assert.assertEquals("Erro no pop", n4, pilha.top());

	}
	
	@Test public void toArray() throws ADTOverflowException{
		Assert.assertTrue(pilha.isEmpty());
		
		Integer n1 = 10;
		Integer n2 = 20;
		Integer n3 = 30;
		Integer n4 = 40;
		
		pilha.push(n1);
		pilha.push(n2);
		pilha.push(n3);
		pilha.push(n4);
		
		Integer[] array = new Integer[30];
		array[0] = n1;
		array[1] = n2;
		array[2] = n3;
		array[3] = n4;
		
		Assert.assertArrayEquals("erro no toArray", array, pilha.toArray());
		
	}
	
	@Test public void full() throws ADTOverflowException{
		Assert.assertTrue("Erro no isEmpty", pilha.isEmpty());
		Assert.assertFalse("Erro no full", pilha.full());
		
		for (int i = 0; i < 99; i++){
			pilha.push(i);
		}
		Assert.assertFalse("Erro no full", pilha.full());
		pilha.push(100);
		Assert.assertTrue("Erro no full", pilha.full());
		
	}
	
	@Test public void topException() {
		Assert.assertTrue("Erro no isEmpty", pilha.isEmpty());
		
		
		try {
			pilha.top();
		} catch (ADTUnderflowException e) {
			Assert.assertEquals("Erro no top", "Structure is empty", e.getMessage());
		}
	}
	
}