package parser;

import composite.Box;

public class WordParser extends BaseParser {
    private BaseParser next;
    private Box box;

    @Override
    public Box handle(Box b){
        System.out.println("Word worked");
        return b;
    }
}
