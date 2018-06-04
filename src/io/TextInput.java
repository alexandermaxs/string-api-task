package io;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class TextInput {
    private StringBuilder content = new StringBuilder("");

    public StringBuilder getContent() {
        return content;
    }

    public void readFile(String path){
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            int i;
            while ((i = br.read()) != -1) {
                this.content.append((char)i);
            }
            br.close();
        } catch (IOException e) {
            //e.printStackTrace();
            // logger catch
        }
    }

    public void flush(){
        this.content = new StringBuilder("");
    }
}
