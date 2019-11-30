package main;

public class Knight extends Hero {
    private int execute;
    private float executePercentage;
    private int slam;

    Knight() {
        this.hp = Constants.KNIGHT_INIT_HP;
        this.execute = Constants.EXECUTE_FLAT_DMG;
        this.executePercentage = Constants.EXECUTE_PERCENTAGE;
        this.slam = Constants.SLAM_FLAT_DMG;
    }

    @Override
    public float getLandModifier(LandType land) {
        if(land == LandType.Land) {
            return Constants.LAND_KNIGHT;
        }
        return 1;
    }

    @Override
    public void dealDmg(Knight hero, LandType land) {
        if(hero.getHp() < this.executePercentage
                * (hero.getLevel() * Constants.KNIGHT_HP_GROWTH + Constants.KNIGHT_INIT_HP)) {
            // execute hero
            hero.getHit(hero.getHp());
            this.experience += Math.max(0, 200 - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
            return;
        }
        float landMod = this.getLandModifier(land);
        int executeDmg = Math.round(this.execute * Constants.EXECUTE_APPLIED_TO_KNIGHT * landMod);
        int slamDmg = Math.round(this.slam * Constants.SLAM_APPLIED_TO_KNIGHT * landMod);
        hero.getHit(executeDmg + slamDmg);
        if (hero.getHp() <= 0) {
            this.experience += Math.max(0, 200 - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
    }

    @Override
    public void dealDmg(Pyromancer hero, LandType land) {
        if(hero.getHp() < this.executePercentage
                * (hero.getLevel() * Constants.PYRO_HP_GROWTH + Constants.PYRO_INIT_HP)) {
            // execute hero
            hero.getHit(hero.getHp());
            this.experience += Math.max(0, 200 - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
            return;
        }
        float landMod = this.getLandModifier(land);
        int executeDmg = Math.round(this.execute * Constants.EXECUTE_APPLIED_TO_PYRO * landMod);
        int slamDmg = Math.round(this.slam * Constants.SLAM_APPLIED_TO_PYRO * landMod);
        hero.getHit(executeDmg + slamDmg);
        if (hero.getHp() <= 0) {
            this.experience += Math.max(0, 200 - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
    }

    @Override
    public void dealDmg(Wizard hero, LandType land) {
        if(hero.getHp() < this.executePercentage
                * (hero.getLevel() * Constants.WIZ_HP_GROWTH + Constants.WIZ_INIT_HP)) {
            // execute hero
            hero.setDmgToDeflect(hero.getHp());
            hero.getHit(hero.getHp());
            this.experience += Math.max(0, 200 - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
            return;
        }
        float landMod = this.getLandModifier(land);
        int executeDmg = Math.round(this.execute * Constants.EXECUTE_APPLIED_TO_WIZ* landMod);
        int slamDmg = Math.round(this.slam * Constants.SLAM_APPLIED_TO_WIZ * landMod);
        int dmgToDeflect = Math.round(this.execute * landMod) + Math.round(this.slam * landMod);
        hero.setDmgToDeflect(dmgToDeflect);
        hero.getHit(executeDmg + slamDmg);
        if (hero.getHp() <= 0) {
            this.experience += Math.max(0, 200 - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
    }

    @Override
    public void dealDmg(Rogue hero, LandType land) {
        if(hero.getHp() < this.executePercentage
                * (hero.getLevel() * Constants.ROGUE_HP_GROWTH + Constants.ROGUE_INIT_HP)) {
            // execute hero
            hero.getHit(hero.getHp());
            this.experience += Math.max(0, 200 - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
            return;
        }
        float landMod = this.getLandModifier(land);
        int executeDmg = Math.round(this.execute * Constants.EXECUTE_APPLIED_TO_ROGUE * landMod);
        int slamDmg = Math.round(this.slam * Constants.SLAM_APPLIED_TO_ROGUE * landMod);
        hero.getHit(executeDmg + slamDmg);
        if (hero.getHp() <= 0) {
            this.experience += Math.max(0, 200 - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
    }

    @Override
    public void takeDmg(Visitor v, LandType land) {
        v.dealDmg(this, land);
    }

    @Override
    void levelUp() {
        int i = 0;
        while(this.experience > Constants.LEVEL_ONE_EXPERIENCE + i * Constants.EXPERIENCE_PER_LEVEL) {
            i++;
        }
        if(i > this.level) {
            this.level = i;
            this.hp = Constants.KNIGHT_INIT_HP + i * Constants.KNIGHT_HP_GROWTH;
            this.execute = Constants.EXECUTE_FLAT_DMG + i * Constants.EXECUTE_DMG_PER_LEVEL;
            this.executePercentage = Constants.EXECUTE_PERCENTAGE + i * Constants.EXECUTE_PERCENT_PER_LEVEL;
            this.slam = Constants.SLAM_FLAT_DMG + i * Constants.SLAM_DMG_PER_LEVEL;
        }
    }

    @Override
    void printHeroClass() {
        System.out.print("K ");
    }


}
