package strategies;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public interface Strategy {
    void applyStrategy(Knight h);
    void applyStrategy(Pyromancer h);
    void applyStrategy(Rogue h);
    void applyStrategy(Wizard h);
}
