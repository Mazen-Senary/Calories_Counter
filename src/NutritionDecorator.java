public abstract class NutritionDecorator implements FoodInfo {
    protected FoodInfo wrappedFoodInfo;

    public NutritionDecorator(FoodInfo foodInfo) {
        this.wrappedFoodInfo = foodInfo;
    }
}
