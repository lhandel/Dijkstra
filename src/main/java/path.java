/**
 * Created by ludwighandel on 2016-12-14.
 *  TODO :
 * Testa med andra grapfer
 */
public class path {

    public static void main(String[] args) {


        String file = "/Users/ludwighandel/IdeaProjects/Dijkstra/src/main/resources/graph.txt";
        Graph g = new Graph(file);
        System.out.println("Nodes:"+g.numberOfVertices());
        System.out.println("Edges:"+g.numberOfEdges);

        int runs = 200;
        long totalTime=0;
        long totalTime2=0;
        for(int b = 0;b<5;b++){




            for(int i = 0; i<runs;i++) {
                Timer t1 = new Timer();
                Dijkstra dij = new Dijkstra(g, 0, true);
                totalTime = totalTime + t1.stop();
            }




            for(int i2 = 0; i2<runs;i2++) {
                Timer t2 = new Timer();
                Dijkstra dij2 = new Dijkstra(g, 0, false);
                totalTime2 = totalTime2 + t2.stop();
            }
        }
        System.out.println("Using SimpleQueue");
        System.out.println(totalTime/(runs*5));
        System.out.println("Using PriorityQueue");
        System.out.println(totalTime2/(runs*5));
        /*
        Dijkstra dij3 = new Dijkstra(g, 0, false);
        System.out.println(dij3.distTo(4));
        System.out.println(dij3.pathTo(4));

        */

    }

}
