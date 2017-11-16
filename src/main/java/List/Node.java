package List;

/**
 * Created by Administrator on 2015/3/24.
 */
public class Node {
    private Object value;
    private Node next;
    private int index;
    public Node(Object value){
        this.value = value;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public Node getNext() {
        return next;
    }

    public Object getValue() {
        return value;
    }
    public String toString(){
        return "Node[index="+index+", value"+value+"]";
    }
}
