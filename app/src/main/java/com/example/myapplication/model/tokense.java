package com.example.myapplication.model;

import java.util.ArrayList;
import java.util.List;

public class tokense {
    String timing;
    long timeadded;
    ArrayList<String> toke;

    public tokense() {
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public long getTimeadded() {
        return timeadded;
    }

    public void setTimeadded(long timeadded) {
        this.timeadded = timeadded;
    }

    public ArrayList<String> getToke() {
        return toke;
    }

    public void setToke(ArrayList toke) {
        this.toke = (ArrayList) toke;
    }
}
