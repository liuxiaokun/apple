package com.fred.apple.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.io.File;
import java.io.PrintWriter;

/**
 * @author Fred Liu(liuxiaokun0410@gmail.com)
 * @version 1.0
 * @since 2015/9/18
 */
public class UpgradeUtil {

    private static final int SUCCESS = 0;
    private static final int FAIL = 1;

    public static boolean install(String apkPath, Context context) {

        if (hasRootPerssion()) {
            return clientInstall(apkPath);
        } else {
            File file = new File(apkPath);

            if (!file.exists())
                return false;
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            context.startActivity(intent);
            return true;
        }
    }

    private static boolean clientInstall(String apkPath) {

        PrintWriter PrintWriter;
        Process process = null;

        try {
            process = Runtime.getRuntime().exec("su");
            PrintWriter = new PrintWriter(process.getOutputStream());
            PrintWriter.println("chmod 777 " + apkPath);
            PrintWriter.println("export LD_LIBRARY_PATH=/vendor/lib:/system/lib");
            PrintWriter.println("pm install -r " + apkPath);
            PrintWriter.flush();
            PrintWriter.close();
            int value = process.waitFor();

            return returnResult(value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (process != null) {
                process.destroy();
            }
        }
        return false;
    }

    private static boolean hasRootPerssion() {
        PrintWriter PrintWriter = null;
        Process process = null;

        try {
            process = Runtime.getRuntime().exec("su");
            PrintWriter = new PrintWriter(process.getOutputStream());
            PrintWriter.flush();
            PrintWriter.close();
            int value = process.waitFor();
            return returnResult(value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (process != null) {
                process.destroy();
            }
        }
        return false;
    }

    private static boolean returnResult(int value) {
        boolean result = false;

        if (value == SUCCESS) {
            result = true;
        }

        return result;
    }
}
