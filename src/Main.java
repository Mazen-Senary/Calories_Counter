import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
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
        l.setSize(500,500);

    }
}