package com.example.myapplication;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.Until;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * Base Test class which will be extended by all the test classes.
 * Contains information that will be shared by all test cases across suite, such as launching the app etc...
 *
 */
@RunWith(AndroidJUnit4.class)
public class BaseTest {

    public static String PACKAGE_NAME = "it.feio.android.omninotes.alpha";
    public static String ACTIVITY_NAME = "it.feio.android.omninotes.MainActivity";
    private static final int LAUNCH_TIMEOUT = 5000;
    private UiDevice device;
    private static final String KILL_ALL_APPS = "am kill-all";

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() {
        device = UiDevice.getInstance(getInstrumentation());

        // Start from the home screen
        device.pressHome();

        // Launch the app
        Context context = getApplicationContext();
        final Intent intent = new Intent();
        intent.setComponent(new ComponentName(PACKAGE_NAME, ACTIVITY_NAME));
//         Clear out any previous instances
        intent.addCategory(Intent.CATEGORY_LAUNCHER);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        // Wait for the app to appear
        device.wait(Until.hasObject(By.pkg(PACKAGE_NAME).depth(0)),
                LAUNCH_TIMEOUT);
    }

    private String getLauncherPackageName() {
        // Create launcher Intent
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);

        // Use PackageManager to get the launcher package name
        PackageManager pm = getApplicationContext().getPackageManager();
        ResolveInfo resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return resolveInfo.activityInfo.packageName;
    }

    @After
    public void cleanUp() {
        BasePage basePage = new BasePage();
        basePage.runCommand(KILL_ALL_APPS);
    }
}