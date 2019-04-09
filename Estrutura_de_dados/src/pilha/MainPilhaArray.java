package pilha;

import exceptions.PilhaVaziaException;

public class MainPilhaArray {

	public static void main(String[] args) throws PilhaVaziaException {
		
		Pilha pilha = new Pilha(4);
		
		//pilha.pop();
		pilha.push(99);
		pilha.push(77);
		pilha.push(33);
		System.out.println(pilha.mostrarPilha());
		pilha.push(55);
		pilha.push(66);
		System.out.println(pilha.mostrarPilha());
		System.out.println(pilha.top());
		pilha.pop();
		System.out.println(pilha.mostrarPilha());
		System.out.println(pilha.top());

	}

}
