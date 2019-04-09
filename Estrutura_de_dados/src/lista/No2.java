package lista;

public class No2{
	
	private No2 proximo;
	private No2 anterior;
	private Object elemento;
	
	public No2(Object elemento, No2 proximo, No2 anterior) {
		this.setElemento(elemento);
		this.setProximo(proximo);
		this.setAnterior(anterior);
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

	public Object getElemento() {
		return elemento;
	}

	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}
	
	
	
}
