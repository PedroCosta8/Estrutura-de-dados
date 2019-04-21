package arvore;

import java.util.ArrayList;

public class MainArvore {

	public static void main(String[] args) {
		
		Arvore tree = new Arvore(2);
		
		Node raiz = tree.root();
		
		tree.addChild(raiz, 99);
		tree.addChild(raiz, 88);
		ArrayList<Node> f = tree.children(raiz);
		tree.addChild(f.get(0), 11);
		tree.addChild(f.get(0), 22);
		tree.addChild(f.get(1), 77);
		ArrayList<Node> x = tree.children(f.get(1));
		tree.addChild(x.get(0), 66);
		//System.out.println(tree.depth(raiz));
		System.out.println(tree.mostraArvore(raiz));
		
	}

}
