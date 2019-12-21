package angels;

import Utils.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import map.LandType;
import visitor_pattern.Visitor;

public class LifeGiver extends Angel implements Visitor {

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
    public String getAngelType() {
        return Constants.LIFEGIVER;
    }

    @Override
    public String getAction() {
        return Constants.HELPED;
    }
}
