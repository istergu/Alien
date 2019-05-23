package alien;
import java.util.LinkedList;

public class WeightedGraph {
    static class Edge {
        int source;
        int destination;
        int time;
        float distance;
        Location location; 

        public Edge(int source, int destination, int time, float distance, Location location) {
            this.source = source;
            this.destination = destination;
            this.time = time;
            this.distance = distance;
            this.location = location;
        }
    }

    static class Graph {
        int vertices;
        LinkedList<Edge>  adjacencylist[];

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];
            //initialize adjacency lists for all the vertices
            for (int i = 0; i <vertices ; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }

        public void addEgde(int source, int destination, int time, float distance, Location loc) {
            Edge edge = new Edge(source, destination, time, distance, loc);
            adjacencylist[source].addFirst(edge); //for directed graph
        }

        public void printGraph(){
            int temp;
            for (int i = 0; i <vertices ; i++) {
                LinkedList<Edge> list = adjacencylist[i];
                for (int j = 0; j <list.size() ; j++) {
                    temp = list.get(j).destination;
                    System.out.println("vertex-" + i + " Location name: " + list.get(j).location.getName() + " is connected to " +
                             adjacencylist[temp].get(0).location.getName() + " with time (in minutes) " +  list.get(j).time + " and distance (in kilometers)" + list.get(j).distance);
                }
            }
        }
    }
      /*public static void main(String[] args) {
            
        }*/
}

