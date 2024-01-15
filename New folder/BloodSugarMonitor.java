
//22ug2-0549
import java.util.ArrayList;
import java.util.Scanner;

class BloodSugar {
    private int id;
    private String name;
    private int yob;
    private int sugarLevel;

    // Constructor to initialize BloodSugar object
    public BloodSugar(int id, String name, int yob, int sugarLevel) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.sugarLevel = sugarLevel;
    }

    // Getter for the user ID
    public int getId() {
        return id;
    }

    // Display method to show user details
    public void display() {
        System.out
                .println("ID: " + id + ", Name: " + name + ", Year of Birth: " + yob + ", Sugar Level: " + sugarLevel);
    }
}

public class BloodSugarMonitor {
    private ArrayList<BloodSugar> users = new ArrayList<>();

    // Main method to start the application
    public static void main(String[] args) {
        BloodSugarMonitor monitor = new BloodSugarMonitor();
        monitor.displayMenu();
    }

    // Display menu method to interact with the user
    public void displayMenu() {
        String choice;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Blood Sugar Monitor Menu:");
            System.out.println("1. Create a record");
            System.out.println("2. Show blood sugar data for all users");
            System.out.println("3. Show blood sugar data for a selected user");
            System.out.println("4. Delete all");
            System.out.println("5. Exit application");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    create();// Call the create method
                    break;
                case "2":
                    index();// Call the index method
                    break;
                case "3":
                    System.out.print("Enter user id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    view(id);// Call the view method with user ID
                    break;
                case "4":
                    delete();// Call the delete method
                    break;
                case "5":
                    exit();// Call the exit method
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!choice.equals("5"));
    }

    // Display all user records
    public void index() {
        for (BloodSugar user : users) {
            user.display();// Call the display method for each user
        }
    }

    // Display details for a specific user
    public void view(int id) {
        for (BloodSugar user : users) {
            if (user.getId() == id) {
                user.display();// Call the display method for the selected user
                return;
            }
        }
        System.out.println("User not found with id: " + id);
    }

    // Create a new user record
    public void create() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter year of birth: ");
        int yob = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter blood sugar level: ");
        int sugarLevel = Integer.parseInt(scanner.nextLine());
        BloodSugar user = new BloodSugar(id, name, yob, sugarLevel);
        users.add(user);// Add the user to the list
        System.out.println("User record created successfully.");
    }

    // Delete all user records
    public void delete() {
        users.clear();
        System.out.println("All records deleted successfully.");
    }

    // Exit the application
    public void exit() {
        System.out.println("Exiting application. Goodbye!");
        System.exit(0);
    }
}