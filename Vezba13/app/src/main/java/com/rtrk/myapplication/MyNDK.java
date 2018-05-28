package com.rtrk.myapplication;

/**
 * Created by student on 28.5.2018.
 */

public class MyNDK {

    static {
        System.loadLibrary("MyLibrary");
    }

    public native int increment(int x);
}
