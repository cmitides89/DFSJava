public class Vertex{
    int timeDiscovered;
    int timeFinished;
    Vertex predecessor;
    String color;
    int vertexNo;

    Vertex(){
        // this.vertexNo = vertexNo;
        this.predecessor = null;
        this.color = "WHITE";
    }

}