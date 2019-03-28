package lista;

import lista.exceptions.ListaVaziaException;
import lista.exceptions.PosicaoInvalidaException;

public class MainLista {

	public static void main(String[] args) throws PosicaoInvalidaException, ListaVaziaException {
		Lista lista = new Lista();
		//lista.last();
		lista.insertFirst(3);
		lista.insertFirst(4);
		lista.insertFirst(20);
		//No2 p = new No2(4,null,null);
		Posicao p = lista.first();
		lista.insertBefore(p, 99);
		//Posicao s = (Posicao) new No2(99, null, null);
		//lista.remove(s);
		System.out.println(lista.mostrarLista());
		System.out.println("-----");
		p = lista.last();
		lista.insertAfter(p, 100);
		System.out.println(lista.mostrarLista());
		System.out.println("-----");
		p = lista.before(p);
		lista.insertBefore(p, 88);
		System.out.println(lista.mostrarLista());
		System.out.println("-----");
		//Posicao x = lista.first();
		Posicao x = lista.last();
		if(lista.isFirst(x))
			System.out.println(x.getElemento() + " eh o primeiro elemento");
		else
			System.out.println(x.getElemento() + " nao eh o primeiro elemento");
		No2 y = (No2)lista.first();
		Posicao a = (Posicao) y.getProximo().getProximo(); //88
		System.out.println(lista.before(a).getElemento());//20
		System.out.println("-----");
		System.out.println(lista.after(a).getElemento()); //4
		a = lista.last();
		a = lista.before(a); //3
		lista.replaceElement(a, 22);
		System.out.println("-----");
		System.out.println(lista.mostrarLista());
		p = lista.first();
		a = lista.last();
		lista.swapElements(p, a);
		System.out.println("-----");
		System.out.println(lista.mostrarLista());
		lista.insertLast(33);
		System.out.println("-----");
		System.out.println(lista.mostrarLista());
		lista.remove(lista.first());
		lista.remove(lista.first());
		System.out.println("-----");
		System.out.println(lista.mostrarLista());
	}

}
