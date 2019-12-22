package heroes;

import utils.Constants;
import map.LandType;
import visitor.Visitor;

import java.util.ArrayList;

public class Pyromancer extends Hero {
    private int fireblast;
    private int ignite;
    private int igniteOt;
    private int igniteDuration;

    public Pyromancer(final int id) {
        this.id = id;
        this.hp = Constants.PYRO_INIT_HP;
        this.maxHp = Constants.PYRO_INIT_HP;
        this.fireblast = Constants.FIREBLAST_FLAT_DMG;
        this.ignite = Constants.IGNITE_FLAT_DMG;
        this.igniteOt = Constants.IGNITE_OT_DMG;
        this.igniteDuration = 2;
    }

    @Override
    public final float getLandModifier(final LandType land) {
        if (land == LandType.Volcanic) {
            return Constants.VOLCANIC_PYRO;
        }
        return 1;
    }

    @Override
    public final void visit(final Knight hero, final LandType land) {
        float landMod = this.getLandModifier(land);
        int fireblastDmg = Math.round(this.fireblast
                * Constants.FIREBLAST_APPLIED_TO_KNIGHT * landMod);
        int igniteDmg = Math.round(this.ignite * Constants.IGNITE_APPLIED_TO_KNIGHT * landMod);
        int igniteDot = Math.round(this.igniteOt * Constants.IGNITE_APPLIED_TO_KNIGHT * landMod);
        // Aplic damage overtime
        hero.debuff(igniteDot, false, igniteDuration);
        // Aplic damage catre target (hero)
        hero.getHit(fireblastDmg + igniteDmg);
        if (hero.getHp() <= 0) {    // Verific daca a facut kill
            this.experience += Math.max(0, Constants.WIN_EXPERIENCE
                    - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
    }

    @Override
    public final void visit(final Pyromancer hero, final LandType land) {
        float landMod = this.getLandModifier(land);
        int fireblastDmg = Math.round(this.fireblast
                * Constants.FIREBLAST_APPLIED_TO_PYRO * landMod);
        int igniteDmg = Math.round(this.ignite * Constants.IGNITE_APPLIED_TO_PYRO * landMod);
        int igniteDot = Math.round(this.igniteOt * Constants.IGNITE_APPLIED_TO_PYRO * landMod);
        // Aplic damage overtime
        hero.debuff(igniteDot, false, igniteDuration);
        // Aplic damage catre target (hero)
        hero.getHit(fireblastDmg + igniteDmg);
        if (hero.getHp() <= 0) {    // Verific daca a facut kill
            this.experience += Math.max(0, Constants.WIN_EXPERIENCE
                    - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
    }

    @Override
    public final void visit(final Wizard hero, final LandType land) {
        float landMod = this.getLandModifier(land);
        int fireblastDmg = Math.round(this.fireblast
                * Constants.FIREBLAST_APPLIED_TO_WIZ * landMod);
        int igniteDmg = Math.round(this.ignite * Constants.IGNITE_APPLIED_TO_WIZ * landMod);
        int igniteDot = Math.round(this.igniteOt * Constants.IGNITE_APPLIED_TO_WIZ * landMod);
        // Aplic damage overtime
        hero.debuff(igniteDot, false, igniteDuration);
        int dmgToDeflect = Math.round(this.fireblast * landMod)
                + Math.round(this.ignite * landMod);
        // Setez damage-ul dat de erou catre wizard fara modificatorii de rasa (pentru deflect)
        hero.setDmgToDeflect(dmgToDeflect);
        // Aplic damage catre target (hero)
        hero.getHit(fireblastDmg + igniteDmg);
        if (hero.getHp() <= 0) {    // Verific daca a facut kill
            this.experience += Math.max(0, Constants.WIN_EXPERIENCE
                    - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
    }

    @Override
    public final void visit(final Rogue hero, final LandType land) {
        float landMod = this.getLandModifier(land);
        int fireblastDmg = Math.round(this.fireblast
                * Constants.FIREBLAST_APPLIED_TO_ROGUE * landMod);
        int igniteDmg = Math.round(this.ignite * Constants.IGNITE_APPLIED_TO_ROGUE * landMod);
        int igniteDot = Math.round(this.igniteOt * Constants.IGNITE_APPLIED_TO_ROGUE * landMod);
        // Aplic damage overtime
        hero.debuff(igniteDot, false, igniteDuration);
        // Aplic damage catre target (hero)
        hero.getHit(fireblastDmg + igniteDmg);
        if (hero.getHp() <= 0) {    // Verific daca a facut kill
            this.experience += Math.max(0, Constants.WIN_EXPERIENCE
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
            this.level ++;
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
            this.hp = Constants.PYRO_INIT_HP + i * Constants.PYRO_HP_GROWTH;
            this.maxHp = this.hp;
            this.fireblast = Constants.FIREBLAST_FLAT_DMG + i * Constants.FIREBLAST_DMG_PER_LEVEL;
            this.ignite = Constants.IGNITE_FLAT_DMG + i * Constants.IGNITE_FLAT_DMG_PER_LEVEL;
            this.igniteOt = Constants.IGNITE_OT_DMG + i * Constants.IGNITE_OT_DMG_PER_LEVEL;
        }
    }

    @Override
    public final String getHeroClass() {
        return "P ";
    }

    @Override
    public final String getHeroType() {
        return "Pyromancer";
    }

}
