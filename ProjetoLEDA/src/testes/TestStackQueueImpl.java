package testes;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eda.linearADT.StackQueueImpl;
import eda.util.ADTOverflowException;
import eda.util.ADTUnderflowException;

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
//	
//	@Test public void toArray() throws ADTOverflowException{
//		Integer n1 = 10;
//		Integer n2 = 20;
//		Integer n3 = 30;
//		Integer n4 = 40;
//		
//		pilha.push(n1);
//		pilha.push(n2);
//		pilha.push(n3);
//		pilha.push(n4);
//		
//		Integer[] array = new Integer[4];
//		array[0] = n1;
//		array[1] = n2;
//		array[2] = n3;
//		array[3] = n4;
//		
//		Assert.assertArrayEquals("erro no toArray", array, pilha.toArray());
//		
//	}
	

}