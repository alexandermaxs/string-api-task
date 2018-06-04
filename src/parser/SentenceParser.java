package parser;

import composite.Box;

public class SentenceParser extends BaseParser {
    private BaseParser next;
    private Box box;

    @Override
    public Box handle(Box b) {
        System.out.println("Sentence worked");
        //[^\.\!\?]*[\.\!\?]
        return b;
    }
}
