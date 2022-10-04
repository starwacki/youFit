package io;

import model.calories.CaloricDemand;
import java.io.*;

public class CaloricDemandIO {
    private static final String CALORIC_DEMAND_FILE_PATH = "caloric-demand.obj";

    public static void safeCaloricDemand(CaloricDemand caloricDemand) {
        try(
                var object = new ObjectOutputStream(new FileOutputStream(CALORIC_DEMAND_FILE_PATH))
        )
        {
            object.writeObject(caloricDemand);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static CaloricDemand getCaloricDemand () {
       CaloricDemand caloricDemand;
        try(
                var object = new ObjectInputStream(new FileInputStream(CALORIC_DEMAND_FILE_PATH))
        )
        {
            caloricDemand= (CaloricDemand) object.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return caloricDemand;
    }
}
