import java.util.*;
import java.io.*;

public class ShoppingList {

    public static void main(String[] args) throws FileNotFoundException {
        ShoppingService[] services = new ShoppingService[2];
        boolean done = false;

        System.out.println("-----------------------------");
        System.out.println("\tWelcome to ALaCarte");
        System.out.println("-----------------------------");

        /* read in the config.txt */
        File config_file = new File("config.txt");
        Scanner scanner = new Scanner(config_file);

        /* populate a ShoppingService array that holds basic information on each delivery service */
        int index = 0;
        while(scanner.hasNextLine()){
            String[] config = scanner.nextLine().split("=");
            String[] tokens = config[1].split(",");
            ShoppingService service = new ShoppingService(tokens[0], tokens[1], Double.parseDouble(tokens[2]));
            services[index] = service;
            index++;
        }

        /* assign HashTables to each ShoppingService & populate by reading in respective their csv file */
        for( int i = 0; i < services.length; i++ ){
            File csv_file = new File(services[i].csv_file);
            Scanner csv_scanner = new Scanner(csv_file);
            while(csv_scanner.hasNextLine()){
                String[] csv = csv_scanner.nextLine().split(",");
                String key = csv[0];

                /* adjust variables to correct types */
                String[] size_str = csv[2].split("oz");
                double size = Double.parseDouble(size_str[0]);
                String price_str = csv[3].substring(1);
                double price = Double.parseDouble(price_str);

                ShoppingItem new_item = new ShoppingItem(key, csv[1], size, price);
                services[i].hashtable.put(key, new_item);
            }
        }

        Scanner shoppingScanner = new Scanner(System.in);
        System.out.println("Let's start your shopping list.\n");
        while( !done ){
            System.out.println("Enter your item or 'done': ");
            String key = shoppingScanner.nextLine();

            if( key.equals("done") ){
                done = true;
            } else {
                System.out.println("Size: ");
                double size = shoppingScanner.nextDouble();

                /* search through all the services */
                System.out.println("Searching...");
                ShoppingItem item_0 = services[0].searchItem(key, size);
                if( item_0 != null ){
                    services[0].total_price += item_0.price;
                }
                ShoppingItem item_1 = services[1].searchItem(key, size);
                if( item_1 != null ) {
                    services[1].total_price += item_1.price;
                }
                // services[2].total_price += services[2].searchPrice(key, size);
                if( !(item_0 == null && item_1 == null )){
                    System.out.println("Added to cart.\n");
                }
            }
        }

        /* add delivery fee */
        services[0].total_price += services[0].delivery_charge;
        services[1].total_price += services[1].delivery_charge;
        //services[2].total_price += services[2].delivery_charge;

        ShoppingService bestService = services[0];
        double bestPrice = services[0].total_price;
        for( int j = 1; j < services.length; j++){
            if( services[j].total_price < bestPrice){
                bestService = services[j];
                bestPrice = services[j].total_price;
            }
        }

        System.out.println("");
        System.out.println("Best price through " + bestService.service + ". Your total cost: $" + bestPrice);

    }
}


