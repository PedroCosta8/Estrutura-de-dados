package mapa;

import java.util.ArrayList;

import exceptions.ChaveInvalidaException;

public class MapaLP implements MapaInterface{
	
	private Item[] mapa;
	private int tamanho;
	
	public MapaLP(int tam) {
		mapa = new Item[tam];
		tamanho = 0;
	}

	@Override
	public int size() {
		return tamanho;
	}

	@Override
	public boolean isEmpty() {
		return (tamanho == 0)?true:false;
	}

	@Override
	public ArrayList<Integer> keys() {
		ArrayList<Integer> chaves = new ArrayList<Integer>();
		for(int i = 0; i < mapa.length; i++) {
			if(mapa[i] != null) {
				chaves.add(mapa[i].getChave());
			}
		}
		return chaves;
	}

	@Override
	public ArrayList<Object> elements() {
		ArrayList<Object> valores = new ArrayList<Object>();
		for(int i = 0; i < mapa.length; i++) {
			if(mapa[i] != null) {
				valores.add(mapa[i].getValor());
			}
		}
		return valores;
	}

	@Override
	public void insert(int k, Object o) {
		if(this.size() == mapa.length-1) {
			Item[] novoMapa = new Item[mapa.length*2];
			for(int i = 0; i < mapa.length; i++) {
				int hash = i;
				if(mapa[i] != null) {
					hash = mapa[i].getChave()%novoMapa.length; //faz o hashing novamente no novo array
				}
				novoMapa[hash] = mapa[i]; 
			}
			mapa = novoMapa;
		}
		tamanho++;
		int hash = k%mapa.length;
		if(mapa[hash] == null) {
			Item novo = new Item(o, k, null);
			mapa[hash] = novo;
		}
		else {
			while(mapa[hash] != null) {
				hash = (k+1)%mapa.length;
			}
			Item novo = new Item(o, k, null);
			mapa[hash] = novo;
		}
	}

	@Override
	public Item find(int k) throws ChaveInvalidaException {
		int hash = k%mapa.length;
		Item buscado = mapa[hash];
		int key = k;
		int tam = 0;
		while(tam < mapa.length) {
			key++;
			if(buscado == null) {
				hash = key%mapa.length;
				buscado = mapa[hash];
				tam++;
				continue;
			}
			else {
				if(buscado.getChave() == k) break;
				hash = key%mapa.length;
				buscado = mapa[hash];
				tam++;
			}
		}
		if(buscado == null || buscado.getChave() != k) throw new ChaveInvalidaException("Chave inválida");
		return buscado;
	}

	@Override
	public void remove(int k) throws ChaveInvalidaException{
		int hash = k%mapa.length;
		Item buscado = mapa[hash];
		int key = k;
		int tam = 0;
		while(tam < mapa.length) {
			key++;
			if(buscado == null) {
				hash = key%mapa.length;
				buscado = mapa[hash];
				tam++;
				continue;
			}
			else {
				if(buscado.getChave() == k) {
					mapa[hash] = null;
					tamanho--;
					break;
				}
				hash = key%mapa.length;
				buscado = mapa[hash];
				tam++;
			}
		}
		if(buscado == null || buscado.getChave() != k) throw new ChaveInvalidaException("Chave inválida");
	}
	
	public Item[] vetor() {
		return mapa;
	}

}
