package com.epam.task2.parser;

import com.epam.task2.composite.Box;
import com.epam.task2.composite.Unit;
import com.epam.task2.composite.Printable;
import com.epam.task2.util.RegexConfigurator;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends BaseParser {
    private RegexConfigurator regex = RegexConfigurator.invoke("regex");

    @Override
    public Box parse(Box b) {
        List<Printable> sentences = new ArrayList<>();
        String sentence = regex.getString("sentence");
        for (Printable p: b.getParts()) {
            Pattern sentencePattern = Pattern.compile(sentence);
            Matcher matcher = sentencePattern.matcher(p.print());
            while (matcher.find()) {
                Box child = new Box();
                child.add(new Unit(matcher.group()));
                child = doChain(child);
                sentences.add(child);
            }
        }
        b.setParts(sentences);
        return b;
    }
}
