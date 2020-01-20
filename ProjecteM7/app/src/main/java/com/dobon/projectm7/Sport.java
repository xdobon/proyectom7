package com.dobon.projectm7;

public class Sport {
    // Member variables representing the title and information about the sport.
    private String title;
    private String info;
    private final int imageResource; //Afegim atribut de tipus int que guardara el recurs de tipus drawable.
    /**
     * Constructor for the Sport data model.
     *
     * @param title The name if the sport.
     * @param info Information about the sport.
     */
    public Sport(String title, String info, int imageResource) {
        this.title = title;
        this.info = info;
        this.imageResource=imageResource; //L'afegim al constructor.
    }

    /**
     * Gets the title of the sport.
     *
     * @return The title of the sport.
     */
    String getTitle() {
        return title;
    }

    /**
     * Gets the info about the sport.
     *
     * @return The info about the sport.
     */
    String getInfo() {
        return info;
    }

    public int getImageResource() { //Creem el seu getter.
        return imageResource;
    }
}
