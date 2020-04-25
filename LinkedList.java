import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class  LinkedList {

    private int size;
    private Node head;

    public class Node {
        String[] keys;
        ShoppingItem item;
        Node next;

        /**
         * Node constructor.
         * @param new_keys
         * @param new_item
         */
        Node(String[] new_keys, ShoppingItem new_item){
            keys = new_keys;
            item = new_item;
            next = null;
        }
    }

    /**
     * Sequentially adds node to end of the LinkedList.
     * @param keys
     * @param item
     */
    public void add(String[] keys, ShoppingItem item){
        /* Node is at the start: new head*/
        if(head == null){
            Node curr = new Node(keys, item);
            head = curr;
        } else {
            Node prev = head;
            for(int i = 0; i < size - 1; i++){
                prev = prev.next;
            }
            Node curr = new Node(keys, item);
            prev.next = curr;
        }
        ++size;
    }

    /**
     * Finds the ShoppingItem given a specific key from the user.
     * @param key
     * @return ShoppingItem
     */
    public ShoppingItem get(String key){
        /* Finds wanted node by looping through up till end */
        Node node = head;
        while(node != null){
            /* if the key is either the brand name or brand + item name, the item exists */
            if(node.keys[0].equals(key) || node.keys[1].equals(key) ){
                return node.item;
            }
            node = node.next;
        }
        /* requested item doesn't not exist */
        return null;
    }

}
