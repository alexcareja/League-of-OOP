package main;

public interface Visitor {
    void dealDmg(Knight hero, LandType land);
    void dealDmg(Pyromancer hero, LandType land);
    void dealDmg(Wizard hero, LandType land);
    void dealDmg(Rogue hero, LandType land);
}
