package main;

public class Constants {
    static final int LEVEL_ONE_EXPERIENCE = 250;
    static final int EXPERIENCE_PER_LEVEL = 50;
    static final int LEVEL_DIFF_EXP_MULTIPLIER = 40;
    // Pyromancer abilities modifiers
    static final float FIREBLAST_APPLIED_TO_ROGUE = 0.8f;
    static final float FIREBLAST_APPLIED_TO_KNIGHT = 1.2f;
    static final float FIREBLAST_APPLIED_TO_PYRO= 0.9f;
    static final float FIREBLAST_APPLIED_TO_WIZ = 1.05f;
    static final float IGNITE_APPLIED_TO_ROGUE = 0.8f;
    static final float IGNITE_APPLIED_TO_KNIGHT = 1.2f;
    static final float IGNITE_APPLIED_TO_PYRO = 0.9f;
    static final float IGNITE_APPLIED_TO_WIZ = 1.05f;
    // Knight abilities modifiers
    static final float EXECUTE_APPLIED_TO_ROGUE = 1.15f;
    static final float EXECUTE_APPLIED_TO_KNIGHT = 1f;
    static final float EXECUTE_APPLIED_TO_PYRO= 1.1f;
    static final float EXECUTE_APPLIED_TO_WIZ = 0.8f;
    static final float SLAM_APPLIED_TO_ROGUE = 0.8f;
    static final float SLAM_APPLIED_TO_KNIGHT = 1.2f;
    static final float SLAM_APPLIED_TO_PYRO = 0.9f;
    static final float SLAM_APPLIED_TO_WIZ = 1.05f;
    // Wizard abilities modifiers
    static final float DRAIN_APPLIED_TO_ROGUE = 0.8f;
    static final float DRAIN_APPLIED_TO_KNIGHT = 1.2f;
    static final float DRAIN_APPLIED_TO_PYRO = 0.9f;
    static final float DRAIN_APPLIED_TO_WIZ = 1.05f;
    static final float DEFLECT_APPLIED_TO_ROGUE = 1.2f;
    static final float DEFLECT_APPLIED_TO_KNIGHT = 1.4f;
    static final float DEFLECT_APPLIED_TO_PYRO = 1.3f;
    // Rogue abilities modifiers
    static final float BACKSTAB_APPLIED_TO_ROGUE = 1.2f;
    static final float BACKSTAB_APPLIED_TO_KNIGHT = 0.9f;
    static final float BACKSTAB_APPLIED_TO_PYRO = 1.25f;
    static final float BACKSTAB_APPLIED_TO_WIZ = 1.25f;
    static final float PARALYSIS_APPLIED_TO_ROGUE = 0.9f;
    static final float PARALYSIS_APPLIED_TO_KNIGHT = 0.8f;
    static final float PARALYSIS_APPLIED_TO_PYRO = 1.20f;
    static final float PARALYSIS_APPLIED_TO_WIZ = 1.25f;
    // Land modifiers
    static final float VOLCANIC_PYRO = 1.25f;
    static final float LAND_KNIGHT = 1.15f;
    static final float DESERT_WIZ = 1.10f;
    static final float WOODS_ROGUE = 1.15f;
    // Pyromancer constants
    static final int PYRO_INIT_HP = 500;
    static final int FIREBLAST_FLAT_DMG = 350;
    static final int IGNITE_FLAT_DMG = 150;
    static final int IGNITE_OT_DMG = 50;
    static final int PYRO_HP_GROWTH = 50;
    static final int FIREBLAST_DMG_PER_LEVEL = 50;
    static final int IGNITE_FLAT_DMG_PER_LEVEL = 20;
    static final int IGNITE_OT_DMG_PER_LEVEL = 30;
    // Knight constants
    static final int KNIGHT_INIT_HP = 900;
    static final int EXECUTE_FLAT_DMG = 200;
    static final float EXECUTE_PERCENTAGE = 0.2f;
    static final int SLAM_FLAT_DMG = 100;
    static final int KNIGHT_HP_GROWTH = 80;
    static final int EXECUTE_DMG_PER_LEVEL = 30;
    static final float EXECUTE_PERCENT_PER_LEVEL = 0.01f;
    static final int SLAM_DMG_PER_LEVEL = 40;
    // Wizard constants
    static final int WIZ_INIT_HP = 400;
    static final float DRAIN_FLAT_PERCENTAGE = 0.2f;
    static final float DEFLECT_FLAT_PERCENTAGE = 0.35f;
    static final float DEFLECT_MAX_PERCENTAGE = 0.7f;
    static final int WIZ_HP_GROWTH = 30;
    static final float DRAIN_PERCENT_PER_LEVEL = 0.05f;
    static final float DEFLECT_PERCENT_PER_LEVEL = 0.02f;
    // Rogue constants
    static final int ROGUE_INIT_HP = 600;
    static final int BACKSTAB_FLAT_DMG = 200;
    static final int PARALYSIS_FLAT_DMG = 40;
    static final int PARALYSIS_DURATION = 3;
    static final int ROGUE_HP_GROWTH = 40;
    static final int BACKSTAB_DMG_PER_LEVEL = 20;
    static final int PARALYSIS_DMG_PER_LEVEL = 10;

    private Constants() {
    }
}
