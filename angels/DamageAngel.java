package angels;

import utils.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import map.LandType;

public final class DamageAngel extends Angel {

    @Override
    public void visit(final Knight hero, final LandType land) {
        hero.modAngelModifier(Constants.DAMAGE_ANGEL_KNIGHT_DMG_GAIN);
    }

    @Override
    public void visit(final Pyromancer hero, final LandType land) {
        hero.modAngelModifier(Constants.DAMAGE_ANGEL_PYRO_DMG_GAIN);
    }

    @Override
    public void visit(final Wizard hero, final LandType land) {
        hero.modAngelModifier(Constants.DAMAGE_ANGEL_WIZARD_DMG_GAIN);
    }

    @Override
    public void visit(final Rogue hero, final LandType land) {
        hero.modAngelModifier(Constants.DAMAGE_ANGEL_ROGUE_DMG_GAIN);
    }

    @Override
    public String getAngelType() {
        return Constants.DAMAGEANGEL;
    }

    @Override
    public String getAction() {
        return Constants.HELP;
    }
}
