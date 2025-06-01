import java.util.*;
import java.io.*;

public class NutritionDataLoader {
    private static Map<String, NutritionData> dataMap = new HashMap<>();

    static {
        loadData();
    }

    private static void loadData() {
        try (BufferedReader br = new BufferedReader(new FileReader("data/Meals.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if(parts.length >= 4){
                    String mealName = parts[0].trim();
                    int calories = Integer.parseInt(parts[1].trim());
                    int protein = Integer.parseInt(parts[2].trim());
                    int fat = Integer.parseInt(parts[3].trim());
                    dataMap.put(mealName, new NutritionData(calories, protein, fat));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static NutritionData getNutrition(String mealName) {
        return dataMap.get(mealName);
    }
}


//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.Map;
//
//public class NutritionDataLoader {
//    public static Map<String, NutritionData> loadData() {
//        Map<String, NutritionData> dataMap = new HashMap<>();
//
//        try {
//            InputStream input = NutritionDataLoader.class.getClassLoader().getResourceAsStream("data/Meals.txt");
//            if (input == null) {
//                System.err.println("Meals.txt not found in resources!");
//                return dataMap;
//            }
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(",");
//                if (parts.length == 3) {
//                    String name = parts[0].trim();
//                    int calories = Integer.parseInt(parts[1].trim());
//                    int protein = Integer.parseInt(parts[2].trim());
//                    dataMap.put(name, new NutritionData(calories, protein, 0)); // Set fat later if needed
//                }
//            }
//            reader.close();
//        } catch (Exception e) {
//            System.err.println("Error loading Meals.txt: " + e.getMessage());
//        }
//
//        return dataMap;
//    }
//}

