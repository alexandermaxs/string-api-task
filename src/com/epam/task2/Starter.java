package com.epam.task2;

import com.epam.task2.entity.composite.Box;
import com.epam.task2.entity.composite.Unit;
import com.epam.task2.parser.ParagraphParser;
import com.epam.task2.parser.SentenceParser;
import com.epam.task2.parser.WordParser;
import com.epam.task2.util.Eraser;
import com.epam.task2.util.HitRegister;
import com.epam.task2.util.TextUtility;

public class Starter {
    private static String textPath = "documents/text.txt";
    private static String outputTextPath = "documents/output/new_text.txt";
    private static String examplePath = "documents/exampleFor10And11.txt";
    private static String result10 = "documents/output/result10.txt";
    private static String result11 = "documents/output/result11.txt";

    public static void main(String[] args){
        TextUtility textUtility = new TextUtility();
        Box text = new Box();
        text.add(new Unit(textUtility.readFile(textPath)));
        ParagraphParser h1 = new ParagraphParser();
        SentenceParser h2 = new SentenceParser();
        WordParser h3 = new WordParser();
        h1.setNextParser(h2);
        h2.setNextParser(h3);
        text = h1.parse(text);
        textUtility.writeToFile(text.print(), outputTextPath);
        String task11 = textUtility.readFile(examplePath);
        textUtility.writeToFile(Eraser.execute(task11),result11);
        textUtility.writeToFile(HitRegister.info(task11), result10);
    }
}