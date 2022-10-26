package test;

import model.Page;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PageTest {
    private Page testPage;

    @BeforeEach
    void runBefore() {
        testPage = new Page("Math 200 notes");
    }

    @Test
    void testPage() {
        assertEquals("Math 200 notes", testPage.getName());
        assertEquals(new ArrayList<>(), testPage.getListParagraphs());
        assertEquals(new ArrayList<>(), testPage.getListLinks());
    }

    @Test
    void testAddParagraph() {
        testPage.addParagraph("This is some text, blah blah blah.");
        assertEquals("This is some text, blah blah blah.",
                testPage.getListParagraphs().get(0).getText());
    }

    @Test
    void testDeleteParagraph() {
        testPage.addParagraph("asdfghjk");
        testPage.deleteParagraph(0);
        assertEquals(new ArrayList<>(), testPage.getListParagraphs());
    }

    @Test
    void testAddLink() {
        Page mathNotes = new Page("Math 200 - PDEs");
        testPage.addLink(mathNotes);
        assertEquals(Arrays.asList(mathNotes), testPage.getListLinks());
    }

    @Test
    void testDeleteLink() {
        Page mathNotes = new Page("Math 221 Notes - Basis and Dimension");
        testPage.addLink(mathNotes);
        testPage.deleteLink(0);
        assertEquals(new ArrayList<>(), testPage.getListLinks());
    }

    @Test
    void testChangeName() {
        testPage.setName("CPSC 210 hurts my brain");
        assertEquals("CPSC 210 hurts my brain", testPage.getName());
    }

    @Test
    // tests if can add paragraphs, then delete it
    void testAddThenDelete() {
        testPage.addParagraph("agony pain suffering");
        testPage.deleteParagraph(0);
        assertEquals(new ArrayList<>(), testPage.getListParagraphs());
    }

    @Test
    // tests if can add multiple paragraphs
    void testAddMultiple() {
        testPage.addParagraph("name 1");
        testPage.addParagraph("name 2");
        testPage.addParagraph("name 3");
        assertEquals("name 1", testPage.getListParagraphs().get(0).getText());
        assertEquals("name 2", testPage.getListParagraphs().get(1).getText());
        assertEquals("name 3", testPage.getListParagraphs().get(2).getText());
    }

    @Test
    // tests if can add and delete multiple times
    void testAddMultipleDeleteMultiple() {
        testPage.addParagraph("ABC");
        testPage.addParagraph("DEF");
        testPage.deleteParagraph(0);
        testPage.addParagraph("GHI123");
        testPage.deleteParagraph(1);
        assertTrue("DEF" == testPage.getListParagraphs().get(0).getText());
    }

    @Test
    void testLinkSamePageTwice() {
        Page page1 = new Page("test page");
        testPage.addLink(page1);
        assertEquals(Arrays.asList(page1), testPage.getListLinks());
        testPage.addLink(page1);
        assertEquals(Arrays.asList(page1), testPage.getListLinks());
    }

    @Test
    void testDisplayChoices() {
        testPage.addParagraph("Test");
        testPage.addParagraph("Testing");
        assertEquals("[1] Test" + "\n[2] Testing" + "\n", testPage.displayParagraphs());
    }

    @Test
    void testDisplayLinks() {
        Page link1 = new Page("link1");
        Page link2 = new Page("link2");
        testPage.addLink(link1);
        testPage.addLink(link2);
        assertEquals("[1] link1" + "\n[2] link2" + "\n", testPage.displayLinks());
    }
}