public class ArrayGraph {

    // a graph can be represented by adjacency matrix , which is mostly a 2 by 2 matrix
    int[][] adj;
    private int vertices;
    private int edges;
    // creating a new graph with a given number of nodes/vertex (which will initialise them to 0)
    ArrayGraph(int nodes){
        this.adj = new int[nodes][nodes];
        this.vertices = nodes;
        this.edges = 0;
    }


    public void addEdge(int node1, int node2){
        this.adj[node1][node2] = 1;
        this.adj[node2][node1] = 1;   // because this is an undirected graph, adding an edge will require both ways
        edges++;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(vertices + " vertices " + edges + " edges " + "\n");
        for (int v =0; v< vertices;v++){
            sb.append(v+ ": ");
                for(int w: adj[v]){
                    sb.append(w + " ");
                }

            sb.append("\n");
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        ArrayGraph g = new ArrayGraph(8);
        g.addEdge(0,0);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,0);
        System.out.println(g);
    }
}




