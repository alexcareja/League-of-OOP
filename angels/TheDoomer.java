package angels;

import utils.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import map.LandType;
import visitor.Visitor;

public final class TheDoomer extends Angel implements Visitor {

    @Override
    public void visit(final Knight hero, final LandType land) {
        hero.getHit(hero.getHp());
        hero.checkHp();
    }

    @Override
    public void visit(final Pyromancer hero, final LandType land) {
        hero.getHit(hero.getHp());
        hero.checkHp();
    }

    @Override
    public void visit(final Wizard hero, final LandType land) {
        hero.getHit(hero.getHp());
        hero.checkHp();
    }

    @Override
    public void visit(final Rogue hero, final LandType land) {
        hero.getHit(hero.getHp());
        hero.checkHp();
    }

    @Override
    public String getAngelType() {
        return Constants.THEDOOMER;
    }

    @Override
    public String getAction() {
        return Constants.HIT;
    }
}
