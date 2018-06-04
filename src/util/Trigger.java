package util;

import composite.Box;
import composite.Leaf;
import parser.ParagraphHandler;
import io.TextInput;

public class Trigger {
    public static void main(String[] args){
        TextInput textInput = new TextInput();
        textInput.readFile("example.txt");
        // path from file_path.properties
        //System.out.println(textInput.getContent());
        //input text from file
        Box box = new Box();
        box.add(new Leaf(textInput.getContent().toString()));
        //
        ParagraphHandler h1 = new ParagraphHandler();
        /*
        SentenceHandler h2 = new SentenceHandler();
        WordHandler h3 = new WordHandler();
        h1.setNext(h2);
        h2.setNext(h3);
        h1.doChain(box);
        */
        box = h1.handle(box);
        System.out.println(box.getParts().size());
        /*baseBox.add(new Leaf("leaf1 "));
        baseBox.add(new Leaf(" leaf2 "));
        baseBox.add(new Leaf(" leaf3"));
        System.out.println(baseBox.print());*/
        // try-catch logger
        // reconstruct output
    }
}
