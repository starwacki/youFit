package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class DateControllerTest {

    @Test
    public void shouldReturnDatesWhenGivenDayIsMonday() {
        DateController.setActualClickedDate(LocalDate.of(2022,10,24));
        DateController dateController = new DateController(LocalDate.of(2022,10,24)); //monday
        Assertions.assertEquals(LocalDate.of(2022,10,24),dateController.getMondayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,25),dateController.getTuesdayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,26),dateController.getWednesdayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,27),dateController.getThursdayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,28),dateController.getFridayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,29),dateController.getSaturdayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,30),dateController.getSundayDate());

    }

    @Test
    public void shouldReturnDatesWhenGivenDayIsTuesday() {
        DateController.setActualClickedDate(LocalDate.of(2022,10,25));
        DateController dateController = new DateController(LocalDate.of(2022,10,25)); //tuesday
        Assertions.assertEquals(LocalDate.of(2022,10,24),dateController.getMondayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,25),dateController.getTuesdayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,26),dateController.getWednesdayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,27),dateController.getThursdayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,28),dateController.getFridayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,29),dateController.getSaturdayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,30),dateController.getSundayDate());
    }

    @Test
    public void shouldReturnDatesWhenGivenDayIsWednesday() {
        DateController.setActualClickedDate(LocalDate.of(2022,10,26));
        DateController dateController = new DateController(LocalDate.of(2022,10,26)); //wednesday
        Assertions.assertEquals(LocalDate.of(2022,10,24),dateController.getMondayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,25),dateController.getTuesdayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,26),dateController.getWednesdayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,27),dateController.getThursdayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,28),dateController.getFridayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,29),dateController.getSaturdayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,30),dateController.getSundayDate());
    }

    @Test
    public void shouldReturnDatesWhenGivenDayIsThursday() {
        DateController.setActualClickedDate(LocalDate.of(2022,10,27));
        DateController dateController = new DateController(LocalDate.of(2022,10,27)); //thursday
        Assertions.assertEquals(LocalDate.of(2022,10,24),dateController.getMondayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,25),dateController.getTuesdayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,26),dateController.getWednesdayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,27),dateController.getThursdayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,28),dateController.getFridayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,29),dateController.getSaturdayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,30),dateController.getSundayDate());
    }

    @Test
    public void shouldReturnDatesWhenGivenDayIsFriday() {
        DateController.setActualClickedDate(LocalDate.of(2022,10,28));
        DateController dateController = new DateController(LocalDate.of(2022,10,28)); //friday
        Assertions.assertEquals(LocalDate.of(2022,10,24),dateController.getMondayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,25),dateController.getTuesdayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,26),dateController.getWednesdayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,27),dateController.getThursdayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,28),dateController.getFridayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,29),dateController.getSaturdayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,30),dateController.getSundayDate());
    }

    @Test
    public void shouldReturnDatesWhenGivenDayIsSaturday() {
        DateController.setActualClickedDate(LocalDate.of(2022,10,29));
        DateController dateController = new DateController(LocalDate.of(2022,10,29)); //friday
        Assertions.assertEquals(LocalDate.of(2022,10,24),dateController.getMondayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,25),dateController.getTuesdayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,26),dateController.getWednesdayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,27),dateController.getThursdayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,28),dateController.getFridayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,29),dateController.getSaturdayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,30),dateController.getSundayDate());
    }

    @Test
    public void shouldReturnDatesWhenGivenDayIsSunday() {
        DateController.setActualClickedDate(LocalDate.of(2022,10,30));
        DateController dateController = new DateController(LocalDate.of(2022,10,30)); //sunday
        Assertions.assertEquals(LocalDate.of(2022,10,24),dateController.getMondayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,25),dateController.getTuesdayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,26),dateController.getWednesdayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,27),dateController.getThursdayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,28),dateController.getFridayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,29),dateController.getSaturdayDate());
        Assertions.assertEquals(LocalDate.of(2022,10,30),dateController.getSundayDate());

    }


}