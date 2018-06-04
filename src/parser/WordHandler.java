package parser;

import composite.Box;

public class WordHandler extends BaseHandler{
    private BaseHandler next;
    private Box box;

    @Override
    public Box handle(Box b){
        System.out.println("Word worked");
        return b;
    }
}
