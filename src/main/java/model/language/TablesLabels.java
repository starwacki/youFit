package model.language;

import java.io.Serial;
import java.io.Serializable;

public class TablesLabels implements Serializable {
    @Serial
    private static final long serialVersionUID = -1106987852148508455L;
    public static String basicBreakfastName;
    public static String basicBrunchName;
    public static String basicLunchName;
    public static String basicSupperName;
    public static String basicBreakfastTime;
    public static String basicBrunchTime;
    public static String basicLunchTime;
    public static String basicSupperTime;
    private String breakfastName;
    private String brunchName;
    private String lunchName;
    private String supperName;
    private String breakfastTime;
    private String brunchTime;
    private String lunchTime;
    private String supperTime;

    public TablesLabels() {
    }

    public TablesLabels(String breakfastName, String brunchName, String lunchName, String supperName,
                        String breakfastTime, String brunchTime, String lunchTime, String supperTime) {
        this.breakfastName = breakfastName;
        this.brunchName = brunchName;
        this.lunchName = lunchName;
        this.supperName = supperName;
        this.breakfastTime = breakfastTime;
        this.brunchTime = brunchTime;
        this.lunchTime = lunchTime;
        this.supperTime = supperTime;
    }

    public String getBreakfastName() {
        return breakfastName;
    }

    public void setBreakfastName(String breakfastName) {
        this.breakfastName = breakfastName;
    }

    public String getBrunchName() {
        return brunchName;
    }

    public void setBrunchName(String brunchName) {
        this.brunchName = brunchName;
    }

    public String getLunchName() {
        return lunchName;
    }

    public void setLunchName(String lunchName) {
        this.lunchName = lunchName;
    }

    public String getSupperName() {
        return supperName;
    }

    public void setSupperName(String supperName) {
        this.supperName = supperName;
    }

    public String getBreakfastTime() {
        return breakfastTime;
    }

    public void setBreakfastTime(String breakfastTime) {
        this.breakfastTime = breakfastTime;
    }

    public String getBrunchTime() {
        return brunchTime;
    }

    public void setBrunchTime(String brunchTime) {
        this.brunchTime = brunchTime;
    }

    public String getLunchTime() {
        return lunchTime;
    }

    public void setLunchTime(String lunchTime) {
        this.lunchTime = lunchTime;
    }

    public String getSupperTime() {
        return supperTime;
    }

    public void setSupperTime(String supperTime) {
        this.supperTime = supperTime;
    }

}
