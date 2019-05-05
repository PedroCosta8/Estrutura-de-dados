package arvore_binaria;

public class MainArvoreBP {

	public static void main(String[] args) {
		
		ArvoreBinaria bt = new ArvoreBinaria();
		
		bt.insert(null, 10);
		bt.insert(bt.root(), 15);
		bt.insert(bt.root(), 4);
		//bt.preOrder(bt.root());
		bt.insert(bt.root(), 2);
		bt.insert(bt.root(), 20);
		//bt.insert(bt.root(), 21);
		//bt.insert(bt.root(), 19);
//		for(Node e : bt.inOrder(bt.root(), false)) {
//			System.out.print(e.getElemento() + " ");
//		}
		//System.out.println(bt.mostrarArvore());
		System.out.println(bt.mostraArvore());
		System.out.println("altura: "+ bt.height(bt.root()));
	}

}
