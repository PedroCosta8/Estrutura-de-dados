package sequencia;

import lista.Lista;
import lista.ListaInterface;
import lista.No2;
import lista.Posicao;
import lista.exceptions.ListaVaziaException;
import lista.exceptions.PosicaoInvalidaException;
import vetor.exceptions.RankInvalidoException;

public class Sequencia extends Lista implements ListaInterface{

	private No2 header;
	private No2 trailer;
	private int total;
	
	public Sequencia() {
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
		v.getAnterior().setProximo(n);
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

	public Object elementAtRank(int r) throws RankInvalidoException, PosicaoInvalidaException {
		if(r < 0 || r > total)
			throw new RankInvalidoException("Rank inválido");
		if(r < total/2) {
			No2 e = header.getProximo();
			int i = 0;
			while(i != r) {
				e = e.getProximo();
				this.checarPosicao(e);
				i++;
			}
			return e.getElemento();
		}
		else {
			No2 e = trailer.getAnterior();
			int i = total-1;
			while(i != r) {
				e = e.getAnterior();
				this.checarPosicao(e);
				i--;
			}
			return e.getElemento();
		}
	}

	public Object replaceAtRank(int r, Object o) throws RankInvalidoException, PosicaoInvalidaException {
		if(r < 0 || r > total)
			throw new RankInvalidoException("Rank inválido");
		if(r < total/2) {
			No2 e = header.getProximo();
			int i = 0;
			while(i != r) {
				e = e.getProximo();
				this.checarPosicao(e);
				i++;
			}
			Object old = e.getElemento();
			e.setElemento(o);
			return old;
		}
		else {
			No2 e = trailer.getAnterior();
			int i = total-1;
			while(i != r) {
				e = e.getAnterior();
				this.checarPosicao(e);
				i--;
			}
			Object old = e.getElemento();
			e.setElemento(o);
			return old;
		}
	}


	public void insertAtRank(int r, Object o) throws RankInvalidoException{
		if(r < 0 || r > total)
			throw new RankInvalidoException("Rank inválido");
		No2 e = header.getProximo();
		int i = 0;
		while(i != r) {
			e = e.getProximo();
			i++;
		}
		No2 n = new No2(o, e, e.getAnterior());
		e.getAnterior().setProximo(n);
		e.setAnterior(n);
		total++;	
	}

	public Object removeAtRank(int r) throws RankInvalidoException, PosicaoInvalidaException {
		if(r < 0 || r > total)
			throw new RankInvalidoException("Rank inválido");
		if(r < total/2) {
			No2 e = header.getProximo();
			int i = 0;
			while(i != r) {
				e = e.getProximo();
				this.checarPosicao(e);
				i++;
			}
			Object aux = e.getElemento();
			e.getAnterior().setProximo(e.getProximo());
			e.getProximo().setAnterior(e.getAnterior());
			e.setProximo(null);
			e.setAnterior(null);
			total--;
			return aux;
		}
		else {
			No2 e = trailer.getAnterior();
			int i = total-1;
			while(i != r) {
				e = e.getAnterior();
				this.checarPosicao(e);
				i--;
			}
			Object aux = e.getElemento();
			e.getAnterior().setProximo(e.getProximo());
			e.getProximo().setAnterior(e.getAnterior());
			e.setProximo(null);
			e.setAnterior(null);
			total--;
			return aux;
		}
	}
	
	public Posicao atRank(int r) throws RankInvalidoException, PosicaoInvalidaException {
		if(r < 0 || r > total-1)
			throw new RankInvalidoException("Rank inválido");
		if(r < total/2) {
			No2 e = header.getProximo();
			int i = 0;
			while(i != r) {
				e = e.getProximo();
				this.checarPosicao(e);
				i++;
			}
			return e;
		}
		else {
			No2 e = trailer.getAnterior();
			int i = total;
			while(i != r) {
				e = e.getAnterior();
				i--;
			}
			return e;
		}
	}
	
	public int rankOf(Posicao p) throws PosicaoInvalidaException{
		No2 i = header.getProximo();
		No2 p2 = this.checarPosicao(p);
		int r = 0;
		while(i != p2 && i != trailer) {
			i = i.getProximo();
			r++;
		}
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
	
	public String mostrarLista() throws PosicaoInvalidaException {
		No2 e = header.getProximo();
		String lista = "";
		while(e != trailer) {
			lista += String.valueOf(e.getElemento());
			lista += " ";
			e = e.getProximo();
		}
		lista += "|qtd: " + String.valueOf(total) + "|";
		return lista;
	}

}
