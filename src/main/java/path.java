
import java.util.Iterator;

/**
 * Created by ludwighandel on 2016-12-14.
 *  TODO :
 * Implementera simple queue
 * Testa med andra grapfer
 */
public class path {

    public static void main(String[] args) {


        String file = "/Users/ludwighandel/IdeaProjects/Dijkstra/src/main/resources/graph.txt";
        Graph g = new Graph(file);


        Dijkstra dij = new Dijkstra(g, 0,false);
        System.out.println("Shortest Path : "+dij.distTo(3)+" steps)");

    }

}
