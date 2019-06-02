package alien;
import java.util.LinkedList;

public class WeightedGraph {
    static class Edge {
        int source;
        int destination;
        int time;
        int distance;

        public Edge(int source, int destination, int time, int distance) {
            this.source = source;
            this.destination = destination;
            this.time = time;
            this.distance = distance;
        }
    }

    static class Graph {
        int vertices;
        Location_Timetravel local[];
        LinkedList<Edge>  adjacencylist[];

        Graph(Location_Timetravel local[]) {
            this.local = local;
            this.vertices = local.length;
            adjacencylist = new LinkedList[vertices];
            //initialize adjacency lists for all the vertices
            for (int i = 0; i <vertices ; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }

        public void addEgde(int source, int destination, int time, int distance) {
            Edge edge = new Edge(source, destination, time, distance);
            adjacencylist[source].addFirst(edge); //for directed graph
        }

        public void printGraph(){
            
        }
    }
      /*public static void main(String[] args) {
            
        }*/
}

