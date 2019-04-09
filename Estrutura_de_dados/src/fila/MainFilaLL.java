package fila;

import exceptions.FilaVaziaException;

public class MainFilaLL {

	public static void main(String[] args) throws FilaVaziaException {

		FilaLL fila = new FilaLL();
		
		fila.enfileirar(99);
		fila.enfileirar(77);
		fila.enfileirar(33);
		fila.enfileirar(11);
		System.out.println(fila.inicio());
		System.out.println(fila.mostrarFila());
		fila.enfileirar(17);
		fila.desenfileirar();
		fila.desenfileirar();
		System.out.println(fila.inicio());
		System.out.println(fila.mostrarFila());
		
	}

}
