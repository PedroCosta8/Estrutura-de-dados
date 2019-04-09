package lista;

import exceptions.ListaVaziaException;
import exceptions.NoInvalidoException;

public class MainLista {

	public static void main(String[] args) throws ListaVaziaException, NoInvalidoException {
	
		Lista lista = new Lista();
		
		lista.insertFirst(99);
		lista.insertFirst(77);
		lista.insertLast(11);
		System.out.println(lista.mostrarLista());
		No2 n = lista.first().getProximo();
		lista.insertAfter(n, 100);
		System.out.println(lista.mostrarLista());
		lista.insertBefore(n, 33);
		System.out.println(lista.mostrarLista());
		if(lista.isFirst(n)) System.out.println("O numero "+ n.getElemento()+ " eh o primeiro");
		else System.out.println("O numero "+ n.getElemento()+ " nao eh o primeiro");
		lista.remove(n);
		System.out.println(lista.first().getElemento());
		System.out.println(lista.last().getElemento());
		System.out.println(lista.mostrarLista());
		n = lista.before(lista.last());
		lista.replaceElements(n, 55);
		System.out.println(lista.mostrarLista());
		lista.swapElements(lista.before(n), lista.before(lista.last()));
		System.out.println(lista.mostrarLista());
		
	}

}
