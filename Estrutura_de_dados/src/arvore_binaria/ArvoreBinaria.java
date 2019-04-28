package arvore_binaria;

import java.util.ArrayList;
import arvore_binaria.Node;

public class ArvoreBinaria{
	
	private Node raiz;
	private int tamanho;
	
	public ArvoreBinaria() {
		raiz = null;	
		tamanho = 0;
	}

	public int size() {
		return this.tamanho;
	}

	public int height(Node no) {
		if(this.isExternal(no)) return 0;
		int h = 0;
		return 0;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Object> elements() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Node> nos() {
		// TODO Auto-generated method stub
		return null;
	}

	public Node root() {
		return raiz;
	}

	public Node parent(Node filho) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Node> children(Node pai) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isInternal(Node no) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isExternal(Node no) {
		return (no.getEsquerdo() == null && no.getDireito() == null)?true:false;
	}

	public boolean isRoot(Node no) {
		// TODO Auto-generated method stub
		return false;
	}

	public int depth(Node no) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object replace(Node no, Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(Node no, int valor) {
		if(raiz == null) {
			raiz =  new Node(valor, null, null, null);
		}
		else {
			if(valor < no.getElemento()) {
				if(no.getEsquerdo() != null) {
					add(no.getEsquerdo(), valor);
				}
				else {
					Node novo = new Node(valor,no, null, null);
					no.setEsquerdo(novo);
				}
			}
			else {
				if(no.getDireito() != null) {
					add(no.getDireito(), valor);
				}
				else {
					Node novo = new Node(valor,no, null, null);
					no.setDireito(novo);
				}
			}
		}
	}

	public Object remove(Node no) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void preOrder(Node no) {
		System.out.print(no.getElemento() + " ");
		if(no.getEsquerdo() != null) {
			preOrder(no.getEsquerdo());
		}
		if(no.getDireito() != null) {
			preOrder(no.getDireito());
		}
	}

	public void inOrder(Node no) {
		if(no.getEsquerdo() != null) {
			inOrder(no.getEsquerdo());
		}
		System.out.println(no.getElemento() + " ");
		if(no.getDireito() != null) {
			inOrder(no.getDireito());
		}
	}
	
	public void posOrder(Node no) {
		if(no.getEsquerdo() != null) {
			inOrder(no.getEsquerdo());
		}
		if(no.getDireito() != null) {
			inOrder(no.getDireito());
		}
		System.out.println(no.getElemento() + " ");
	}

}
