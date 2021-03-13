package grafo;

import java.util.ArrayList;
import java.util.List;

public class CaminhoMinimo {
	
	List<Vertice> vertices;
	List<Integer> peso;
	List<Vertice> antecessor;
	
	public CaminhoMinimo() {
		vertices = new ArrayList<Vertice>();
		peso = new ArrayList<Integer>();
		antecessor = new ArrayList<Vertice>();
	}

}
