import java.util.*;
import java.io.*;

public class ShoppingList {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("---- Welcome to ALaCarte! ----\n");
        ShoppingService[] services = new ShoppingService[2];
        /* read in the config.txt */
        System.out.println("Reading in config.txt...");
        File config_file = new File("config.txt");
        Scanner scanner = new Scanner(config_file);

        /* populate a ShoppingService array that holds basic information on each delivery service */
        int index = 0;
        while(scanner.hasNextLine()){
            String config = scanner.nextLine();
            String[] split = config.split("=");
            String[] tokens = split[1].split(",");
            ShoppingService service = new ShoppingService(tokens[0], tokens[1], Double.parseDouble(tokens[2]));
            services[index] = service;
            service.printShoppingService();
            index++;
        }

        /* assign HashTables to each ShoppingService & populate by reading in respective their csv file */
        for( int i = 0; i < services.length; i++ ){
            System.out.println("Reading in " + services[i].csv_file);
            File csv_file = new File(services[i].csv_file);
            Scanner csv_scanner = new Scanner(csv_file);
            while(csv_scanner.hasNextLine()){
                String csv = scanner.nextLine();
                String[] tokens = csv.split(",");

                String key = tokens[0];
                ShoppingItem new_item = new ShoppingItem(key, tokens[1], Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
                services[i].hashtable.put(key, new_item);
                new_item.printShoppingItem();
            }
        }
    }
}
