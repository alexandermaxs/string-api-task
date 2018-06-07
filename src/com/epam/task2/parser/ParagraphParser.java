package com.epam.task2.parser;

import com.epam.task2.composite.Box;
import com.epam.task2.composite.Unit;
import com.epam.task2.composite.Printable;
import com.epam.task2.util.RegexConfigurator;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends BaseParser {
    private RegexConfigurator regex = RegexConfigurator.invoke("regex");

    @Override
    public Box parse(Box b) {
        List<Printable> paragraphs = new ArrayList<>();
        String paragraph = regex.getString("paragraph");
        String code = regex.getString("code");
        for (Printable text: b.getParts()) {
            Pattern paragraphPattern = Pattern.compile(paragraph);
            Matcher matcher = paragraphPattern.matcher(text.print());
            while (matcher.find()) {
                if (Pattern.matches(code, matcher.group())) {
                    paragraphs.add(new Unit(matcher.group()));
                }
                else {
                    Box child = new Box();
                    child.add(new Unit(matcher.group()));
                    child = doChain(child);
                    paragraphs.add(child);
                }
            }
        }
        b.setParts(paragraphs);
        return b;
    }
}
