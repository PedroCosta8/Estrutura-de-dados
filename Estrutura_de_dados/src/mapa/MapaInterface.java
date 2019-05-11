package mapa;

import java.util.ArrayList;

public interface MapaInterface {

	public int size();
	public int isEmpty();
	public ArrayList<Integer> keys();
	public ArrayList<Object> elements();
	public void insert(int k, Object o);
	public Item find(int k);
	public void remove(int k);
	
}
