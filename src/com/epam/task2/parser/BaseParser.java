package com.epam.task2.parser;

import com.epam.task2.composite.Box;

public abstract class BaseParser {
    private BaseParser nextParser;

    public BaseParser setNextParser(BaseParser next) {
        this.nextParser = next;
        return nextParser;
    }

    public Box doChain(Box b) {
        if (nextParser != null)
            return nextParser.parse(b);
        else return b;
    }

    public abstract Box parse(Box b);
}
