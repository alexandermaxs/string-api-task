package com.epam.task2.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import java.io.*;

public class TextUtility {
    static Logger logger = Logger.getLogger(TextUtility.class);
    static {
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
    }

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
            logger.error("Error occurred while reading the file.\n", e);
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
            logger.error("Error occurred while writing the file.\n", e);
        }
    }
}
