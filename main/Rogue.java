package main;

public class Rogue extends Hero {
    private int backstab;
    private int paralysis;
    private int backstabCount;

    Rogue() {
        this.hp = Constants.ROGUE_INIT_HP;
        this.backstab = Constants.BACKSTAB_FLAT_DMG;
        this.paralysis = Constants.PARALYSIS_FLAT_DMG;
    }

    @Override
    public float getLandModifier(LandType land) {
        if(land == LandType.Woods) {
            return Constants.WOODS_ROGUE;
        }
        return 1;
    }

    @Override
    public void dealDmg(Knight hero, LandType land) {
        backstabCount++;
        int duration = Constants.PARALYSIS_DURATION;
        float backstabCrit = 1f;
        if(land == LandType.Woods) {
            duration *= 2;
            if(backstabCount % 3 == 0) {
                backstabCrit = 1.5f;
            }
        }
        float landMod = this.getLandModifier(land);
        int backstabDmg = Math.round(this.backstab * Constants.BACKSTAB_APPLIED_TO_KNIGHT * landMod * backstabCrit);
        int paralysisDmg = Math.round(this.paralysis * Constants.PARALYSIS_APPLIED_TO_KNIGHT * landMod);
        hero.debuff(paralysisDmg, true, duration);
        hero.getHit(backstabDmg + paralysisDmg);
        if (hero.getHp() <= 0) {
            this.experience += Math.max(0, 200 - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
    }

    @Override
    public void dealDmg(Pyromancer hero, LandType land) {
        backstabCount++;
        int duration = Constants.PARALYSIS_DURATION;
        float backstabCrit = 1;
        if(land == LandType.Woods) {
            duration *= 2;
            if(backstabCount % 3 == 0) {
                backstabCrit = 1.5f;
            }
        }
        float landMod = this.getLandModifier(land);
        int backstabDmg = Math.round(this.backstab * Constants.BACKSTAB_APPLIED_TO_PYRO * landMod * backstabCrit);
        int paralysisDmg = Math.round(this.paralysis * Constants.PARALYSIS_APPLIED_TO_PYRO * landMod);
        hero.debuff(paralysisDmg, true, duration);
        hero.getHit(backstabDmg + paralysisDmg);
        if (hero.getHp() <= 0) {
            this.experience += Math.max(0, 200 - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
    }

    @Override
    public void dealDmg(Wizard hero, LandType land) {
        backstabCount++;
        int duration = Constants.PARALYSIS_DURATION;
        float backstabCrit = 1;
        if(land == LandType.Woods) {
            duration *= 2;
            if(backstabCount % 3 == 0) {
                backstabCrit = 1.5f;
            }
        }
        float landMod = this.getLandModifier(land);
        int backstabDmg = Math.round(this.backstab * Constants.BACKSTAB_APPLIED_TO_WIZ * landMod * backstabCrit);
        int paralysisDmg = Math.round(this.paralysis * Constants.PARALYSIS_APPLIED_TO_WIZ * landMod);
        int dmgToDeflect = Math.round(this.backstab * landMod) + Math.round(this.paralysis * landMod);
        hero.setDmgToDeflect(dmgToDeflect);
        hero.debuff(paralysisDmg, true, duration);
        hero.getHit(backstabDmg + paralysisDmg);
        if (hero.getHp() <= 0) {
            this.experience += Math.max(0, 200 - (this.level - hero.getLevel()) * Constants.LEVEL_DIFF_EXP_MULTIPLIER);
        }
    }

    @Override
    public void dealDmg(Rogue hero, LandType land) {
        backstabCount++;
        int duration = Constants.PARALYSIS_DURATION;
        float backstabCrit = 1;
        if(land == LandType.Woods) {
            duration *= 2;
            if(backstabCount % 3 == 0) {
                backstabCrit = 1.5f;
            }
        }
        float landMod = this.getLandModifier(land);
        int backstabDmg = Math.round(this.backstab * Constants.BACKSTAB_APPLIED_TO_ROGUE * landMod * backstabCrit);
        int paralysisDmg = Math.round(this.paralysis * Constants.PARALYSIS_APPLIED_TO_ROGUE * landMod);
        hero.debuff(paralysisDmg, true, duration);
        hero.getHit(backstabDmg + paralysisDmg);
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
            this.hp = Constants.ROGUE_INIT_HP + i * Constants.ROGUE_HP_GROWTH;
            this.backstab = Constants.BACKSTAB_FLAT_DMG + i * Constants.BACKSTAB_DMG_PER_LEVEL;
            this.paralysis = Constants.PARALYSIS_FLAT_DMG + i * Constants.PARALYSIS_DMG_PER_LEVEL;
        }
    }

    @Override
    void printHeroClass() {
        System.out.print("R ");
    }

}
