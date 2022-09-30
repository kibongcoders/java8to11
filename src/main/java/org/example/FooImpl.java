package org.example;

public class FooImpl implements Bar{

    private String name;

    public FooImpl(String name){
        this.name = name;
    }

    @Override
    public void printName(){
        System.out.println(this.name);
    };

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void printHello(){
        System.out.println("Hello");
    }
}
