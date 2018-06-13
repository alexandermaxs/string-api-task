package com.epam.task2;

import com.epam.task2.composite.Box;
import com.epam.task2.composite.Unit;
import com.epam.task2.parser.ParagraphParser;
import com.epam.task2.parser.SentenceParser;
import com.epam.task2.parser.WordParser;
import com.epam.task2.util.Eraser;
import com.epam.task2.util.HitRegister;
import com.epam.task2.util.TextUtility;

public class Starter {
    public static void main(String[] args){
        TextUtility textUtility = new TextUtility();
        Box text = new Box();
        text.add(new Unit(textUtility.readFile("documents/text.txt")));
        ParagraphParser h1 = new ParagraphParser();
        SentenceParser h2 = new SentenceParser();
        WordParser h3 = new WordParser();
        h1.setNextParser(h2);
        h2.setNextParser(h3);
        text = h1.parse(text);
        textUtility.writeToFile(text.print(), "documents/output/new_text.txt");
        String task11 = textUtility.readFile("documents/exampleFor10And11.txt");
        textUtility.writeToFile(Eraser.execute(task11),"documents/output/result11.txt");
        textUtility.writeToFile(HitRegister.info(task11), "documents/output/result10.txt");
    }
}