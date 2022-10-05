package io;

import model.bodyMeasurements.BodyMeasurements;
import java.io.*;

public class BodyMeasurementsIO {
    private static final String BODY_MEASUREMENTS_FILE_PATH = "body-measurements.obj";

    public static void initializeBodyMeasurementsBase() {
        BodyMeasurements.bodyMeasurementsToSafe = getBodyMeasurements().getBodyMeasurements();
        BodyMeasurements.linearChartMeasurementsToSafe = getBodyMeasurements().getLinearChartMeasurements();
    }

    public static void safeBodyMeasurementsBase() {
        BodyMeasurements bodyMeasurements = new BodyMeasurements(BodyMeasurements.bodyMeasurementsToSafe, BodyMeasurements.linearChartMeasurementsToSafe);
        safeBodyMeasurements(bodyMeasurements);
    }

    public static void safeBodyMeasurements(BodyMeasurements bodyMeasurements) {
        try(
                var object = new ObjectOutputStream(new FileOutputStream(BODY_MEASUREMENTS_FILE_PATH))
        )
        {
            object.writeObject(bodyMeasurements);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static BodyMeasurements getBodyMeasurements () {
        BodyMeasurements bodyMeasurements;
        try(
                var object = new ObjectInputStream(new FileInputStream(BODY_MEASUREMENTS_FILE_PATH))
        )
        {
           bodyMeasurements = (BodyMeasurements) object.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return bodyMeasurements;
    }

}

