public class HashTable {
    LinkedList[] hash; /* array of the LinkedList of the values */
    int listLength;

    public HashTable(){
        listLength = 10;
        hash = new LinkedList[listLength];
    }

    /**
     * Calculates the hashCode index of the hash table based on the key.
     * @param key
     * @return
     */
    int getHashCode(String key){
        /* calculate sum of ascii values */
        int len = key.length();
        int sum = 0;
        for( int i = 0; i < len; i++ ){
            sum += key.charAt(i);
        }
        /* calculate hashCode */
        int hashCode = sum % listLength;

        return hashCode;
    }

    /**
     * Inserts a key into the hash table.
     * @param key
     * @param value
     * @return
     */
    void put(String key, ShoppingItem value){ //return type initially bool
        int index = getHashCode(key);
        System.out.println("Index: " + index);
        /* check the LinkedList for collisions */
        if( hash[index] == null ){
            System.out.println("Adding new to hashtable ....");
            LinkedList list = new LinkedList();
            hash[index] = list;
            list.add(key, value);
        } else {
            System.out.println("Adding to hashtable ....");
            hash[index].add(key, value);
        }
    }

    ShoppingItem getItem(String key){
        int index = getHashCode(key);
        ShoppingItem item = hash[index].get(key);
        return item;
    }
}
