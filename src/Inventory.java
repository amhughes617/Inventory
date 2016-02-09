import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by alexanderhughes on 2/8/16.
 */
public class Inventory {

    public static HashMap<String, Account> accounts = new HashMap<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Account alice = new Account("Alice", "pass1");
        Account bob = new Account("Bob", "pass2");
        Account charlie = new Account("Charlie", "pass3");
        accounts.put(alice.name, alice);
        accounts.put(bob.name, bob);
        accounts.put(charlie.name, charlie);

        while (true) {

            System.out.print("Please enter user name: ");
            String userName = scanner.nextLine();
            System.out.print("Please enter password: ");
            String userPass = scanner.nextLine();
            if (accounts.containsKey(userName) && accounts.get(userName).password.equals(userPass)) {
                System.out.printf("Welcome %s\n", userName);

                while (true) {

                    int i = 1;
                    for (InventoryItem item : accounts.get(userName).items) {
                        System.out.printf("%d. %s: [%s] %s\n\n", i, item.category, item.quantity, item.name);
                        i++;
                    }
                    System.out.println("1. Add new item");
                    System.out.println("2. Remove item");
                    System.out.println("3. Update item quantity");
                    System.out.println("4. Logout");

                    String option = scanner.nextLine();

                    if (option.equals("1")) {
                        System.out.print("Enter new item: ");
                        String name = scanner.nextLine();
                        System.out.printf("Enter the quantity of %ss: ", name);
                        String quantity = scanner.nextLine();
                        accounts.get(userName).items.add(Inventory.createItem(name, quantity));
                    } else if (option.equals("2")) {
                        System.out.print("Enter the index number of the item you want to remove: ");
                        int itemNum = Integer.valueOf(scanner.nextLine());
                        accounts.get(userName).items.remove(itemNum - 1);
                    } else if (option.equals("3")) {
                        System.out.print("Enter the index number of the item you would like to update: ");
                        int itemNum = Integer.valueOf(scanner.nextLine());
                        InventoryItem itemChoice = accounts.get(userName).items.get(itemNum - 1);
                        System.out.printf("How much would you like to add to %s: ", itemChoice);
                        itemChoice.quantity = scanner.nextLine();
                    } else if (option.equals("4")) {
                        System.out.printf("Goodbye %s\n", userName);
                        break;
                    } else {
                        System.out.println("Invalid Response!!!");
                    }
                }
            } else {
                System.out.println("Invalid user name/password");
            }
        }
    }
    static InventoryItem createItem(String name, String quantity) {
        System.out.printf("Enter %s's category [Fruit/Meat/Animal/Cereal/Hat]: ", name);
        String category = scanner.nextLine();
        if (category.equalsIgnoreCase("Fruit")) {
            return new Fruit(name, quantity);
        }
        else if (category.equalsIgnoreCase("Meat")) {
            return new Meat(name, quantity);
        }
        else if (category.equalsIgnoreCase("Animal")) {
            return new Animal(name, quantity);
        }
        else if (category.equalsIgnoreCase("Cereal")) {
            return new Cereal(name, quantity);
        }
        else if (category.equalsIgnoreCase("Hat")) {
            return new Hat(name, quantity);
        }
        else {
            System.out.println("Invalid Category!!!");
            return createItem(name, quantity);
        }

    }
}
