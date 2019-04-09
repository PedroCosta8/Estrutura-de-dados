package fila;

import exceptions.FilaVaziaException;
import pilha.No;

public class FilaLL implements FilaInterface{
	
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
		No no = new No(o, null);
		if(fim == null) {
			inicio = fim = no;
			total++;
		}
		else {
			fim.setProximo(no);
			fim = no;
			total++;
		}
	}

	@Override
	public Object desenfileirar() throws FilaVaziaException {
		if(this.isEmpty()) throw new FilaVaziaException("fila vazia");
		Object aux = inicio.getElemento();
		inicio = inicio.getProximo();
		total--;
		return aux;
	}

	@Override
	public Object inicio() throws FilaVaziaException {
		if(this.isEmpty()) throw new FilaVaziaException("fila vazia");
		return inicio.getElemento();
	}

	@Override
	public String mostrarFila() {
		String f = "";
		No aux = inicio;
		while(aux != null) {
			f += aux.getElemento() + " ";
			aux = aux.getProximo();
		}
		f += "|qtd: " + total + "|";
		return f;
	}

}
