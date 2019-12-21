package angels;

import visitor_pattern.Visitor;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public abstract class Angel extends Observable implements Visitor {
    ArrayList<Observer> observers = new ArrayList<>();

    @Override
    public synchronized void addObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void notifyObservers(Object arg) {
        for(Observer o : this.observers) {
            o.update(this, arg);
        }
    }

    public abstract String getAngelType();
    public abstract String getAction();
}
