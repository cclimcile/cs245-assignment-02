//import java.util.Iterator;
//import java.util.List;
//import java.util.NoSuchElementException;
//
//public class LinkedList<T> implements List<T> {
//
//    private int size;
//    private Node head;
//
//    public void add(T key, HashTable.ShoppingItem value) {
//    }
//
//    /* An inner class */
//    public class Node {
//        T data;
//        Node next;
//
//        /* Node Constructor */
//        Node(T new_data){
//            data = new_data;
//            next = null;
//        }
//    }
//
//    /* An inner class */
//    class LinkedListIterator implements Iterator<T>{
//        /* We know this node keeps track of which index we are at */
//        Node index;
//
//        public LinkedListIterator(){
//            index = head;
//        }
//
//        /* check if the node has next */
//        public boolean hasNext(){
//            /* list is empty or we are at the end of the list */
//            if(index != null){
//                return true;
//            } else {
//                return false;
//            }
//        }
//
//        /* returns what value of the next node is */
//        public T next(){
//            /* if the next Node does not exist */
//            if(!hasNext()){
//                throw new NoSuchElementException();
//            }
//            /* we are returning value at that index */
//            T value = index.data;
//            index = index.next;
//            return value;
//        }
//    }
//
//    public void add(T key, T value){
//        /* Node is at the start: new head*/
//        Node curr = new Node(item);
//        if(size == 0){
//            head = curr;
//            curr.next = null;
//        } else {
//            LinkedListIterator list = new LinkedListIterator();
//            for(int i = 0; i < size; i++){
//                list.next();
//            }
//            /* Slotting the new node at end */
//            list.index.next = curr;
//            curr.next = null;
//        }
//        ++size;
//
//    }
//
//    public void add(int pos, T item){
//        /* Node is at the start: new head*/
//        if(pos == 0){
//            Node curr = new Node(item);
//            curr.next = head;
//            head = curr;
//        } else {
//            Node prev = head;
//            for(int i = 0; i < pos - 1; i++){
//                prev = prev.next;
//            }
//            /* Slotting the new node in */
//            Node curr = new Node(item);
//            prev.next = curr;
//            curr.next = prev.next;
//        }
//        ++size;
//
//    }
//
//    public T get(int pos){
//        /* Error checking */
//        if(pos < 0) {
//            throw new IndexOutOfBoundsException();
//        }
//        /* Finds wanted node by looping through up till pos */
//        Node node = head;
//        for(int i = 0; i < pos; i++){
//            node = node.next;
//        }
//        return node.data;
//
//    }
//
//    public T remove(int pos){
//        /* Error checking */
//        if(pos < 0 || pos > size){
//            throw new IndexOutOfBoundsException();
//        }
//        Node curr;
//        /* It is the first node: becomes new head */
//        if(pos == 0){
//            curr = head;
//            head = head.next;
//        } else {
//            LinkedListIterator list = new LinkedListIterator();
//            for(int i = 0; i < pos; i++){
//                list.next();
//            }
//            /* Slotting the new node in */
//            curr = list.index;
//            curr.next = list.index.next.next;
//        }
//        --size;
//        return curr.data;
//
//    }
//
//    public int size(){
//        return size;
//    }
//
//}
