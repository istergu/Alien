package alien;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class WeightedGraph {
    static class Edge implements Serializable{
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

        @Override
        public String toString() {
            return "Edge{" + "source=" + source + ", destination=" + destination + ", time=" + time + ", distance=" + distance + '}';
        }
        
        
    }

    static class Graph {
        int vertices;
        LinkedList<Edge>  adjacencylist[];

        Graph(int vert) {
            this.vertices = vert;
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
        
        public void addEgdes(ArrayList<Edge> edg) {
            for(Edge eg: edg){
                adjacencylist[eg.source].addFirst(eg); //for directed graph
            }
        }
    }
}

