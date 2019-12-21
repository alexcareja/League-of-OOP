package angels;

import utils.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import map.LandType;
import visitor.Visitor;

public final class SmallAngel extends Angel implements Visitor {

    @Override
    public void visit(final Knight hero, final LandType land) {
        hero.modAngelModifier(Constants.SMALL_ANGEL_KNIGHT_DMG_GAIN);
        hero.heal(Constants.SMALL_ANGEL_KNIGHT_HEAL);
    }

    @Override
    public void visit(final Pyromancer hero, final LandType land) {
        hero.modAngelModifier(Constants.SMALL_ANGEL_PYRO_DMG_GAIN);
        hero.heal(Constants.SMALL_ANGEL_PYRO_HEAL);
    }

    @Override
    public void visit(final Wizard hero, final LandType land) {
        hero.modAngelModifier(Constants.SMALL_ANGEL_WIZARD_DMG_GAIN);
        hero.heal(Constants.SMALL_ANGEL_WIZARD_HEAL);
    }

    @Override
    public void visit(final Rogue hero, final LandType land) {
        hero.modAngelModifier(Constants.SMALL_ANGEL_ROGUE_DMG_GAIN);
        hero.heal(Constants.SMALL_ANGEL_ROGUE_HEAL);
    }

    @Override
    public String getAngelType() {
        return Constants.SMALLANGEL;
    }

    @Override
    public String getAction() {
        return Constants.HELP;
    }
}
