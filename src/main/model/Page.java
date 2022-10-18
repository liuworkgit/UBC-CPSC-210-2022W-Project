package model;

// Represents a page with an id, paragraphs (text) and links to other pages

// (METHOD CREATED) As a user, I want to be able to create a new page and have it be added to my list of existing pages.
//- Page (represents an empty page)
//- ListOfPages (represents an empty list of note pages)
//
// As a user, I want to be able to highlight text.
//- highlighter? idk
//
//As a user, I want to be able to type and delete text.
//- functionality in page?
//
//As a user, I want to be able to create a hyperlink between a word and another page, or between two pages.
//- functionality in page? (ask TA)

import java.util.ArrayList;
import java.util.List;

public class Page {
    private String name;
    private List<Paragraph> listParagraphs;
    private List<String> listLinks; // LINK TO PAGE AND PARAGRAPH+PAGE IT'S IN, save as list strings of name or name|id

    // REQUIRES: name must not be empty
    // EFFECTS: creates a page with no paragraphs and links
    public Page(String name) {
        this.name = name;
        this.listParagraphs = new ArrayList<>();
        this.listLinks = new ArrayList<>();
    }

    // REQUIRES: text cannot be an empty string
    // MODIFIES: this
    // EFFECTS: adds a paragraph to the bottom of the page
    public void addParagraph(String text) {
        listParagraphs.add(new Paragraph(text));
    }

    // MODIFIES: this
    // EFFECTS: deletes a paragraph from the page
    public void deleteParagraph(int index) {
        listParagraphs.remove(index);
    }

    // MODIFIES: this
    // EFFECTS: edits an existing paragraph by rewriting it
    public void editParagraph(int index) {
        
    }

    // REQUIRES: a page must exist and have the given name
    // MODIFIES: this
    // EFFECTS: adds a link to the page
    public void addLink(String name) {
        if (listLinks.contains(name)) {
            System.out.println("You already have a page named " + name);
        } else {
            listLinks.add(name);
        }
    }

    // MODIFIES: this
    // EFFECTS: deletes a link from the page
    public void deleteLink(int index) {
        listLinks.remove(index);
    }


    // getters and setters

    public String getName() {
        return name;
    }

    public void changeName(String newName) {
        this.name = newName;
    }

    public List<Paragraph> getListParagraphs() {
        return listParagraphs;
    }

    public List<String> getListLinks() {
        return listLinks;
    }
}
