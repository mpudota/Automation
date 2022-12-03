package com.example.myapplication.tests;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.uiautomator.UiObjectNotFoundException;

import com.example.myapplication.BaseTest;
import com.example.myapplication.pages.CheckListPage;
import com.example.myapplication.pages.HomePage;
import com.example.myapplication.pages.TextNotePage;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * A test class that contains some functionality automation test cases.
 * These are text notes and checklist functionalities.
 *
 */
@RunWith(AndroidJUnit4.class)
public class HomePageTests extends BaseTest {
    HomePage homePage = new HomePage();
    String note = "Test Note";
    String content = "Test Content";

    // Negative test data

    String noMatchNote = "Note Test";
    String noMatchContent = "Content Test";

    // Verify Empty state
    // Try making and selection and cancel it
    // Verify it falls back to empty state
    @Test
    public void baseTest() {
        homePage.verifyEmptyState();
    }

    // A test that will add a title and content and verify that in home page
    @Test
    public void textNoteText() {
        homePage.clickOnAddNotes();
        TextNotePage textNotePage = homePage.clickOnTextNoteIcon();
        textNotePage.enterTitle(note);
        textNotePage.enterContent(content);
        textNotePage.pressNavBack();
        homePage.verifyNoteTitle(note);
        homePage.verifyContentTitle(content);
        homePage.clickOnTitle();
        textNotePage.clickOnMoreOptions();
        textNotePage.clickOnTrash();
    }

    // A test that will add a title and new item and verify that in home page
    @Test
    public void checkListText() throws UiObjectNotFoundException {
        homePage.clickOnAddNotes();
        CheckListPage checkListPage = homePage.clickOnCheckListIcon();
        checkListPage.enterTitle(note);
        checkListPage.enterNewItem(content);
        checkListPage.pressNavBack();
        homePage.verifyNoteTitle(note);
        homePage.verifyContentTitle(content);
        homePage.clickOnTitle();
        checkListPage.clickOnMoreOptions();
        checkListPage.clickOnTrash();
    }

    // A test that will test check box functionality
    @Test
    public void verifyCheckBoxIsEnabledAndChecked() throws UiObjectNotFoundException {
        homePage.clickOnAddNotes();
        CheckListPage checkListPage = homePage.clickOnCheckListIcon();
        checkListPage.verifyCheckBoxIsNotEnabled();
        checkListPage.enterTitle(note);
        checkListPage.enterNewItem(content);
        checkListPage.pressNavBack();
        homePage.clickOnTitle();
        checkListPage.clickOnCheckBoxAndVerify();
        checkListPage.clickOnMoreOptions();
        checkListPage.clickOnTrash();
    }

    // a Test that will test add reminder functionality.
    @Test
    public void addReminderTest() {
        homePage.clickOnAddNotes();
        TextNotePage textNotePage = homePage.clickOnTextNoteIcon();
        textNotePage.enterTitle(note);
        textNotePage.enterContent(content);
        textNotePage.clickOnAddReminder();
        textNotePage.verifyDateTimePickerWindow();
        textNotePage.clickOkToDateTimePicker();
        textNotePage.pressNavBack();
        homePage.verifyReminder();
        homePage.clickOnTitle();
        textNotePage.clickOnMoreOptions();
        textNotePage.clickOnTrash();
    }

    // Negative test case
    @Test
    public void verifyFalseData() {
        homePage.clickOnAddNotes();
        TextNotePage textNotePage = homePage.clickOnTextNoteIcon();
        textNotePage.enterTitle(note);
        textNotePage.enterContent(content);
        textNotePage.pressNavBack();
        homePage.verifyNoteTitleDoesNotMatch(noMatchNote);
        homePage.verifyNoteContentDoesNotMatch(noMatchContent);
        homePage.clickOnTitle();
        textNotePage.clickOnMoreOptions();
        textNotePage.clickOnTrash();

    }
}
