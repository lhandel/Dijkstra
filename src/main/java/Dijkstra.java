

import java.util.Comparator;


import  java.util.*;


/**
 * Created by ludwighandel on 15-12-09.
 */


public class Dijkstra {
    private Edge[] edgeTo;
    private double[] distTo;
    private PriorityQueue<Node> pq;


    public Dijkstra(Graph G, int s, boolean useWeights) {
        findPath(G,s);
    }
    public Dijkstra(Graph G, int s) {
        findPath(G,s);
    }

    private void findPath(Graph G, int s){

        // Keeps track of the previous node
        edgeTo = new Edge[G.numberOfVertices()];


        distTo = new double[G.numberOfVertices()];
        pq = new PriorityQueue<Node>(G.numberOfVertices(),new Node());

        // Set all vertices to infinity
        for (int v = 0; v < G.numberOfVertices(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;

        // Distiance to startvertex = 0
        distTo[s] = 0.0;
        pq.add(new Node(s,0.0));



        while (!pq.isEmpty()){

            int v = pq.remove().node;

            // Loop throue all edges for the vertex V
            //for (Edge e : G.adj(v)){
            Iterator<Edge> it  = G.adj(v);
            while(it.hasNext()){
                Edge e = it.next();

                int w = e.to; // The next node

                // The weights to the node W
                double asWeight = e.weight;


                if (distTo[w] > distTo[v] + asWeight)
                {
                    distTo[w] = distTo[v] + asWeight;
                    edgeTo[w] = e;

                    pq.add(new Node(w, distTo[w]));
                }
            }

        }

    }
    public double distTo(int v)
    {
        return this.distTo[v];
    }


}
class Node implements Comparator<Node>{

    public int node;
    public double cost;
    public Node() {

    }

    public Node(int node, double cost)
    {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compare(Node node1, Node node2)
    {
        if (node1.cost < node2.cost)
            return -1;
        if (node1.cost > node2.cost)
            return 1;
        return 0;
    }
}