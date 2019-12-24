package heroes;

import strategies.Strategy;
import utils.Constants;
import map.LandType;
import visitor.Visitor;
import java.util.ArrayList;

public class Knight extends Hero {
    private int execute;
    private float executePercentage;
    private int slam;

    public Knight(final int id) {
        this.id = id;
        this.hp = Constants.KNIGHT_INIT_HP;
        this.maxHp = Constants.KNIGHT_INIT_HP;
        this.execute = Constants.EXECUTE_FLAT_DMG;
        this.executePercentage = Constants.EXECUTE_PERCENTAGE;
        this.slam = Constants.SLAM_FLAT_DMG;
    }

    @Override
    public final float getLandModifier(final LandType land) {
        if (land == LandType.Land) {
            return Constants.LAND_KNIGHT;
        }
        return 1;
    }

    @Override
    public final void applyStrategy(final Strategy off, final Strategy deff) {
        if (this.hp < Constants.KNIGHT_LOWER_HP_BOUND * this.maxHp) {
            deff.applyStrategy(this);
        } else {
            if (this.hp < Constants.KNIGHT_UPPER_HP_BOUND * this.maxHp
                    && this.hp > Constants.KNIGHT_LOWER_HP_BOUND * this.maxHp) {
                off.applyStrategy(this);
            }
        }
    }

    @Override
    public final void visit(final Knight hero, final LandType land) {
        if (hero.getHp() < this.executePercentage * hero.getMaxHp()) {
            // execute hero
            hero.getHit(hero.getHp());
            this.expGained = Math.max(0, Constants.WIN_EXPERIENCE
                    - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
            return;
        }
        float landMod = this.getLandModifier(land);
        int executeDmg = Math.round(this.execute * landMod);
        int slamDmg = Math.round(Math.round(this.slam * landMod)
                * (Constants.SLAM_APPLIED_TO_KNIGHT + this.angelModifier + this.stratModifier));
        // Aplic root pentru o runa oponentului
        hero.debuff(0, true, 1);
        // Aplic damage catre target (hero)
        hero.getHit(executeDmg + slamDmg);
        if (hero.getHp() <= 0) {    // Verific daca a facut kill
            this.expGained += Math.max(0, Constants.WIN_EXPERIENCE
                    - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
    }

    @Override
    public final void visit(final Pyromancer hero, final LandType land) {
        if (hero.getHp() < this.executePercentage * hero.getMaxHp()) {
            // execute hero
            hero.getHit(hero.getHp());
            this.expGained += Math.max(0, Constants.WIN_EXPERIENCE
                    - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
            return;
        }
        float landMod = this.getLandModifier(land);
        int executeDmg = Math.round(Math.round(this.execute * landMod
                * (Constants.EXECUTE_APPLIED_TO_PYRO + this.angelModifier + this.stratModifier)));
        int slamDmg = Math.round(Math.round(this.slam * landMod)
                * (Constants.SLAM_APPLIED_TO_PYRO + this.angelModifier + this.stratModifier));
        // Aplic root pentru o runa oponentului
        hero.debuff(0, true, 1);
        // Aplic damage catre target (hero)
        hero.getHit(executeDmg + slamDmg);
        if (hero.getHp() <= 0) {    // Verific daca a facut kill
            this.expGained = Math.max(0, Constants.WIN_EXPERIENCE
                    - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
    }

    @Override
    public final void visit(final Wizard hero, final LandType land) {
        float landMod = this.getLandModifier(land);
        int dmgToDeflect = Math.round(this.execute * landMod) + Math.round(this.slam * landMod);
        // Setez damage-ul dat de erou catre wizard fara modificatorii de rasa (pentru deflect)
        hero.setDmgToDeflect(dmgToDeflect);
        if (hero.getHp() < this.executePercentage * hero.getMaxHp()) {
            // execute hero
            //hero.setDmgToDeflect(hero.getHp());
            hero.getHit(hero.getHp());
            this.expGained = Math.max(0, Constants.WIN_EXPERIENCE
                    - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
            return;
        }
        int executeDmg = Math.round(Math.round(this.execute * landMod)
                        * (Constants.EXECUTE_APPLIED_TO_WIZ + this.angelModifier
                + this.stratModifier));
        int slamDmg = Math.round(Math.round(this.slam * landMod)
                *  (Constants.SLAM_APPLIED_TO_WIZ + this.angelModifier + this.stratModifier));
        // Aplic root pentru o runda oponentului
        hero.debuff(0, true, 1);
        // Aplic damage catre target (hero)
        hero.getHit(executeDmg + slamDmg);
        if (hero.getHp() <= 0) {    // Verific daca a facut kill
            this.expGained = Math.max(0, Constants.WIN_EXPERIENCE
                    - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
    }

    @Override
    public final void visit(final Rogue hero, final LandType land) {
        if (hero.getHp() < this.executePercentage * hero.getMaxHp()) {
            // execute hero
            hero.getHit(hero.getHp());
            this.expGained = Math.max(0, Constants.WIN_EXPERIENCE
                    - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
            return;
        }
        float landMod = this.getLandModifier(land);
        int executeDmg = Math.round(Math.round(this.execute * landMod)
                        * (Constants.EXECUTE_APPLIED_TO_ROGUE + this.angelModifier
                + this.stratModifier));
        int slamDmg = Math.round(Math.round(this.slam * landMod)
                * (Constants.SLAM_APPLIED_TO_ROGUE + this.angelModifier + this.stratModifier));
        // Aplic root pentru o runa oponentului
        hero.debuff(0, true, 1);
        // Aplic damage catre target (hero)
        hero.getHit(executeDmg + slamDmg);
        if (hero.getHp() <= 0) {    // Verific daca a facut kill
            this.expGained = Math.max(0, Constants.WIN_EXPERIENCE
                    - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
    }

    @Override
    public final void accept(final Visitor v, final LandType land) {
        v.visit(this, land);
    }

    @Override
    public final void levelUp() {
        if (this.isDead()) {
            return;
        }
        int i = 0;
        while (this.experience >= Constants.LEVEL_ONE_EXPERIENCE + i
                * Constants.EXPERIENCE_PER_LEVEL) {
            i++;
        }
        ArrayList<String> arg = new ArrayList<>();
        boolean leveledUp = false;
        while (this.level < i) {
            this.level++;
            leveledUp = true;
            arg.add(Constants.LVLUP);
            arg.add(this.getHeroType());
            arg.add(Integer.toString(this.id));
            arg.add(Integer.toString(this.level));
            this.notifyObservers(arg);
            arg.clear();
        }
        if (leveledUp) {
            // Creste damage-ul si viata proportional cu nivelul si intoarce eroul la full hp
            this.level = i;
            this.hp = Constants.KNIGHT_INIT_HP + i * Constants.KNIGHT_HP_GROWTH;
            this.maxHp = this.hp;
            this.execute = Constants.EXECUTE_FLAT_DMG + i * Constants.EXECUTE_DMG_PER_LEVEL;
            this.executePercentage = Constants.EXECUTE_PERCENTAGE + i
                    * Constants.EXECUTE_PERCENT_PER_LEVEL;
            this.slam = Constants.SLAM_FLAT_DMG + i * Constants.SLAM_DMG_PER_LEVEL;
        }
    }

    @Override
    public final String getHeroClass() {
        return "K ";
    }

    @Override
    public final String getHeroType() {
        return "Knight";
    }

}
