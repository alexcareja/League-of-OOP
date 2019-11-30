package main;

public class Knight extends Hero {
    private int execute;
    private int slam;
    private boolean isDead = false;

    Knight() {
        this.hp = Constants.KNIGHT_INIT_HP;
        this.execute = Constants.EXECUTE_FLAT_DMG;
        this.slam = Constants.SLAM_FLAT_DMG;
    }

    @Override
    public boolean isRooted() {
        return false;
    }

    @Override
    public double getLandModifier(LandType land) {
        if(land == LandType.Land) {
            return Constants.LAND_KNIGHT;
        }
        return 1;
    }


    /*
    * TODO
    *  ->EXECUTE IF POSSIBLE
    *  */
    @Override
    public void dealDmg(Knight hero, LandType land) {
        double landMod = this.getLandModifier(land);
        int executeDmg = (int) Math.round(this.execute * Constants.EXECUTE_APPLIED_TO_KNIGHT * landMod);
        int slamDmg = (int) Math.round(this.slam * Constants.SLAM_APPLIED_TO_KNIGHT * landMod);
        hero.getHit(executeDmg + slamDmg);
        if (hero.isDead()) {
            this.experience += Math.max(0, 200 - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
    }

    @Override
    public void dealDmg(Pyromancer hero, LandType land) {
        double landMod = this.getLandModifier(land);
        int executeDmg = (int) Math.round(this.execute * Constants.EXECUTE_APPLIED_TO_PYRO * landMod);
        int slamDmg = (int) Math.round(this.slam * Constants.SLAM_APPLIED_TO_PYRO * landMod);
        hero.getHit(executeDmg + slamDmg);
        if (hero.isDead()) {
            this.experience += Math.max(0, 200 - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
    }

    @Override
    public void dealDmg(Wizard hero, LandType land) {
        double landMod = this.getLandModifier(land);
        int executeDmg = (int) Math.round(this.execute * Constants.EXECUTE_APPLIED_TO_WIZ* landMod);
        int slamDmg = (int) Math.round(this.slam * Constants.SLAM_APPLIED_TO_WIZ * landMod);
        hero.getHit(executeDmg + slamDmg);
        if (hero.isDead()) {
            this.experience += Math.max(0, 200 - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
    }

    @Override
    public void dealDmg(Rogue hero, LandType land) {
        double landMod = this.getLandModifier(land);
        int executeDmg = (int) Math.round(this.execute * Constants.EXECUTE_APPLIED_TO_ROGUE * landMod);
        int slamDmg = (int) Math.round(this.slam * Constants.SLAM_APPLIED_TO_ROGUE * landMod);
        hero.getHit(executeDmg + slamDmg);
        if (hero.isDead()) {
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
            this.slam = Constants.SLAM_FLAT_DMG + i * Constants.SLAM_DMG_PER_LEVEL;
        }
    }

    @Override
    void printStatus() {
        System.out.print("K "
                + this.level
                + " "
                + this.experience
                + " "
                + this.hp
                + " ");
    }

}
