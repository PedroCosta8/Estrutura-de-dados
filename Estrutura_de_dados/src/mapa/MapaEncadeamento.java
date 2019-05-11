package mapa;

import java.util.ArrayList;

public class MapaEncadeamento implements MapaInterface{
	
	private Item[] mapa;
	private int tamanho;
	
	public MapaEncadeamento(int tam) {
		mapa = new Item[tam];
		tamanho = 0;
	}

	@Override
	public int size() {
		return tamanho;
	}

	@Override
	public int isEmpty() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Integer> keys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Object> elements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(int k, Object o) {
		int hash = k%mapa.length;
		if (mapa[hash] == null) {
			Item novo = new Item(o, k, null);
			mapa[hash] = novo;
			tamanho++;
		}
		else {
			Item tmp = mapa[hash];
			Item ant = null;
			while(tmp != null) {
				ant = tmp;
				tmp = tmp.getProximo();
			}
			Item novo = new Item(o, k, null);
			ant.setProximo(novo);
			tamanho++;
		}
	}

	@Override
	public Item find(int k) {
		int hash = k%mapa.length;
		if(mapa[hash] == null) {
			return null;
		}
		else {
			Item buscado = mapa[hash];
			while(buscado.getChave() != k) {
				buscado = buscado.getProximo();
			}
			return buscado;
		}
	}

	@Override
	public void remove(int k) {
		int hash = k%mapa.length;
		if(mapa[hash] == null) {
			return; //deve disparar a exceção
		}
		else {
			if(mapa[hash].getChave() == k) {
				if (mapa[hash].getProximo() != null) {
					mapa[hash] = mapa[hash].getProximo();
					tamanho--;
				}
				else {
					mapa[hash] = null;
					tamanho--;
				}
			}
			else {
				Item buscado = mapa[hash];
				Item ant = null;
				while(buscado.getChave() != k) {
					ant = buscado;
					buscado = buscado.getProximo();
				}
				ant.setValor(buscado.getValor());
				ant.setProximo(null);
				tamanho--;
			}
		}
	}
	
	

}
