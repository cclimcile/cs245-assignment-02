import java.util.*;
import java.io.*;

public class ShoppingList {

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
        }
    }
}
