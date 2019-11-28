package main;

public interface Visitor {
    void visit(Knight hero);
    void visit(Pyromancer hero);
    void visit(Wizard hero);
    void visit(Rogue hero);
}
