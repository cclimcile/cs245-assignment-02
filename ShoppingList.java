import java.util.*;
import java.io.*;

public class ShoppingList {

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
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("---- Welcome to ALaCarte! ----");
        ShoppingService[] services = new ShoppingService[2];
        /* read in the config.txt */
        File config_file = new File("config.txt");
        Scanner scanner = new Scanner(config_file);

        int index = 0;
        while(scanner.hasNextLine()){
            String csv = scanner.nextLine();
            String[] split = csv.split("=");
            String[] tokens = split[1].split(",");
            ShoppingService service = new ShoppingService(tokens[0], tokens[1], Double.parseDouble(tokens[2]));
            services[index] = service;
            for( String i : tokens) {
                System.out.println(i);
            }
        }
    }
}
