package composite;

public class Lexeme implements Printable {
    private String content;

    public Lexeme(String content){
        this.content = content;
    }

    @Override
    public String print(){
        return content;
    }
}
