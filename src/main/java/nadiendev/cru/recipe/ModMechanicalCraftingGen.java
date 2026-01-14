package nadiendev.cru.recipe;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.api.data.recipe.MechanicalCraftingRecipeGen;
import com.simibubi.create.api.data.recipe.MechanicalCraftingRecipeBuilder;
import net.minecraft.world.item.Items;
import nadiendev.cru.CreateUncraftableRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;

import java.util.concurrent.CompletableFuture;

public class ModMechanicalCraftingGen extends MechanicalCraftingRecipeGen {
    
    public ModMechanicalCraftingGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateUncraftableRecipes.MOD_ID);
    }
    
    private Block getCreateBlock(String id) {
        return BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("create", id));
    }
    
    private Item getCreateItem(String id) {
        return BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("create", id));
    }
    
    GeneratedRecipe
    
    CREATIVE_MOTOR = create(() -> getCreateBlock("creative_motor")).recipe(b -> b
        .key('E', Items.NETHER_STAR)
        .key('B', AllBlocks.SHAFT.asItem())
        .key('S', Items.CRYING_OBSIDIAN)
        .key('C', AllBlocks.ANDESITE_CASING.asItem())
        .key('D', Items.DRAGON_EGG)
        .patternLine("EBE")
        .patternLine("SBS")
        .patternLine("SCS")
        .patternLine("EDE")
    ),
    
    CREATIVE_FLUID_TANK = create(() -> getCreateBlock("creative_fluid_tank")).recipe(b -> b
        .key('E', Items.CRYING_OBSIDIAN)
        .key('S', Items.NETHER_STAR)
        .key('B', AllBlocks.FLUID_TANK.asItem())
        .patternLine("ESE")
        .patternLine("SBS")
        .patternLine("ESE")
    ),
    
    CREATIVE_CRATE = create(() -> getCreateBlock("creative_crate")).recipe(b -> b
        .key('E', Items.CRYING_OBSIDIAN)
        .key('S', Items.NETHER_STAR)
        .key('B', Items.BARREL)
        .patternLine("ESE")
        .patternLine("SBS")
        .patternLine("ESE")
    ),
 
    HANDHELD_WORLDSHAPER = create(() -> getCreateItem("handheld_worldshaper")).recipe(b -> b
        .key('A', AllItems.POWDERED_OBSIDIAN.asItem())
        .key('B', Items.END_ROD)
        .key('C', Items.DRAGON_BREATH)
        .key('D', AllItems.PRECISION_MECHANISM.asItem())
        .key('E', Items.CRYING_OBSIDIAN)
        .key('F', Items.NETHER_STAR)
        .patternLine("  B  ")
        .patternLine("  D  ")
        .patternLine(" EFE ")
        .patternLine(" ECE ")
        .patternLine(" ABA ")
    ),
    
    CREATIVE_BLAZE_CAKE = create(() -> getCreateItem("creative_blaze_cake")).recipe(b -> b
        .key('P', AllItems.BLAZE_CAKE.asItem())
        .key('S', Items.NETHER_STAR)
        .key('B', Items.CRYING_OBSIDIAN)
        .key('A', Items.DRAGON_BREATH)
        .patternLine(" AAA ")
        .patternLine("AAPAA")
        .patternLine("APSPA")
        .patternLine("BBPBB")
        .patternLine(" BBB ")
    );
}