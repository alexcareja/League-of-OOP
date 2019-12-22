package strategies;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import utils.Constants;

public class OffensiveStrategy implements Strategy {

    private static OffensiveStrategy instance;

    private OffensiveStrategy() {
    }

    public static OffensiveStrategy getInstance() {
        if (instance == null) {
            instance = new OffensiveStrategy();
        }
        return instance;
    }

    @Override
    public void applyStrategy(Knight h) {
        h.heal(Math.round(h.getHp() * Constants.KNIGHT_OFF_HEAL));
        h.setStratModifier(Constants.KNIGHT_OFF_DMG);
    }

    @Override
    public void applyStrategy(Pyromancer h) {
        h.heal(Math.round(h.getHp() * Constants.PYRO_OFF_HEAL));
        h.setStratModifier(Constants.PYRO_OFF_DMG);
    }

    @Override
    public void applyStrategy(Rogue h) {
        h.heal(Math.round(h.getHp() * Constants.ROGUE_OFF_HEAL));
        h.setStratModifier(Constants.ROGUE_OFF_DMG);
    }

    @Override
    public void applyStrategy(Wizard h) {
        h.heal(Math.round(h.getHp() * Constants.WIZARD_OFF_HEAL));
        h.setStratModifier(Constants.WIZARD_OFF_DMG);
    }
}
