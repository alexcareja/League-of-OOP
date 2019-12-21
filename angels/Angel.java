package angels;

import visitor.Visitor;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public abstract class Angel extends Observable implements Visitor {
    private ArrayList<Observer> observers = new ArrayList<>();

    @Override
    public final synchronized void addObserver(final Observer o) {
        this.observers.add(o);
    }

    @Override
    public final void notifyObservers(final Object arg) {
        for (Observer o : this.observers) {
            o.update(this, arg);
        }
    }

    public abstract String getAngelType();
    public abstract String getAction();
}
