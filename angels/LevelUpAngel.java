package angels;

import utils.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import map.LandType;
import visitor.Visitor;

public final class LevelUpAngel extends Angel implements Visitor {

    @Override
    public void visit(final Knight hero, final LandType land) {
        hero.modAngelModifier(Constants.LEVEL_UP_ANGEL_KNIGHT_DMG_GAIN);
        hero.getLeveledUp();
    }

    @Override
    public void visit(final Pyromancer hero, final LandType land) {
        hero.modAngelModifier(Constants.LEVEL_UP_ANGEL_PYRO_DMG_GAIN);
        hero.getLeveledUp();
    }

    @Override
    public void visit(final Wizard hero, final LandType land) {
        hero.modAngelModifier(Constants.LEVEL_UP_ANGEL_WIZARD_DMG_GAIN);
        hero.getLeveledUp();
    }

    @Override
    public void visit(final Rogue hero, final LandType land) {
        hero.modAngelModifier(Constants.LEVEL_UP_ANGEL_ROGUE_DMG_GAIN);
        hero.getLeveledUp();
    }

    @Override
    public String getAngelType() {
        return Constants.LEVELUPANGEL;
    }

    @Override
    public String getAction() {
        return Constants.HELP;
    }
}
