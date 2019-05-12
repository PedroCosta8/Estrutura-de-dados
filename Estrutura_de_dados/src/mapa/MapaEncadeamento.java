package mapa;

import java.util.ArrayList;

import exceptions.ChaveInvalidaException;

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
	public boolean isEmpty() {
		return (tamanho == 0)?true:false;
	}

	@Override
	public ArrayList<Integer> keys() {
		ArrayList<Integer> chaves = new ArrayList<Integer>();
		for(int i = 0; i < mapa.length; i++) {
			if(mapa[i] != null) {
				if(mapa[i].getProximo() != null) {
					Item aux = mapa[i];
					while(aux != null) {
						chaves.add(aux.getChave());
						aux = aux.getProximo();
					}
				}
				else {
					chaves.add(mapa[i].getChave());
				}
			}
		}
		return chaves;
	}

	@Override
	public ArrayList<Object> elements() {
		ArrayList<Object> valores = new ArrayList<Object>();
		for(int i = 0; i < mapa.length; i++) {
			if(mapa[i] != null) {
				if(mapa[i].getProximo() != null) {
					Item aux = mapa[i];
					while(aux != null) {
						valores.add(aux.getValor());
						aux = aux.getProximo();
					}
				}
				else {
					valores.add(mapa[i].getValor());
				}
			}
		}
		return valores;
	}

	@Override
	public void insert(int k, Object o) {
		int hash = k%mapa.length;
		if (mapa[hash] == null) { //se tiver espaço vazio insira nessa posicao
			Item novo = new Item(o, k, null);
			mapa[hash] = novo;
			tamanho++;
		}
		else {
			Item tmp = mapa[hash]; //se ja tiver ocupado, faça encadeamento com lista
			Item ant = null;
			while(tmp != null) { //procura o ultimo elemento da lista atual
				ant = tmp;
				tmp = tmp.getProximo();
			}
			Item novo = new Item(o, k, null);
			ant.setProximo(novo);
			tamanho++;
		}
	}

	@Override
	public Item find(int k) throws ChaveInvalidaException{
		int hash = k%mapa.length;
		if(mapa[hash] == null) {
			throw new ChaveInvalidaException("Chave inválida");
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
	public void remove(int k) throws ChaveInvalidaException{
		int hash = k%mapa.length;
		if(mapa[hash] == null) {
			throw new ChaveInvalidaException("Chave inválida");
		}
		else {
			if(mapa[hash].getChave() == k) { //se a chave for igual 
				if (mapa[hash].getProximo() != null) { //se tiver 1 elemento encadeado
					mapa[hash] = mapa[hash].getProximo(); //vao trocar de lugar
					tamanho--;
				}
				else {
					mapa[hash] = null; //se nao tiver elemento encadeado
					tamanho--;
				}
			}
			else {
				Item buscado = mapa[hash];
				Item ant = null;
				while(buscado.getChave() != k) { //vai buscar no encadeamento o item correspondente e o seu anterior
					ant = buscado;
					buscado = buscado.getProximo();
				}
				ant.setProximo(buscado.getProximo());
				buscado.setValor(null);
				buscado.setProximo(null);
				tamanho--;
			}
		}
	}
	
	

}
