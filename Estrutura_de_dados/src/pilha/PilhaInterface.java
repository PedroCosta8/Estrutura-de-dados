package pilha;

import exceptions.PilhaVaziaException;

public interface PilhaInterface {
	
	public int size();
	public boolean isEmpty();
	public Object top() throws PilhaVaziaException;
	public void push(Object o);
	public Object pop() throws PilhaVaziaException;
	public String mostrarPilha();

}
