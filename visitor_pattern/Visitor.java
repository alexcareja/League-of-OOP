package visitor_pattern;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import map.LandType;

public interface Visitor {
    void visit(Knight hero, LandType land);

    void visit(Pyromancer hero, LandType land);

    void visit(Wizard hero, LandType land);

    void visit(Rogue hero, LandType land);
}
