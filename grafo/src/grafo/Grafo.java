package grafo;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	
	private List<Vertice> vertices;
	private List<Aresta> arestas;
	
	public Grafo() {
		vertices = new ArrayList<Vertice>();
		arestas = new ArrayList<Aresta>();
	}
	
	public List<Vertice> getVertices(){
		return vertices;
	}
	
	public Vertice getVertice(int pos) {
		return vertices.get(pos);
	}
	
	public void addVertice(Vertice vertice) {
		vertices.add(vertice);
	}
	

	
	public void addAresta(Vertice origem, Vertice destino, int peso) {
		Aresta aresta = new Aresta(origem, destino, peso);
		origem.addAresta(aresta);
		arestas.add(aresta);
	}
	
	public List<Vertice> busca_profundidade(Vertice atual, List<Vertice> visitados) {
		visitados.add(atual);
		for (Aresta aresta: atual.getArestas()) 
			if(!visitados.contains(aresta.getDestino()))
				visitados = busca_profundidade(aresta.getDestino(), visitados);	
		return visitados;
	}
	
	public List<Vertice> busca_largura(Vertice atual) {
		List<Vertice> visitados = new ArrayList<Vertice>();
		List<Vertice> proximos = new ArrayList<Vertice>();
		
		proximos.add(atual);
		while(!proximos.isEmpty()) {
			atual = proximos.remove(0);
			visitados.add(atual);
			for (Aresta aresta: atual.getArestas()) 
				if(!visitados.contains(aresta.getDestino()) && !proximos.contains(aresta.getDestino())) 
					proximos.add(aresta.getDestino());
		}
		return visitados;		
	}

	@Override
	public String toString() {
		return "Grafo [vertices=\n" + vertices + ", \narestas=" + arestas + "]";
	}
	
	
	
}
