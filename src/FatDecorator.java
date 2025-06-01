import java.util.Map;

public class FatDecorator extends NutritionDecorator {
    private String mealName;
    private static Map<String, NutritionData> nutritionDB = CaloriesInfo.nutritionDB;

    public FatDecorator(FoodInfo foodInfo, String mealName) {
        super(foodInfo);
        this.mealName = mealName;
    }

    @Override
    public String getNutritionDetails() {
        String baseDetails = wrappedFoodInfo.getNutritionDetails();
        NutritionData data = nutritionDB.get(mealName);
        if (data == null) return baseDetails;
        return baseDetails + "\nFat: " + data.fat + "g";
    }
}
