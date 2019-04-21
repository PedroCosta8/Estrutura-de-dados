package arvore;

import java.util.ArrayList;

public class Node {
	
	private Object elemento;
	private Node pai;
	private ArrayList<Node> filhos;
	
	public Node(Node pai, Object elemento) {
		this.pai = pai;
		this.elemento = elemento;
		filhos = new ArrayList<Node>();
	}
	
	public Object element() {
		return elemento;
	}
	
	public Node parent() {
		return pai;
	}
	
	public void setElement(Object o) {
		this.elemento = o;
	}
	
	public void addChild(Node f) {
		filhos.add(f);
	}
	
	public void removeChild(Node f) {
		filhos.remove(f);
	}
	
	public int childrenNumber() {
		return filhos.size();
	}
	
	public ArrayList<Node> children() {
		return filhos;
	}

}
