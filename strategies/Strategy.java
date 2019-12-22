package strategies;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public interface Strategy {
    public void applyStrategy(Knight h);
    public void applyStrategy(Pyromancer h);
    public void applyStrategy(Rogue h);
    public void applyStrategy(Wizard h);
}
