package model;

import utils.Utilities;

public class Game {

    private String title;

    private String publisher;

    private String description;

    private String orginalDeveloper;

    private String orginalMachine;

    private int yearReleased;

    private String coverArt;

    public Game(String title, String publisher, String description, String orginalDeveloper, String orginalMachine, int yearReleased, String coverArt) {
        this.title = title;
        this.publisher = publisher;
        this.description = description;
        this.orginalDeveloper = orginalDeveloper;
        this.orginalMachine = orginalMachine;
        this.yearReleased = yearReleased;
        this.coverArt = coverArt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title.length()<=35)
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        if (Utilities.validStringlength(publisher, 25)) {
            this.publisher = publisher;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (Utilities.validStringlength(description, 25)) {
            this.description = description;
        }
    }

    public String getOrginalDeveloper() {

        return orginalDeveloper;
    }

    public void setOrginalDeveloper(String orginalDeveloper) {
        if (Utilities.validStringlength(orginalDeveloper, 25)) {
            this.orginalDeveloper = orginalDeveloper;
        }
    }

    public String getOrginalMachine() {
        return orginalMachine;
    }

    public void setOrginalMachine(String orginalMachine) {
        if (Utilities.validStringlength(orginalMachine, 25)) {
            this.orginalMachine = orginalMachine;
        }
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(int yearReleased) {
        if (Utilities.validRange(yearReleased, 1958, 2023)) {
            this.yearReleased = yearReleased;
        }
    }

    public String getCoverArt() {
        return coverArt;
    }

    public void setCoverArt(String coverArt) {
        this.coverArt = coverArt;
    }

    @Override
    public String toString() {
        return "";
    }
}