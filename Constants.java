package main;

public class Constants {
    static final int LEVEL_ONE_EXPERIENCE = 250;
    static final int EXPERIENCE_PER_LEVEL = 50;
    static final int LEVEL_DIFF_EXP_MULTIPLIER = 40;
    // Pyromancer abilities modifiers
    static final double FIREBLAST_APPLIED_TO_ROGUE = 0.8;
    static final double FIREBLAST_APPLIED_TO_KNIGHT = 1.2;
    static final double FIREBLAST_APPLIED_TO_PYRO= 0.9;
    static final double FIREBLAST_APPLIED_TO_WIZ = 1.05;
    static final double IGNITE_APPLIED_TO_ROGUE = 0.8;
    static final double IGNITE_APPLIED_TO_KNIGHT = 1.2;
    static final double IGNITE_APPLIED_TO_PYRO = 0.9;
    static final double IGNITE_APPLIED_TO_WIZ = 1.05;
    // Knight abilities modifiers
    static final double EXECUTE_APPLIED_TO_ROGUE = 1.15;
    static final double EXECUTE_APPLIED_TO_KNIGHT = 1;
    static final double EXECUTE_APPLIED_TO_PYRO= 1.1;
    static final double EXECUTE_APPLIED_TO_WIZ = 0.8;
    static final double SLAM_APPLIED_TO_ROGUE = 0.8;
    static final double SLAM_APPLIED_TO_KNIGHT = 1.2;
    static final double SLAM_APPLIED_TO_PYRO = 0.9;
    static final double SLAM_APPLIED_TO_WIZ = 1.05;
    // Wizard abilities modifiers
    static final double DRAIN_APPLIED_TO_ROGUE = 0.8;
    static final double DRAIN_APPLIED_TO_KNIGHT = 1.2;
    static final double DRAIN_APPLIED_TO_PYRO = 0.9;
    static final double DRAIN_APPLIED_TO_WIZ = 1.05;
    static final double DEFLECT_APPLIED_TO_ROGUE = 1.2;
    static final double DEFLECT_APPLIED_TO_KNIGHT = 1.4;
    static final double DEFLECT_APPLIED_TO_PYRO = 1.3;
    static final double DEFLECT_APPLIED_TO_WIZ = 0;
    // Rogue abilities modifiers
    static final double BACKSTAB_APPLIED_TO_ROGUE = 1.2;
    static final double BACKSTAB_APPLIED_TO_KNIGHT = 0.9;
    static final double BACKSTAB_APPLIED_TO_PYRO = 1.25;
    static final double BACKSTAB_APPLIED_TO_WIZ = 1.25;
    static final double PARALYSIS_APPLIED_TO_ROGUE = 0.9;
    static final double PARALYSIS_APPLIED_TO_KNIGHT = 0.8;
    static final double PARALYSIS_APPLIED_TO_PYRO = 1.20;
    static final double PARALYSIS_APPLIED_TO_WIZ = 1.25;
    // Land modifiers
    static final double VOLCANIC_PYRO = 1.25;
    static final double LAND_KNIGHT = 1.15;
    static final double DESERT_WIZ = 1.10;
    static final double WOODS_ROGUE = 1.15;
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
    static final double EXECUTE_PERCENTAGE = 0.2;
    static final int SLAM_FLAT_DMG = 100;
    static final int KNIGHT_HP_GROWTH = 80;
    static final int EXECUTE_DMG_PER_LEVEL = 30;
    static final double EXECUTE_PERCENT_PER_LEVEL = 0.01;
    static final int SLAM_DMG_PER_LEVEL = 40;
    // Wizard constants
    static final int WIZ_INIT_HP = 400;
    static final double DRAIN_FLAT_PERCENTAGE = 0.2;
    static final double DEFLECT_FLAT_PERCENTAGE = 0.35;
    static final double DEFLECT_MAX_PERCENTAGE = 0.7;
    static final int WIZ_HP_GROWTH = 30;
    static final double DRAIN_PERCENT_PER_LEVEL = 0.05;
    static final double DEFLECT_PERCENT_PER_LEVEL = 0.02;
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
