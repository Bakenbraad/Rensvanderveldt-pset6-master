package com.example.rens.rensvanderveldt_pset6;

/**
 * Created by Rens on 09/12/2016.
 */

public class Regio {

    String name = null;
    boolean select = false;

    public Regio(String title, boolean selected) {
        super();
        name = title;
        select = selected;
    }

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return select;
    }

    public void setSelected(boolean selected) {
        this.select = selected;
    }
}