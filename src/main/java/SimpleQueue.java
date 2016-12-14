
/**
 * Created by ludwighandel on 2016-12-14.
 */
public class SimpleQueue {

    private Node head;

    public SimpleQueue(){
        head = null;
    }

    public void add(Node x){
        x.next = head;
        head = x;
    }



    public Node remove() {

        try {
            Node min = head;
            Node temp = head;
            Node prev = null;

            while (temp != null) {
                if (temp.next != null && temp.next.cost < min.next.cost) {
                    min = temp.next;
                    prev = temp;
                }
                temp = temp.next;
            }

            if (min != head) {
                prev.next = min.next;
            } else {
                head = head.next;
            }

        return min;

        }catch (Exception e){

        }

        return null;
    }

    boolean isEmpty(){
        return (head == null);
    }



}
