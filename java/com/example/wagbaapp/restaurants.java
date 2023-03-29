package com.example.wagbaapp;

public class restaurants {
    String Name,Icon;

    public restaurants() {
    }

    public restaurants(String name, String icon) {
        Name = name;
        Icon = icon;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getIcon() {
        return Icon;
    }

    public void setIcon(String icon) {
        Icon = icon;
    }
}
