package lista;

import exceptions.ListaVaziaException;
import exceptions.NoInvalidoException;

public interface ListaInterface {
	
	public int size();
	public boolean isEmpty();
	public boolean isFirst(No2 no) throws ListaVaziaException,
	NoInvalidoException;
	public boolean isLast(No2 no) throws ListaVaziaException, NoInvalidoException;
	public No2 first() throws ListaVaziaException;
	public No2 last() throws ListaVaziaException;
	public No2 before(No2 no) throws ListaVaziaException, NoInvalidoException;
	public No2 after(No2 no) throws ListaVaziaException, NoInvalidoException;
	public Object replaceElements(No2 no, Object o) throws ListaVaziaException, 
	NoInvalidoException;
	public void swapElements(No2 no1, No2 no2) throws ListaVaziaException, 
	NoInvalidoException;
	public No2 insertBefore(No2 no, Object o) throws ListaVaziaException, 
	NoInvalidoException;
	public No2 insertAfter(No2 no, Object o) throws ListaVaziaException, 
	NoInvalidoException;
	public void insertFirst(Object o);
	public void insertLast(Object o);
	public Object remove(No2 no) throws ListaVaziaException, 
	NoInvalidoException;
	public String mostrarLista();
	

}
