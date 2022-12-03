package com.example.myapplication.pages;

import static org.junit.Assert.assertNotEquals;

import android.util.Log;

import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;

import com.example.myapplication.BasePage;


public class HomePage extends BasePage {

    public final String TAG = HomePage.class.getName();

    UiObject addNotesIcon = findViewById("fab_expand_menu_button");
    UiObject nothingHereText = findViewById("empty_list");
    UiObject checkListIcon = findViewById("fab_checklist");
    UiObject textNoteIcon = findViewById("fab_note");
    UiObject photoIcon = findViewById("fab_camera");
    UiObject noteTitle = findViewById("note_title");
    UiObject noteContent = findViewById("note_content");
    UiObject reminderMessage = findViewById("datetime");
    UiObject reminderIcon = findViewById("reminder_icon");

    public void clickOnAddNotes() {
        try {
            addNotesIcon.click();
        } catch (UiObjectNotFoundException e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public void verifyEmptyState() {
        try {
            nothingHereText.getText().equals("Nothing here!");
            addNotesIcon.click();
        } catch (UiObjectNotFoundException e) {
            Log.e(TAG, e.getMessage());
        }
        checkListIcon.exists();
        textNoteIcon.exists();
        photoIcon.exists();
        // Cancel the selection and verify the screen falls back to empty state
        try {
            addNotesIcon.click();
            nothingHereText.getText().equals("Nothing here!");
        } catch (UiObjectNotFoundException e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public CheckListPage clickOnCheckListIcon() throws UiObjectNotFoundException {
        try {
            checkListIcon.click();
        } catch (UiObjectNotFoundException e) {
            Log.e(TAG, e.getMessage());
        }
        return new CheckListPage();
    }

    public TextNotePage clickOnTextNoteIcon() {
        try {
            textNoteIcon.click();
        } catch (UiObjectNotFoundException e) {
            Log.e(TAG, e.getMessage());
        }
        return new TextNotePage();
    }

    public void verifyNoteTitle(String title) {
        try {
            noteTitle.getText().equals(title);
        } catch (UiObjectNotFoundException e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public void verifyNoteTitleDoesNotMatch(String title) {
        try {
            assertNotEquals(noteTitle.getText(), title);
        } catch (UiObjectNotFoundException e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public void verifyNoteContentDoesNotMatch(String title) {
        try {
            assertNotEquals(noteContent.getText(), title);
        } catch (UiObjectNotFoundException e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public void verifyContentTitle(String content) {
        try {
            noteContent.getText().equals(content);
        } catch (UiObjectNotFoundException e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public void clickOnTitle() {
        try {
            noteTitle.click();
        } catch (UiObjectNotFoundException e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public void verifyReminder() {
        reminderIcon.exists();
        try {
            reminderMessage.getText().startsWith("Reminder set for");
        } catch (UiObjectNotFoundException e) {
            Log.e(TAG, e.getMessage());
        }
    }

}
