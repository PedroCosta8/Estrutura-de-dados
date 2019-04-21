package arvore;

import java.util.ArrayList;

public interface ArvoreInterface {

	public int size();
	public int height(Node no);
	public boolean isEmpty();
	public ArrayList<Object> elements();
	public ArrayList<Node> nos();
	public Node root();
	public Node parent(Node filho);
	public ArrayList<Node> children(Node pai);
	public boolean isInternal(Node no);
	public boolean isExternal(Node no);
	public boolean isRoot(Node no);
	public int depth(Node no);
	public Object replace(Node no, Object o);
	public void addChild(Node pai, Object o);
	public Object remove(Node no);
	
}
