package testes;

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
 * 			Testes da Classe StackImpl.java
 */


public class TestStackImpl {
	 StackImpl<String> stack1;
	 
	 @Before
	 public void criarInstancias(){
		stack1 = new StackImpl<String>();
	 }
	 
	 @Test
	 public void testPilhaVazia(){
		 Assert.assertTrue(stack1.isEmpty());
		 Assert.assertEquals("Array deve ser vazio", stack1.toString(), "[]");
	 }
	 @Test
	 public void testPush() throws ADTOverflowException{
		 Assert.assertTrue(stack1.isEmpty());
		 Assert.assertEquals("Array deve ser vazio", stack1.toString(), "[]");
		 
		 stack1.push("elemento1");
		 Assert.assertEquals("Array tem 1 elemento", "[elemento1]", stack1.toString() );
		 stack1.push("elemento2");	
		 Assert.assertEquals("Array tem 2 elementos",  "[elemento1, elemento2]", stack1.toString());
	 }
}
