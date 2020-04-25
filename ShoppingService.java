public class ShoppingService {

    String service;
    String csv_file;
    double delivery_charge;
    HashTable hashtable;
    double total_price;

    /**
     * ShoppingService constructor. This stores information on a given service by pulling
     * data from a given config.txt file.
     * @param service
     * @param csv_file
     * @param delivery_charge
     */
    public ShoppingService(String service, String csv_file, double delivery_charge){
        this.service = service;
        this. csv_file = csv_file;
        this.delivery_charge = delivery_charge;
        this.hashtable = new HashTable();
        this.total_price = 0; /* used when comparing which service is cheapest */
    }

    ShoppingItem searchItem(String key, double size) throws NullPointerException{
        ShoppingItem item = this.hashtable.getItem(key);
        if( item == null || item.size % size != 0 ){
            return null;
        }
        return item;
    }

}
