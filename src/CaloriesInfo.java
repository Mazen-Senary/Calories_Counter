import java.util.Map;

public class CaloriesInfo implements FoodInfo {
    private String mealName;
    public static Map<String, NutritionData> nutritionDB = Map.of(
            "Spaghetti Bolognese", new NutritionData(350, 25, 10),
            "Chicken Salad", new NutritionData(220, 30, 5),
            "Veggie Omelette", new NutritionData(150, 20, 8)
    );

    public CaloriesInfo(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public String getNutritionDetails() {
        NutritionData data = nutritionDB.get(mealName);
        if (data == null) return "No data for meal: " + mealName;
        return "Calories: " + data.calories;
    }
}


//
//import java.io.*;
//import java.util.*;
//
//public class CaloriesInfo implements FoodInfo {
//    private String mealName;
//    public static Map<String, NutritionData> nutritionDB;
//
//    static {
//        try {
//            nutritionDB = NutritionDataLoader.loadData();
//        } catch (Exception e) {
//            nutritionDB = new HashMap<>();
//            System.err.println("Failed to load Meals.txt: " + e.getMessage());
//        }
//    }
//
//    public CaloriesInfo(String mealName) {
//        this.mealName = mealName;
//    }
//
//    @Override
//    public String getNutritionDetails() {
//        NutritionData data = nutritionDB.get(mealName);
//        if (data == null) return "No data for meal: " + mealName;
//        return "Calories: " + data.calories;
//    }
//}

