package lista;

import lista.exceptions.ListaVaziaException;
import lista.exceptions.PosicaoInvalidaException;

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
	public boolean isFirst(Posicao p) throws PosicaoInvalidaException {
		No2 v = this.checarPosicao(p);
		return (v.getAnterior() == header)?true:false;
	}

	@Override
	public boolean isLast(Posicao p) throws PosicaoInvalidaException {
		No2 v = this.checarPosicao(p);
		return (v.getProximo() == trailer)?true:false;
	}

	@Override
	public Posicao first() throws ListaVaziaException {
		if(this.isEmpty())
			throw new ListaVaziaException("Lista vazia");
		return header.getProximo();
	}

	@Override
	public Posicao last() throws ListaVaziaException {
		if(this.isEmpty())
			throw new ListaVaziaException("Lista vazia");
		return trailer.getAnterior();
	}

	@Override
	public Posicao before(Posicao p) throws PosicaoInvalidaException {
		No2 v = this.checarPosicao(p);
		No2 aux = v.getAnterior();
		return aux;
	}

	@Override
	public Posicao after(Posicao p) throws PosicaoInvalidaException {
		No2 v = this.checarPosicao(p);
		No2 aux = v.getProximo();
		return aux;
	}

	@Override
	public Object replaceElement(Posicao p, Object o) throws PosicaoInvalidaException {
		No2 v = this.checarPosicao(p);
		Object old = v.getElemento();
		v.setElemento(o);
		return old;
	}

	@Override
	public void swapElements(Posicao a, Posicao b) throws PosicaoInvalidaException {
		No2 v1 = this.checarPosicao(a);
		No2 v2 = this.checarPosicao(b);
		Object aux = v1.getElemento();
		v1.setElemento(v2.getElemento());
		v2.setElemento(aux);
	}

	@Override
	public Posicao insertBefore(Posicao p, Object o) throws PosicaoInvalidaException {
		No2 v = this.checarPosicao(p);
		No2 n = new No2(o, v, v.getAnterior());
		v.getProximo().setProximo(n);
		v.setAnterior(n);
		total++;
		return n;
	}

	@Override
	public Posicao insertAfter(Posicao p, Object o) throws PosicaoInvalidaException {
		No2 v = this.checarPosicao(p);
		No2 n = new No2(o, v.getProximo(), v);
		v.getProximo().setAnterior(n);
		v.setProximo(n);
		total++;
		return n;
	}

	@Override
	public Posicao insertFirst(Object o) {
		No2 n = new No2(o, header.getProximo(), header);
		header.getProximo().setAnterior(n);
		header.setProximo(n);
		total++;
		return n;
	}

	@Override
	public Posicao insertLast(Object o) {
		No2 n = new No2(o, trailer, trailer.getAnterior());
		trailer.getAnterior().setProximo(n);
		trailer.setAnterior(n);
		total++;
		return n;
	}

	@Override
	public Object remove(Posicao p) throws PosicaoInvalidaException {
		No2 v = this.checarPosicao(p);
		No2 aux = v.getAnterior();
		v.getProximo().setAnterior(aux);
		aux.setProximo(v.getProximo());
		Object r = v.getElemento();
		v.setProximo(null);
		v.setAnterior(null);
		total--;
		return r;
	}
	
	private No2 checarPosicao(Posicao p) throws PosicaoInvalidaException {	
		if(p == null || p == header || p == trailer)
			throw new PosicaoInvalidaException("Posição inválida");
		No2 aux = (No2)p;
		if((aux.getAnterior() == null) || (aux.getProximo() == null))
			throw new PosicaoInvalidaException("Posição inválida");
		return aux;
	}

}
