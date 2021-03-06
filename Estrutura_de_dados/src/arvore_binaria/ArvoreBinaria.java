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
			int left = height(no.getFilhoEsquerdo());
			int right = height(no.getFilhoDireito());
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
		ArrayList<Object> elementos = new ArrayList<Object>();
		ArrayList<Node> preOrderAux = this.preOrder(this.raiz, false);
		int tam = preOrderAux.size();
		for(int i = 0; i < tam; i++) {
			elementos.add(preOrderAux.get(i).getElemento());
		}
		return elementos;
	}

	public ArrayList<Node> nos() {
		ArrayList<Node> nos = new ArrayList<Node>();
		ArrayList<Node> preOrderAux = this.preOrder(this.raiz, false);
		int tam = preOrderAux.size();
		for(int i = 0; i < tam; i++) {
			nos.add(preOrderAux.get(i));
		}
		return nos;
	}

	public Node root() {
		return raiz;
	}

	public Node parent(Node filho) {
		return filho.getPai();
	}

	public ArrayList<Node> children(Node pai) {
		ArrayList<Node> filhos = new ArrayList<Node>();
		if(pai.getFilhoEsquerdo() != null) {
			filhos.add(pai.getFilhoEsquerdo());
		}
		if(pai.getFilhoDireito() != null) {
			filhos.add(pai.getFilhoDireito());
		}
		return filhos;
	}

	public boolean isInternal(Node no) {
		return (!this.isExternal(no))?true:false;
	}

	public boolean isExternal(Node no) {
		return (no.getFilhoEsquerdo() == null && no.getFilhoDireito() == null)?true:false;
	}

	public boolean isRoot(Node no) {
		return (no != raiz)?false:true;
	}

	public int depth(Node no) {
		if(no == null) return -1;
		if(this.isRoot(no)) return 0;
		else return 1 + depth(no.getPai());
	}

	public Object replace(Node no, int v) { //precisa consertar
		int old = no.getElemento();
		no.setElemento(v);
		return old;
	}
	
	public void swapElements(Node no1, Node no2) { //precisa consertar
		int aux = no1.getElemento();
		no1.setElemento(no2.getElemento());
		no2.setElemento(aux);
	}

	public void insert(Node no, int valor) {
		if(raiz == null) {
			raiz =  new Node(valor, null, null, null);
		}
		else {
			if(valor < no.getElemento()) {
				if(no.getFilhoEsquerdo() != null) {
					insert(no.getFilhoEsquerdo(), valor);
				}
				else {
					Node novo = new Node(valor,no, null, null);
					no.setFilhoEsquerdo(novo);
				}
			}
			else {
				if(no.getFilhoDireito() != null) {
					insert(no.getFilhoDireito(), valor);
				}
				else {
					Node novo = new Node(valor,no, null, null);
					no.setFilhoDireito(novo);
				}
			}
		}
	}

	public Object remove(Node no) {
		int valor = 0;
		//folha
		if(this.isExternal(no)) {
			valor = no.getElemento();
			if(no.getPai().getFilhoEsquerdo() == no) {
				no.getPai().setFilhoEsquerdo(null);
			}
			else {
				no.getPai().setFilhoDireito(null);
			}
		}
		else {
			int qtdF = this.children(no).size();
			//1 filho
			if(qtdF == 1) {
				valor = no.getElemento();
				if(no.getPai().getFilhoDireito() == no) { //eh o filho direito do pai
					if(no.getFilhoEsquerdo() != null) { //so tem filho na esquerda
						no.getPai().setFilhoDireito(no.getFilhoEsquerdo());
						no.getFilhoEsquerdo().setPai(no.getPai());
						no.clear();
					}
					else { //so tem filho na direita
						no.getPai().setFilhoDireito(no.getFilhoDireito());
						no.getFilhoDireito().setPai(no.getPai());
						no.clear();
					}
				}
				else {
					if(no.getFilhoEsquerdo() != null) { //so tem filho na esquerda
						no.getPai().setFilhoEsquerdo(no.getFilhoEsquerdo());
						no.getFilhoEsquerdo().setPai(no.getPai());
						no.clear();
					}
					else { //so tem filho na direita
						no.getPai().setFilhoEsquerdo(no.getFilhoDireito());
						no.getFilhoDireito().setPai(no.getPai());
						no.clear();
					}
				}
			}
			else { //2 filhos
				valor = no.getElemento();
				Node aux = no.getFilhoDireito();
				Node sub = null; //o substituto do nó que sera removido
				while(aux != null) {
					sub = aux; //nó mais a esquerda da sub-arvore direita
					aux = aux.getFilhoEsquerdo();
				}
				no.setElemento(sub.getElemento());
				this.remove(sub);
			}
		}
		return valor;
	}
	
	public ArrayList<Node> preOrder(Node no, boolean visitado) {
		if(!visitado) {
			listaPreOrder = new ArrayList<Node>();
		}
		listaPreOrder.add(no);
		if(no.getFilhoEsquerdo() != null) {
			preOrder(no.getFilhoEsquerdo(), true);
		}
		if(no.getFilhoDireito() != null) {
			preOrder(no.getFilhoDireito(), true);
		}
		return listaPreOrder;
	}

	public ArrayList<Node> inOrder(Node no, boolean visitado) {
		if(!visitado) {
			listaInOrder = new ArrayList<Node>();
		}
		if(no.getFilhoEsquerdo() != null) {
			inOrder(no.getFilhoEsquerdo(), true);
		}
		listaInOrder.add(no);
		if(no.getFilhoDireito() != null) {
			inOrder(no.getFilhoDireito(), true);
		}
		return listaInOrder;
	}
	
	public ArrayList<Node> posOrder(Node no, boolean visitado) {
		if(!visitado) {
			listaPosOrder = new ArrayList<Node>();
		}
		if(no.getFilhoEsquerdo() != null) {
			posOrder(no.getFilhoEsquerdo(), true);
		}
		if(no.getFilhoDireito() != null) {
			posOrder(no.getFilhoDireito(), true);
		}
		listaPosOrder.add(no);
		if(!visitado) {
			return listaPosOrder;
		}
		return null;
	}
	
	public String mostraArvore() {
		String arvoreCompleta = "";
		
		ArrayList<Node> nos = this.inOrder(this.raiz, false);
		
		int largura = nos.size();
		int altura = this.height(this.raiz);
		
		String[][] arvore = new String[altura+1][largura];
		
		Node no = null;
		int l = 0;
		
		for(int i=0; i<largura; i++) {
			no = nos.get(i);
			l = this.depth(no);
			
			arvore[l][i] = String.valueOf(no.getElemento());
		}
		
		for(int i=0; i<altura+1; i++) {
			for(int j=0; j<largura; j++) {
				if(arvore[i][j] == null) {
					arvoreCompleta += "  ";
				}
				else {
					
					arvoreCompleta += arvore[i][j];
				}
			}
			arvoreCompleta += "\n";
		}
		return arvoreCompleta;
	}
	
	public Node search(int valor, Node no) {
		Node aux = null;
		if(valor == no.getElemento()) {
			return no;
		}
		if(valor < no.getElemento()) {
			aux = this.search(valor, no.getFilhoEsquerdo());
		}
		if(valor > no.getElemento()) {
			aux =this.search(valor, no.getFilhoDireito());
		}
		no = aux;
		return no;
	}
	
	public Node leftChild(Node no) {
		return no.getFilhoEsquerdo();
	}
	
	public Node rightChild(Node no) {
		return no.getFilhoDireito();
	}
	
	public boolean hasLeftChild(Node no) {
		return (no.getFilhoEsquerdo() != null)?true:false;
	}
	
	public boolean hasRightChild(Node no) {
		return (no.getFilhoDireito() != null)?true:false;
	}
	
	

}
