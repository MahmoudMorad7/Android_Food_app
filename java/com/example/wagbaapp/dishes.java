package com.example.wagbaapp;

public class dishes {
    String Icon, Name, Price, ResID,Time;

    public dishes(String icon, String name, String price, String resID, String time) {
        Icon = icon;
        Name = name;
        Price = price;
        ResID = resID;
        Time = time;
    }

    public String getIcon() {
        return Icon;
    }

    public void setIcon(String icon) {
        Icon = icon;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getResID() {
        return ResID;
    }

    public void setResID(String resID) {
        ResID = resID;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public dishes() {
    }
}
