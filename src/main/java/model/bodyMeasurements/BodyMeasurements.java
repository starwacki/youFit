package model.bodyMeasurements;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class BodyMeasurements implements Serializable {
    public static List<BodyMeasurement> bodyMeasurementsToSafe;
    public static List<LinearChartMeasurement> linearChartMeasurementsToSafe;
    @Serial
    private static final long serialVersionUID = -8686707249055593435L;
    private List<BodyMeasurement> bodyMeasurements;
    private List<LinearChartMeasurement> linearChartMeasurements;

    public BodyMeasurements(List<BodyMeasurement> bodyMeasurements, List<LinearChartMeasurement> linearChartMeasurements) {
        this.bodyMeasurements = bodyMeasurements;
        this.linearChartMeasurements = linearChartMeasurements;
    }

    public List<BodyMeasurement> getBodyMeasurements() {
        return bodyMeasurements;
    }

    public List<LinearChartMeasurement> getLinearChartMeasurements() {
        return linearChartMeasurements;
    }
}
