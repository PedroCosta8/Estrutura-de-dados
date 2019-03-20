package lista;

import pilha.Pilha;
import pilha.exceptions.PilhaVaziaException;

public class PilhaLL implements Pilha{
	
	private No top;
	private int total;
	
	public PilhaLL() {
		top = null;
		total = 0;
	}
	
	@Override
	public int size() {
		return total;
	}

	@Override
	public boolean isEmpty() {
		return (total == 0)?true:false;
	}

	@Override
	public Object top() throws PilhaVaziaException {
		if(this.isEmpty())
			throw new PilhaVaziaException("Lista vazia");
		return top.getElemento();
	}

	@Override
	public void push(Object o) {
		if(top != null) {
			No e = new No(o, top);
			top = e;
			total++;
		}
		else {
			No e = new No(o, null);
			top = e;
			total++;
		}
	}

	@Override
	public Object pop() throws PilhaVaziaException {
		if(this.isEmpty())
			throw new PilhaVaziaException("Lista vazia");
		No aux = top;
		top = top.getProximo();
		total--;
		return aux.getElemento();
	}
	
	
}
