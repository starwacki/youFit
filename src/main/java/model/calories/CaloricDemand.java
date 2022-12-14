package model.calories;

import java.io.Serial;
import java.io.Serializable;

public class CaloricDemand implements Serializable {
    @Serial
    private static final long serialVersionUID = 7826912357526727204L;
    private static final double CARBOHYDRATES_PERCENT = 0.55;
    private static final int NULL_VALUE = -1;
    private static final int LOSS_WEIGHT_ADDITIONAL_CALORIES = -400;
    private static final int PUT_ON_WEIGHT_ADDITIONAL_CALORIES = 400;
    private static final int MALE_INDEX = 0;
    private static final int FEMALE_INDEX = 1;
    transient private int weight; //in kg
    transient private int height; // in cm
    transient private int gender; //if 0 - male 1 - female (biologic gender)
    transient private CaloricDemandPhysicalActivity physicalActivity;
    transient private int age; // >0!!
    transient private Purpose purpose; // LOSS WEIGHT TDEE - 400 KCAL, STAY AT WEIGHT = TDEE, PUN ON WEIGHT = TDEE + 400 KCAL
    private double totalDailyEnergyExpenditure; //TDEE
    private double proteinsInDiet;
    private double carbohydratesInDiet;
    private double fatInDiet;


    public CaloricDemand(int weight, int height, int gender,
                         CaloricDemandPhysicalActivity physicalActivity, int age,Purpose purpose) {
        this.weight=weight;
        this.height=height;
        this.gender=gender;
        this.physicalActivity = physicalActivity;
        this.age=age;
        this.purpose = purpose;
        this.totalDailyEnergyExpenditure = TDEE();
        setMacronutrients();

    }
    public CaloricDemand() {

    }
    public void setTotalDailyEnergyExpenditure(double totalDailyEnergyExpenditure) {
        this.totalDailyEnergyExpenditure = totalDailyEnergyExpenditure;
    }
    public void setProteinsInDiet(double proteinsInDiet) {
        this.proteinsInDiet = proteinsInDiet;
    }

    public void setCarbohydratesInDiet(double carbohydratesInDiet) {
        this.carbohydratesInDiet = carbohydratesInDiet;
    }

    public void setFatInDiet(double fatInDiet) {
        this.fatInDiet = fatInDiet;
    }

    public double getTotalDailyEnergyExpenditure() {
        return totalDailyEnergyExpenditure;
    }

    public double getProteinsInDiet() {
        return proteinsInDiet;
    }

    public double getCarbohydratesInDiet() {
        return carbohydratesInDiet;
    }

    public double getFatInDiet() {
        return fatInDiet;
    }

    public double calorieNeeded() {
        double calorieNeeded = NULL_VALUE;
        switch (purpose) {
            case LOSS_WEIGHT -> calorieNeeded = totalDailyEnergyExpenditure+LOSS_WEIGHT_ADDITIONAL_CALORIES;
            case STAY_AT_WEIGHT -> calorieNeeded = totalDailyEnergyExpenditure;
            case PUT_ON_WEIGHT -> calorieNeeded = totalDailyEnergyExpenditure+PUT_ON_WEIGHT_ADDITIONAL_CALORIES;
        }
        return calorieNeeded;
    }


   /* Method return TDEE - total daily energy expenditure. TDEE is energy you need to stay at weight.
    * TDEE = BMR*PHYSICAL_ACTIVITY_RATIO */

    private double TDEE() {
        double bmrCalculate = NULL_VALUE;
        switch (gender) {
            case MALE_INDEX -> bmrCalculate = bmrForMale() * physicalActivityRatio();
            case FEMALE_INDEX -> bmrCalculate = bmrForFemale() * physicalActivityRatio();
        }
        return bmrCalculate;
    }

    private double physicalActivityRatio() {
        double ratio = NULL_VALUE;
        switch (physicalActivity) {
            case VERY_LOW -> ratio= 1.2;
            case LOW -> ratio = 1.375;
            case AVERAGE -> ratio = 1.55;
            case BIG ->  ratio = 1.725;
            case VERY_BIG -> ratio = 1.9;
        }
        return ratio;
    }

  /* Methods calculate BMR (basal metabolic rate) for given gender by Harris-Benedict formula.
  Male: BMR = 66 + (13,7 ?? weight in kg) + (5 ?? height in cm) - (6,8 ?? age in years)
  Female: BMR = 655 + (9,6 ?? weight in kg) + (1,8 ?? height in cm) - (4,7 ?? age in years) */

    private double bmrForMale() {
        return 66 + (13.7*weight)+(5*height)-(6.8*age);
    }

    private double bmrForFemale() {
        return 655 + (9.6*weight)+(1.8*height)-(4.7*age);
    }

    /* Method return proteins,carbohydrates,fat in accordance with the principles of a balanced diet
    10-25% of energy -> proteins (depending on the physical activity)
    ~55% of energy - > carbohydrates
    20-35% of energy - > fats ( depending on the proteins)
    values are purely indicative - averaged for an ordinary person without disease or disorder!
    */

    private void setMacronutrients() {
        switch (physicalActivity) {
            case  VERY_LOW,LOW -> calculateMacronutrientsForLowActivity();
            case  AVERAGE -> calculateMacronutrientsForAverageActivity();
            case BIG,VERY_BIG -> calculateMacronutrientsForBigActivity();
        }
    }

    private void calculateMacronutrientsForLowActivity() {
        double proteinPercent = 0.15;
        double fatPercent = 1 - CARBOHYDRATES_PERCENT - proteinPercent;
        proteinsInDiet = calorieNeeded()*proteinPercent/CaloriesCalculator.ONE_GRAM_OF_PROTEIN_CALORIES;
        carbohydratesInDiet = calorieNeeded()*CARBOHYDRATES_PERCENT/CaloriesCalculator.ONE_GRAM_OF_CARBOHYDRATES_CALORIES;
        fatInDiet = calorieNeeded() * fatPercent/CaloriesCalculator.ONE_GRAM_OF_FAT_CALORIES;
    }

    private void calculateMacronutrientsForAverageActivity() {
        double proteinPercent = 0.19;
        double fatPercent = 1 - CARBOHYDRATES_PERCENT - proteinPercent;
        proteinsInDiet = calorieNeeded()*proteinPercent/CaloriesCalculator.ONE_GRAM_OF_PROTEIN_CALORIES;
        carbohydratesInDiet = calorieNeeded()*CARBOHYDRATES_PERCENT/CaloriesCalculator.ONE_GRAM_OF_CARBOHYDRATES_CALORIES;
        fatInDiet = calorieNeeded() * fatPercent/CaloriesCalculator.ONE_GRAM_OF_FAT_CALORIES;
    }

    private void calculateMacronutrientsForBigActivity() {
        double proteinPercent = 0.21;
        double fatPercent = 1 - CARBOHYDRATES_PERCENT - proteinPercent;
        proteinsInDiet = calorieNeeded()*proteinPercent/CaloriesCalculator.ONE_GRAM_OF_PROTEIN_CALORIES;
        carbohydratesInDiet = calorieNeeded()*CARBOHYDRATES_PERCENT/CaloriesCalculator.ONE_GRAM_OF_CARBOHYDRATES_CALORIES;
        fatInDiet = calorieNeeded() * fatPercent/CaloriesCalculator.ONE_GRAM_OF_FAT_CALORIES;
    }

}
