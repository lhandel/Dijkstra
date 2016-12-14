import java.util.PriorityQueue;

/**
 * Created by ludwighandel on 2016-12-14.
 */
public class MultiQueue {

    private SimpleQueue sq;
    private PriorityQueue<Node> pq;

    public boolean useSimple = false;

    public MultiQueue(boolean useSimple) {
        this.useSimple = useSimple;
        sq = new SimpleQueue();
    }

    public MultiQueue(int numberOfVertices) {
        pq = new PriorityQueue<Node>(numberOfVertices, new Node());
    }

    public void add(Node n) {
        if (useSimple) {
            sq.add(n);
        } else {
            pq.add(n);
        }
    }

    public Node remove() {

        Node n;
        if (useSimple) {
            n = sq.remove();
        } else {
            n = pq.remove();
        }
        return n;
    }

    public boolean isEmpty() {
        boolean n = false;
        if (useSimple) {
            n = sq.isEmpty();
        } else {
            n = pq.isEmpty();
        }
        return n;
    }
}