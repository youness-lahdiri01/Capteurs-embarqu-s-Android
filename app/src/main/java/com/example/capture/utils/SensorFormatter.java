package com.example.capture.utils;

import android.hardware.Sensor;

public class SensorFormatter {
    public static String format(Sensor s) {
        return "Nom : " + s.getName() + "\n" +
               "Constructeur : " + s.getVendor() + "\n" +
               "Type ID : " + s.getType() + "\n" +
               "Résolution : " + s.getResolution() + "\n" +
               "Consommation : " + s.getPower() + " mA\n" +
               "Portée Max : " + s.getMaximumRange() + "\n" +
               "---------------------------------";
    }
}
