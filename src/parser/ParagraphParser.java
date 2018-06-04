package parser;

import composite.Box;
import composite.Lexeme;
import composite.Printable;
import util.TextInput;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends BaseParser {
    private BaseParser next;
    private Box box;

    @Override
    public Box handle(Box b){
        box = b;

        List<Printable> itrList = new ArrayList<>(box.getParts());
        List<Printable> recList = new ArrayList<>(box.getParts());

        TextInput input = new TextInput();
        //input.readFile("resources/regex_code.properties");
        //String code = input.getContent().toString();
        //input.flush();
        input.readFile("resources/regex_paragraph.properties");
        String paragraph = input.getContent().toString();

        for (Printable p: itrList) {
            Pattern paragraphPattern = Pattern.compile(paragraph);
            //Pattern codePattern = Pattern.compile(code);
            Matcher ordinary = paragraphPattern.matcher(p.print());
            //Matcher special = codePattern.matcher(p.print());

            Box child = new Box();
            while (ordinary.find()) {
                child.add(new Lexeme(ordinary.group()));
                System.out.println(ordinary.group());
            }
            recList.add(child);
        }

        recList.remove(0);
        box.setParts(recList);
        System.out.println("Paragraph worked");
        return box;
    }
}
