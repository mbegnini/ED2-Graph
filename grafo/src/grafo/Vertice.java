package grafo;

import java.util.ArrayList;
import java.util.List;

public class Vertice {

	private int id;
	private List<Aresta> arestas;
	
	public Vertice(int id) {
		this.id = id;
		this.arestas = new ArrayList<Aresta>();
	}
	
	public int getId() {
		return id;
	}

	public void addAresta(Aresta aresta) {
		arestas.add(aresta);
	}
	
	public List<Aresta> getArestas(){
		return arestas;
	}

	@Override
	public String toString() {
		return "Vertice [id=" + id + ", arestas=" + arestas + "]\n";
	}
	
}
