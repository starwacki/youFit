package model.user;
import java.time.LocalDate;

public class User {
    private static int userID;

    private static  String nickname;

    private static String email;

    private static LocalDate dateOfBirth;

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
}
