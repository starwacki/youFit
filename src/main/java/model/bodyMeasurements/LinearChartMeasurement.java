package model.bodyMeasurements;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class LinearChartMeasurement implements Serializable,Comparable<LinearChartMeasurement> {
    @Serial
    private static final long serialVersionUID = -3972005098025006735L;
    private LocalDate date;
    private String weight;

    public LinearChartMeasurement(LocalDate date, String weight) {
        this.date = date;
        this.weight = weight;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getWeight() {
        return weight;
    }

    @Override
    public int compareTo(LinearChartMeasurement o) {
          return this.date.compareTo(o.date);
        }
    }

