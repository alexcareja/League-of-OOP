package angels;

import utils.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import map.LandType;
import visitor.Visitor;

public final class GoodBoy extends Angel implements Visitor {

    @Override
    public void visit(final Knight hero, final LandType land) {
        hero.modAngelModifier(Constants.GOOD_BOY_KNIGHT_DMG_GAIN);
        hero.heal(Constants.GOOD_BOY_KNIGHT_HEAL);
    }

    @Override
    public void visit(final Pyromancer hero, final LandType land) {
        hero.modAngelModifier(Constants.GOOD_BOY_PYRO_DMG_GAIN);
        hero.heal(Constants.GOOD_BOY_PYRO_HEAL);
    }

    @Override
    public void visit(final Wizard hero, final LandType land) {
        hero.modAngelModifier(Constants.GOOD_BOY_WIZARD_DMG_GAIN);
        hero.heal(Constants.GOOD_BOY_WIZARD_HEAL);
    }

    @Override
    public void visit(final Rogue hero, final LandType land) {
        hero.modAngelModifier(Constants.GOOD_BOY_ROGUE_DMG_GAIN);
        hero.heal(Constants.GOOD_BOY_ROGUE_HEAL);
    }

    @Override
    public String getAngelType() {
        return Constants.GOODBOY;
    }

    @Override
    public String getAction() {
        return Constants.HELP;
    }
}
