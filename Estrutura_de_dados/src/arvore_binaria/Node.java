package arvore_binaria;

public class Node {

	private int elemento;
	private Node pai, esquerdo, direito;
	
	public Node(int elemento, Node pai, Node esquerdo, Node direito) {
		this.setElemento(elemento);
		this.setPai(pai);
		this.setEsquerdo(esquerdo);
		this.setDireito(direito);
	}

	public int getElemento() {
		return elemento;
	}

	public void setElemento(int elemento) {
		this.elemento = elemento;
	}

	public Node getPai() {
		return pai;
	}

	public void setPai(Node pai) {
		this.pai = pai;
	}

	public Node getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(Node esquerdo) {
		this.esquerdo = esquerdo;
	}

	public Node getDireito() {
		return direito;
	}

	public void setDireito(Node direito) {
		this.direito = direito;
	}
	
	
	
}
