package mapa;

public class Item {

	private Object valor;
	private int chave;
	private Item proximo;
	
	public Item(Object valor, int chave, Item proximo) {
		this.setValor(valor);
		this.setChave(chave);
		this.setProximo(proximo);
	}

	public Object getValor() {
		return valor;
	}

	public void setValor(Object valor) {
		this.valor = valor;
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	public Item getProximo() {
		return proximo;
	}

	public void setProximo(Item proximo) {
		this.proximo = proximo;
	}
	
}
