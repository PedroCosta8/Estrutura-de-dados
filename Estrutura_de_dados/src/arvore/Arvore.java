package arvore;

import java.util.ArrayList;

public class Arvore implements ArvoreInterface{
	
	private Node raiz;
	private int tamanho;
	
	public Arvore(Object o) {
		raiz = new Node(null, o);
		tamanho = 1;
	}

	@Override
	public int size() {
		return this.tamanho;
	}

	@Override
	public int height(Node no) {
		if(this.isExternal(no)) return 0;
		int h = 0;
		for(Node w : no.children())
			h = Math.max(h, height(w));
		return 1+h;
	}

	@Override
	public boolean isEmpty() {
		return (tamanho == 0)?true:false;
	}

	@Override
	public ArrayList<Object> elements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Node> nos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node root() {
		return raiz;
	}

	@Override
	public Node parent(Node filho) {
		return filho.parent();
	}

	@Override
	public ArrayList<Node> children(Node pai) {
		return pai.children();
	}

	@Override
	public boolean isInternal(Node no){
		return (this.isExternal(no))?false:true;
	}

	@Override
	public boolean isExternal(Node no) {
		return (no.childrenNumber() == 0)?true:false;
	}

	@Override
	public boolean isRoot(Node no) {
		return (no.parent() == null)?true:false;
	}

	@Override
	public int depth(Node no) {
		if(this.isRoot(no)) return 0;
		else return 1 + depth(this.parent(no));
	}

	@Override
	public Object replace(Node no, Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addChild(Node pai, Object o) {
		Node no = new Node(pai, o);
		pai.addChild(no);
		tamanho++;
	}

	@Override
	public Object remove(Node no) {
		Node pai = no.parent();
		pai.removeChild(no);
		Object o = no.element();
		no.setElement(null);
		tamanho--;
		return o;
	}
	
	public String mostraArvore(Node r) {
		String s = r.element().toString();
		if(this.isInternal(r)) {
			for(Node w : r.children()) {
				s += "\n"+(repeteChar("  ", this.depth(w))) +mostraArvore(w);
			}
		}
		return s;
	}
	
	public String mostraArvore2(Node r) {
		String s = r.element().toString();
		for(Node w : r.children()) {
			s += "\n"+ (repeteChar("  ", this.depth(w))) + w.element();
			if(this.isInternal(w)) {
				for(Node i : w.children()) {
					s += "\n"+ (repeteChar("  ", this.depth(i))) + i.element();
				}
			}
		}
		
		return s;
	}
	
	private String repeteChar(String c, int num) {
		String aux = c;
		for(int i = 0; i<num-1; i++)
			aux += c;
		return aux;
	}

}
