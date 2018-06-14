package com.epam.task2.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Eraser {
    private static RegexConfigurator regex = RegexConfigurator.invoke("regex");

    public static String execute(String content){
        String sentence = regex.getString("sentence");
        Pattern sentencePattern = Pattern.compile(sentence);
        Matcher matcher = sentencePattern.matcher(content);
        List<String> sentences = new ArrayList<>();
        while (matcher.find()) {
            sentences.add(matcher.group());
        }
        String substring = regex.getString("lexeme");
        Pattern substringPattern = Pattern.compile(substring);
        StringBuilder text = new StringBuilder("");
        for (String s: sentences){
            matcher = substringPattern.matcher(s);
            String max = "";
            while (matcher.find()) {
                if (matcher.group().length() >= max.length()) {
                    max = matcher.group();
                }
            }
            s = s.replace(max,"");
            text.append(s);
        }
        return text.toString();
    }
}
