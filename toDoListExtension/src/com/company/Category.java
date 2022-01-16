package com.company;

public enum Category {
  RED("\033[0;31m"), WHITE("\033[0;37m"), BLUE("\033[0;34m"), PURPLE("\033[0;35m"), YELLOW("\033[0;33m"), GREEN("\033[0;32m");

    private String colour;
    public String getColour() {
        return this.colour;
    }


    Category(String colour) {
        this.colour = colour;
    }


}
