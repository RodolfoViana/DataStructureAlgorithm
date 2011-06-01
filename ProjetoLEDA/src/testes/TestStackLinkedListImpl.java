package testes;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eda.linearADT.StackLinkedListImpl;
import eda.util.ADTOverflowException;
import eda.util.ADTUnderflowException;

public class TestStackLinkedListImpl {
	
	private StackLinkedListImpl<Integer> pilha;
	
	@Before public void construtor(){
		pilha = new StackLinkedListImpl<Integer>();
	}

	@Test public void push() throws ADTOverflowException{
		Assert.assertTrue("Erro no isEmpty", pilha.isEmpty());
		pilha.push(10);
		Assert.assertEquals("Erro no size", 1, pilha.size());
		Assert.assertEquals("Erro no toString", "{10}", pilha.toString());
		
		pilha.push(12);
		Assert.assertEquals("Erro no size", 2, pilha.size());
		Assert.assertEquals("Erro no toString", "{10,12}", pilha.toString());
		pilha.push(1);
		Assert.assertEquals("Erro no size", 3, pilha.size());
		Assert.assertEquals("Erro no toString", "{10,12,1}", pilha.toString());
	}
	
	@Test public void pop() throws ADTOverflowException, ADTUnderflowException{
		Assert.assertTrue("Erro no isEmpty", pilha.isEmpty());
		
		Integer n1 = 10;
		Integer n2 = 12;
		Integer n3 = 1;
		Integer n4 = 20;
		Integer n5 = 2;
		Integer n6 = 0;
		
		pilha.push(n1);
		pilha.push(n2);
		pilha.push(n3);
		pilha.push(n4);
		pilha.push(n5);
		pilha.push(n6);
		
		Assert.assertEquals("Erro no size", 6, pilha.size());
		Assert.assertEquals("Erro no toString", "{10,12,1,20,2,0}", pilha.toString());
		Assert.assertEquals("Erro no pop", n6, pilha.pop());
		
		Assert.assertEquals("Erro no size", 5, pilha.size());
		Assert.assertEquals("Erro no toString", "{10,12,1,20,2}", pilha.toString());
		Assert.assertEquals("Erro no pop", n5, pilha.pop());
		
		Assert.assertEquals("Erro no size", 4, pilha.size());
		Assert.assertEquals("Erro no toString", "{10,12,1,20}", pilha.toString());
		Assert.assertEquals("Erro no pop", n4, pilha.pop());
		
		Assert.assertEquals("Erro no size", 3, pilha.size());
		Assert.assertEquals("Erro no toString", "{10,12,1}", pilha.toString());
		Assert.assertEquals("Erro no pop", n3, pilha.pop());
		
		Assert.assertEquals("Erro no size", 2, pilha.size());
		Assert.assertEquals("Erro no toString", "{10,12}", pilha.toString());
		Assert.assertEquals("Erro no pop", n2, pilha.pop());
		
		Assert.assertEquals("Erro no size", 1, pilha.size());
		Assert.assertEquals("Erro no toString", "{10}", pilha.toString());
		Assert.assertEquals("Erro no pop", n1, pilha.pop());
		
		Assert.assertEquals("Erro no size", 0, pilha.size());
		Assert.assertEquals("Erro no toString", "{}", pilha.toString());
	}
	
	@Test public void top() throws ADTOverflowException, ADTUnderflowException{
		Assert.assertTrue("Erro no isEmpty", pilha.isEmpty());
		
		Integer n1 = 10;
		Integer n2 = 12;
		Integer n3 = 1;
		Integer n4 = 20;
		Integer n5 = 2;
		Integer n6 = 0;
		
		pilha.push(n1);
		pilha.push(n2);
		pilha.push(n3);
		pilha.push(n4);
		pilha.push(n5);
		pilha.push(n6);
		
		Assert.assertEquals("Erro no size", 6, pilha.size());
		Assert.assertEquals("Erro no toString", "{10,12,1,20,2,0}", pilha.toString());
		Assert.assertEquals("Erro no pop", n6, pilha.top());
		
	}
	
	@Test public void full() throws ADTOverflowException{
		
		for (int i = 0; i < 99; i++){
			pilha.push(i);
		}
		
		Assert.assertFalse(pilha.full());
		pilha.push(100);
		Assert.assertTrue(pilha.full());
	}
	
	@Test public void pushException() throws ADTOverflowException {
		for (int i = 0; i < 99; i++){
			pilha.push(i);
		}
	
		Assert.assertFalse(pilha.full());
		pilha.push(100);
	
		
		try {
			Assert.assertTrue(pilha.full());
			Assert.assertEquals("Erro no size", 100, pilha.size());
			pilha.push(101);
		} catch (ADTOverflowException e){
			Assert.assertEquals("Structure is full", e.getMessage());
		}
	}
	
	@Test public void popException(){
		Assert.assertTrue("Erro no isEmpty", pilha.isEmpty());
		
		try{
			pilha.pop();
		} catch (ADTUnderflowException e){
			Assert.assertEquals("Structure is empty", e.getMessage());
		}		
	}
	
	@Test public void toArray() throws ADTOverflowException, ADTUnderflowException{
		pilha.push(2);
		pilha.push(3);
		pilha.push(4);

		Assert.assertEquals("Erro ao adicionar", 3, pilha.size());
	
		pilha.pop();
	
		Assert.assertEquals("Erro ao remover", 2, pilha.size());
	

		Integer[] aux = new Integer[2];
		aux[0] = 2;
		aux[1] = 3;
	
		Assert.assertArrayEquals(aux, pilha.toArray());
	}
	
	@Test public void topException(){
		Assert.assertTrue("Erro no isEmpty", pilha.isEmpty());
		pilha.top();
		Assert.assertTrue(pilha.top() == null);
		
	}		
}
