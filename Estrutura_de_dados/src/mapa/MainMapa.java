package mapa;

public class MainMapa {

	public static void main(String[] args) {
	
		MapaEncadeamento map = new MapaEncadeamento(2);
		
		map.insert(0, 99);
		map.insert(1, 77);
		map.insert(2, 33);
		System.out.println(map.find(2).getValor());
		System.out.println("qtd: "+ map.size());
		map.remove(0);
		System.out.println(map.find(2).getValor());
		System.out.println("qtd: "+ map.size());
	}

}
