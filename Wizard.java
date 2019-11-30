package main;

public class Wizard extends Hero {
    private double drain;
    private double deflect;

    Wizard() {
        this.hp = Constants.WIZ_INIT_HP;
        this.drain = Constants.DRAIN_FLAT_PERCENTAGE;
        this.deflect = Constants.DEFLECT_FLAT_PERCENTAGE;
    }

    @Override
    public double getLandModifier(LandType land) {
        if(land == LandType.Desert) {
            return Constants.DESERT_WIZ;
        }
        return 1;
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
    void printHeroClass() {
        System.out.print("W ");
    }

}
