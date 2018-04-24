
/*************************************************************************
 *
 *  Pace University
 *
 *  Course: CS 608 Algorithms and Computing Theory
 *  Author: Constantin Mitides
 *  Collaborators: PUT YOUR COLLABORATORS HERE, IF NONE, PUT NONE
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
 *   -------
 *
 *   PUT ALL NON-CODING ANSWERS HERE
 *
 *
 *************************************************************************/
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Random;

public class Assignment6{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter a number of nodes ");
        int totalNodes = scan.nextInt();
        System.out.println("and a number of edges");
        int totalEdges = scan.nextInt(); 
        scan.close();

        LinkedList<Integer>[] myAdjacencyList = adjacencyList(totalNodes, totalEdges);
        printingFunction(myAdjacencyList);
       
        //measure DFS run times
    }
    //create an adjaceny list choosing the edges at random (keep in mind this is a directed graph)
    //Adjacency List: an array of linked lists, size of the array is equal to number of vertices. 
    //Let the array be array[] An entry array[i] represents the linked list of vertices adjacent to the ith
    //vertex
    public static LinkedList<Integer>[] adjacencyList(int totalNodes, int totalEdges){
        Random random = new Random();
        //number of nodes is how long the array will be
        LinkedList<Integer>[] adjList = new LinkedList[totalNodes];
        //populate the array with new linkedlists
        for(int i = 0; i < totalNodes; i++){
            //this will represent the node's neighbors
            adjList[i] = new LinkedList<Integer>();
        }
        //for N edges, keep connecting nodes with eachother
        while(totalEdges != 0){
            int node = (random.nextInt(totalNodes + 1));
            int neighborNode = (random.nextInt(totalNodes + 1));
            // addEdge(adjList, node, neighborNode);
            adjList[node].add(neighborNode);
            totalEdges --;
        }
        
        // int randomNumberOfNeighbors = random.nextInt(totalEdges);
        // for(int i = 0; i < totalNodes; i++){
        //     if (totalEdges > 0) {
        //         for(int j = 0; j < randomNumberOfNeighbors; j++){
        //             adjList[i].add(random.nextInt(adjList.length));
        //         }
            
        //         totalEdges = totalEdges - 1;
        //         if(totalEdges != 0)
        //             randomNumberOfNeighbors = random.nextInt(totalEdges);
        //     }
        //     System.out.println("total edges is now: "+totalEdges);
            
        // }
        // for(int i = 0; i < totalNodes; i++){
        //     int node =( random.nextInt(totalNodes + 1));
        //     int neighborNode = (random.nextInt(totalNodes + 1));
        //     // addEdge(adjList, node, neighborNode);
        //     adjList[node].add(neighborNode);
        // }
        return adjList;
    }

    public static void addEdge(LinkedList<Integer>[] adjList, int node, int neighbor){
        if(node > adjList.length || neighbor > adjList.length){
            System.out.println("You cant have a node or a neighbor larger than the adjlist size!");
            return;
        }
        adjList[node].add(neighbor);
    }

    public static void printingFunction(LinkedList<Integer>[] myAdjacencyList){
       for(int i = 0; i < myAdjacencyList.length; i++){
           System.out.println("Adjacency List of vertex "+ i);
           System.out.print("head");
           for(int pCrawl: myAdjacencyList[i]){
               System.out.print(" ->" +pCrawl);
           }
           System.out.println("\n");
       }
    }


    //DFS 
    public void dfs(LinkedList<Integer>[] adjList){
        
    }

}