package parser;

import composite.Box;

public class SentenceHandler extends BaseHandler {
    private BaseHandler next;
    private Box box;

    @Override
    public Box handle(Box b) {
        System.out.println("Sentence worked");
        //[^\.\!\?]*[\.\!\?]
        return b;
    }
}
