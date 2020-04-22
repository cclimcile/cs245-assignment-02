import java.util.*;
import java.io.*;

public class ShoppingList {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("-----------------------------");
        System.out.println("\tWelcome to ALaCarte");
        System.out.println("-----------------------------");

        ShoppingService[] services = new ShoppingService[3];
        /* read in the config.txt */
        System.out.println("Reading in config.txt...");
        File config_file = new File("config.txt");
        Scanner scanner = new Scanner(config_file);

        /* populate a ShoppingService array that holds basic information on each delivery service */
        int index = 0;
        while(scanner.hasNextLine()){
            String[] config = scanner.nextLine().split("=");
            String[] tokens = config[1].split(",");
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
                String[] csv = csv_scanner.nextLine().split(",");
                String key = csv[0];

                /* adjust variables to correct types */
                String[] size_str = csv[2].split("oz");
                double size = Double.parseDouble(size_str[0]);
                String price_str = csv[3].substring(1);
                double price = Double.parseDouble(price_str);

                System.out.println("Brand: " + key);
                System.out.println("Item: " + csv[1]);
                System.out.println("Size: " + size + " oz");
                System.out.println("Price: $" + price);
                System.out.println();

//                ShoppingItem new_item = new ShoppingItem(key, csv[1], size, price);
//                services[i].hashtable.put(key, new_item);
//                new_item.printShoppingItem();
            }
        }

        Scanner shoppingScanner = new Scanner(System.in);
        System.out.println("Let's start your shopping list.\n");
        String response = "";
        while(!response.equals("done")){
            System.out.println("Enter your item or 'done': ");
            response = shoppingScanner.next();
            String key = response;
            System.out.println("Size: ");
            double size = shoppingScanner.nextInt();

            /* search through all the services */
            services[0].total_price += services[0].searchPrice(key, size);
            services[1].total_price += services[1].searchPrice(key, size);
            services[2].total_price += services[2].searchPrice(key, size);
            System.out.println("Added to cart.\n");
        }

        /* add delivery fee */
        services[0].total_price += services[0].delivery_charge;
        services[1].total_price += services[1].delivery_charge;
        services[2].total_price += services[2].delivery_charge;

        ShoppingService bestService = services[0];
        double bestPrice = services[0].total_price;
        for( int j = 1; j < services.length; j++){
            if( services[j].total_price < bestPrice){
                bestService = services[j];
                bestPrice = services[j].total_price;
            }
        }

        System.out.println("Best price through " + bestService.service + ". Your total cost: $" + bestPrice);

    }
}


