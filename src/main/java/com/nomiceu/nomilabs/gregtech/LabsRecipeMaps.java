package com.nomiceu.nomilabs.gregtech;

import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.core.sound.GTSoundEvents;

public class LabsRecipeMaps {
    public static RecipeMap<SimpleRecipeBuilder> GREENHOUSE_RECIPES;

    public static final RecipeMap<SimpleRecipeBuilder> SMALL_MICROVERSE_RECIPES = new RecipeMap<>("microverse_small", 4, 16, 1, 0, new SimpleRecipeBuilder(), false);
    public static final RecipeMap<SimpleRecipeBuilder> MEDIUM_MICROVERSE_RECIPES = new RecipeMap<>("microverse_medium", 4, 16, 0, 0, new SimpleRecipeBuilder(), false);
    public static final RecipeMap<SimpleRecipeBuilder> LARGE_MICROVERSE_RECIPES = new RecipeMap<>("microverse_large", 9, 16, 1, 0, new SimpleRecipeBuilder(), false);



    public static void preInit() {
        GREENHOUSE_RECIPES = new RecipeMap<>("greenhouse", 4, 9, 1, 0, new SimpleRecipeBuilder(), false)
                .setSlotOverlay(false, false, GuiTextures.SCANNER_OVERLAY).setSlotOverlay(false, true, GuiTextures.SCANNER_OVERLAY)
                .setSlotOverlay(true, false, GuiTextures.SCANNER_OVERLAY).setSlotOverlay(true, true, GuiTextures.SCANNER_OVERLAY)
                .setSound(GTSoundEvents.SAW_TOOL);

        SMALL_MICROVERSE_RECIPES.setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL);
        MEDIUM_MICROVERSE_RECIPES.setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL);
        LARGE_MICROVERSE_RECIPES.setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL);
    }
}
