public class ShoppingItem {
    String brand;
    String item;
    double size;
    double price;

    public ShoppingItem(String brand, String item, double size, double price){
        this.brand = brand;
        this.item = item;
        this.size = size;
        this.price = price;
    }

    public void printShoppingItem(){
        System.out.println("Brand name: " + this.brand);
        System.out.println("Item name: " + this.item);
        System.out.println("Size: " + this.size +" oz");
        System.out.println("Price: $" + this.price);
    }
}