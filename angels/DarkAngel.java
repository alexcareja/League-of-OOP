package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import utils.Constants;
import map.LandType;
import visitor.Visitor;

public final class DarkAngel extends Angel implements Visitor {

    @Override
    public void visit(final Knight hero, final LandType land) {
        hero.getHit(Constants.DARK_ANGEL_KNIGHT_HP_DEDUCTION);
        hero.checkHp();
    }

    @Override
    public void visit(final Pyromancer hero, final LandType land) {
        hero.getHit(Constants.DARK_ANGEL_PYRO_HP_DEDUCTION);
        hero.checkHp();
    }

    @Override
    public void visit(final Wizard hero, final LandType land) {
        hero.getHit(Constants.DARK_ANGEL_WIZARD_HP_DEDUCTION);
        hero.checkHp();
    }

    @Override
    public void visit(final Rogue hero, final LandType land) {
        hero.getHit(Constants.DARK_ANGEL_ROGUE_HP_DEDUCTION);
        hero.checkHp();
    }

    @Override
    public String getAngelType() {
        return Constants.DARKANGEL;
    }

    @Override
    public String getAction() {
        return Constants.HIT;
    }
}
