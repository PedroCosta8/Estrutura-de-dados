package fila;

import fila.exceptions.FilaVaziaException;

public class FilaArray implements FilaInterface{
	
	private int inicio;
	private int fim;
	private Object f[];

	public FilaArray(int tam) {
		inicio = 0;
		fim = 0;
		f = new Object[tam];
	}
	
	@Override
	public int size() {
		return (f.length - inicio + fim)%f.length;
	}

	@Override
	public boolean isEmpty() {
		return (inicio == fim)?true:false;
	}

	@Override
	public void enfileirar(Object o) {
		if(this.size() == f.length-1) {
			Object aux[] = new Object[f.length *2];
			int i, j;
			for(i = inicio, j=0; i != fim; i=(i+1)%f.length, j++) {
				aux[j] = f[i]; 
			}
			aux[j] = o;
			f = aux;
			inicio = 0;
			fim = j+1;
			return;
		}
		f[fim] = o;
		fim = (fim+1)%f.length;
	}

	@Override
	public Object desenfileirar() throws FilaVaziaException {
		if(this.isEmpty())
			throw new FilaVaziaException("Fila vazia");
		Object aux = f[inicio];
		inicio = (inicio+1)%f.length;
		return aux;
	}

	@Override
	public Object inicio() throws FilaVaziaException {
		if(this.isEmpty())
			throw new FilaVaziaException("Fila vazia");
		return f[inicio];
	}

}
