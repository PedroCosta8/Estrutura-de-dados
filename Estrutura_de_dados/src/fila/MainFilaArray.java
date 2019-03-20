package fila;

import fila.exceptions.FilaVaziaException;

public class MainFilaArray {

	public static void main(String[] args) throws FilaVaziaException {
		FilaArray fa = new FilaArray(4);
		//fa.desenfileirar();
		fa.enfileirar(22);
		fa.enfileirar(88);
		fa.enfileirar(33);
		fa.enfileirar(99);
		System.out.println(fa.inicio());
		fa.desenfileirar();
		System.out.println(fa.inicio());
		fa.enfileirar(111);
		fa.enfileirar(78);
		System.out.println(fa.size());
		System.out.println(fa.inicio());
	}

}
