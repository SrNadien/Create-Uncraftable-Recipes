package nadiendev.cru.compat.emi;

import com.simibubi.create.AllRecipeTypes;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import nadiendev.cru.CreateUncraftableRecipes;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

public class ModEMIPlugin implements EmiPlugin {
    
    @Override
    public void register(EmiRegistry registry) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();
        
        var mechanicalCraftingRecipes = recipeManager
            .getAllRecipesFor(AllRecipeTypes.MECHANICAL_CRAFTING.getType())
            .stream()
            .filter(holder -> holder.id().getNamespace().equals(CreateUncraftableRecipes.MOD_ID))
            .map(RecipeHolder::value)
            .toList();
        
        if (!mechanicalCraftingRecipes.isEmpty()) {
            CreateUncraftableRecipes.LOGGER.info("[EMI] Found {} mechanical crafting recipes", 
                mechanicalCraftingRecipes.size());
        }
    }
}