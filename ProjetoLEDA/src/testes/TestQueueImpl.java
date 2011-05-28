package testes;

import eda.linearADT.QueueImpl;
import eda.linearADT.StackImpl;
import eda.util.ADTOverflowException;
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
	public void testEqueue() {
		
	}
	

}
