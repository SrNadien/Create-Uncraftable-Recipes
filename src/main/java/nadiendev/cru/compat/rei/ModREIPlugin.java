package nadiendev.cru.compat.rei;

import com.simibubi.create.AllRecipeTypes;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import nadiendev.cru.CreateUncraftableRecipes;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

public class ModREIPlugin implements REIClientPlugin {
    
    @Override
    public String getPluginProviderName() {
        return CreateUncraftableRecipes.MOD_ID;
    }
    
    @Override
    public void registerDisplays(DisplayRegistry registry) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();
        
        var mechanicalCraftingRecipes = recipeManager
            .getAllRecipesFor(AllRecipeTypes.MECHANICAL_CRAFTING.getType())
            .stream()
            .filter(holder -> holder.id().getNamespace().equals(CreateUncraftableRecipes.MOD_ID))
            .map(RecipeHolder::value)
            .toList();
        
        if (!mechanicalCraftingRecipes.isEmpty()) {
            CreateUncraftableRecipes.LOGGER.info("[REI] Found {} mechanical crafting recipes", 
                mechanicalCraftingRecipes.size());
        }
    }
}