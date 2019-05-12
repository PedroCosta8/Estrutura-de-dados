package mapa;

import java.util.ArrayList;

import exceptions.ChaveInvalidaException;

public interface MapaInterface {

	public int size();
	public boolean isEmpty();
	public ArrayList<Integer> keys();
	public ArrayList<Object> elements();
	public void insert(int k, Object o);
	public Item find(int k) throws ChaveInvalidaException;
	public void remove(int k) throws ChaveInvalidaException;
	
}
