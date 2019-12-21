package angels;

import utils.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import map.LandType;
import visitor.Visitor;

public final class Dracula extends Angel implements Visitor {

    @Override
    public void visit(final Knight hero, final LandType land) {
        hero.getHit(Constants.DRACULA_KNIGHT_HP_DEDUCTION);
        hero.checkHp();
        hero.modAngelModifier(Constants.DRACULA_KNIGHT_DMG_DEDUCTION);
    }

    @Override
    public void visit(final Pyromancer hero, final LandType land) {
        hero.getHit(Constants.DRACULA_PYRO_HP_DEDUCTION);
        hero.checkHp();
        hero.modAngelModifier(Constants.DRACULA_PYRO_DMG_DEDUCTION);
    }

    @Override
    public void visit(final Wizard hero, final LandType land) {
        hero.getHit(Constants.DRACULA_WIZARD_HP_DEDUCTION);
        hero.checkHp();
        hero.modAngelModifier(Constants.DRACULA_WIZARD_DMG_DEDUCTION);
    }

    @Override
    public void visit(final Rogue hero, final LandType land) {
        hero.getHit(Constants.DRACULA_ROGUE_HP_DEDUCTION);
        hero.checkHp();
        hero.modAngelModifier(Constants.DRACULA_ROGUE_DMG_DEDUCTION);
    }

    @Override
    public String getAngelType() {
        return Constants.DRACULA;
    }

    @Override
    public String getAction() {
        return Constants.HIT;
    }
}
