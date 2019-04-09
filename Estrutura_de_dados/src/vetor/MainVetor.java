package vetor;

import exceptions.RankInvalidoException;

public class MainVetor {

	public static void main(String[] args) throws RankInvalidoException {
		
		Vetor vetor = new Vetor(4);
		vetor.insertAtRank(0, 22);
		vetor.insertAtRank(2, 88);
		System.out.println(vetor.mostrarVetor());
		vetor.insertAtRank(1, 33);
		vetor.insertAtRank(3, 71);
		vetor.insertAtRank(4, 11);
		System.out.println(vetor.mostrarVetor());
		vetor.removeAtRank(2);
		System.out.println(vetor.mostrarVetor());
		System.out.println(vetor.elementAtRank(3));
		vetor.replaceAtRank(1, 19);
		System.out.println(vetor.mostrarVetor());

	}

}
