package org.example;

public class FunctionalInterFace {

    public void doFunction(){
        BookInterFace bookInterFace = number -> number + 10;

        System.out.println(bookInterFace.doInit(10));
    }
}
