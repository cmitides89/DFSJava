
/*************************************************************************
 *
 *  Pace University
 *
 *  Course: CS 608 Algorithms and Computing Theory
 *  Author: Constantin Mitides
 *  Collaborators: NONE
 *  References: PUT THE LINKS TO YOUR SOURCES HERE
 *
 *  Assignment: Write a program that, given the adjacency list of a directed graph, computes DFS efficiently.
 *  Problem: PUT THE MAIN PROBLEM NAME HERE
 *  Description: PUT A BRIEF DESCRIPTION HERE
 *
 *  Input: 
 *  Output: 
 *
 *  Visible data fields:
 *  COPY DECLARATION OF VISIBLE DATA FIELDS HERE
 *
 *  Visible methods:
 *  COPY SIGNATURE OF VISIBLE METHODS HERE
 *
 *
 *   Remarks
 *-------------------------------------------------------
 *       V     |      E = v -1       | Nanoseconds      |
 * ------------------------------------------------------/
 *       10    |      9              |    9,769,779       |
 * ------------------------------------------------------/
 *       25    |      24             |  241,448,077       |
 * ------------------------------------------------------/
 *       70    |      69             |  691,150,875       |
 * ------------------------------------------------------/
 *       100   |     99              |   99,729,616       |
 * ------------------------------------------------------/
 *       V     |      E = v - 1^1.5  | Nanoseconds      |
 * ------------------------------------------------------/
 *       10    |     27              |    9,508,278       |
 * ------------------------------------------------------/
 *       25    |    117              |   24,629,211    |
 * ------------------------------------------------------/
 *       70    |    573              |  691,492,256       |
 * ------------------------------------------------------/
 *       100    |   9801               | overflow        |
 * ------------------------------------------------------/
 *       V     |      E = v - 1 ^ 2   | Nanoseconds     |
 * ------------------------------------------------------/
 *      10     |   81                 |   9,542,639      |
 * ------------------------------------------------------/
 *      25     |   576                |  244,003,297     |
 * ------------------------------------------------------/
 *      70     |   4761               |6,932,208,891      |
 * ------------------------------------------------------/
 *      100    |   9801               | overflow        |
 * ------------------------------------------------------/
 * The expected run time for this algorithm was to run at O(V + E)
 * The Time displayed below increases in a linear fashion which I think is close to O(V + E) since they are both
 * Inputs that increase it makes sense that the time would increase as the inputs do it is difficult to tell for sure without plotting 
 * the numbers in a graph which would be 3 dimensional as opposed to the 2 dimensional visualization we are use to seeing.
 * This is due to the fact that we have two growing inputs as opposed to the one n input we typically use.
 *************************************************/

import java.util.Scanner;
import java.util.Random;
import java.util.LinkedList;

public class RunDFS{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        System.out.println("enter a number of nodes ");
        int totalNodes = scan.nextInt();
        System.out.println("and a number of edges");
        int totalEdges = scan.nextInt();
        scan.close();

        Graph myGraph = new Graph(totalNodes);
        //populate the graph's edges randomly
        // for(int i = 0; i < totalEdges; i++){
        //     // Vertex node = new Vertex().vertexNo = i;
        //     // int indexOfAdjList = random.nextInt(totalNodes + 1);
        //     int indexOfAdjList = random.nextInt(totalNodes + 1);
        //     Vertex neighborNode = new Vertex();
        //     neighborNode.vertexNo = random.nextInt(totalNodes);
        //     myGraph.addEdge(indexOfAdjList, neighborNode);
        // }
        
//=======================================GENERATING RANDOM NUMBERS===============================
        // int randomNumberOfNeighbors = random.nextInt(totalEdges);
        // for(int i = 0; i < totalNodes; i++){
        //     if(totalEdges > 0){
        //         for(int j = 0; j < randomNumberOfNeighbors; j++){
        //             Vertex neighborNode = new Vertex();
        //             neighborNode.vertexNo = random.nextInt(totalNodes);
        //             myGraph.addEdge(i, neighborNode);
        //         }
        //         totalEdges = totalEdges - 1;
        //         if(totalEdges != 0)
        //             randomNumberOfNeighbors = random.nextInt(totalEdges);
        //     }
        // }
        //TODO: CHANGE THE INTS TO VERTEX OBJECT
        while(totalEdges > 0){
            int i = (int) Math.floor(totalNodes*Math.random());
            int j = (int) Math.floor(totalNodes*Math.random());
            Vertex randomVertex = new Vertex();
            randomVertex.vertexNo = j;
            //Change this to: if i contains a vertex with name of j
            if(myGraph.adjList[i].contains(randomVertex.vertexNo) == false){
                myGraph.addEdge(i,randomVertex);
                totalEdges -- ;
            }
        }
        int runtime1 = totalNodes - 1;
        long startTime = System.nanoTime();
        dfs(myGraph);
        
        // int runtime2 = (Math.pow(totalNodes, (3/2)) - 1);
        // int runtime3 =  (Math.pow((totalNodes - 1), 2));
        System.out.println("DFS of "+ runtime1 + (System.nanoTime() - startTime) + " Nanoseconds");

        // myGraph.printGraph();
   
    }
    static int time = 0;
    public static void dfs(Graph myGraph){
        time = 0;
        for (LinkedList<Vertex> vertices : myGraph.adjList) {
            for(int i = 0; i < vertices.size(); i++){
                if (vertices.get(i).color == "WHITE"){
                    dfsVisit(myGraph, vertices.get(i));
                }
            }
        }
    }
    public static void dfsVisit(Graph myGraph, Vertex u){
        time = time + 1;
        u.timeDiscovered = time;
        u.color = "GRAY";
        for (Vertex v : myGraph.adjList[u.vertexNo]) {
            if (v.color == "WHITE"){
                v.predecessor = u;
                dfsVisit(myGraph, v);
            }
        }
        u.color = "BLACK";
        time = time + 1;
        u.timeFinished = time;
    }

}