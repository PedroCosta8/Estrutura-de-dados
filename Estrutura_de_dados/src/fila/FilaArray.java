package fila;

import exceptions.FilaVaziaException;

public class FilaArray implements FilaInterface{

	private Object[] fila;
	private int inicio;
	private int fim;
	
	public FilaArray(int tam) {
		fila = new Object[tam];
		inicio = 0;
		fim = 0;
	}
	
	public int realSize() {
		return fila.length;
	}
	
	@Override
	public int size() {
		return (fila.length - inicio + fim)%fila.length;
	}

	@Override
	public boolean isEmpty() {
		return (inicio == fim)?true:false;
	}

	@Override
	public void enfileirar(Object o) {
		if(this.size() == fila.length-1) {
			Object[] aux = new Object[fila.length*2];
			int i, j;
			for(i = inicio,j = 0; i != fim; i = (i+1)%fila.length, j++) {
				aux[j] = fila[i];
			}
			fila = aux;
			fila[j] = o;
			inicio = 0;
			fim = j+1;
			return;
		}
		fila[fim] = o;
		fim = (fim+1)%fila.length;
	}

	@Override
	public Object desenfileirar() throws FilaVaziaException {
		if(this.isEmpty()) throw new FilaVaziaException("fila vazia");
		Object aux = fila[inicio];
		inicio = (inicio+1)%fila.length;
		return aux;
	}

	@Override
	public Object inicio() throws FilaVaziaException {
		if(this.isEmpty()) throw new FilaVaziaException("fila vazia");
		return fila[inicio];
	}

	@Override
	public String mostrarFila() {
		String f = "";
		int aux1 = inicio;
		int aux2 = fim;
		int i;
		for(i = aux1; i != aux2; i = (i+1)%fila.length) {
			f += fila[i] + " ";
		}
		f += "|qtd: " + this.size() + "|";
		return f;
	}

}
