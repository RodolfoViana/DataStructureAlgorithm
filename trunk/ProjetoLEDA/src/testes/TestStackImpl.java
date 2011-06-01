package testes;

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
	 
		@Test
		public void aumentaTamanhoFila() throws ADTOverflowException{
			
			for (int i = 0; i < 29; i++){
				stack1.push("teste " + i);
			}
			
			Assert.assertEquals("Erro no aumentaTamanho", 29, stack1.size());
			stack1.push("teste " + 30);
			Assert.assertEquals("Erro no aumentaTamanho", 30, stack1.size());
			
		}
		
	@Test public void pop() throws ADTOverflowException, ADTUnderflowException{
		String n1 = "elemento1";
		String n2 = "elemento2";
		String n3 = "elemento3";
		
		stack1.push(n1);
		stack1.push(n2);
		stack1.push(n3);
		
		Assert.assertEquals("Erro no pop", n3, stack1.pop());
		Assert.assertEquals("Erro no pop", n2, stack1.pop());
		Assert.assertEquals("Erro no pop", n1, stack1.pop());
		Assert.assertEquals("Erro no size", 0, stack1.size());
		
	}
	
	@Test public void top() throws ADTOverflowException, ADTUnderflowException{
		String n1 = "elemento1";
		String n2 = "elemento2";
		String n3 = "elemento3";
		
		stack1.push(n1);
		stack1.push(n2);
		stack1.push(n3);
		
		Assert.assertEquals("Erro no pop", n3, stack1.top());
		Assert.assertEquals("Erro no size", 3, stack1.size());
		
	}
	
//	@Test public void full() throws ADTOverflowException{
//		Assert.assertTrue("Erro no isEmpty", stack1.isEmpty());
//		Assert.assertFalse("Erro no full", stack1.full());
//		
//		for (int i = 0; i < 49; i++){
//		stack1.push("teste" + i );
//		}
//		Assert.assertFalse("Erro no full", stack1.full());
//		stack1.push("teste" + 100);
//		Assert.assertTrue("Erro no full", stack1.full());
//		
//	}
//	
//	@Test public void toArray() throws ADTOverflowException{
//		Assert.assertTrue(stack1.isEmpty());
//		
//		String n1 = "Teste 10";
//		String n2 = "Teste 20";
//		String n3 = "Teste 30";
//		String n4 = "Teste 40";
//		
//		stack1.push("Teste" + n1 );
//		stack1.push("Teste" + n2);
//		stack1.push("Teste" + n3);
//		stack1.push("Teste" + n4);
//		
//		String[] array = new String[30];
//		array[0] = n1;
//		array[1] = n2;
//		array[2] = n3;
//		array[3] = n4;
//		
//		Assert.assertArrayEquals("erro no toArray", array, stack1.toArray());
//		
//	}
	
	@Test public void topException() {
		Assert.assertTrue("Erro no isEmpty", stack1.isEmpty());
		
		
		try {
			stack1.top();
		} catch (ADTUnderflowException e) {
			Assert.assertEquals("Erro no top", "Structure is empty", e.getMessage());
		}
	}
		
}
