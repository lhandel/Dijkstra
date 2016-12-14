import java.util.Iterator;

/**
 * Created by ludwighandel on 2016-12-14.
 */
public class Edge implements Comparable<Edge> {
    public final int from;
    public final int to;
    public final double weight;

    public Edge() {
        this.from = 0;
        this.to = 0;
        this.weight = 0.0D;
    }

    public Edge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }



    public int compareTo(Edge that) {
        return this.weight < that.weight?-1:(this.weight > that.weight?1:0);
    }

    public String toString() {
        return "(" + this.from + " -> " + this.to + ", " + this.weight + ")";
    }
}
