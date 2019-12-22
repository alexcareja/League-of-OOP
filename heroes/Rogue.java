package heroes;

import strategies.Strategy;
import utils.Constants;
import map.LandType;
import visitor.Visitor;

import java.util.ArrayList;

public class Rogue extends Hero {
    private int backstab;
    private int paralysis;
    private int backstabCount;

    public Rogue(final int id) {
        this.id = id;
        this.hp = Constants.ROGUE_INIT_HP;
        this.maxHp = Constants.ROGUE_INIT_HP;
        this.backstab = Constants.BACKSTAB_FLAT_DMG;
        this.paralysis = Constants.PARALYSIS_FLAT_DMG;
        this.backstabCount = 0;
    }

    @Override
    public final float getLandModifier(final LandType land) {
        if (land == LandType.Woods) {
            return Constants.WOODS_ROGUE;
        }
        return 1;
    }

    @Override
    public final void applyStrategy(final Strategy off, final Strategy deff) {
        if (this.hp < Constants.ROGUE_LOWER_HP_BOUND * this.maxHp) {
            deff.applyStrategy(this);
        } else {
            if (this.hp < Constants.ROGUE_UPPER_HP_BOUND * this.maxHp) {
                off.applyStrategy(this);
            }
        }
    }

    @Override
    public final void visit(final Knight hero, final LandType land) {
        int duration = Constants.PARALYSIS_DURATION;
        float backstabCrit = 1f;
        if (land == LandType.Woods) {
            duration *= 2;
            if (backstabCount % Constants.BACKSTAB_CRIT_COUNT == 0) {
                backstabCrit = Constants.BACKSTAB_CRIT_MULTIPLIER;
            }
        }
        float landMod = this.getLandModifier(land);
        int backstabDmg = Math.round(Math.round(Math.round(
                this.backstab * (Constants.BACKSTAB_APPLIED_TO_KNIGHT
                        + this.angelModifier + this.stratModifier))
                * landMod) * backstabCrit);
        int paralysisDmg = Math.round(Math.round(
                this.paralysis * (Constants.PARALYSIS_APPLIED_TO_KNIGHT
                        + this.angelModifier + this.stratModifier))
                * landMod);
        // Aplic damage overtime si root
        hero.debuff(paralysisDmg, true, duration);
        // Aplic damage catre target (hero)
        hero.getHit(backstabDmg + paralysisDmg);
        if (hero.getHp() <= 0) {    // Verific daca a facut kill
            this.experience += Math.max(0, Constants.WIN_EXPERIENCE
                    - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
        backstabCount++;
    }

    @Override
    public final void visit(final Pyromancer hero, final LandType land) {
        int duration = Constants.PARALYSIS_DURATION;
        float backstabCrit = 1;
        if (land == LandType.Woods) {
            duration *= 2;
            if (backstabCount % Constants.BACKSTAB_CRIT_COUNT == 0) {
                backstabCrit = Constants.BACKSTAB_CRIT_MULTIPLIER;
            }
        }
        float landMod = this.getLandModifier(land);
        int backstabDmg = Math.round(Math.round(Math.round(
                this.backstab * (Constants.BACKSTAB_APPLIED_TO_PYRO
                        + this.angelModifier + this.stratModifier))
                * landMod) * backstabCrit);
        int paralysisDmg = Math.round(Math.round(
                this.paralysis * (Constants.PARALYSIS_APPLIED_TO_PYRO
                        + this.angelModifier + this.stratModifier))
                * landMod);
        // Aplic damage overtime si root
        hero.debuff(paralysisDmg, true, duration);
        // Aplic damage catre target (hero)
        hero.getHit(backstabDmg + paralysisDmg);
        if (hero.getHp() <= 0) {    // Verific daca a facut kill
            this.experience += Math.max(0, Constants.WIN_EXPERIENCE
                    - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
        backstabCount++;
    }

    @Override
    public final void visit(final Wizard hero, final LandType land) {
        int duration = Constants.PARALYSIS_DURATION;
        float backstabCrit = 1;
        if (land == LandType.Woods) {
            duration *= 2;
            if (backstabCount % Constants.BACKSTAB_CRIT_COUNT == 0) {
                backstabCrit = Constants.BACKSTAB_CRIT_MULTIPLIER;
            }
        }
        float landMod = this.getLandModifier(land);
        int backstabDmg = Math.round(Math.round(Math.round(
                this.backstab * (Constants.BACKSTAB_APPLIED_TO_WIZ
                        + this.angelModifier + this.stratModifier))
                * landMod) * backstabCrit);
        int paralysisDmg = Math.round(Math.round(
                this.paralysis * (Constants.PARALYSIS_APPLIED_TO_WIZ
                        + this.angelModifier + this.stratModifier))
                * landMod);
        int dmgToDeflect = Math.round(Math.round(this.backstab * landMod) * backstabCrit)
                + Math.round(this.paralysis * landMod);
        // Setez damage-ul dat de erou catre wizard fara modificatorii de rasa (pentru deflect)
        hero.setDmgToDeflect(dmgToDeflect);
        // Aplic damage overtime si root
        hero.debuff(paralysisDmg, true, duration);
        // Aplic damage catre target (hero)
        hero.getHit(backstabDmg + paralysisDmg);
        if (hero.getHp() <= 0) {    // Verific daca a facut kill
            this.experience += Math.max(0, Constants.WIN_EXPERIENCE
                    - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
        backstabCount++;
    }

    @Override
    public final void visit(final Rogue hero, final LandType land) {
        int duration = Constants.PARALYSIS_DURATION;
        float backstabCrit = 1;
        if (land == LandType.Woods) {
            duration *= 2;
            if (backstabCount % Constants.BACKSTAB_CRIT_COUNT == 0) {
                backstabCrit = Constants.BACKSTAB_CRIT_MULTIPLIER;
            }
        }
        float landMod = this.getLandModifier(land);
        int backstabDmg = Math.round(Math.round(Math.round(
                this.backstab * (Constants.BACKSTAB_APPLIED_TO_ROGUE
                        + this.angelModifier + this.stratModifier))
                * landMod) * backstabCrit);
        int paralysisDmg = Math.round(Math.round(
                this.paralysis * (Constants.PARALYSIS_APPLIED_TO_ROGUE
                        + this.angelModifier + this.stratModifier))
                * landMod);
        // Aplic damage overtime si root
        hero.debuff(paralysisDmg, true, duration);
        // Aplic damage catre target (hero)
        hero.getHit(backstabDmg + paralysisDmg);
        if (hero.getHp() <= 0) {    // Verific daca a facut kill
            this.experience += Math.max(0, Constants.WIN_EXPERIENCE
                    - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
        backstabCount++;
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
            this.hp = Constants.ROGUE_INIT_HP + i * Constants.ROGUE_HP_GROWTH;
            this.maxHp = this.hp;
            this.backstab = Constants.BACKSTAB_FLAT_DMG + i * Constants.BACKSTAB_DMG_PER_LEVEL;
            this.paralysis = Constants.PARALYSIS_FLAT_DMG + i * Constants.PARALYSIS_DMG_PER_LEVEL;
        }
    }

    @Override
    public final String getHeroClass() {
        return "R ";
    }

    @Override
    public final String getHeroType() {
        return "Rogue";
    }
}
