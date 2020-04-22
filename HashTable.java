public class HashTable {
    LinkedList[] data; /* array of the LinkedList of the values */
    int listLength;

    public HashTable(){
        listLength = 10;
        data = new LinkedList[listLength];
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

        return sum;
    }

    /**
     * Inserts a key into the hash table.
     * @param key
     * @param value
     * @return
     */
    boolean put(String key, ShoppingItem value){
        int index = getHashCode(key);
        /* check the LinkedList for collisions */
        LinkedList list = data[index];
        list.add(key, value);
        return false;
    }

    ShoppingItem getItem(String key){
        int index = getHashCode(key);
        LinkedList list = data[index];
        ShoppingItem item = list.get(key);
        return item;
    }
}
