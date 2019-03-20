package lista;

import fila.FilaInterface;
import fila.exceptions.FilaVaziaException;

public class FilaLL implements FilaInterface {
	
	private No inicio;
	private No fim;
	private int total;
	
	public FilaLL() {
		inicio = null;
		fim = null;
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
	public void enfileirar(Object o) {
		No e = new No(o, null);
		if(fim == null) {
			inicio = fim = e;
			total++;
		}
		else {
			fim.setProximo(e);
			fim = e;
			total++;
		}
	}

	@Override
	public Object desenfileirar() throws FilaVaziaException {
		if(this.isEmpty())
			throw new FilaVaziaException("Lista vazia");
		No aux = inicio;
		inicio = inicio.getProximo();
		aux.setProximo(null);
		total--;
		return aux.getElemento();
	}

	@Override
	public Object inicio() throws FilaVaziaException {
		if(this.isEmpty())
			throw new FilaVaziaException("Lista vazia");
		return inicio.getElemento();
	}

}
