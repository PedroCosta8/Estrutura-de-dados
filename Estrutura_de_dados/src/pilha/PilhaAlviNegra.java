package pilha;

import pilha.exceptions.PilhaVaziaException;

public class PilhaAlviNegra{
	
	private Object S[];
	private int tb;
	private int tp;
	
	public PilhaAlviNegra(int tam) {
		S = new Object[tam];
		tb = -1;
		tp = tam;
	}

	public int sizeBranco() {
		if(this.isEmptyBranco())
			return 0;
		return this.tb + 1;
	}
	
	public int sizePreto() {
		if(this.isEmptyPreto())
			return 0;
		return (this.S.length - this.tp);
	}
	
	public boolean isEmptyBranco() {
		if(this.tb == -1)
			return true;
		return false;
	}
	
	public boolean isEmptyPreto() {
		if(this.tp == this.S.length)
			return true;
		return false;
	}
	
	public Object topBranco() throws PilhaVaziaException {
		if(this.isEmptyBranco())
			throw new PilhaVaziaException("Pilha Vazia");
		return this.S[tb];
	}
	
	public Object topPreto() throws PilhaVaziaException {
		if(this.isEmptyPreto())
			throw new PilhaVaziaException("Pilha Vazia");
		return this.S[tp];
	}
	
	public void pushBranco(Object o){
		if(this.S.length <= this.sizeBranco() + this.sizePreto()) {
			Object aux[] = new Object[this.S.length * 2];
			for(int i = 0; i < this.tb+1; i++) {
				aux[i] = this.S[i];
			}
			int j = aux.length-1;
			for(int i = (this.S.length-1); i > this.tp; i--) {
				aux[j] = this.S[i];
				j--;
			}
			this.tp = j;
			S = aux;
		}
		this.S[++tb] = o;
	}
	
	public void pushPreto(Object o){
		if(this.S.length <= this.sizeBranco() + this.sizePreto()) {
			Object aux[] = new Object[this.S.length * 2];
			for(int i = 0; i < this.tb+1; i++) {
				aux[i] = this.S[i];
			}
			int j = aux.length-1;
			for(int i = (this.S.length-1); i > this.tp; i--) {
				aux[j] = this.S[i];
				j--;
			}
			this.tp = j;
			S = aux;
		}
		this.S[--tp] = o;
	}
	
	public Object popBranco() throws PilhaVaziaException {
		if (isEmptyBranco())
			throw new PilhaVaziaException("Pilha Vazia");
		return this.S[this.tb--];
	}
	
	public Object popPreto() throws PilhaVaziaException {
		if (isEmptyPreto())
			throw new PilhaVaziaException("Pilha Vazia");
		return this.S[this.tp++];
	}
	

}
