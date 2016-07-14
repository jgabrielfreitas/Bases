package com.jgabrielfreitas.core.util;

/**
 * Created by JGabrielFreitas on 13/07/16.
 */
public class LogUtil {

    public static void logException(Throwable e) {

        try {

            e.printStackTrace();

        }
        catch (Exception ex) {

            ex.printStackTrace();
        }
    }

}
