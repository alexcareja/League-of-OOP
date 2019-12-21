package angels;

import utils.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import map.LandType;
import visitor.Visitor;

public final class Spawner extends Angel implements Visitor {

    @Override
    public void visit(final Knight hero, final LandType land) {
        hero.revive(Constants.SPAWNER_KNIGHT_REVIVE_HP);
    }

    @Override
    public void visit(final Pyromancer hero, final LandType land) {
        hero.revive(Constants.SPAWNER_PYRO_REVIVE_HP);
    }

    @Override
    public void visit(final Wizard hero, final LandType land) {
        hero.revive(Constants.SPAWNER_WIZARD_REVIVE_HP);
    }

    @Override
    public void visit(final Rogue hero, final LandType land) {
        hero.revive(Constants.SPAWNER_ROGUE_REVIVE_HP);
    }

    @Override
    public String getAngelType() {
        return Constants.SPAWNER;
    }

    @Override
    public String getAction() {
        return Constants.HELP;
    }
}
