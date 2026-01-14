// package nadiendev.cru.recipe;

// import com.simibubi.create.AllBlocks;
// import com.simibubi.create.AllItems;
// import nadiendev.cru.CreateUncraftableRecipes;
// import net.minecraft.advancements.Advancement;
// import net.minecraft.advancements.AdvancementHolder;
// import net.minecraft.core.HolderLookup;
// import net.minecraft.core.registries.BuiltInRegistries;
// import net.minecraft.data.PackOutput;
// import net.minecraft.data.recipes.*;
// import net.minecraft.resources.ResourceLocation;
// import net.minecraft.world.item.Items;
// import net.neoforged.neoforge.common.conditions.ICondition;

// import java.util.concurrent.CompletableFuture;

// public class ModRecipeProvider extends RecipeProvider {
    
//     public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
//         super(output, lookupProvider);
//     }

//     @Override
//     protected void buildRecipes(RecipeOutput output) {
//         // Wrapper para evitar generar advancements automáticos
//         RecipeOutput recipeOutput = new RecipeOutput() {
//             @Override
//             public void accept(ResourceLocation id, net.minecraft.world.item.crafting.Recipe<?> recipe, AdvancementHolder advancement, ICondition... conditions) {
//                 output.accept(id, recipe, null, conditions); // No generar advancement
//             }

//             @Override
//             public Advancement.Builder advancement() {
//                 return output.advancement();
//             }
//         };
        
//         // Creative Worldshaper (item creative-only de Create)
//         var creativeWorldshaper = BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("create", "creative_worldshaper"));
        
//         ShapedRecipeBuilder.shaped(RecipeCategory.MISC, creativeWorldshaper)
//             .pattern("DEB")
//             .pattern("GCG")
//             .pattern("FAF")
//             .define('A', AllItems.POWDERED_OBSIDIAN.asItem())
//             .define('B', Items.END_ROD)
//             .define('C', Items.DRAGON_BREATH)
//             .define('D', AllItems.PRECISION_MECHANISM.asItem())
//             .define('E', Items.CRYING_OBSIDIAN)
//             .define('F', Items.NETHER_STAR)
//             .define('G', AllBlocks.BRASS_CASING.asItem())
//             .unlockedBy("has_nether_star", has(Items.NETHER_STAR))
//             .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateUncraftableRecipes.MODID, "creative_worldshaper"));
//     }
// }