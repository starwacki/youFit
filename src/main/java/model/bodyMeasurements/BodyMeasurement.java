package model.bodyMeasurements;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class BodyMeasurement implements Serializable,Comparable<BodyMeasurement> {
    @Serial
    private static final long serialVersionUID = 5838731998853688146L;
    private LocalDate date;
    private String hip;
    private String chest;
    private String thigh;
    private String biceps;
    private String triceps;
    private String waist;

    public BodyMeasurement(LocalDate date, String hip, String chest, String thigh, String biceps, String triceps, String waist) {
        this.date = date;
        this.hip = hip;
        this.chest = chest;
        this.thigh = thigh;
        this.biceps = biceps;
        this.triceps = triceps;
        this.waist = waist;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getHip() {
        return hip;
    }

    public String getChest() {
        return chest;
    }

    public String getThigh() {
        return thigh;
    }

    public String getBiceps() {
        return biceps;
    }

    public String getTriceps() {
        return triceps;
    }

    public String getWaist() {
        return waist;
    }

    @Override
    public int compareTo(BodyMeasurement o) {
        return this.date.compareTo(o.date);
    }
}
