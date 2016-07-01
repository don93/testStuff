import java.util.HashMap;
import java.util.Scanner;

public class testclass {

    static HashMap<String, Integer> inventory = new HashMap<String, Integer>();

    public static void main(String[] args) {

        System.out.println("\nWelcome to Dianna's Dinosaur & Donut Emporium's inventory system! \n\n");
        System.out.println("Available commands are 'Add', 'List', 'Delete', 'Help', and 'Quit'\n\n\n");

        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        while (true) {
            collectInput();
        }

    }
//add some comment

    private static void collectInput () {
        System.out.println("Please input your command");

        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine().toLowerCase();

        userInput = userInput.split(" ")[0];

        if (userInput.substring(0, 3).equals("add")) {
            callAdd();
        }

        else if (userInput.substring(0, 4).equals("list")) {
            callList();
        }

        else if (userInput.equals("delete")) {
            callDelete();
        }

        else if (userInput.substring(0, 4).equals("help")){
            callHelp();
        }

        else if (userInput.equals("quit") || userInput.equals("exit")){
            System.exit(0);
        }

        else {
            System.out.println("I didn't understand that, could you try again?");
            collectInput();
        }
    }

    private static void callAdd() {
        System.out.println("What product would you like to add?");

        Scanner input = new Scanner(System.in);
        String newProduct = input.nextLine().toLowerCase();
        newProduct = capitalize(newProduct);

        System.out.println("How many would you like to add?");

        int productInt = addHowMany();

        addProduct(newProduct, productInt);
    }

    private static int addHowMany () {

        Scanner input = new Scanner(System.in);
        String productQuantity = input.nextLine().toLowerCase();

        int productInt = validateInt(productQuantity);

        if (productInt <= 0){
            System.out.println("I'm sorry, that doesn't appear to be a valid number.  Can you try again?");
            productInt = addHowMany();
        }

        return productInt;

    }

    private static int validateInt(String number) {

        int productInt;

        try {
            productInt = Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            System.out.println("I'm sorry, I didn't understand that");
            System.out.println("Could you please try again with Arabic numerals?");

            Scanner input = new Scanner(System.in);
            String userInput = input.nextLine().toLowerCase();

            productInt = validateInt(userInput);
            return productInt;
        }

        return(productInt);
    }

    private static void callList() {

//        listInventory();

        Object[] keys = inventory.keySet().toArray();

        if (inventory.size() == 0) {
            System.out.println("No items found");
        }

        for (int i = 0; i < inventory.size(); i++) {

            int j = i + 1;

            System.out.println(j + ". " + keys[i] + " --- " + inventory.get(keys[i]));

        }
    }

    private static void callDelete() {

        if (!isDeleteValid(1)) {
            System.out.println("There isn't anything here to delete yet.");

        } else {

            callList();

            System.out.println("Return: cancel deletion and return to menu.");
            System.out.println("Which item would you like to delete (please enter a number)?");

            Scanner input = new Scanner(System.in);
            String deleteIndex = input.nextLine().toLowerCase();
            deleteIndex = capitalize(deleteIndex);

            if (!deleteIndex.equals("Return")) {

                int productInt = validateInt(deleteIndex);

                if (isDeleteValid(productInt)) {

                    deleteAtIndex(productInt);

                } else {

                    System.out.println("That item number does not appear to be in the list.  Could you please try again?");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }

                    callDelete();

                }

            }
        }
    }

    private static void callHelp() {

        System.out.println("Available commands are as follows:");
        System.out.println("Add  : adds a product to inventory.  Will request product name and quantity.");
        System.out.println("List  : will list current inventory");
        System.out.println("Delete  : will print current inventory then request the index of the object to be deleted");

    }


    private static void addProduct(String object, int quantity) {

        int currentStock = quantity;

        if (inventory.containsKey(object)) {
            currentStock += inventory.get(object);
        }

        object = capitalize(object);

        inventory.put(object, currentStock);

        System.out.println("Product added to stock: " + object + ". Quantity added: " + quantity + ".  Current total: " + currentStock);
    }

    private static boolean isDeleteValid (int index) {
        if (index < 1 || index > inventory.size()) {
            return false;
        } else {
            return true;
        }
    }

    private static void deleteAtIndex (int index) {

        Object[] keys = inventory.keySet().toArray();

        inventory.remove(keys[index-1]);

        System.out.println(keys[index-1] + " removed from inventory");

    }

    private static String capitalize(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }

    }
