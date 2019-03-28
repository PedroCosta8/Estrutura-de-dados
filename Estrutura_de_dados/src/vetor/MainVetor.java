package vetor;

import vetor.exceptions.RankInvalidoException;

public class MainVetor {

	public static void main(String[] args) throws RankInvalidoException {

		Vetor vetor = new Vetor(4);
		vetor.insertAtRank(0, 11);
		vetor.insertAtRank(1, 22);
		vetor.insertAtRank(2, 6);
		vetor.insertAtRank(3, 99);
		System.out.println(vetor.mostrarVetor());
		System.out.println(vetor.elementAtRank(1));
		vetor.insertAtRank(4, 77);
		System.out.println(vetor.mostrarVetor());
		//vetor.insertAtRank(10, 66);
		vetor.insertAtRank(0, 66);
		System.out.println(vetor.mostrarVetor());
		vetor.replaceAtRank(4, 74);
		System.out.println(vetor.mostrarVetor());
		vetor.removeAtRank(2);
		System.out.println(vetor.mostrarVetor());
	}

}
