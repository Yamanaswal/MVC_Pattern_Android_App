package com.yaman.mvc_pattern_android_app.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class MainModel extends Observable {

    // Declaring a list of integer
    private final List<Integer> list;

    //Initialize
    public MainModel() {
        // reserving the space for list elements
        list = new ArrayList<Integer>(3);

        // adding elements into the list
        list.add(0);
        list.add(0);
        list.add(0);
    }

    // Defining getter and setter functions

    // This function is to return appropriate count value at correct index
    public int getValueAtIndex(final int index) throws IndexOutOfBoundsException {
        return list.get(index);
    }

    // This function is to make changes in the activity button's count value when user touch it
    public void setValueAtIndex(final int index) throws IndexOutOfBoundsException{
        list.set(index, list.get(index) + 1);
        setChanged();
        notifyObservers();
    }
}
