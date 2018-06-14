package com.epam.task2.util;

import com.epam.task2.entity.HitEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HitRegister {
    private static RegexConfigurator regex = RegexConfigurator.invoke("regex");
    private static String wordListPath = "documents/wordList10.txt";

    public static String info(String content){
        TextUtility text = new TextUtility();
        List<String> sentences = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex.getString("sentence"));
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            sentences.add(matcher.group());
        }
        List<HitEntity> wordList = new ArrayList<>();
        pattern = Pattern.compile(regex.getString("lexeme"));
        matcher = pattern.matcher(text.readFile(wordListPath));
        while (matcher.find()) {
            wordList.add(new HitEntity(matcher.group()));
        }
        StringBuilder info = new StringBuilder("");
        for (String s: sentences) {
            List<String> list = new ArrayList<>();
            matcher = pattern.matcher(s);
            while (matcher.find()) {
                list.add(matcher.group());
            }
            for (HitEntity h: wordList) {
                int count = 0;
                for (String w: list) {
                    if (h.getContent().equalsIgnoreCase(w)) {
                        count++;
                    }
                }
                h.setCount(count);
            }
            Collections.sort(wordList);
            Collections.reverse(wordList);
            for (HitEntity h: wordList) {
                info.append(h.getContent());
                info.append(" ");
                info.append(h.getCount());
                info.append("\n");
            }
        }
        return info.toString();
    }
}
