public class Vertex{
    int timeDiscovered;
    int timeFinished;
    Vertex predecessor;
    String color;
    int vertexNo;

    Vertex(int vertexNo){
        this.vertexNo = vertexNo;
        this.predecessor = null;
        this.color = "WHITE";
    }

}