package com.pair;

public class Pair{
    String el1;
    String el2;

    public Pair(String l, String n) {
        this.el1 = l;
        this.el2 = n;
    }

    public String glue() {
        return el1 + el2;
    }

    public String getEl1() {
        return el1;
    }

    public void setEl1(String el1) {
        this.el1 = el1;
    }

    public String getEl2() {
        return el2;
    }

    public void setEl2(String el2) {
        this.el2 = el2;
    }
}