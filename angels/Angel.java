package angels;

import visitor_pattern.Visitor;

import java.util.Observable;

public abstract class Angel extends Observable implements Visitor {

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }

    abstract void printAngel();
}
