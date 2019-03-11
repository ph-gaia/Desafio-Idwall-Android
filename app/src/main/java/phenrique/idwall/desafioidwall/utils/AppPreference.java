package phenrique.idwall.desafioidwall.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import phenrique.idwall.desafioidwall.data.model.User;

public class AppPreference {

    public static final String LOGGED_STATUS = "logged_status";
    public static final String TOKEN_AUTH = "token_auth";
    public static final String EMAIL_USER = "email_user";

    static SharedPreferences getPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    /**
     * Set the Login Status
     * @param context
     * @param loggedIn
     */
    public static void setLoggedIn(Context context, boolean loggedIn) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putBoolean(LOGGED_STATUS, loggedIn);
        editor.apply();
    }

    /**
     * Set the Token autentication
     * @param context
     * @param token
     */
    public static void setTokenAuth(Context context, String token) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putString(TOKEN_AUTH, token);
        editor.apply();
    }

    /**
     * Set the Email autentication
     * @param context
     * @param email
     */
    public static void setEmailUser(Context context, String email) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putString(EMAIL_USER, email);
        editor.apply();
    }

    public static void setSaveUser(Context context, User user) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putString(EMAIL_USER, user.getEmail());
        editor.putString(TOKEN_AUTH, user.getToken());
        editor.putBoolean(LOGGED_STATUS, true);
        editor.apply();
    }

    public static void logout(Context context) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.clear();
        editor.commit();
    }

    public static boolean getLoggedStatus(Context context) {
        return getPreferences(context).getBoolean(LOGGED_STATUS, false);
    }

    public static String getTokenAuth(Context context) {
        return getPreferences(context).getString(TOKEN_AUTH,"");
    }

    public static String getEmailUser(Context context) {
        return getPreferences(context).getString(EMAIL_USER,"");
    }
}
