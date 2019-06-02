package alien;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import javafx.util.Pair;

public class Dijkstra {

    WeightedGraph.Graph weight;

    public Dijkstra(WeightedGraph.Graph weight) {
        this.weight = weight;
    }
    
    public void dijkstra_GetMinDistances(int sourceVertex, int vertices){
        int[] parent= new int[vertices];
        boolean[] SPT = new boolean[vertices];
        int[] distance = new int[vertices];
        
        for (int i = 0; i < vertices; i++) {
            parent[i] = -1;
            distance[i] = Integer.MAX_VALUE;
        }
            PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(vertices, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                int key1 = p1.getKey();
                int key2 = p2.getKey();
                return key1 - key2;
            }
        });
        distance[sourceVertex] = 0;
        Pair<Integer, Integer> p0 = new Pair<>(distance[sourceVertex], sourceVertex);
        pq.offer(p0);
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> extractedPair = pq.poll();
            int extractedVertex = extractedPair.getValue();
            if (SPT[extractedVertex] == false) {
                SPT[extractedVertex] = true;
                LinkedList<WeightedGraph.Edge> list = weight.adjacencylist[extractedVertex];
                for (int i = 0; i < list.size(); i++) {
                    WeightedGraph.Edge edge = list.get(i);
                    int destination = edge.destination;
                    
                    if (SPT[destination] == false) {
                        int newKey = distance[extractedVertex] + edge.distance;
                        int currentKey = distance[destination];
                        
                        if (currentKey > newKey) {
                            parent[destination]  = extractedVertex;
                            Pair<Integer, Integer> p = new Pair<>(newKey, destination);
                            pq.offer(p);
                            distance[destination] = newKey;
                        }
                    }
                }
            }
        }
        printDijkstra(distance, sourceVertex, vertices, parent);
    }
    
    public void printDijkstra(int[] distance, int sourceVertex, int vertices, int parent[]){
            System.out.println("Dijkstra Algorithm: (Adjacency List + Priority Queue)");
            for (int i = 0; i <vertices ; i++) {
                System.out.print("Source Vertex: " + sourceVertex + " to vertex " +   + i +
                        " distance: " + distance[i]);
                System.out.print(" path: " + sourceVertex + " ");
                printPath(i, parent);
                System.out.println("");
                
            }
    }
    
    private static void printPath (int j,int[] parents) 
    { 
        if (parents[j] == -1) 
        { 
            return; 
        } 
        printPath(parents[j], parents);
        System.out.print(j + " ");
    }
    
}
