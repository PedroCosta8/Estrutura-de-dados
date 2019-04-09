package pilha;

import exceptions.PilhaVaziaException;

public class PilhaLL implements PilhaInterface {
	
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
		if(this.isEmpty()) throw new PilhaVaziaException("pilha vazia");
		return top.getElemento();
	}

	@Override
	public void push(Object o) {
		if(this.isEmpty()) {
			No no = new No(o, null);
			top = no;
			total++;
		}
		else {
			No no = new No(o, top);
			top = no;
			total++;
		}
	}

	@Override
	public Object pop() throws PilhaVaziaException {
		if(this.isEmpty()) throw new PilhaVaziaException("pilha vazia");
		Object aux = top.getElemento();
		top = top.getProximo();
		total--;
		return aux;
	}

	@Override
	public String mostrarPilha() {
		String p = "";
		No aux = top;
		while(aux != null) {
			p += aux.getElemento() + " ";
			aux = aux.getProximo();
		}
		p += "|qtd: "+ total + "|";
		return p;
	}

}
