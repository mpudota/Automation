package com.example.myapplication;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiSelector;

/**
 * Base Page class which will be extended by all the Page classes.
 * Contains information that will be shared by all page cases across suite
 * May contains some common functions and selector.
 *
 */
public class BasePage {

   public UiDevice device = UiDevice.getInstance(getInstrumentation());
   public static String APP_PKG = "it.feio.android.omninotes.alpha";
   // Adding them here because these are common across few page classes.
   public UiObject datePicker =  findViewById("datePicker");
   public UiObject timePicker = findViewById("timePicker");
   public UiObject cancelButton = findViewById("buttonNegative");
   public UiObject okButton = findViewById("buttonPositive");

    /**
     * Helper function to run some adb commands on the go.
     * @param command adb command to run.
     */
    public void runCommand(String command) {
        getInstrumentation().getUiAutomation().executeShellCommand(command);
    }

    public UiObject findViewById(String resId) {
        return device.findObject(new UiSelector().resourceId(APP_PKG + ":id/" + resId));
    }
}
