package Utils;

public final class Constants {
    public static final int LEVEL_ONE_EXPERIENCE = 250;
    public static final int EXPERIENCE_PER_LEVEL = 50;
    public static final int LEVEL_DIFF_EXP_MULTIPLIER = 40;
    public static final int WIN_EXPERIENCE = 200;
    // Pyromancer abilities modifiers
    public static final float FIREBLAST_APPLIED_TO_ROGUE = 0.8f;
    public static final float FIREBLAST_APPLIED_TO_KNIGHT = 1.2f;
    public static final float FIREBLAST_APPLIED_TO_PYRO = 0.9f;
    public static final float FIREBLAST_APPLIED_TO_WIZ = 1.05f;
    public static final float IGNITE_APPLIED_TO_ROGUE = 0.8f;
    public static final float IGNITE_APPLIED_TO_KNIGHT = 1.2f;
    public static final float IGNITE_APPLIED_TO_PYRO = 0.9f;
    public static final float IGNITE_APPLIED_TO_WIZ = 1.05f;
    // Knight abilities modifiers
    public static final float EXECUTE_APPLIED_TO_ROGUE = 1.15f;
    public static final float EXECUTE_APPLIED_TO_PYRO = 1.1f;
    public static final float EXECUTE_APPLIED_TO_WIZ = 0.8f;
    public static final float SLAM_APPLIED_TO_ROGUE = 0.8f;
    public static final float SLAM_APPLIED_TO_KNIGHT = 1.2f;
    public static final float SLAM_APPLIED_TO_PYRO = 0.9f;
    public static final float SLAM_APPLIED_TO_WIZ = 1.05f;
    // Wizard abilities modifiers
    public static final float DRAIN_APPLIED_TO_ROGUE = 0.8f;
    public static final float DRAIN_APPLIED_TO_KNIGHT = 1.2f;
    public static final float DRAIN_APPLIED_TO_PYRO = 0.9f;
    public static final float DRAIN_APPLIED_TO_WIZ = 1.05f;
    public static final float DEFLECT_APPLIED_TO_ROGUE = 1.2f;
    public static final float DEFLECT_APPLIED_TO_KNIGHT = 1.4f;
    public static final float DEFLECT_APPLIED_TO_PYRO = 1.3f;
    // Rogue abilities modifiers
    public static final float BACKSTAB_APPLIED_TO_ROGUE = 1.2f;
    public static final float BACKSTAB_APPLIED_TO_KNIGHT = 0.9f;
    public static final float BACKSTAB_APPLIED_TO_PYRO = 1.25f;
    public static final float BACKSTAB_APPLIED_TO_WIZ = 1.25f;
    public static final float PARALYSIS_APPLIED_TO_ROGUE = 0.9f;
    public static final float PARALYSIS_APPLIED_TO_KNIGHT = 0.8f;
    public static final float PARALYSIS_APPLIED_TO_PYRO = 1.20f;
    public static final float PARALYSIS_APPLIED_TO_WIZ = 1.25f;
    // Land modifiers
    public static final float VOLCANIC_PYRO = 1.25f;
    public static final float LAND_KNIGHT = 1.15f;
    public static final float DESERT_WIZ = 1.10f;
    public static final float WOODS_ROGUE = 1.15f;
    // Pyromancer constants
    public static final int PYRO_INIT_HP = 500;
    public static final int FIREBLAST_FLAT_DMG = 350;
    public static final int IGNITE_FLAT_DMG = 150;
    public static final int IGNITE_OT_DMG = 50;
    public static final int PYRO_HP_GROWTH = 50;
    public static final int FIREBLAST_DMG_PER_LEVEL = 50;
    public static final int IGNITE_FLAT_DMG_PER_LEVEL = 20;
    public static final int IGNITE_OT_DMG_PER_LEVEL = 30;
    // Knight constants
    public static final int KNIGHT_INIT_HP = 900;
    public static final int EXECUTE_FLAT_DMG = 200;
    public static final float EXECUTE_PERCENTAGE = 0.2f;
    public static final int SLAM_FLAT_DMG = 100;
    public static final int KNIGHT_HP_GROWTH = 80;
    public static final int EXECUTE_DMG_PER_LEVEL = 30;
    public static final float EXECUTE_PERCENT_PER_LEVEL = 0.01f;
    public static final int SLAM_DMG_PER_LEVEL = 40;
    // Wizard constants
    public static final int WIZ_INIT_HP = 400;
    public static final float DRAIN_FLAT_PERCENTAGE = 0.2f;
    public static final float DRAIN_MAX_HEALTH_MULT = 0.3f;
    public static final float DEFLECT_FLAT_PERCENTAGE = 0.35f;
    public static final float DEFLECT_MAX_PERCENTAGE = 0.7f;
    public static final int WIZ_HP_GROWTH = 30;
    public static final float DRAIN_PERCENT_PER_LEVEL = 0.05f;
    public static final float DEFLECT_PERCENT_PER_LEVEL = 0.02f;
    // Rogue constants
    public static final int ROGUE_INIT_HP = 600;
    public static final int BACKSTAB_FLAT_DMG = 200;
    public static final int BACKSTAB_CRIT_COUNT = 3;
    public static final float BACKSTAB_CRIT_MULTIPLIER = 1.5f;
    public static final int PARALYSIS_FLAT_DMG = 40;
    public static final int PARALYSIS_DURATION = 3;
    public static final int ROGUE_HP_GROWTH = 40;
    public static final int BACKSTAB_DMG_PER_LEVEL = 20;
    public static final int PARALYSIS_DMG_PER_LEVEL = 10;
    // DamageAngel Constants
    public static final float DAMAGE_ANGEL_KNIGHT_DMG_GAIN = 0.15f;
    public static final float DAMAGE_ANGEL_PYRO_DMG_GAIN = 0.20f;
    public static final float DAMAGE_ANGEL_ROGUE_DMG_GAIN = 0.30f;
    public static final float DAMAGE_ANGEL_WIZARD_DMG_GAIN = 0.40f;
    // DarkAngel Constants
    public static final int DARK_ANGEL_KNIGHT_HP_DEDUCTION = -40;
    public static final int DARK_ANGEL_PYRO_HP_DEDUCTION = -30;
    public static final int DARK_ANGEL_ROGUE_HP_DEDUCTION = -10;
    public static final int DARK_ANGEL_WIZARD_HP_DEDUCTION = -20;
    // Dracula Constans
    public static final int DRACULA_KNIGHT_HP_DEDUCTION = -60;
    public static final int DRACULA_PYRO_HP_DEDUCTION = -40;
    public static final int DRACULA_ROGUE_HP_DEDUCTION = -35;
    public static final int DRACULA_WIZARD_HP_DEDUCTION = -20;
    public static final float DRACULA_KNIGHT_DMG_DEDUCTION = -0.2f;
    public static final float DRACULA_PYRO_DMG_DEDUCTION= -0.3f;
    public static final float DRACULA_ROGUE_DMG_DEDUCTION = -0.1f;
    public static final float DRACULA_WIZARD_DMG_DEDUCTION = -0.4f;
    // GoodBoy Constants
    public static final int GOOD_BOY_KNIGHT_HP_GAIN = 20;
    public static final int GOOD_BOY_PYRO_HP_GAIN = 30;
    public static final int GOOD_BOY_ROGUE_HP_GAIN = 40;
    public static final int GOOD_BOY_WIZARD_HP_GAIN = 50;
    public static final float GOOD_BOY_KNIGHT_DMG_GAIN = 0.4f;
    public static final float GOOD_BOY_PYRO_DMG_GAIN = 0.5f;
    public static final float GOOD_BOY_ROGUE_DMG_GAIN = 0.4f;
    public static final float GOOD_BOY_WIZARD_DMG_GAIN = 0.3f;
    // LevelUpAngel Constants
    public static final float LEVEL_UP_ANGEL_KNIGHT_DMG_GAIN = 0.1f;
    public static final float LEVEL_UP_ANGEL_PYRO_DMG_GAIN = 0.2f;
    public static final float LEVEL_UP_ANGEL_ROGUE_DMG_GAIN = 0.15f;
    public static final float LEVEL_UP_ANGEL_WIZARD_DMG_GAIN = 0.25f;
    // LifeGiver Constants
    public static final int LIFE_GIVER_KNIGHT_HP_GAIN = 100;
    public static final int LIFE_GIVER_PYRO_HP_GAIN = 80;
    public static final int LIFE_GIVER_ROGUE_HP_GAIN = 90;
    public static final int LIFE_GIVER_WIZARD_HP_GAIN = 120;
    // SmallAngel Constants
    public static final int SMALL_ANGEL_KNIGHT_HP_GAIN = 10;
    public static final int SMALL_ANGEL_PYRO_HP_GAIN = 15;
    public static final int SMALL_ANGEL_ROGUE_HP_GAIN = 20;
    public static final int SMALL_ANGEL_WIZARD_HP_GAIN = 25;
    public static final float SMALL_ANGEL_KNIGHT_DMG_GAIN = 0.1f;
    public static final float SMALL_ANGEL_PYRO_DMG_GAIN = 0.15f;
    public static final float SMALL_ANGEL_ROGUE_DMG_GAIN = 0.05f;
    public static final float SMALL_ANGEL_WIZARD_DMG_GAIN = 0.1f;
    // Spawner Constants
    public static final int SPAWNER_KNIGHT_REVIVE_HP = 200;
    public static final int SPAWNER_PYRO_REVIVE_HP = 150;
    public static final int SPAWNER_ROGUE_REVIVE_HP = 180;
    public static final int SPAWNER_WIZARD_REVIVE_HP = 120;
    // XPAngel Constants
    public static final int XP_ANGEL_KNIGHT_XP_GAIN = 45;
    public static final int XP_ANGEL_PYRO_XP_GAIN = 50;
    public static final int XP_ANGEL_ROGUE_XP_GAIN = 40;
    public static final int XP_ANGEL_WIZARD_XP_GAIN = 60;

    private Constants() {
    }
}
