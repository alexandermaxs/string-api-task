import composite.Box;
import composite.Lexeme;
import util.TextInput;
import parser.ParagraphParser;

public class Starter {
    public static void main(String[] args){
        TextInput textInput = new TextInput();
        textInput.readFile("example.txt");
        // path from file_path.properties
        //System.out.println(textInput.getContent());
        //input text from file
        Box box = new Box();
        box.add(new Lexeme(textInput.getContent().toString()));
        //
        ParagraphParser h1 = new ParagraphParser();
        /*
        SentenceParser h2 = new SentenceParser();
        WordParser h3 = new WordParser();
        h1.setNext(h2);
        h2.setNext(h3);
        h1.doChain(box);
        */
        box = h1.handle(box);
        System.out.println(box.getParts().size());
        /*baseBox.add(new Lexeme("leaf1 "));
        baseBox.add(new Lexeme(" leaf2 "));
        baseBox.add(new Lexeme(" leaf3"));
        System.out.println(baseBox.print());*/
        // try-catch logger
        // reconstruct output
    }
}
