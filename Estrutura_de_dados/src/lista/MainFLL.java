package lista;

import fila.exceptions.FilaVaziaException;

public class MainFLL {

	public static void main(String[] args) throws FilaVaziaException {
		FilaLL fll = new FilaLL();
		//fll.inicio();
		fll.enfileirar(22);
		fll.enfileirar(44);
		fll.enfileirar(77);
		fll.enfileirar(99);
		System.out.println(fll.inicio());
		fll.desenfileirar();
		System.out.println(fll.inicio());
		fll.desenfileirar();
		System.out.println(fll.inicio());
		System.out.println(fll.size());
	}

}
