package lista;

import pilha.exceptions.PilhaVaziaException;

public class MainPLL {

	public static void main(String[] args) throws PilhaVaziaException {
		PilhaLL pll = new PilhaLL();
		pll.push(2);
		pll.push(77);
		pll.push(99);
		System.out.println(pll.top());
		pll.pop();
		System.out.println(pll.top());
		System.out.println(pll.size());
		pll.pop();
		System.out.println(pll.top());
		System.out.println(pll.size());
		pll.pop();
		System.out.println(pll.size());
		pll.pop();
	}

}
