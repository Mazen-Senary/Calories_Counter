import data.User;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
// Main.java (Add this to your main method temporarily, or create a new test method)
public class Main {
    public static void main(String[] args) {
        // ... (existing LoginScreen code)

        // --- Prototype Pattern Demonstration ---
        System.out.println("\n--- Prototype Pattern Demonstration ---");

        // Create an original user
        User originalUser = new User();
        originalUser.setEmail("original@example.com");
        originalUser.setUsername("originalUser");
        originalUser.setPassword("pass123");
        originalUser.setAge(30);
        originalUser.setWeight(70.5);

        System.out.println("Original User:");
        originalUser.displayInfo();

        // Clone the original user to create a new user
        User clonedUser = originalUser.clone();
        clonedUser.setEmail("cloned@example.com"); // Modify the cloned user
        clonedUser.setUsername("clonedUser");
        clonedUser.setPassword("newpass"); // Example: Change password for the new user

        System.out.println("\nCloned User (modified):");
        clonedUser.displayInfo();

        System.out.println("\nOriginal User (after clone, should remain unchanged):");
        originalUser.displayInfo();

        System.out.println("Are originalUser and clonedUser the same object? " + (originalUser == clonedUser)); // Should be false
        System.out.println("Are their contents equal (based on your equals method)? " + originalUser.equals(clonedUser)); // Should be false now due to changes
        // --- End Prototype Pattern Demonstration ---

        // ... (rest of your Main.java code)


//        CaloriesCounter counter = CaloriesCounter.getInstance();
//        counter.addCalories(700);
//        counter.addCalories(600);
//        System.out.println(counter.getTotalCalories());
//        CaloriesCounter count2 = CaloriesCounter.getInstance();
//        count2.addCalories(5000);
//        System.out.println(count2.getTotalCalories());
//        System.out.println(count2 == counter);
//        System.out.println(counter.getTotalCalories());

        LoginScreen l = new LoginScreen();
        l.setContentPane(l.loginFrame);
        l.setVisible(true);
        l.setSize(650, 500);


    }}
