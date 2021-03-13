package grafo;

import java.util.ArrayList;
import java.util.List;

public class Main {
		
	public static void main(String args[]) {
		Grafo g = new Grafo();
		for (int i=0; i<5; i++) {
			Vertice v = new Vertice(i);
			g.addVertice(v);
		}
		
		g.addAresta(g.getVertice(0), g.getVertice(1), 10);
		g.addAresta(g.getVertice(0), g.getVertice(3), 5);
		g.addAresta(g.getVertice(1), g.getVertice(3), 2);
		g.addAresta(g.getVertice(2), g.getVertice(1), 1);
		g.addAresta(g.getVertice(2), g.getVertice(4), 4);
		g.addAresta(g.getVertice(3), g.getVertice(2), 9);
		g.addAresta(g.getVertice(3), g.getVertice(1), 3);
		g.addAresta(g.getVertice(3), g.getVertice(4), 2);
		g.addAresta(g.getVertice(4), g.getVertice(0), 7);
		g.addAresta(g.getVertice(4), g.getVertice(2), 6);
		
		System.out.println(g.toString());
		
		System.out.println();
		System.out.println();
		/*
		List<Vertice> visitados = new ArrayList<Vertice>();
		visitados = g.busca_profundidade(g.getVertice(0), visitados);
		for (Vertice vertice : visitados) {
			System.out.print(vertice.getId()+"\t");
		}	
		
		System.out.println();
		System.out.println();
		
		visitados = new ArrayList<Vertice>();
		visitados = g.busca_largura(g.getVertice(0));
		for (Vertice vertice : visitados) {
			System.out.print(vertice.getId()+"\t");
		}	*/
		
		
		CaminhoMinimo cm = dijkstra(g, g.getVertice(2));
		
		for(int i=0; i<cm.vertices.size(); i++) {
			System.out.println("v="+cm.vertices.get(i).getId()+"\tp="+cm.peso.get(i)+"\ta="+cm.antecessor.get(i).getId());
		}
		
		
		
	}
	
	public static CaminhoMinimo dijkstra(Grafo g, Vertice v) {
		
		CaminhoMinimo fechados = new CaminhoMinimo();
		fechados.vertices.add(v);
		fechados.peso.add(0);
		fechados.antecessor.add(v);
		
		CaminhoMinimo abertos = new CaminhoMinimo();
		
		for(Vertice vertice : g.getVertices()) {
			if(!fechados.vertices.contains(vertice)) {
				abertos.vertices.add(vertice);
				abertos.antecessor.add(null);
				abertos.peso.add(-1);
			}
		}
		
		while(!abertos.vertices.isEmpty()) {
			for(int i=0; i<fechados.vertices.size(); i++) {
				Vertice vertice = fechados.vertices.get(i);
				for (Aresta aresta : vertice.getArestas()) {
					if(!fechados.vertices.contains(aresta.getDestino())) {
						int pos = abertos.vertices.indexOf(aresta.getDestino());
						if(abertos.peso.get(pos) > fechados.peso.get(i)+aresta.getPeso() || 
								abertos.peso.get(pos) == -1) {
							abertos.peso.set(pos, fechados.peso.get(i)+aresta.getPeso()); //trocar i por pos 
							abertos.antecessor.set(pos, aresta.getOrigem()); //trocar i por pos
						}
					}
				}
			}
			int pesoMinimo=-1; //setar como -1 e não como o valor da pos 0 porque pode não estar iniciado
			int posPesoMinimo=-1;
			int i;
			for(i=0; i<abertos.vertices.size(); i++) { //fazer o for do 0 e não do 1 já que não setou da pos 0
				if((abertos.peso.get(i) < pesoMinimo || pesoMinimo == -1) && abertos.peso.get(i)!=-1) { // condição peso minimo -1
					pesoMinimo = abertos.peso.get(i);
					posPesoMinimo = i;
				}
			}
			fechados.vertices.add(abertos.vertices.get(posPesoMinimo));
			fechados.peso.add(abertos.peso.get(posPesoMinimo));
			fechados.antecessor.add(abertos.antecessor.get(posPesoMinimo));
			
			abertos.vertices.remove(posPesoMinimo);
			abertos.peso.remove(posPesoMinimo);
			abertos.antecessor.remove(posPesoMinimo);
		}
		
		
		
		return fechados;
	}
	
	
	

}