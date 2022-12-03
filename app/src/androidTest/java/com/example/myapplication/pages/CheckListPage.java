package com.example.myapplication.pages;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.util.Log;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

import com.example.myapplication.BasePage;

/**
 * This class contains all the helper functions and selector from
 * CheckList Page that opens when user clicks on Checklist in home page.
 *
 */
public class CheckListPage extends BasePage {

    private final String LOG_TAG = CheckListPage.class.getName();
    UiObject title = findViewById("detail_title");
    UiObject detailContent = findViewById("detail_content");
    // Since there is no better selector to use to find new item and checkbox i'm calling getChild on a superview that has id to it.
    UiObject detailLinearLayout = detailContent.getChild(new UiSelector().index(0)).getChild(new UiSelector().index(0));
    UiObject newItem = detailLinearLayout.getChild(new UiSelector().index(2));
    UiObject checkBox = detailLinearLayout.getChild(new UiSelector().index(1));
    UiObject navBack = device.findObject(new UiSelector()
            .descriptionContains("drawer open"));
    UiObject moreOptions = device.findObject(new UiSelector()
            .descriptionContains("More options"));
    UiObject trash = device.findObject(new UiSelector()
            .text("Trash"));

    // Verifies basic views before performing any actions or assertions.
    public CheckListPage() throws UiObjectNotFoundException {
        title.exists();
        newItem.exists();
        checkBox.exists();
    }

    public void enterTitle(String textTitle) {
        try {
            title.setText(textTitle);
        } catch (UiObjectNotFoundException e) {
            Log.e(LOG_TAG, e.getMessage());
        }
    }

    public void enterNewItem(String newItemText) {
        try {
            newItem.setText(newItemText);
        } catch (UiObjectNotFoundException e) {
            Log.e(LOG_TAG, e.getMessage());
        }
    }

    public void verifyCheckBoxIsNotEnabled() {
        try {
            assertFalse(checkBox.isEnabled());
            assertFalse(checkBox.isChecked());
        } catch (UiObjectNotFoundException e) {
            Log.e(LOG_TAG, e.getMessage());
        }
    }

    public void clickOnCheckBoxAndVerify() {
        try {
            checkBox.click();
            assertTrue(checkBox.isEnabled());
            assertTrue(checkBox.isChecked());
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
}
