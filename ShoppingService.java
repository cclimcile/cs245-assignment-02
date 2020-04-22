public class ShoppingService {

    String service;
    String csv_file;
    double delivery_charge;
    HashTable hashtable;

    public ShoppingService(String service, String csv_file, double delivery_charge){
        this.service = service;
        this. csv_file = csv_file;
        this.delivery_charge = delivery_charge;
        this.hashtable = new HashTable();
    }

    public void printShoppingService(){
        System.out.println("Service: " + this.service);
        System.out.println("csv_file: " + this.csv_file);
        System.out.println("delivery charge: $" + this.delivery_charge + "\n");
    }

}
