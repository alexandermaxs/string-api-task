package parser;

import composite.Box;

public abstract class BaseHandler {
    private BaseHandler next;
    private Box box;

    public void setNext(BaseHandler h) {
        this.next = h;
    }

    public Box handle(Box b) {
        this.box = b;
        return this.box;
    }

    public Box doChain(Box b){
        this.box = handle(b);
        if (next != null)
            next.doChain(b);
        return this.box;
    }
}
