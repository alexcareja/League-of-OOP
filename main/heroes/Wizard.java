package heroes;

import Utils.Constants;
import map.LandType;
import visitor_pattern.Visitor;

public class Wizard extends Hero {
    private float drain;
    private float deflect;
    private int deflectFlatDmg;

    public Wizard() {
        this.hp = Constants.WIZ_INIT_HP;
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
    public final void dealDmg(final Knight hero, final LandType land) {
        int heroMaxHp = Constants.KNIGHT_INIT_HP + hero.getLevel() * Constants.KNIGHT_HP_GROWTH;
        float landMod = this.getLandModifier(land);
        int drainDmg = Math.round(this.drain * Math.min(Constants.DRAIN_MAX_HEALTH_MULT
                * heroMaxHp, hero.getHp()) * landMod * Constants.DRAIN_APPLIED_TO_KNIGHT);
        int deflectDmg = Math.round(this.deflectFlatDmg * this.deflect
                * Constants.DEFLECT_APPLIED_TO_KNIGHT * landMod);
        // Aplic damage catre target (hero)
        hero.getHit(drainDmg + deflectDmg);
        if (hero.getHp() <= 0) {    // Verific daca a facut kill
            this.experience += Math.max(0, Constants.WIN_EXPERIENCE
                    - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
        this.deflectFlatDmg = 0;
    }

    @Override
    public final void dealDmg(final Pyromancer hero, final LandType land) {
        int heroMaxHp = Constants.PYRO_INIT_HP + hero.getLevel() * Constants.PYRO_HP_GROWTH;
        float landMod = this.getLandModifier(land);
        int drainDmg = Math.round(this.drain * Math.min(Constants.DRAIN_MAX_HEALTH_MULT
                * heroMaxHp, hero.getHp()) * landMod * Constants.DRAIN_APPLIED_TO_PYRO);
        int deflectDmg = Math.round(this.deflectFlatDmg * this.deflect
                * Constants.DEFLECT_APPLIED_TO_PYRO * landMod);
        // Aplic damage catre target (hero)
        hero.getHit(drainDmg + deflectDmg);
        if (hero.getHp() <= 0) {    // Verific daca a facut kill
            this.experience += Math.max(0, Constants.WIN_EXPERIENCE
                    - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
        this.deflectFlatDmg = 0;
    }

    @Override
    public final void dealDmg(final Wizard hero, final LandType land) {
        this.deflectFlatDmg = 0;
        int heroMaxHp = Constants.WIZ_INIT_HP + hero.getLevel() * Constants.WIZ_HP_GROWTH;
        float landMod = this.getLandModifier(land);
        int drainDmg = Math.round(this.drain * Math.min(Constants.DRAIN_MAX_HEALTH_MULT
                * heroMaxHp, hero.getHp()) * landMod * Constants.DRAIN_APPLIED_TO_WIZ);
        // Aplic damage catre target (hero)
        hero.getHit(drainDmg);
        if (hero.getHp() <= 0) {    // Verific daca a facut kill
            this.experience += Math.max(0, Constants.WIN_EXPERIENCE
                    - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
    }

    @Override
    public final void dealDmg(final Rogue hero, final LandType land) {
        int heroMaxHp = Constants.ROGUE_INIT_HP + hero.getLevel() * Constants.ROGUE_HP_GROWTH;
        float landMod = this.getLandModifier(land);
        int drainDmg = Math.round(this.drain * Math.min(Constants.DRAIN_MAX_HEALTH_MULT
                * heroMaxHp, hero.getHp()) * landMod * Constants.DRAIN_APPLIED_TO_ROGUE);
        int deflectDmg = Math.round(this.deflectFlatDmg * this.deflect
                * Constants.DEFLECT_APPLIED_TO_ROGUE * landMod);
        // Aplic damage catre target (hero)
        hero.getHit(drainDmg + deflectDmg);
        if (hero.getHp() <= 0) {    // Verific daca a facut kill
            this.experience += Math.max(0, Constants.WIN_EXPERIENCE
                    - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
        this.deflectFlatDmg = 0;
    }

    @Override
    public final void takeDmg(final Visitor v, final LandType land) {
        v.dealDmg(this, land);
    }

    @Override
    public final void levelUp() {
        if (this.isDead()) {
            return;
        }
        int i = 0;
        while (this.experience >= Constants.LEVEL_ONE_EXPERIENCE
                + i * Constants.EXPERIENCE_PER_LEVEL) {
            i++;
        }
        if (i > this.level) {
            // Creste damage-ul si viata proportional cu nivelul si intoarce eroul la full hp
            this.level = i;
            this.hp = Constants.WIZ_INIT_HP + i * Constants.WIZ_HP_GROWTH;
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

}
