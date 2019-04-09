package vetor;

import exceptions.RankInvalidoException;

public interface VetorInterface {

	public int size();
	public boolean isEmpty();
	public Object elementAtRank(int r) throws RankInvalidoException;
	public void replaceAtRank(int r, Object o) throws RankInvalidoException;
	public Object removeAtRank(int r) throws RankInvalidoException;
	public void insertAtRank(int r, Object o) throws RankInvalidoException;
	public String mostrarVetor();
	
}
