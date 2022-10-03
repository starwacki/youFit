package io;

import model.language.Language;

import java.io.*;

public class LanguageIO {


    public static void safeLanguageVersion(Language language) {
        try(
                var object = new ObjectOutputStream(new FileOutputStream("language.obj"))
        )
        {
            object.writeObject(language);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Language getLanguageVersion() {
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
    public static void setLanguageApp() {
        Language.language = getLanguageVersion().getLanguageLanguage();
    }
    public static void safeLanguageApp() {
        Language.language = getLanguageVersion().getLanguageLanguage();
        safeLanguageVersion(new Language());
    }
}
