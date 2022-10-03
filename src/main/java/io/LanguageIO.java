package io;

import model.language.Language;
import model.language.TablesLabels;

import java.io.*;

public class LanguageIO {
    private final static String LANGUAGE_PATH ="language.obj";
    private final static String TABLE_LABELS = "table-labels.obj";
    public static void initializeLanguage() {
        setLanguageApp();
        setTableLabels();
    }
    private static void setTableLabels() {
        TablesLabels tablesLabels = getTablesLabels();
        TablesLabels.basicBreakfastName = tablesLabels.getBreakfastName();
        TablesLabels.basicBrunchName= tablesLabels.getBrunchName();
        TablesLabels.basicLunchName = tablesLabels.getLunchName();
        TablesLabels.basicSupperName = tablesLabels.getSupperName();
        TablesLabels.basicBreakfastTime = tablesLabels.getBreakfastTime();
        TablesLabels.basicBrunchTime = tablesLabels.getBrunchTime();
        TablesLabels.basicLunchTime = tablesLabels.getLunchTime();
        TablesLabels.basicSupperTime = tablesLabels.getSupperTime();
    }
    private static void setLanguageApp() {
        Language.language = getLanguageVersion().getLanguageLanguage();
    }
    public static void safeLanguageApp() {
        safeLanguageVersion(new Language());
        safeTableLabels();
    }
    private static Language getLanguageVersion() {
        Language language;
        try(
                var object = new ObjectInputStream(new FileInputStream("language.obj"))
        )
        {
            language = (Language) object.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return language;
    }


    private static void safeLanguageVersion(Language language) {
        try(
                var object = new ObjectOutputStream(new FileOutputStream(LANGUAGE_PATH))
        )
        {
            object.writeObject(language);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static TablesLabels getTablesLabels () {
        TablesLabels tablesLabels;
        try(
                var object = new ObjectInputStream(new FileInputStream(TABLE_LABELS))
        )
        {
        tablesLabels= (TablesLabels) object.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
      return tablesLabels;
    }
    private static void safeTableLabels() {
        try(
                var object = new ObjectOutputStream(new FileOutputStream(TABLE_LABELS))
        )
        {
            object.writeObject(new TablesLabels(TablesLabels.basicBreakfastName,TablesLabels.basicBrunchName,
                    TablesLabels.basicLunchName, TablesLabels.basicSupperName,
                    TablesLabels.basicBreakfastTime, TablesLabels.basicBrunchTime,
                    TablesLabels.basicLunchTime,TablesLabels.basicSupperTime));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
