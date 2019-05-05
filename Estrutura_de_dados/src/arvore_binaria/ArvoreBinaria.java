package arvore_binaria;

import java.util.ArrayList;
import arvore_binaria.Node;

public class ArvoreBinaria{
	
	private Node raiz;
	private int tamanho;
	private ArrayList<Node> listaPreOrder, listaInOrder, listaPosOrder;
	
	public ArvoreBinaria() {
		raiz = null;	
		tamanho = 0;
	}
	
	public ArvoreBinaria(Node raiz) {
		this.raiz = raiz;
		tamanho = 1;
	}

	public int size() {
		return this.tamanho;
	}

	public int height(Node no) {
		if(no == null || this.isExternal(no)) {
			return 0;
		}
		else {
			int left = height(no.getEsquerdo());
			int right = height(no.getDireito());
			if (left > right) {
				return left + 1;
			}
			return right + 1;
		}
	}

	public boolean isEmpty() {
		return (raiz == null)?true:false;
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
		ArrayList<Node> filhos = new ArrayList<Node>();
		filhos.add(pai.getEsquerdo());
		filhos.add(pai.getEsquerdo());
		return filhos;
	}

	public boolean isInternal(Node no) {
		return (!this.isExternal(no))?true:false;
	}

	public boolean isExternal(Node no) {
		return (no.getEsquerdo() == null && no.getDireito() == null)?true:false;
	}

	public boolean isRoot(Node no) {
		return (no != raiz)?false:true;
	}

	public int depth(Node no) {
		if(no == null) return -1;
		if(this.isRoot(no)) return 0;
		else return 1 + depth(no.getPai());
	}

	public Object replace(Node no, Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insert(Node no, int valor) {
		if(raiz == null) {
			raiz =  new Node(valor, null, null, null);
		}
		else {
			if(valor < no.getElemento()) {
				if(no.getEsquerdo() != null) {
					insert(no.getEsquerdo(), valor);
				}
				else {
					Node novo = new Node(valor,no, null, null);
					no.setEsquerdo(novo);
				}
			}
			else {
				if(no.getDireito() != null) {
					insert(no.getDireito(), valor);
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
	
	public ArrayList<Node> preOrder(Node no, boolean visitado) {
		if(!visitado) {
			listaPreOrder = new ArrayList<Node>();
		}
		listaPreOrder.add(no);
		if(no.getEsquerdo() != null) {
			preOrder(no.getEsquerdo(), true);
		}
		if(no.getDireito() != null) {
			preOrder(no.getDireito(), true);
		}
		return listaPreOrder;
	}

	public ArrayList<Node> inOrder(Node no, boolean visitado) {
		if(!visitado) {
			listaInOrder = new ArrayList<Node>();
		}
		if(no.getEsquerdo() != null) {
			inOrder(no.getEsquerdo(), true);
		}
		listaInOrder.add(no);
		if(no.getDireito() != null) {
			inOrder(no.getDireito(), true);
		}
		return listaInOrder;
	}
	
	public ArrayList<Node> posOrder(Node no, boolean visitado) {
		if(!visitado) {
			listaPosOrder = new ArrayList<Node>();
		}
		if(no.getEsquerdo() != null) {
			inOrder(no.getEsquerdo(), true);
		}
		if(no.getDireito() != null) {
			inOrder(no.getDireito(), true);
		}
		listaPosOrder.add(no);
		return listaPosOrder;
	}
	
	public String mostraArvore() {
		String arvoreCompleta = "";
		
		ArrayList<Node> tmpList = this.inOrder(this.raiz, false);
		
		int largura = tmpList.size();
		int altura = this.height(this.raiz);
		
		String[][] arvore = new String[altura+1][largura];
		
		Node no = null;
		int l = 0;
		
		for(int i=0; i<largura; i++) {
			no = tmpList.get(i);
			l = this.depth(no);
			
			arvore[l][i] = String.valueOf(no.getElemento());
		}
		
		for(int i=0; i<altura+1; i++) {
			for(int j=0; j<largura; j++) {
				if(arvore[i][j] == null) {
					arvoreCompleta += " ";
				}
				else {
					
					arvoreCompleta += arvore[i][j]+" ";
				}
			}
			arvoreCompleta += "\n";
		}
		return arvoreCompleta;
	}

}
