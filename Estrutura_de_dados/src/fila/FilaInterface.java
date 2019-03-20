package fila;

import fila.exceptions.FilaVaziaException;

public interface FilaInterface {
	
	public int size();
	public boolean isEmpty();
	public void enfileirar(Object o);
	public Object desenfileirar()
	throws FilaVaziaException;
	public Object inicio()
	throws FilaVaziaException;
}
