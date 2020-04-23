public class ShoppingService {

    String service;
    String csv_file;
    double delivery_charge;
    HashTable hashtable;
    double total_price;

    public ShoppingService(String service, String csv_file, double delivery_charge){
        this.service = service;
        this. csv_file = csv_file;
        this.delivery_charge = delivery_charge;
        this.hashtable = new HashTable();
        this.total_price = 0;
    }

    public void printShoppingService(){
        System.out.println("Service: " + this.service);
        System.out.println("csv_file: " + this.csv_file);
        System.out.println("delivery charge: $" + this.delivery_charge + "\n");
    }

    ShoppingItem searchItem(String key, double size){

        ShoppingItem item = this.hashtable.getItem(key);
        if( item == null){
            System.out.println("No such item.");
            return null;
        }
        if( item.size % size != 0 ){
            System.out.println("No such size.");
            return null;
        }
        return item;
    }

}
