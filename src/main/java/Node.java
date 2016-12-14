import java.util.Comparator;

public class Node implements Comparator<Node> {

    public int node;
    public double cost;
    public Node next;
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