package graphen;

public class Graph {
	
	private int e;
	private boolean[][] adj;
	
	public Graph(int e) {
		this.e = e;
		adj = new boolean[e][e];
	}
	
	public void insertKante(int i, int k) {
		if (adj[i][k] && adj[k][i])
			System.out.println("Kante existiert bereits.");
		else {
			adj[i][k] = true;
			adj[k][i] = true;
		}
	}
	
	public void deleteKante(int i, int k) {
		if (! adj[i][k] || adj[k][i])
			System.out.println("Kante existiert nicht.");
		else {
			adj[i][k] = false;
			adj[k][i] = false;
		}
	}
	
	public boolean[][] getAdj(){
		return adj;
	}
	
	public void adjOut() {
		System.out.print("\t");
		for (int j = 0; j < e; j++) {
			System.out.print(j + "\t");
		}
		System.out.println();
		for (int i = 0; i < e; i++) {			
			System.out.print(i + "\t");
			for (int k = 0; k < e; k++) {
				System.out.print(adj[i][k]+"\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.insertKante(0, 1);
		g.insertKante(1, 2);
		g.insertKante(2, 0);
		g.adjOut();
	}

}
