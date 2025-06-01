public abstract class FoodInfoDecorator implements FoodInfo {
    protected FoodInfo decoratedFoodInfo;
    protected String mealName;

    public FoodInfoDecorator(FoodInfo decoratedFoodInfo, String mealName) {
        this.decoratedFoodInfo = decoratedFoodInfo;
        this.mealName = mealName;
    }
}
