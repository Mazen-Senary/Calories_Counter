package data;
// NutritionFacade.java
import java.util.Map;

public class NutritionFacade {
    // We will use the existing CaloriesInfo.nutritionDB
    // Or you could inject a data source if it was more complex
    private Map<String, NutritionData> nutritionDatabase;

    public NutritionFacade() {
        // Initialize with the static nutritionDB from CaloriesInfo
        this.nutritionDatabase = CaloriesInfo.nutritionDB;
    }

    /**
     * Provides a simplified way to get comprehensive nutrition details for a meal.
     * It handles the creation and application of decorators internally.
     * @param mealName The name of the meal.
     * @return A string containing the nutrition details (Calories, Protein, Fat), or an error message.
     */
    public String getComprehensiveMealDetails(String mealName) {
        if (mealName == null || mealName.trim().isEmpty()) {
            return "Please enter a meal name.";
        }

        NutritionData data = nutritionDatabase.get(mealName);
        if (data == null) {
            return "No data for meal: " + mealName;
        }

        // Apply decorators through the facade
        FoodInfo caloriesInfo = new CaloriesInfo(mealName);
        FoodInfo proteinDecorator = new ProteinDecorator(caloriesInfo, mealName);
        FoodInfo fatDecorator = new FatDecorator(proteinDecorator, mealName);

        return fatDecorator.getNutritionDetails();
    }

    /**
     * Provides a simplified way to get just the total calories for a meal.
     * @param mealName The name of the meal.
     * @return The total calories, or -1 if no data.
     */
    public int getMealCalories(String mealName) {
        if (mealName == null || mealName.trim().isEmpty()) {
            return -1; // Or throw an IllegalArgumentException
        }
        NutritionData data = nutritionDatabase.get(mealName);
        return data != null ? data.calories : -1;
    }
}