import java.util.ArrayList;

/**
 * Created by alexanderhughes on 2/9/16.
 */
public class Account {
    String name;
    String password;
    public ArrayList<InventoryItem> items = new ArrayList<>();

    public Account(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
