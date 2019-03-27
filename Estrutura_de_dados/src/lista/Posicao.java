package lista;

import lista.exceptions.PosicaoInvalidaException;

public interface Posicao {
	
	public Object getElemento()
	throws PosicaoInvalidaException;

}
