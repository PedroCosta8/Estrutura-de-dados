package pilha;

import pilha.exceptions.PilhaVaziaException;

public class PilhaArray implements Pilha{

	private Object S[];
	private int t;
	
	public PilhaArray(int tam) {
		S = new Object[tam];
		t = -1;
	}
	
	@Override
	public int size() {
		if(this.isEmpty())
			return 0;
		return this.t + 1;
	}

	@Override
	public boolean isEmpty() {
		if(this.t == -1)
			return true;
		return false;
	}

	@Override
	public Object top() throws PilhaVaziaException {
		if(this.isEmpty())
			throw new PilhaVaziaException("Pilha Vazia");
		return S[t];
	}

	@Override
	public void push(Object o){
		if(this.S.length == this.t+1) {
			Object aux[] = new Object[this.S.length * 2];
			for(int i = 0; i < this.S.length; i++) {
				aux[i] = S[i];
			}
			S = aux;
		}
		this.S[++t] = o;
	}

	@Override
	public Object pop() throws PilhaVaziaException {
		if (isEmpty())
			throw new PilhaVaziaException("Pilha Vazia");
		return this.S[this.t--];
	}

}
