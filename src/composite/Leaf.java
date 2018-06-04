package composite;

public class Leaf implements Printable {
    private String content;

    public Leaf(String content){
        this.content = content;
    }

    @Override
    public String print(){
        return content;
    }
}
