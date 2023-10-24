import java.util.*;

public class MapGraph {

    //create a map with node as key and list of nodes as values
    Map<Integer, List<Integer>> graph;

    MapGraph(){
        this.graph = new HashMap<>();
    }

    public void buildGraph(int[][] edges) {
//        int size = edges.length;

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            // Adding node2 to the adjacency list of node1
            if (!this.graph.containsKey(node1)) {
                this.graph.put(node1, new ArrayList<>());
            }
            this.graph.get(node1).add(node2);

            // Adding node1 to the adjacency list of node2
            if (!this.graph.containsKey(node2)) {
                this.graph.put(node2, new ArrayList<>());
            }
            this.graph.get(node2).add(node1);
        }
    }

    public void bfs(int root){
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);

        // in case the root does not exist in the graph
        if (!this.graph.containsKey(root)) return;

        while(!queue.isEmpty()){
            int current = queue.poll();
            visited.add(current);
            System.out.print(current+ " -> ");

            for(int neighbour : this.graph.get(current)){
                if(!visited.contains(neighbour)){
                    visited.add(neighbour);
                    queue.offer(neighbour);
                }
            }
        }

        System.out.println(" \n");
    }

    public void dfs(int root){
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        stack.push(root);

        // in case the root does not exist in the graph
        if (!this.graph.containsKey(root)) return;

        while(!stack.empty()){
            int current = stack.pop();
            visited.add(root);
            System.out.print(current+ " -> ");
            for(int neighbour : this.graph.get(current)){

                if(!visited.contains(neighbour)){
                    visited.add(neighbour);
                    stack.push(neighbour);
                }
            }
        }
        System.out.println(" \n");

    }

    public int connectedComponentCount(){
        Set<Integer> keys = this.graph.keySet();
        Set<Integer> visited = new HashSet<>();
        int count = 0;

        for(int key: keys){

            if(!visited.contains(key)) count++;

            visited.add(key);
            List<Integer> neighbours = this.graph.get(key);
            for(int neighbour: neighbours){
                if(!visited.contains(neighbour)){
                    visited.add(neighbour);
                }
            }
        }
        return count;
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            int node = entry.getKey();
            List<Integer> edges = entry.getValue();
            result.append("Node ").append(node).append(" is connected to: ");
            result.append(edges.toString()).append("\n");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        MapGraph graph = new MapGraph();
        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 0},
                {2, 4},
                {5,20},
                {21,44}
        };
        graph.buildGraph(edges);
        graph.bfs(0);
        graph.dfs(0);

        System.out.println("Number of components within this graph is : " + graph.connectedComponentCount());
//        System.out.println(graph);
    }

}
