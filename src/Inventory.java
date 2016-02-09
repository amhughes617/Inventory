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
                System.out.println(i + " [" + item.quantity + "]" + ". " + item.name);
            }
            System.out.println();
            System.out.println("1. Add new item.");
            System.out.println("2. Remove item.");
            System.out.println("3. Update item quantity");

            String option = scanner.nextLine();

            switch (option) {

                case "1":
                    System.out.print("Enter new item: ");
                    String text = scanner.nextLine();
                    items.add(new InventoryItem(text, "0"));
                    break;

                case "2":
                    System.out.print("Enter the index number of the item you want to remove: ");
                    int itemNum = Integer.valueOf(scanner.nextLine());
                    items.remove(itemNum - 1);
                    break;

                case "3":
                    System.out.print("Enter the index number of the item you would like to increase: ");
                    itemNum = Integer.valueOf(scanner.nextLine());
                    InventoryItem itemChoice = items.get(itemNum - 1);
                    System.out.print("How much would you like to add to " + itemChoice + ": ");
                    itemChoice.quantity = scanner.nextLine();
                    break;

                default:
                    System.out.println("Invalid Response!!!");
                    break;
            }
        }
    }
}
