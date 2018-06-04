package composite;

import java.util.ArrayList;
import java.util.List;

public class Box implements Printable {
    private List<Printable> parts = new ArrayList<>();

    @Override
    public String print(){
        StringBuilder s = new StringBuilder("");
        for(Printable p: parts)
            s.append(p.print());
        return s.toString();
    }

    public void add(Printable p){
        parts.add(p);
    }

    public void remove(int index){
        parts.remove(index);
    }

    public List<Printable> getParts() {
        return parts;
    }

    public void setParts(List parts) {
        this.parts = parts;
    }
}
