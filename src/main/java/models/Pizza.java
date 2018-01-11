package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pizza implements Comparable<Pizza> {
    private String name;

    private String orderTime;

    public Pizza(String name, String orderTime) {
        this.name = name;
        this.orderTime = orderTime;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    @Override
    public int compareTo(Pizza o) {
        return name.compareToIgnoreCase(o.name);
    }

    public String getOutputString() {
        return name + " " + orderTime;
    }
}
