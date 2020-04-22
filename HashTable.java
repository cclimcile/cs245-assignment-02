//public class HashTable {
//    LinkedList<String>[] data; /* array of the LinkedList of the values */
//    int listLength;
//
//    public HashTable(){
//        listLength = 10;
//        data = new LinkedList[listLength];
//    }
//
//    int getHashCode(String key){
//        /* calculate sum of ascii values */
//        int len = key.length();
//        int sum = 0;
//        for( int i = 0; i < len; i++ ){
//            sum += key.charAt(i);
//        }
//        /* calculate hashCode */
//        int hashCode = sum % listLength;
//
//        return sum;
//    }
//
//    boolean put(String key, ShoppingItem value){
//        int index = getHashCode(key);
//        /* check the LinkedList for collisions */
//        LinkedList<String> list = data[index];
//        list.add(key, value);
//        return false;
//    }
//}
