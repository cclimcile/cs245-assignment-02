CS245-ASSIGNMENT-02

This program is a basic service that determines which grocery delivery services leads to the overall least cost for the client.

    Class ShoppingService
        This class stores information from a config.txt file. For each "service=..." line, a ShoppingService object is created 
        and stores data such as the service name, service csv file, service delivery fee, service hashtable, and service total
        price. A service hashtable is makes use of HashTables(), a data structure I have chosen to store all inventory items
        of a given grocery store. Service total is used to calculate the total price of a given shopping list based on the 
        prices of that store's items.

    Class ShoppingItem
        This class stores information from a csv file. For each "brand name,item name,size,price" line, a ShoppingItem object
        is created and stores data such as an item's brand, item's name, item's weight, item's price, and a variable called 
        brand_item. This variable concatenates an item's brand name and name together so as to add in the search of the item 
        in HashTable(). Since the user can search for an item through (1) brand name or (2) brand + item name, brand_item 
        keeps track of the latter.
        
    Class ShoppingList
        This class is the driver of the program. It stores information from a config file as well as from various csv files 
        and populates each service's hashtable accordingly. Through an interactive section, it asks users for a given item and 
        searches every service's inventory (hashtable) ti find the matching item. If the item is found, it is added to the 
        service's total_price. Once the user enters 'done', the program determines the cheapest grocery service based on    
        total_price += delivery_fee.
        
For this program, I chose to use a mixture of HashTables and LinkedLists. 

(1) HashTables
        I chose the data structure HashTable as I found it an effective way to store keys and ShoppingItems. The fastest way 
        to find any given vairable in an array is if we know the index of the item. For example, if I have an int[] arr = 
        {Amy, Lucy, Jill}, instead for parsing through all elements in the array to find 'Jill', I can use arr[2]. Thus, by           fixing items to have a given array, I cut my search time significantly. My HashTable, hash, is a LinkedList array as 
        LinkedLists allowed me to avoid collisions when a ShoppingItem from a specific service was added. Each node in the 
        LinkedList consisted of a String[] keys and a ShoppingItem item. This allowed both options of keys (brand name and 
        brand_item name) to be stored in keys, and the other information, such as the item's price and weight, to be stored.
        
        Class HashTable
        
        int getHashCode(String key);
           This function calculates an index for hash[].
        
        void put(String[] keys, ShoppingItem value);
            Given a index by getHashCode, it adds a Node to the LinkedList at hash[index]. This avoids collision.
        
        ShoppingItem getItem(String key);
            This parse key through findBrandName to retrieve the key's brand and uses brand to find an index. 
            
        String findBrandName(String key);
            As mentioned, the user can search via 2 options. Thus, we would search through brand name since both options 
            include brand name. Afterall, our node contains a String[] keys, so when we are searching, we could still check if 
            the key given by the user matches any of the item keys.
