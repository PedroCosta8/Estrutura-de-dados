package pilha;

import pilha.exceptions.PilhaVaziaException;

public class Main {

	public static void main(String[] args) throws PilhaVaziaException {
	
		PilhaAlviNegra pan = new PilhaAlviNegra(4);
		//pan.popBranco();
		pan.pushBranco(99);
		pan.pushBranco(21);
		pan.pushBranco(37);
		pan.pushPreto(5);
		System.out.println(pan.topBranco());
		System.out.println(pan.topPreto());
		pan.pushPreto(22);
		System.out.println(pan.topPreto());
	}

}
