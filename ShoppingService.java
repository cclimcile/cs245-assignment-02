public class ShoppingService {

    String service, csv_file;
    double delivery_charge, total_price;
    HashTable hashtable;
    boolean hasItem, isEliminated;

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
        this.total_price = 0.0;
        this.hasItem = true;
        this.isEliminated = false;
    }

    ShoppingItem searchItem(String key, double size) throws NullPointerException{
        ShoppingItem item = this.hashtable.getItem(key, size);
        if( item == null || item.size / size != 1 ){
            return null;
        }
//        System.out.println(item.brand_item);
//        System.out.println(item.size);
//        System.out.println();
        return item;
    }

}
