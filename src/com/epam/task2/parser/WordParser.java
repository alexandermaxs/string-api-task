package com.epam.task2.parser;

import com.epam.task2.composite.Box;
import com.epam.task2.composite.Unit;
import com.epam.task2.composite.Printable;
import com.epam.task2.util.RegexConfigurator;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser extends BaseParser {
    private RegexConfigurator regex = RegexConfigurator.invoke("regex");

    @Override
    public Box parse(Box b){
        List<Printable> words = new ArrayList<>();
        String word = regex.getString("word");
        for (Printable p: b.getParts()) {
            Pattern wordPattern = Pattern.compile(word);
            Matcher matcher = wordPattern.matcher(p.print());
            while (matcher.find()) {
                words.add(new Unit(matcher.group()));
            }
        }
        b.setParts(words);
        return b;
    }
}
