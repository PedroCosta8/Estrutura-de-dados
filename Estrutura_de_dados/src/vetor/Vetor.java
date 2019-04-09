package vetor;

import exceptions.RankInvalidoException;

public class Vetor implements VetorInterface{
	
	private Object[] vetor;
	private int total;
	
	public Vetor(int tam) {
		vetor = new Object[tam];
		total = 0;
	}

	@Override
	public int size() {
		return total;
	}

	@Override
	public boolean isEmpty() {
		return (total == 0)?true:false;
	}

	@Override
	public Object elementAtRank(int r) throws RankInvalidoException {
		if(r < 0 || r > vetor.length-1) throw new RankInvalidoException("Rank inválido");
		if(vetor[r] == null) throw new RankInvalidoException("Rank inválido");
		return vetor[r];
	}

	@Override
	public void replaceAtRank(int r, Object o) throws RankInvalidoException {
		if(r < 0 || r > vetor.length-1) throw new RankInvalidoException("Rank inválido");
		vetor[r] = o;
	}

	@Override
	public Object removeAtRank(int r) throws RankInvalidoException {
		if(r < 0 || r > vetor.length-1) throw new RankInvalidoException("Rank inválido");
		Object aux = vetor[r];
		for(int i = r; i < total-1; i++) { //nao pode ser total se nao, ira tentar acessar um indice inexistente
			vetor[i] = vetor[i+1];
		}
		vetor[total-1] = null;
		total--;
		return aux;
	}

	@Override
	public void insertAtRank(int r, Object o) throws RankInvalidoException {
		if(r < 0 || r > vetor.length-1) throw new RankInvalidoException("Rank inválido");
		total++;
		if(total == vetor.length-1) {
			Object[] aux = new Object[vetor.length*2];
			for(int i = 0; i < vetor.length-1; i++) {
				aux[i] = vetor[i];
			}
			vetor = aux;
		}
		for(int i = total-1; i > r; i--) {
			vetor[i+1] = vetor[i];
		}
		vetor[r] = o;
	}

	@Override
	public String mostrarVetor() {
		String v = "";
		for(int i = 0; i < vetor.length; i++) {
			v += vetor[i] + " ";
		}
		v += "|qtd: " + this.size()+ "|";
		return v;
	}

}
