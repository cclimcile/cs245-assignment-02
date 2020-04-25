import java.util.*;
import java.io.*;

public class ShoppingList {

    public static void main(String[] args) throws FileNotFoundException, NumberFormatException, NullPointerException {
        /* to accommodate more services, simply adjust the ShoppingService[i]
         * where i refers to the number of services.
         */
        ShoppingService[] services = new ShoppingService[2];
        boolean done = false;

        System.out.println("-----------------------------");
        System.out.println("\tWelcome to ALaCarte");
        System.out.println("-----------------------------");

        /* reads in the config.txt */
        File config_file = new File("config.txt");
        Scanner scanner = new Scanner(config_file);

        /* POPULATING FROM CONFIG */
        /* populates ShoppingService[] that holds basic information on each delivery service */
        int index = 0;
        while(scanner.hasNextLine()){
            String[] config = scanner.nextLine().split("=");
            String[] tokens = config[1].split(",");
            ShoppingService service = new ShoppingService(tokens[0], tokens[1], Double.parseDouble(tokens[2]));
            services[index] = service;
            index++;
        }

        /* POPULATING FROM CSV */
        /* assign HashTables to each ShoppingService & populate by reading in respective their csv file */
        for( int i = 0; i < services.length; i++ ){
            File csv_file = new File(services[i].csv_file);
            Scanner csv_scanner = new Scanner(csv_file);
            while(csv_scanner.hasNextLine()){
                String[] csv = csv_scanner.nextLine().split(",");
                /* Add brand name */
                String brand = csv[0];
                /* Add item name */
                String item = csv[1];
                /* Add size */
                String[] size_str = csv[2].split("oz");
                double size = Double.parseDouble(size_str[0]);
                /* Add price */
                String price_str = csv[3].substring(1);
                double price = Double.parseDouble(price_str);
                /* Create new ShoppingItem */
                ShoppingItem new_item = new ShoppingItem(brand, item, size, price);

                /* Need to check which key to parse in hashtable.put().
                 * This is because a user can search via two options:
                 * (1) Brand name
                 * (2) Brand name + Item name
                 */
                String[] keys = new String[2];
                keys[0] = new_item.brand;
                keys[1] = new_item.brand_item;
                //System.out.println("Key 1: " + keys[0]);
                //System.out.println("Key 2: " + keys[1]);
                services[i].hashtable.put(keys, new_item);
                //System.out.println();
            }
        }


        System.out.println("Let's start your shopping list.\n");
        while( !done ){
            Scanner shoppingScanner = new Scanner(System.in);
            System.out.println("Enter your next item or 'done': ");
            String key = shoppingScanner.nextLine();

            if( key.equals("done") ){
                done = true;
            } else {
                System.out.println("Size: ");
                String[] str_size = shoppingScanner.nextLine().split(" ");
                double size;
                try {
                    size = Double.parseDouble(str_size[0]);
                } catch( NumberFormatException e ){
                    System.out.println("Invalid Size. Try Again.");
                    System.out.println("Size: ");
                    str_size = shoppingScanner.nextLine().split(" ");
                    size = Double.parseDouble(str_size[0]);
                }

                /* SEARCHING */
                ShoppingItem item_0 = services[0].searchItem(key, size);
                ShoppingItem item_1 = services[1].searchItem(key, size);
                /* to read in more services, just add the line:
                 * ShoppingItem item_i = services[i].searchItem(key, size);
                 * where i is the index of service in services[]
                 */

                if( item_0 != null && item_1 != null ){
                    System.out.println("Quantity: ");
                    int quantity = shoppingScanner.nextInt();
                    services[0].total_price += (quantity * item_0.price);
                    services[1].total_price += (quantity * item_1.price);
                    /* to read in more services, just add the line:
                     * services[i].total_price += (quantity * item_i.price);
                     * where i is the index of service in services[]
                     */
                } else {
                    System.out.println("No such item/ size.\n");
                }

                /* to read in more services, just replace the line:
                 * !(item_0 == null && item_1 == null ) with
                 * !(item_0 == null && item_1 == null && item_i == nulls )
                 * where i is the index of service in services[]
                 */
                if( !(item_0 == null && item_1 == null )){
                    System.out.println("Added to cart.\n");
                }
            }
        }

        /* CHECKING PRICES */

        /* check if there's an empty cart */
        boolean is_empty = false;
        for(int i = 0; i < services.length; i++){
            if( services[i].total_price == 0 ){
                is_empty = true;
                break;
            }
        }

        double bestPrice;
        ShoppingService bestService;
        if( is_empty ){
            System.out.println("\nYour cart was empty!");

        } else {
            /* add delivery fee */
            services[0].total_price += services[0].delivery_charge;
            services[1].total_price += services[1].delivery_charge;
            /* to read in more services, just add the line:
             * services[i].total_price += services[i].delivery_charge;
             * where i is the index of service in services[]
             */

            bestService = services[0];
            bestPrice = services[0].total_price;
            for( int j = 1; j < services.length; j++){
                if( services[j].total_price < bestPrice){
                    bestService = services[j];
                    bestPrice = services[j].total_price;
                }
            }
            System.out.println("");
            System.out.print("Best price through " + bestService.service + ". Your total cost: $");
            System.out.printf("%.2f\n", bestPrice);
        }

        System.out.println("-------------------------------");
        System.out.println("Thank you for shopping with us!");
        System.out.println("-------------------------------");

    }
}


