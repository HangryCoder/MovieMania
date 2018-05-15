package sonia.moviemania.com.moviemania.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by soniawadji on 16/05/18.
 */

public class Utils {

    public static void myLog(String TAG, String message) {
        if (Constants.DEBUG) {
            Log.e(TAG, message);
        }
    }

    public static void myToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
