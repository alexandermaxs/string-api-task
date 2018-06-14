package com.epam.task2.entity.composite;

public class Unit implements Printable {
    private String content;

    public Unit(String content){
        this.content = content;
    }

    @Override
    public String print(){
        return content;
    }
}
