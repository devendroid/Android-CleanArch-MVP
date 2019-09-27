package com.devs.android_cleanarch_mvp.presentation.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.MediaColumns;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Utilities {

    private static final String TAG = Utilities.class.getSimpleName();
        private ConnectivityManager cm;
        private static Context context;

    private static Utilities singleton = null;

    /* A private Constructor prevents any other
     * class from instantiating.
     */
    private Utilities() {}

    /* Thread safe approach but reduces the performance */
//    public static synchronized Utilities getInstance(Context mContext) {
//        context = mContext;
//        if (singleton == null)
//            singleton = new Utilities();
//        return singleton;
//    }

    /* Thread safe approach with better performance */
     public static Utilities getInstance(Context mContext) {
         context = mContext.getApplicationContext();
         if( singleton == null ){
             synchronized (Utilities.class) {
                 singleton = new Utilities();
             }
         }
         return singleton;
     }

    /**
     * Method for checking network availability
     */
    public boolean isNetworkAvailable() {
        try {
            cm = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            // if no network is available networkInfo will be null
            // otherwise check if we are connected
            if (networkInfo != null && networkInfo.isConnected())
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
    To verify if the device is actually connected to the internet, we can use the
    following method of pinging the Google DNS servers to check for the expected exit value:*/
//    public boolean isOnline() {
//        Runtime runtime = Runtime.getRuntime();
//        try {
//            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
//            int     exitValue = ipProcess.waitFor();
//            return (exitValue == 0);
//        } catch (IOException | InterruptedException e)          { e.printStackTrace(); }
//        return false;
//    }

    public  void hideKeyboard(Activity activity) {
        InputMethodManager inputManager = (InputMethodManager) activity
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        // check if no view has focus:
        View v = activity.getCurrentFocus();
        if (v == null)
            return;

        inputManager.hideSoftInputFromWindow(v.getWindowToken(), 0);

    }

//    public void setDeviceDefaultLocality(String country){
//        try {
//            //String language = Locale.getDefault().getCountry();
//            //Log.i("=========","country "+language);
//            Locale myLocale;
//            myLocale = new Locale(country);
//            Resources res = context.getResources();
//            DisplayMetrics dm = res.getDisplayMetrics();
//            Configuration conf = res.getConfiguration();
//            conf.locale = myLocale;
//            res.updateConfiguration(conf, dm);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    /**
     * @return Current installed app version name
     */
    public String getAppVersion() {
        String appVersion = "";
        try {
            appVersion = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return appVersion;
    }

    /**
     * Method for Checking application running on emulator or real device
     */
//    public boolean isAndroidEmulator() {
//        String product = Build.PRODUCT;
//        boolean isEmulator = false;
//        if (product != null) {
//            isEmulator = product.equals("sdk") || product.contains("_sdk")
//                    || product.contains("sdk_");
//        }
//        return isEmulator;
//    }



    public String getCurrentDateTime() {
        try {
            Date currentDate = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            return dateFormat.format(currentDate);
        } catch (Exception e) {
            e.printStackTrace();
            return "2015-01-01 00:00:00";
        }
    }

    public SimpleDateFormat getSimpleDateFormat(String pattern){
        return new SimpleDateFormat(
                pattern, Locale.getDefault());
    }

    /**
     * This method used to create new file if not exist .
     */
    public File getNewFile(String directoryName, String imageName) {
        String root = Environment.getExternalStorageDirectory()
                + directoryName;
        File file;
        if (isSDCARDMounted()) {
            new File(root).mkdirs();
            file = new File(root, imageName);
        } else {
            file = new File(context.getFilesDir(), imageName);
        }
        return file;
    }

    public boolean isSDCARDMounted() {
        String status = Environment.getExternalStorageState();
        if (status.equals(Environment.MEDIA_MOUNTED))
            return true;
        return false;
    }

    public String getAbsolutePath(Uri uri) {
        try {
            String[] projection = {MediaColumns.DATA};
            // Cursor cursor = ((Activity) context).managedQuery(uri, projection,
            // null, null, null);
            Cursor cursor = context.getContentResolver().query(uri, projection,
                    null, null, null);
            if (cursor != null) {
                int column_index = cursor.getColumnIndexOrThrow(MediaColumns.DATA);
                cursor.moveToFirst();
                return cursor.getString(column_index);
            } else
                return null;

        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getSeconds2Minute(int secs){
        int m = secs/60;
        int s = secs%60;
        return m+":"+s;
    }

    private static SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("MMM dd yyyy hh:mm a", Locale.getDefault());
    private static SimpleDateFormat timeFormatter = new SimpleDateFormat("hh:mm a", Locale.getDefault());

    public void toast(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

//    public static void log(String tag, String message) {
//        if(AppConstants.DEBUG_ENABLE)Log.i(tag,message );
//    }

    public void dialogOK(final Context mContext, String title, final String message,
                         String btnText, final boolean isFinish) {
        // https://www.google.com/design/spec/components/dialogs.html#dialogs-specs

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mContext);
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(message);

        alertDialogBuilder.setPositiveButton(btnText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (isFinish) ((Activity) mContext).finish();

            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

//    public void dialogOK(final Context mContext, String title, final String message,
//                         String btnText, final OnDialogOkListener listener) {
//        // https://www.google.com/design/spec/components/dialogs.html#dialogs-specs
//
//        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mContext);
//        alertDialogBuilder.setTitle(title);
//        alertDialogBuilder.setMessage(message);
//
//        alertDialogBuilder.setPositiveButton(btnText, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                listener.onOk();
//            }
//        });
//
//        AlertDialog alertDialog = alertDialogBuilder.create();
//        alertDialog.show();
//    }
//
//    public void dialogConfirm(Context mContext, String title, Spanned message,
//                              String posBtnText, String negBtnText,
//                              final OnDialogConfirmListener listener) {
//        // https://www.google.com/design/spec/components/dialogs.html#dialogs-specs
//
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mContext);
//        alertDialogBuilder.setTitle(title);
//        alertDialogBuilder.setCancelable(false);
//        alertDialogBuilder.setMessage(message);
//
//        alertDialogBuilder.setPositiveButton(posBtnText, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                listener.onYes();
//            }
//        });
//        alertDialogBuilder.setNegativeButton(negBtnText, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                listener.onNo();
//            }
//        });
//
//        AlertDialog alertDialog = alertDialogBuilder.create();
//        alertDialog.setCanceledOnTouchOutside(false);
//        alertDialog.show();
//
//    }

}
