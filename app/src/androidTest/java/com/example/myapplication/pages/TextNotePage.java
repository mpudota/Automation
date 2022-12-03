package com.example.myapplication.pages;

import android.util.Log;

import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

import com.example.myapplication.BasePage;

/**
 * This class contains all the helper functions and selector from
 * CheckList Page that opens when user clicks on Text note in home page.
 *
 */
public class TextNotePage extends BasePage {

    private static final String LOG_TAG = TextNotePage.class.getName();

    UiObject title = findViewById("detail_title");
    UiObject content = findViewById("detail_content");
    UiObject navBack = device.findObject(new UiSelector()
            .descriptionContains("drawer open"));
    UiObject moreOptions = device.findObject(new UiSelector()
            .descriptionContains("More options"));
    UiObject trash = device.findObject(new UiSelector()
            .text("Trash"));
    UiObject addReminder = findViewById("datetime");

    // Verifies basic views before performing any actions or assertions.
    public TextNotePage() {
        title.exists();
        content.exists();
        addReminder.exists();
    }

    public void enterTitle(String textTitle) {
        try {
            title.setText(textTitle);
        } catch (UiObjectNotFoundException e) {
            Log.e(LOG_TAG, e.getMessage());
        }
    }

    public void enterContent(String textContent) {
        try {
            content.setText(textContent);
        } catch (UiObjectNotFoundException e) {
            Log.e(LOG_TAG, e.getMessage());
        }
    }

    public void pressNavBack() {
        try {
            navBack.click();
        } catch (UiObjectNotFoundException e) {
            Log.e(LOG_TAG, e.getMessage());
        }
    }

    public void clickOnMoreOptions() {
        try {
            moreOptions.click();
        } catch (UiObjectNotFoundException e) {
            Log.e(LOG_TAG, e.getMessage());
        }
    }

    public void clickOnTrash() {
        try {
            trash.click();
        } catch (UiObjectNotFoundException e) {
            Log.e(LOG_TAG, e.getMessage());
        }
    }

    public void clickOnAddReminder() {
        try {
            addReminder.click();
        } catch (UiObjectNotFoundException e) {
            Log.e(LOG_TAG, e.getMessage());
        }
    }

    public void verifyDateTimePickerWindow() {
        datePicker.exists();
        timePicker.exists();
        cancelButton.exists();
        okButton.exists();
    }

    public void clickOkToDateTimePicker() {
        try {
            okButton.click();
        } catch (UiObjectNotFoundException e) {
            Log.e(LOG_TAG, e.getMessage());
        }
    }
}
