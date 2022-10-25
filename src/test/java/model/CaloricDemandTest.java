package model;

import model.calories.CaloricDemand;
import model.calories.CaloricDemandPhysicalActivity;
import model.calories.Purpose;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CaloricDemandTest {
    private static final int ONE_GRAM_OF_PROTEINS_CALORIES = 4;
    private static final int ONE_GRAM_OF_CARBOHYDRATES_CALORIES = 4;
    private static final int ONE_GRAM_OF_FAT_CALORIES = 9;

    @Test
    public void shouldReturnTheSameCaloriesForStayAtWeight() {
        int weight = 100;
        int height = 180;
        int gender = 0;
        CaloricDemandPhysicalActivity physicalActivity = CaloricDemandPhysicalActivity.AVERAGE;
        int age = 19;
        Purpose purpose = Purpose.STAY_AT_WEIGHT;
        CaloricDemand caloricDemand = new CaloricDemand(weight,height,gender,physicalActivity,age,purpose);
        double result = caloricDemand.getProteinsInDiet()*ONE_GRAM_OF_PROTEINS_CALORIES +
                caloricDemand.getCarbohydratesInDiet()*ONE_GRAM_OF_CARBOHYDRATES_CALORIES +
                caloricDemand.getFatInDiet()*ONE_GRAM_OF_FAT_CALORIES;
        Assertions.assertEquals((int)result,(int)caloricDemand.calorieNeeded());
    }

    @Test
    public void shouldReturnTheSameCaloriesForPutOnWeight() {
        int weight = 100;
        int height = 180;
        int gender = 0;
        CaloricDemandPhysicalActivity physicalActivity = CaloricDemandPhysicalActivity.AVERAGE;
        int age = 19;
        Purpose purpose = Purpose.PUT_ON_WEIGHT;
        CaloricDemand caloricDemand = new CaloricDemand(weight,height,gender,physicalActivity,age,purpose);
        double result = caloricDemand.getProteinsInDiet()*ONE_GRAM_OF_PROTEINS_CALORIES +
                caloricDemand.getCarbohydratesInDiet()*ONE_GRAM_OF_CARBOHYDRATES_CALORIES +
                caloricDemand.getFatInDiet()*ONE_GRAM_OF_FAT_CALORIES;
        Assertions.assertEquals((int)result,(int)caloricDemand.calorieNeeded());
    }

    @Test
    public void shouldReturnTheSameCaloriesForVeryBigAverage() {
        int weight = 100;
        int height = 180;
        int gender = 0;
        CaloricDemandPhysicalActivity physicalActivity = CaloricDemandPhysicalActivity.VERY_BIG;
        int age = 19;
        Purpose purpose = Purpose.STAY_AT_WEIGHT;
        CaloricDemand caloricDemand = new CaloricDemand(weight,height,gender,physicalActivity,age,purpose);
        double result = caloricDemand.getProteinsInDiet()*ONE_GRAM_OF_PROTEINS_CALORIES +
                caloricDemand.getCarbohydratesInDiet()*ONE_GRAM_OF_CARBOHYDRATES_CALORIES +
                caloricDemand.getFatInDiet()*ONE_GRAM_OF_FAT_CALORIES;
        Assertions.assertEquals((int)result,(int)caloricDemand.calorieNeeded());
    }


    @Test
    public void shouldReturn3420CaloriesForMale() {
        int weight = 100;
        int height = 180;
        int gender = 0;
        CaloricDemandPhysicalActivity physicalActivity = CaloricDemandPhysicalActivity.AVERAGE;
        int age = 19;
        Purpose purpose = Purpose.STAY_AT_WEIGHT;
        CaloricDemand caloricDemand = new CaloricDemand(weight,height,gender,physicalActivity,age,purpose);
        Assertions.assertEquals(3420,(int)caloricDemand.calorieNeeded());
    }

    @Test
    public void shouldReturn2867CaloriesForFemale() {
        int weight = 100;
        int height = 180;
        int gender = 1;
        CaloricDemandPhysicalActivity physicalActivity = CaloricDemandPhysicalActivity.AVERAGE;
        int age = 19;
        Purpose purpose = Purpose.STAY_AT_WEIGHT;
        CaloricDemand caloricDemand = new CaloricDemand(weight,height,gender,physicalActivity,age,purpose);
        Assertions.assertEquals(2867,(int)caloricDemand.calorieNeeded());
    }

    @Test
    public void shouldReturn3267CaloriesForFemaleForPutOnWeight() {
        int weight = 100;
        int height = 180;
        int gender = 1;
        CaloricDemandPhysicalActivity physicalActivity = CaloricDemandPhysicalActivity.AVERAGE;
        int age = 19;
        Purpose purpose = Purpose.PUT_ON_WEIGHT;
        CaloricDemand caloricDemand = new CaloricDemand(weight,height,gender,physicalActivity,age,purpose);
        Assertions.assertEquals(3267,(int)caloricDemand.calorieNeeded());
    }

    @Test
    public void shouldReturn3020CaloriesForMaleForLossWeight() {
        int weight = 100;
        int height = 180;
        int gender = 0;
        CaloricDemandPhysicalActivity physicalActivity = CaloricDemandPhysicalActivity.AVERAGE;
        int age = 19;
        Purpose purpose = Purpose.LOSS_WEIGHT;
        CaloricDemand caloricDemand = new CaloricDemand(weight,height,gender,physicalActivity,age,purpose);
        Assertions.assertEquals(3020,(int)caloricDemand.calorieNeeded());
    }

    @Test
    public void shouldReturn3806CaloriesForMaleForPhysicalActivityBIG() {
        int weight = 100;
        int height = 180;
        int gender = 0;
        CaloricDemandPhysicalActivity physicalActivity = CaloricDemandPhysicalActivity.BIG;
        int age = 19;
        Purpose purpose = Purpose.STAY_AT_WEIGHT;
        CaloricDemand caloricDemand = new CaloricDemand(weight,height,gender,physicalActivity,age,purpose);
        Assertions.assertEquals(3806,(int)caloricDemand.calorieNeeded());
    }

}