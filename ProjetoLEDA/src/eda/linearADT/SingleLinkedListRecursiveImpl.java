package eda.linearADT;

import eda.util.ADTNoSuchElement;
import eda.util.ADTOverflowException;
import eda.util.Constants;

/**
 * Estrutura representa uma lista simples implementada de forma recursiva. 
 * Ela representa um no da lista que deve ser ligado a outros e todos os metodos
 * devem ser definidos nessa classe, de forma recursiva dentro de cada no, como 
 * visto em sala de aula. 
 * A estrutura deve ter um tamanho inicial, um tamanho maximo que pode 
 * crescer e um FATOR de crescimento. Quando instanciada a estrutura tem um tamanho 
 * inicial. Quando ela vai crescendo e enche, ela aumenta de tamanho de acordo com o 
 * fator de crescimento desde que nao atinja ou ultrapasse o tamanho  maximo. A partir 
 * dai a estrutura nao pode mais crescer e pode ficar cheia. Use as constantes 
 * definidas em eda.util.Constantes para inicializar os valores internos de sua 
 * estrutura. Faca protected qualquer outro metodo auxiliar. 
 */
public class SingleLinkedListRecursiveImpl<E> implements LinkedList<E> {
	

	private E element;
	private LinkedList<E> next;

	@Override
	public boolean isEmpty() {
		boolean resp = false;
		
		if (this.next == null){
			resp = true;
		}
		
		return resp;
	}

	@Override
	public boolean full() {
		boolean resp = false;
		
		if (size() >= eda.util.Constants.MAX_SIZE_OF_STRUCTURE ){
			resp = true;
		}
		return resp;
	}

	@Override
	public int size() {
		int size = 0;
		
		if (this.next != null){
			size = 1 + next.size();
		}
		return size;
	}

	@Override
	public void insert(E element) throws ADTOverflowException {
		if (!full()){
			if (this.next == null ){
				this.element = element;
				this.next = null;
			} else {
				this.next.insert(element);
			}
		}
		else {
			//como lanca erro ! 
		}
		
	}

	@Override
	public int search(E element) throws ADTNoSuchElement {
        int resp = -1;
         
        if (this.next == null){
            //lancar
        } else {
            if (this.dado == element){
                resp = this.element;
            } else {
                resp = this.next.search(element); 
            }
             
        }
         
        return resp;
    } 

	@Override
	public void remove(E element) {
		// TODO Auto-generated method stub

	}

	@Override
	public LinkedList<E> revert() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int maximum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int minimum() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public E[] toArray(){
		// TODO Auto-generated method stub
		return null;
	}
	
//	private int dado = -1;
//	private ListaInteirosImpl proximo;
//	
//	
//	@Override
//	public boolean isEmpty(){
//		boolean resp = false;
//		
//		if (this.proximo == null){
//			resp = true;
//		}
//		return resp;
//	}
//	
//	@Override
//	public int tamanho() {
//		int size = 0;
//		
//		if (this.proximo != null){
//			size = 1 + proximo.tamanho();
//		}
//		return size;
//	}
//
//	@Override
//	public void inserir(int numero) {
//		
//		if (this.proximo == null ){
//			this.dado = numero;
//			this.proximo = new ListaInteirosImpl();
//		} else {
//			proximo.inserir(numero);
//		}
//	}
//
//	@Override
//	public int procurar(int numero) {
//		int retorno = -1;
//		
//		if (this.proximo == null){
//			throw new RuntimeException(MSG_INEXISTENTE);
//		}
//		 
//		else{
//			if (this.dado == numero){
//				retorno = this.dado;
//			} else {
//				retorno = proximo.procurar(numero);
//			}
//			
//		}
//		return retorno;
//	}
//
//	@Override
//	public void remover(int numero) {
//		if (!isEmpty()){
//			if (this.dado == numero){
//				this.dado = proximo.dado;
//				this.proximo = proximo.proximo;
//			}
//			else {
//				proximo.remover(numero);
//			}
//		}
//	}
//	
//	
//	@Override
//	public ListaInteiros revert() {
//		ListaInteiros resp = new ListaInteirosImpl();
//		
//		if (!isEmpty()){
//			resp = proximo.revert();
//			resp.inserir(this.dado);
//		}
//	
//		return resp;
//	}
//
//	@Override
//	public int maior() {
//		int resp = Integer.MIN_VALUE;
//		
//		if (!isEmpty())
//			if (this.dado > resp){
//				int maiorResto = proximo.maior();
//				if (maiorResto > this.dado){
//					resp = maiorResto;
//				} else {
//					resp = dado;
//				}
//			}
//			else {
//				resp = proximo.maior();
//			}
//		return resp;
//	}
//
//	@Override
//	public int menor() {
//		int resp = Integer.MAX_VALUE;
//		
//		if (!isEmpty())
//			if (this.dado < resp){
//				int maiorResto = proximo.maior();
//				if (maiorResto < this.dado){
//					resp = maiorResto;
//				} else {
//					resp = dado;
//				}
//			}
//			else {
//				resp = proximo.maior();
//			}
//		return resp;
//	}
//
//	public int getDado() {
//		return dado;
//	}
//
//	public void setDado(int dado) {
//		this.dado = dado;
//	}
//
//	public ListaInteirosImpl getProximo() {
//		return proximo;
//	}
//
//	public void setProximo(ListaInteirosImpl proximo) {
//		this.proximo = proximo;
//	}
//
//}

}
