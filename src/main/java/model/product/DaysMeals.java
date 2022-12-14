package model.product;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DaysMeals {
    private final List<Meals> mondayMeals = new ArrayList<>();
    private final List<Meals> tuesdayMeals = new ArrayList<>();
    private final List<Meals> wednesdayMeals = new ArrayList<>();
    private final List<Meals> thursdayMeals = new ArrayList<>();
    private final List<Meals> fridayMeals = new ArrayList<>();
    private final List<Meals> saturdayMeals = new ArrayList<>();
    private final List<Meals> sundayMeals = new ArrayList<>();
    private final Map<DayOfWeek, List<Meals>> daysListMap = Map.of(
            DayOfWeek.MONDAY, mondayMeals,
            DayOfWeek.TUESDAY, tuesdayMeals,
            DayOfWeek.WEDNESDAY, wednesdayMeals,
            DayOfWeek.THURSDAY, thursdayMeals,
            DayOfWeek.FRIDAY, fridayMeals,
            DayOfWeek.SATURDAY, saturdayMeals,
            DayOfWeek.SUNDAY, sundayMeals);
    public void createMealsFromAllDays() {
        createAndAddNewMeals(mondayMeals);
        createAndAddNewMeals(tuesdayMeals);
        createAndAddNewMeals(wednesdayMeals);
        createAndAddNewMeals(thursdayMeals);
        createAndAddNewMeals(fridayMeals);
        createAndAddNewMeals(saturdayMeals);
        createAndAddNewMeals(sundayMeals);
    }
    private void createAndAddNewMeals(List<Meals> dayMeals) {
       List<Product> meal1 = new ArrayList<>();
       List<Product> meal2 = new ArrayList<>();
       List<Product> meal3 = new ArrayList<>();
       List<Product> meal4 = new ArrayList<>();


        Meals meals= new Meals(meal1,meal2,meal3,meal4);
        dayMeals.add(meals);
    }
    public Map<DayOfWeek, List<Meals>> getDaysListMap() {
        return daysListMap;
    }

    public List<Meals> getMondayMeals() {
        return mondayMeals;
    }

    public List<Meals> getTuesdayMeals() {
        return tuesdayMeals;
    }

    public List<Meals> getWednesdayMeals() {
        return wednesdayMeals;
    }

    public List<Meals> getThursdayMeals() {
        return thursdayMeals;
    }

    public List<Meals> getFridayMeals() {
        return fridayMeals;
    }

    public List<Meals> getSaturdayMeals() {
        return saturdayMeals;
    }

    public List<Meals> getSundayMeals() {
        return sundayMeals;
    }
}