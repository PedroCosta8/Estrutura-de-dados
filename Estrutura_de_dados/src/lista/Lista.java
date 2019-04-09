package lista;

import exceptions.ListaVaziaException;
import exceptions.NoInvalidoException;

public class Lista implements ListaInterface{

	private No2 header;
	private No2 trailer;
	private int total;
	
	public Lista() {
		header = new No2(null, null, null);
		trailer = new No2(null, null, header);
		header.setProximo(trailer);
		total = 0;
	}

	@Override
	public int size() {
		return total;
	}

	@Override
	public boolean isEmpty() {
		return (total == 0)?true:false;
	}

	@Override
	public boolean isFirst(No2 no) throws ListaVaziaException, NoInvalidoException {
		if(this.isEmpty()) throw new ListaVaziaException("lista vazia");
		if(this.checarNo(no)) throw new NoInvalidoException("Nó inválido");
		if(no == header.getProximo()) return true;
		return false;
	}

	@Override
	public boolean isLast(No2 no) throws ListaVaziaException, NoInvalidoException{
		if(this.isEmpty()) throw new ListaVaziaException("lista vazia");
		if(this.checarNo(no)) throw new NoInvalidoException("Nó inválido");
		if(no == trailer.getAnterior()) return true;
		return false;
	}

	@Override
	public No2 first() throws ListaVaziaException {
		return header.getProximo();
	}

	@Override
	public No2 last() throws ListaVaziaException {
		return trailer.getAnterior();
	}

	@Override
	public No2 before(No2 no) throws ListaVaziaException, NoInvalidoException {
		if(this.isEmpty()) throw new ListaVaziaException("lista vazia");
		if(this.checarNo(no)) throw new NoInvalidoException("Nó inválido");
		return no.getAnterior();
	}

	@Override
	public No2 after(No2 no) throws ListaVaziaException, NoInvalidoException {
		if(this.isEmpty()) throw new ListaVaziaException("lista vazia");
		if(this.checarNo(no)) throw new NoInvalidoException("Nó inválido");
		return no.getProximo();
	}

	@Override
	public Object replaceElements(No2 no, Object o) throws ListaVaziaException, NoInvalidoException {
		if(this.isEmpty()) throw new ListaVaziaException("lista vazia");
		if(this.checarNo(no)) throw new NoInvalidoException("Nó inválido");
		Object old = no.getElemento();
		no.setElemento(o);
		return old;
	}

	@Override
	public void swapElements(No2 no1, No2 no2) throws ListaVaziaException, NoInvalidoException {
		if(this.isEmpty()) throw new ListaVaziaException("lista vazia");
		if(this.checarNo(no1) && this.checarNo(no2)) throw new NoInvalidoException("Nó inválido");
		Object aux = no1.getElemento();
		no1.setElemento(no2.getElemento());
		no2.setElemento(aux);
	}

	@Override
	public No2 insertBefore(No2 no, Object o) throws ListaVaziaException, NoInvalidoException {
		if(this.isEmpty()) throw new ListaVaziaException("lista vazia");
		if(this.checarNo(no)) throw new NoInvalidoException("Nó inválido");
		No2 e = new No2(o, no, no.getAnterior());
		no.getAnterior().setProximo(e);
		no.setAnterior(e);
		total++;
		return e;
	}

	@Override
	public No2 insertAfter(No2 no, Object o) throws ListaVaziaException, NoInvalidoException {
		if(this.isEmpty()) throw new ListaVaziaException("lista vazia");
		if(this.checarNo(no)) throw new NoInvalidoException("Nó inválido");
		No2 e = new No2(o, no.getProximo(), no);
		no.getProximo().setAnterior(e);
		no.setProximo(e);
		total++;
		return e;
	}

	@Override
	public void insertFirst(Object o) {
		No2 e = new No2(o, header.getProximo(), header);
		header.getProximo().setAnterior(e);
		header.setProximo(e);
		total++;
	}

	@Override
	public void insertLast(Object o) {
		No2 e = new No2(o, trailer, trailer.getAnterior());
		trailer.getAnterior().setProximo(e);
		trailer.setAnterior(e);
		total++;
	}

	@Override
	public Object remove(No2 no) throws ListaVaziaException, NoInvalidoException {
		if(this.isEmpty()) throw new ListaVaziaException("lista vazia");
		if(this.checarNo(no)) throw new NoInvalidoException("Nó inválido");
		no.getAnterior().setProximo(no.getProximo());
		no.getProximo().setAnterior(no.getAnterior());
		Object aux = no.getElemento();
		no.setAnterior(null);
		no.setAnterior(null);
		no.setElemento(null);
		total--;
		return aux;
	}

	@Override
	public String mostrarLista() {
		String l = "";
		No2 aux = header.getProximo();
		while(aux != trailer) {
			l += aux.getElemento() + " ";
			aux = aux.getProximo();
		}
		l += "|qtd: " + this.size() + "|";
		return l;
	}
	
	private boolean checarNo(No2 no) {
		if(no == null || no == header || no == header) return true;
		else return false;
		
	}
	
	

}
