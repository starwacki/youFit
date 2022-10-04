package model.calories;

public enum CaloricDemandPhysicalActivity {
    VERY_LOW("Very low - sedentary work, 0 training sessions "),
    LOW("Low - sedentary work, 1-2 training sessions"),
    AVERAGE("Average - physical work, 2-3 training sessions"),
    BIG("Big - hard physical work, 3-4 training sessions"),
    VERY_BIG("Very Big - hard physical work, everyday training sessions");

    CaloricDemandPhysicalActivity(String description) {

    }
}
