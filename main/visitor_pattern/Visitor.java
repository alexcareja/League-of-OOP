package visitor_pattern;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import map.LandType;

public interface Visitor {
    void dealDmg(Knight hero, LandType land);

    void dealDmg(Pyromancer hero, LandType land);

    void dealDmg(Wizard hero, LandType land);

    void dealDmg(Rogue hero, LandType land);
}
