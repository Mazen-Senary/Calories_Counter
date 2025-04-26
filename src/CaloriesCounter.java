public class CaloriesCounter {
    private static CaloriesCounter instance;
    private int totalCalories;
    private CaloriesCounter(){
        totalCalories =0;
    }
    public static CaloriesCounter getInstance(){
        if(instance == null){
            instance=new CaloriesCounter();

        }
        return instance;
    }
    public void addCalories(int calories){
        totalCalories +=calories;
    }
    public void resetCalories() {
        totalCalories = 0;
    }

    public int getTotalCalories() {
        return totalCalories;
    }
}



