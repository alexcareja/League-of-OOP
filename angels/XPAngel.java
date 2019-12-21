package angels;

import utils.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import map.LandType;
import visitor.Visitor;

public final class XPAngel extends Angel implements Visitor {

    @Override
    public void visit(final Knight hero, final LandType land) {
        hero.gainExperience(Constants.XP_ANGEL_KNIGHT_XP_GAIN);
    }

    @Override
    public void visit(final Pyromancer hero, final LandType land) {
        hero.gainExperience(Constants.XP_ANGEL_PYRO_XP_GAIN);
    }

    @Override
    public void visit(final Wizard hero, final LandType land) {
        hero.gainExperience(Constants.XP_ANGEL_WIZARD_XP_GAIN);
    }

    @Override
    public void visit(final Rogue hero, final LandType land) {
        hero.gainExperience(Constants.XP_ANGEL_ROGUE_XP_GAIN);
    }

    @Override
    public String getAngelType() {
        return Constants.XPANGEL;
    }

    @Override
    public String getAction() {
        return Constants.HELP;
    }
}
