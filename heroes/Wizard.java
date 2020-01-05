package heroes;

import strategies.Strategy;
import utils.Constants;
import map.LandType;
import visitor.Visitor;

import java.util.ArrayList;

public class Wizard extends Hero {
    private float drain;
    private float deflect;
    private int deflectFlatDmg;

    public Wizard(final int id) {
        this.id = id;
        this.hp = Constants.WIZ_INIT_HP;
        this.maxHp = Constants.WIZ_INIT_HP;
        this.drain = Constants.DRAIN_FLAT_PERCENTAGE;
        this.deflect = Constants.DEFLECT_FLAT_PERCENTAGE;
        this.deflectFlatDmg = 0;
    }

    final void setDmgToDeflect(final int dmg) {
        this.deflectFlatDmg = dmg;
    }

    @Override
    public final float getLandModifier(final LandType land) {
        if (land == LandType.Desert) {
            return Constants.DESERT_WIZ;
        }
        return 1;
    }

    @Override
    public final void applyStrategy(final Strategy off, final Strategy deff) {
        if (this.hp < Constants.WIZARD_LOWER_HP_BOUND * this.maxHp) {
            deff.applyStrategy(this);
        } else {
            if (this.hp < Constants.WIZARD_UPPER_HP_BOUND * this.maxHp) {
                off.applyStrategy(this);
            }
        }
    }

    @Override
    public final void visit(final Knight hero, final LandType land) {
        int heroMaxHp = hero.getMaxHp();
        float landMod = this.getLandModifier(land);
        float drainMod = this.drain * landMod
                * (Constants.DRAIN_APPLIED_TO_KNIGHT + this.angelModifier + this.stratModifier);
        int drainDmg = Math.round(drainMod
                * Math.min(Constants.DRAIN_MAX_HEALTH_MULT * heroMaxHp, hero.getHp()));
        int deflectDmg = Math.round(Math.round(Math.round(this.deflectFlatDmg * this.deflect)
                * landMod) * (Constants.DEFLECT_APPLIED_TO_KNIGHT + this.angelModifier
                + this.stratModifier));
        // Aplic damage catre target (hero)
        hero.getHit(drainDmg + deflectDmg);
        if (hero.getHp() <= 0) {    // Verific daca a facut kill
            this.expGained = Math.max(0, Constants.WIN_EXPERIENCE
                    - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
        this.deflectFlatDmg = 0;
    }

    @Override
    public final void visit(final Pyromancer hero, final LandType land) {
        int heroMaxHp = hero.getMaxHp();
        float landMod = this.getLandModifier(land);
        float drainMod = this.drain * landMod
                * (Constants.DRAIN_APPLIED_TO_PYRO + this.angelModifier + this.stratModifier);
        int drainDmg = Math.round(drainMod
                * Math.min(Constants.DRAIN_MAX_HEALTH_MULT * heroMaxHp, hero.getHp()));
        int deflectDmg = Math.round(Math.round(Math.round(this.deflectFlatDmg * this.deflect)
                * landMod - Constants.ZERO)
                * (Constants.DEFLECT_APPLIED_TO_PYRO + this.angelModifier + this.stratModifier));
        // Aplic damage catre target (hero)
        hero.getHit(drainDmg + deflectDmg);
        if (hero.getHp() <= 0) {    // Verific daca a facut kill
            this.expGained = Math.max(0, Constants.WIN_EXPERIENCE
                    - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
        this.deflectFlatDmg = 0;
    }

    @Override
    public final void visit(final Wizard hero, final LandType land) {
        this.deflectFlatDmg = 0;
        int heroMaxHp = hero.getMaxHp();
        float landMod = this.getLandModifier(land);
        float drainMod = this.drain * landMod
                * (Constants.DRAIN_APPLIED_TO_WIZ + this.angelModifier + this.stratModifier);
        int drainDmg = Math.round(drainMod
                * Math.min(Constants.DRAIN_MAX_HEALTH_MULT * heroMaxHp, hero.getHp()));

        // Aplic damage catre target (hero)
        hero.getHit(drainDmg);
        if (hero.getHp() <= 0) {    // Verific daca a facut kill
            this.expGained = Math.max(0, Constants.WIN_EXPERIENCE
                    - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
    }

    @Override
    public final void visit(final Rogue hero, final LandType land) {
        int heroMaxHp = hero.getMaxHp();
        float landMod = this.getLandModifier(land);
        float drainMod = this.drain * landMod
                * (Constants.DRAIN_APPLIED_TO_ROGUE + this.angelModifier + this.stratModifier);
        int drainDmg = Math.round(drainMod
                * Math.min(Constants.DRAIN_MAX_HEALTH_MULT * heroMaxHp, hero.getHp()));
        int deflectDmg = Math.round(Math.round(Math.round(
                this.deflectFlatDmg * this.deflect) * (Constants.DEFLECT_APPLIED_TO_ROGUE
                        + this.angelModifier + this.stratModifier)) * landMod - Constants.ZERO);
        // Aplic damage catre target (hero)
        hero.getHit(drainDmg + deflectDmg);
        if (hero.getHp() <= 0) {    // Verific daca a facut kill
            this.expGained = Math.max(0, Constants.WIN_EXPERIENCE
                    - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
        this.deflectFlatDmg = 0;
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
            //this.level = i;
            this.hp = Constants.WIZ_INIT_HP + i * Constants.WIZ_HP_GROWTH;
            this.maxHp = this.hp;
            this.drain = Constants.DRAIN_FLAT_PERCENTAGE + i * Constants.DRAIN_PERCENT_PER_LEVEL;
            this.deflect = Constants.DEFLECT_FLAT_PERCENTAGE
                    + i * Constants.DEFLECT_PERCENT_PER_LEVEL;
            if (this.deflect > Constants.DEFLECT_MAX_PERCENTAGE) {
                this.deflect = Constants.DEFLECT_MAX_PERCENTAGE;
            }
        }
    }

    @Override
    public final String getHeroClass() {
        return "W ";
    }

    @Override
    public final String getHeroType() {
        return "Wizard";
    }

}
