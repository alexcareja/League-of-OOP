package angels;

import utils.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import map.LandType;
import visitor.Visitor;

public final class LifeGiver extends Angel implements Visitor {

    @Override
    public void visit(final Knight hero, final LandType land) {
        hero.heal(Constants.LIFE_GIVER_KNIGHT_HEAL);
    }

    @Override
    public void visit(final Pyromancer hero, final LandType land) {
        hero.heal(Constants.LIFE_GIVER_PYRO_HEAL);
    }

    @Override
    public void visit(final Wizard hero, final LandType land) {
        hero.heal(Constants.LIFE_GIVER_WIZARD_HEAL);
    }

    @Override
    public void visit(final Rogue hero, final LandType land) {
        hero.heal(Constants.LIFE_GIVER_ROGUE_HEAL);
    }

    @Override
    public String getAngelType() {
        return Constants.LIFEGIVER;
    }

    @Override
    public String getAction() {
        return Constants.HELP;
    }
}
