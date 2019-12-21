package angels;

import Utils.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import map.LandType;

public class DamageAngel extends Angel {

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
        return Constants.DAMAGEANGEL;
    }

    @Override
    public String getAction() {
        return Constants.HELPED;
    }
}
