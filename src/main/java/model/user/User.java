package model.user;

import javafx.scene.image.Image;
import java.time.LocalDate;

public class User {
    private static int userID;
    private static  String nickname;
    private static String email;
    private static LocalDate dateOfBirth;
    private static Image image;

    public static int getUserID() {
        return userID;
    }

    public static void setUserID(int userID) {
        User.userID = userID;
    }

    public static String getNickname() {
        return nickname;
    }

    public static void setNickname(String nickname) {
        User.nickname = nickname;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        User.email = email;
    }

    public static LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public static void setDateOfBirth(LocalDate dateOfBirth) {
        User.dateOfBirth = dateOfBirth;
    }

    public static Image getImage() {
        return image;
    }

    public static void setImage(Image image) {
        User.image = image;
    }
}
