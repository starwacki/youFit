package model;
import java.time.DayOfWeek;
import java.time.LocalDate;


public class DateController {
    private static DayOfWeek lastClickedDay = LocalDate.now().getDayOfWeek();
    private static LocalDate actualClickedDate = LocalDate.now();
    private LocalDate mondayDate;
    private LocalDate tuesdayDate;
    private LocalDate wednesdayDate;
    private LocalDate thursdayDate;
    private LocalDate fridayDate;
    private LocalDate saturdayDate;
    private LocalDate sundayDate;



    public DateController() {
     if (lastClickedDay==DayOfWeek.MONDAY) createWeekForMondayNow(actualClickedDate);
     if (lastClickedDay==DayOfWeek.TUESDAY) createWeekForTuesdayNow(actualClickedDate);
     if (lastClickedDay==DayOfWeek.WEDNESDAY) createWeekForWednesdayNow(actualClickedDate);
     if (lastClickedDay==DayOfWeek.THURSDAY) createWeekForThursdayNow(actualClickedDate);
     if (lastClickedDay==DayOfWeek.FRIDAY) createWeekForFridayNow(actualClickedDate);
     if (lastClickedDay==DayOfWeek.SATURDAY) createWeekForSaturdayNow(actualClickedDate);
     if (lastClickedDay==DayOfWeek.SUNDAY) createWeekForSundayNow(actualClickedDate);

    }
    public DateController(LocalDate localDate) {
        if (actualClickedDate.getDayOfWeek()==DayOfWeek.MONDAY) createWeekForMondayNow(localDate);
        if (actualClickedDate.getDayOfWeek()==DayOfWeek.TUESDAY) createWeekForTuesdayNow(localDate);
        if (actualClickedDate.getDayOfWeek()==DayOfWeek.WEDNESDAY) createWeekForWednesdayNow(localDate);
        if (actualClickedDate.getDayOfWeek()==DayOfWeek.THURSDAY) createWeekForThursdayNow(localDate);
        if (actualClickedDate.getDayOfWeek()==DayOfWeek.FRIDAY) createWeekForFridayNow(localDate);
        if (actualClickedDate.getDayOfWeek()==DayOfWeek.SATURDAY) createWeekForSaturdayNow(localDate);
        if (actualClickedDate.getDayOfWeek()==DayOfWeek.SUNDAY) createWeekForSundayNow(localDate);

    }
    private void createWeekForMondayNow(LocalDate localDate) {
        mondayDate = localDate;
        tuesdayDate = localDate.plusDays(1L);
        wednesdayDate= localDate.plusDays(2L);
        thursdayDate= localDate.plusDays(3L);
        fridayDate = localDate.plusDays(4L);
        saturdayDate = localDate.plusDays(5L);
        sundayDate = localDate.plusDays(6L);
    }
    private void createWeekForTuesdayNow(LocalDate localDate) {
        mondayDate = localDate.minusDays(1L);
        tuesdayDate = localDate;
        wednesdayDate= localDate.plusDays(1L);
        thursdayDate= localDate.plusDays(2L);
        fridayDate = localDate.plusDays(3L);
        saturdayDate = localDate.plusDays(4L);
        sundayDate = localDate.plusDays(5L);
    }
    private void createWeekForWednesdayNow(LocalDate localDate) {
        mondayDate = localDate.minusDays(2L);
        tuesdayDate = localDate.minusDays(1L);
        wednesdayDate= localDate;
        thursdayDate= localDate.plusDays(1L);
        fridayDate = localDate.plusDays(2L);
        saturdayDate = localDate.plusDays(3L);
        sundayDate = localDate.plusDays(4L);
    }
    private void createWeekForThursdayNow(LocalDate localDate) {
        mondayDate = localDate.minusDays(3L);
        tuesdayDate = localDate.minusDays(2L);
        wednesdayDate= localDate.minusDays(1L);
        thursdayDate= localDate;
        fridayDate = localDate.plusDays(1L);
        saturdayDate = localDate.plusDays(2L);
        sundayDate = localDate.plusDays(3L);
    }
    private void createWeekForFridayNow(LocalDate localDate) {
        mondayDate = localDate.minusDays(4L);
        tuesdayDate = localDate.minusDays(3L);
        wednesdayDate= localDate.minusDays(2L);
        thursdayDate= localDate.minusDays(1L);
        fridayDate = localDate;
        saturdayDate = localDate.plusDays(1L);
        sundayDate = localDate.plusDays(2L);
    }
    private void createWeekForSaturdayNow(LocalDate localDate) {
        mondayDate = localDate.minusDays(5L);
        tuesdayDate = localDate.minusDays(4L);
        wednesdayDate= localDate.minusDays(3L);
        thursdayDate= localDate.minusDays(2L);
        fridayDate = localDate.minusDays(1L);
        saturdayDate = localDate;
        sundayDate = localDate.plusDays(1L);
    }
    private void createWeekForSundayNow(LocalDate localDate) {
        mondayDate = localDate.minusDays(6L);
        tuesdayDate = localDate.minusDays(5L);
        wednesdayDate= localDate.minusDays(4L);
        thursdayDate= localDate.minusDays(3L);
        fridayDate = localDate.minusDays(2L);
        saturdayDate = localDate.minusDays(1L);
        sundayDate = localDate;
    }

    public static DayOfWeek getLastClickedDay() {
        return lastClickedDay;
    }

    public LocalDate getMondayDate() {
        return mondayDate;
    }

    public LocalDate getTuesdayDate() {
        return tuesdayDate;
    }

    public LocalDate getWednesdayDate() {
        return wednesdayDate;
    }

    public LocalDate getThursdayDate() {
        return thursdayDate;
    }

    public LocalDate getFridayDate() {
        return fridayDate;
    }

    public LocalDate getSaturdayDate() {
        return saturdayDate;
    }

    public LocalDate getSundayDate() {
        return sundayDate;
    }

    public void setMondayDate(LocalDate mondayDate) {
        this.mondayDate = mondayDate;
    }

    public void setTuesdayDate(LocalDate tuesdayDate) {
        this.tuesdayDate = tuesdayDate;
    }

    public void setWednesdayDate(LocalDate wednesdayDate) {
        this.wednesdayDate = wednesdayDate;
    }

    public void setThursdayDate(LocalDate thursdayDate) {
        this.thursdayDate = thursdayDate;
    }

    public void setFridayDate(LocalDate fridayDate) {
        this.fridayDate = fridayDate;
    }

    public void setSaturdayDate(LocalDate saturdayDate) {
        this.saturdayDate = saturdayDate;
    }

    public void setSundayDate(LocalDate sundayDate) {
        this.sundayDate = sundayDate;
    }

    public static void setLastClickedDay(DayOfWeek lastClickedDay) {
        DateController.lastClickedDay = lastClickedDay;
    }

    public static LocalDate getActualClickedDate() {
        return actualClickedDate;
    }

    public static void setActualClickedDate(LocalDate actualClickedDate) {
        DateController.actualClickedDate = actualClickedDate;
    }
}
