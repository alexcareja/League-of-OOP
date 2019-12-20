package angels;

import heroes.*;
import map.LandType;
import visitor_pattern.Visitor;

public class DarkAngel extends Angel implements Visitor {

    @Override
    public void visit(Knight hero, LandType land) {

    }

    @Override
    public void visit(Pyromancer hero, LandType land) {

    }

    @Override
    public void visit(Wizard hero, LandType land) {

    }

    @Override
    public void visit(Rogue hero, LandType land) {

    }

    @Override
    void printAngel() {
        System.out.print("DarkAngel hit ");
    }
}
