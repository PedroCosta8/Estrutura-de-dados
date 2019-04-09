package sequencia;

import exceptions.ListaVaziaException;
import exceptions.NoInvalidoException;
import exceptions.RankInvalidoException;

public class MainSequencia {

	public static void main(String[] args) throws RankInvalidoException, NoInvalidoException, ListaVaziaException {
		Sequencia sequencia = new Sequencia();
		sequencia.insertAtRank(0, 11);
		System.out.println(sequencia.mostrarLista());
		sequencia.insertAtRank(1, 22);
		sequencia.insertAtRank(2, 6);
		sequencia.insertAtRank(3, 99);
		System.out.println(sequencia.mostrarLista());
		sequencia.insertAtRank(3, 66);
		//sequencia.removeAtRank(5);
		System.out.println(sequencia.mostrarLista());
		System.out.println(sequencia.removeAtRank(2));
		System.out.println(sequencia.mostrarLista());
		System.out.println(sequencia.atRank(1).getElemento());
		sequencia.replaceAtRank(1, 90);
		System.out.println(sequencia.mostrarLista());
		System.out.println(sequencia.elementAtRank(3)); //se for indice 4 vai lançar a exception
		sequencia.replaceAtRank(3,100);
		System.out.println(sequencia.mostrarLista());
		System.out.println(sequencia.rankOf(sequencia.last()));

	}

}
