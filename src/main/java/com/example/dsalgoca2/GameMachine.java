package com.example.dsalgoca2;

import com.example.dsalgoca2.utils.Utilities;

public class GameMachine {
    private String name;
    private String manufacturer;

    private String description;
    private String type;
    private String media;
    private int initialLaunchYear;
    private double price;
    private String URL;

    public GameMachine(String name, String manufacturer, String description, String type, String media, int initialLaunchYear, double price, String URL) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.description = description;
        this.type = type;
        this.media = media;
        this.initialLaunchYear = initialLaunchYear;
        this.price = price;
        this.URL = URL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (Utilities.validStringlength(name,20)){
        this.name = name;
        }
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        if (Utilities.validStringlength(manufacturer,20)){
        this.manufacturer = manufacturer;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (Utilities.validStringlength(description,150)){
        this.description = description;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (Utilities.validStringlength(type,20)) {
            this.type = type;
        }
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        if (Utilities.validStringlength(media,20)) {
            this.media = media;
        }
    }

    public int getInitialLaunchYear() {
        return initialLaunchYear;
    }

    public void setInitialLaunchYear(int initialLaunchYear) {
        if (initialLaunchYear >= 1950 && initialLaunchYear <= 2023) {
            this.initialLaunchYear = initialLaunchYear;
        } else {
            System.out.println("Invalid initial launch year");
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
            if (price == 0) {
                System.out.println("Free");
            }
        } else {
            System.out.println("Invalid price"); //where the provided price is negative
        }
    }


    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        if (Utilities.validStringlength(URL,100)) {
            this.URL = URL;
        }
    }
}
