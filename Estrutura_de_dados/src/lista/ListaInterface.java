package lista;

import lista.exceptions.ListaVaziaException;
import lista.exceptions.PosicaoInvalidaException;

public interface ListaInterface {

	public int size();
	public boolean isEmpty();
	public boolean isFirst(Posicao p)
	throws PosicaoInvalidaException;
	public boolean isLast(Posicao p)
	throws PosicaoInvalidaException;
	public Posicao first()
	throws ListaVaziaException;
	public Posicao last()
	throws ListaVaziaException;
	public Posicao before(Posicao p)
	throws PosicaoInvalidaException;
	public Posicao after(Posicao p)
	throws PosicaoInvalidaException;
	public Object replaceElement(Posicao p, Object o)
	throws PosicaoInvalidaException;
	public void swapElements(Posicao a, Posicao b)
	throws PosicaoInvalidaException;
	public Posicao insertBefore(Posicao p, Object o)
    throws PosicaoInvalidaException;
	public Posicao insertAfter(Posicao p, Object o)
    throws PosicaoInvalidaException;
	public Posicao insertFirst(Object o);
	public Posicao insertLast(Object o);
	public Object remove(Posicao p)
	throws PosicaoInvalidaException;
}
