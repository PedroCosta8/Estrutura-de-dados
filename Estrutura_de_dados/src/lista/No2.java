package lista;

import lista.exceptions.PosicaoInvalidaException;

public class No2  implements Posicao{
	
	private Object elemento;
	private No2 proximo, anterior;
	
	public No2(Object elemento, No2 proximo, No2 anterior) {
		this.setElemento(elemento);
		this.setProximo(proximo);
		this.setAnterior(anterior);
	}
	
	@Override
	public Object getElemento() throws PosicaoInvalidaException {
		if((proximo == null) && (anterior == null))
			throw new PosicaoInvalidaException("Posição Inválida");
		return elemento;
	}

	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}

	public No2 getProximo() {
		return proximo;
	}

	public void setProximo(No2 proximo) {
		this.proximo = proximo;
	}

	public No2 getAnterior() {
		return anterior;
	}

	public void setAnterior(No2 anterior) {
		this.anterior = anterior;
	}

}
