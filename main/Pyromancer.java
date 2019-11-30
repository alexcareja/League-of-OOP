package main;

public class Pyromancer extends Hero {

    @Override
    public boolean isRooted() {
        return false;
    }

    @Override
    public double getLandModifier(LandType land) {
        return 0;
    }

    @Override
    public void dealDmg(Knight hero, LandType land) {

    }

    @Override
    public void dealDmg(Pyromancer hero, LandType land) {

    }

    @Override
    public void dealDmg(Wizard hero, LandType land) {

    }

    @Override
    public void dealDmg(Rogue hero, LandType land) {

    }

    @Override
    public void takeDmg(Visitor v, LandType land) {
        v.dealDmg(this, land);
    }

    @Override
    void levelUp() {

    }

    @Override
    void printStatus() {

    }

}
