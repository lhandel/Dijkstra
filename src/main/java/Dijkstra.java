import  java.util.*;
/**
 * Created by ludwighandel on 15-12-09.
 */


public class Dijkstra {

    private Edge[] edgeTo;
    private double[] distTo;
    private MultiQueue mq;

    boolean useSimpelQueue = false;


    public Dijkstra(Graph G, int s, boolean useSimpelQueue) {
        this.useSimpelQueue = useSimpelQueue;
        findPath(G,s);
    }
    public Dijkstra(Graph G, int s) {
        findPath(G,s);
    }

    private void findPath(Graph G, int s){

        // Keeps track of the previous node
        edgeTo = new Edge[G.numberOfVertices()];


        distTo = new double[G.numberOfVertices()];
        if(useSimpelQueue){
            //System.out.println("Using SimpleQueue");
            mq = new MultiQueue(true);
        }else{
            //System.out.println("Using PriorityQueue");
            mq = new MultiQueue(G.numberOfVertices());
        }


        // Set all vertices to infinity
        for (int v = 0; v < G.numberOfVertices(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;

        // Distiance to startvertex = 0
        distTo[s] = 0.0;


        mq.add(new Node(s,0.0));



        while (!mq.isEmpty()){


            int v = mq.remove().node;

            // Loop throue all edges for the vertex V
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

                    mq.add(new Node(w, distTo[w]));
                }
            }

        }

    }
    public double distTo(int v)
    {
        return this.distTo[v];
    }

    public boolean hasPathTo(int v){
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<Edge> pathTo(int v){
        if(hasPathTo(v)) {
            Stack<Edge> path = new Stack<Edge>();
            for (Edge e = edgeTo[v]; e != null; e = edgeTo[e.from])
                path.push(e);

            return path;
        }
        return null;
    }

}
