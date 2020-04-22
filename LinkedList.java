import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class LinkedList {

    private int size;
    private Node head;

    /* An inner class */
    public class Node {
        String key;
        ShoppingItem item;
        Node next;

        /* Node Constructor */
        Node(String new_key, ShoppingItem new_item){
            key = new_key;
            item = new_item;
            next = null;
        }
    }

    public void add(String key, ShoppingItem item){
        /* Node is at the start: new head*/
        if(head == null){
            Node curr = new Node(key, item);
            head = curr;
        } else {
            Node prev = head;
            for(int i = 0; i < size - 1; i++){
                prev = prev.next;
            }
            Node curr = new Node(key, item);
            prev.next = curr;
        }
        ++size;
    }

    public ShoppingItem get(String key){
        /* Finds wanted node by looping through up till end */
        Node node = head;
        while(node != null){
            if(node.key == key){
                return node.item;
            }
            node = node.next;
        }
        return null;
    }

}
