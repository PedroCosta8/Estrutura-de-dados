package arvore_binaria;

public class MainArvoreBP {

	public static void main(String[] args) {
		
		ArvoreBinaria bt = new ArvoreBinaria();
		
		bt.add(null, 1);
		bt.add(bt.root(), 15);
		bt.add(bt.root(), 4);
		//bt.preOrder(bt.root());
		bt.add(bt.root(), 2);
		bt.preOrder(bt.root());
	}

}
