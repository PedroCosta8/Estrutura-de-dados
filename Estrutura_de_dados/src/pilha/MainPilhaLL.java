package pilha;

import exceptions.PilhaVaziaException;

public class MainPilhaLL {

	public static void main(String[] args) throws PilhaVaziaException {
		
		PilhaLL pilha = new PilhaLL();

		//pilha.pop();
		pilha.push(99);
		pilha.push(77);
		pilha.push(33);
		System.out.println(pilha.top());
		System.out.println(pilha.mostrarPilha());
		pilha.push(66);
		pilha.push(55);
		System.out.println(pilha.top());
		System.out.println(pilha.mostrarPilha());
		pilha.pop();
		System.out.println(pilha.top());
		System.out.println(pilha.mostrarPilha());
	}

}
