import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by alexanderhughes on 2/8/16.
 */
public class Inventory {

    public static ArrayList<InventoryItem> items = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {

            int i = 1;
            for (InventoryItem item : items) {
                System.out.printf("%d. %s: [%s] %s\n\n", i, item.category, item.quantity, item.name);
                i++;
            }
            System.out.println("1. Add new item.");
            System.out.println("2. Remove item.");
            System.out.println("3. Update item quantity");

            String option = scanner.nextLine();

            switch (option) {

                case "1":

                    System.out.print("Enter new item: ");
                    String name = scanner.nextLine();
                    System.out.printf("Enter the quantity of %ss: ", name);
                    String quantity = scanner.nextLine();
                    items.add(Inventory.createItem(name, quantity));
                    break;

                case "2":
                    System.out.print("Enter the index number of the item you want to remove: ");
                    int itemNum = Integer.valueOf(scanner.nextLine());
                    items.remove(itemNum - 1);
                    break;

                case "3":
                    System.out.print("Enter the index number of the item you would like to update: ");
                    itemNum = Integer.valueOf(scanner.nextLine());
                    InventoryItem itemChoice = items.get(itemNum - 1);
                    System.out.printf("How much would you like to add to %s: ", itemChoice);
                    itemChoice.quantity = scanner.nextLine();
                    break;

                default:
                    System.out.println("Invalid Response!!!");
                    break;
            }
        }
    }
    static InventoryItem createItem(String name, String quantity) {
        System.out.printf("Enter %s's category: ", name);
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
