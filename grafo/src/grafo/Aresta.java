package grafo;

public class Aresta {
	
	private Vertice origem;
	private Vertice destino;
	private int peso;
	
	public Aresta(Vertice origem, Vertice destino, int peso) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.peso = peso;
	}
	
	public Vertice getDestino() {
		return destino;
	}
	
	public Vertice getOrigem() {
		return origem;
	}
	
	public int getPeso() {
		return peso;
	}

	@Override
	public String toString() {
		return "Aresta [origem=" + origem.getId() + ", destino=" + destino.getId() + ", peso=" + peso + "]";
	}
	
	

}


