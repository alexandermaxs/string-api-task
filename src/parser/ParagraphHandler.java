package parser;

import composite.Box;
import composite.Leaf;
import composite.Printable;
import io.TextInput;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphHandler extends BaseHandler {
    private BaseHandler next;
    private Box box;

    @Override
    public Box handle(Box b){
        box = b;

        ArrayList<Printable> itrList = new ArrayList<>(box.getParts());
        ArrayList<Printable> recList = new ArrayList<>(box.getParts());

        TextInput input = new TextInput();
        input.readFile("resources/regex_code.properties");
        String code = input.getContent().toString();
        input.flush();
        input.readFile("resources/regex_paragraph.properties");
        String paragraph = input.getContent().toString();

        for (Printable p: itrList) {
            Pattern paragraphPattern = Pattern.compile(paragraph);
            //Pattern codePattern = Pattern.compile(code);
            Matcher ordinary = paragraphPattern.matcher(p.print());
            //Matcher special = codePattern.matcher(p.print());

            Box child = new Box();
            while (ordinary.find()) {
                child.add(new Leaf(ordinary.group()));
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
