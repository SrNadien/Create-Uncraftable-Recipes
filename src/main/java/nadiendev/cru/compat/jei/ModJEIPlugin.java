package nadiendev.cru.compat.jei;

import com.simibubi.create.AllRecipeTypes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeRegistration;
import nadiendev.cru.CreateUncraftableRecipes;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

@JeiPlugin
public class ModJEIPlugin implements IModPlugin {
    
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(CreateUncraftableRecipes.MOD_ID, "jei_plugin");
    }
    
    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();
        
        // Obtener todas las recetas de mechanical crafting de nuestro mod
        var mechanicalCraftingRecipes = recipeManager
            .getAllRecipesFor(AllRecipeTypes.MECHANICAL_CRAFTING.getType())
            .stream()
            .filter(holder -> holder.id().getNamespace().equals(CreateUncraftableRecipes.MOD_ID))
            .map(RecipeHolder::value)
            .toList();
        
        // Si hay recetas, las agregamos a JEI
        // Nota: Como no tenemos acceso a los tipos de JEI de Create, 
        // este plugin básicamente no hace nada por ahora
        // Las recetas se registrarán automáticamente si están en el datapack correcto
        if (!mechanicalCraftingRecipes.isEmpty()) {
            CreateUncraftableRecipes.LOGGER.info("Found {} mechanical crafting recipes", 
                mechanicalCraftingRecipes.size());
        }
    }
}