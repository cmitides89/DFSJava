import java.util.LinkedList;
public class Graph{
    
    //initial size of the array
    int V;
    //a graph consists of an array adj
    //which is a list of lists
    LinkedList<Vertex>[] adjList;

    Graph(int V){
        this.V = V;

        adjList = new LinkedList[V];
        //create an empty LL as every  
        //element in the array
        for(int i = 0; i < V; i++){
            adjList[i] = new LinkedList<>();
        }
    }

    // static void addEdge(Graph graph, int src, Vertex dest){
    //     graph.adjListArray[src].add(dest);
    // }
    public void addEdge(int src, Vertex dest){
        this.adjList[src].add(dest);
    }

    public void printGraph(){
        for(int v = 0; v < this.V; v++){
            System.out.println("Adjacency list of vertex " + v);
            System.out.print("head");
            for(Vertex vert : this.adjList[v]){
                System.out.print(" -> "+vert.vertexNo+ " COLOR:"+ vert.color+"  ");    
            }
            // System.out.println("\n");
        }
    }
}