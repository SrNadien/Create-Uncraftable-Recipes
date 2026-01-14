package nadiendev.cru;

import nadiendev.cru.recipe.ModMechanicalCraftingGen;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

@Mod(CreateUncraftableRecipes.MOD_ID)
public class CreateUncraftableRecipes {
    public static final String MOD_ID = "cru";
    public static final String MODID = MOD_ID; // Alias para compatibilidad
    public static final String MOD_NAME = "Create: Uncraftable Recipes";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public CreateUncraftableRecipes(IEventBus modEventBus) {
        LOGGER.info("Initializing Create: Uncraftable Recipes");
        
        // Registrar el evento de data generation
        modEventBus.addListener(this::gatherData);
    }
    
    private void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        
        // Registrar el mechanical crafting recipe generator
        generator.addProvider(event.includeServer(), new ModMechanicalCraftingGen(output, lookupProvider));
        
        // Registrar el recipe provider para shaped recipes
       
        
        LOGGER.info("Data generators registered");
    }
}