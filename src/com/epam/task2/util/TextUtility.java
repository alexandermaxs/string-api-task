package com.epam.task2.util;

import org.apache.log4j.Logger;
import java.io.*;

public class TextUtility {
    private static final Logger logger = Logger.getLogger(TextUtility.class);

    public String readFile(String filepath){
        StringBuilder content = new StringBuilder("");
        try {
            FileReader in = new FileReader(filepath);
            BufferedReader br = new BufferedReader(in);
            int i;
            while ((i = br.read()) != -1) {
                content.append((char)i);
            }
            br.close();
        } catch (IOException e) {
            logger.error("Error occurred while reading the file.", e);
        }
        return content.toString();
    }

    public void writeToFile(String content, String filepath){
        try {
            FileWriter out = new FileWriter(filepath);
            BufferedWriter bw = new BufferedWriter(out);
            PrintWriter pw = new PrintWriter(bw);
            pw.append(content);
            pw.close();
        } catch (IOException e) {
            logger.error("Error occurred while writing the file.", e);
        }
    }
}
