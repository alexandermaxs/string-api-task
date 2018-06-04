package composite;

import java.util.ArrayList;

public class Box implements Printable {
    private ArrayList<Printable> parts = new ArrayList<>();

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

    public ArrayList<Printable> getParts() {
        return parts;
    }

    public void setParts(ArrayList<Printable> parts) {
        this.parts = parts;
    }
}
