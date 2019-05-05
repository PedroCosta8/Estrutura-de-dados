package arvore_binaria;

public class MainArvoreBP {

	public static void main(String[] args) {
		
		ArvoreBinaria bt = new ArvoreBinaria();
		
		bt.insert(null, 20);
		bt.insert(bt.root(), 1000);
		bt.insert(bt.root(), 15);
		bt.insert(bt.root(), 32);
		bt.insert(bt.root(), 25);
		bt.insert(bt.root(), 11);
		bt.insert(bt.root(), 16);
		bt.insert(bt.root(), 12);
		bt.insert(bt.root(), 2000);
		System.out.println(bt.mostraArvore());
		//bt.replace(bt.root().getDireito(), 5000);
		//System.out.println(bt.mostraArvore());
		bt.remove(bt.search(15, bt.root()));
		System.out.println(bt.mostraArvore());
		bt.remove(bt.search(32, bt.root()));
		System.out.println(bt.mostraArvore());
		bt.remove(bt.search(1000, bt.root()));
		System.out.println(bt.mostraArvore());
	}

}
