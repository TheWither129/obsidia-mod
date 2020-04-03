package net.obsidia;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biomes.v1.NetherBiomes;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.DimensionType;
import net.obsidia.world.biome.BrimstoneCavern;
import net.obsidia.world.biome.CorruptedForest;
import net.obsidia.world.biome.CorruptedPlains;

public class Obsidia implements ModInitializer {



    public static final Item end_diamond = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item titanium_ingot = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item mythril_ingot = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item SULFUR = new Item(new Item.Settings().group(ItemGroup.MISC));

    public static final Block END_DIAMOND_ORE = new end_diamond_ore();
    public static final Block RUTILE_CRYSTAL = new rutile_crystal();
    public static final Block BRIMSTONE = new Brimstone();
    public static final Block SULFUR_ORE = new sulfur_ore();
    public static final Block ENDER_LICHEN = new ender_lichen();
    public static final Block ENDER_ROOTS = new EnderRoots();
    public static final Block ENDER_SPROUTS = new EnderSprouts();
    public static final Block CHORUS_STEM = new ChorusStem();

    public static final RenderLayer ENDERROOTS_LAYER = RenderLayer.getCutout();
    public final static Biome CORRUPT_FOREST = Registry.register(Registry.BIOME,
    new Identifier("obsidia", "corrupt_forest"), new CorruptedForest());

    public static DimensionType OBSIDIA_END;


    @SuppressWarnings("deprecation")

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("obsidia", "end_diamond"), end_diamond);
        
        Registry.register(Registry.BLOCK, new Identifier("obsidia", "end_diamond_ore"), END_DIAMOND_ORE);
        Registry.register(Registry.BLOCK, new Identifier("obsidia", "rutile_crystal"), RUTILE_CRYSTAL);
        Registry.register(Registry.BLOCK, new Identifier("obsidia", "brimstone"), BRIMSTONE);
        Registry.register(Registry.BLOCK, new Identifier("obsidia", "sulfur_ore"), SULFUR_ORE);
        Registry.register(Registry.BLOCK, new Identifier("obsidia", "ender_lichen"), ENDER_LICHEN);
        Registry.register(Registry.BLOCK, new Identifier("obsidia", "ender_roots"), ENDER_ROOTS);
        Registry.register(Registry.BLOCK, new Identifier("obsidia", "ender_sprouts"), ENDER_SPROUTS);
        Registry.register(Registry.BLOCK, new Identifier("obsidia", "chorus_stem"), CHORUS_STEM);

        Registry.register(Registry.ITEM, new Identifier("obsidia", "brimstone"),
                new BlockItem(BRIMSTONE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.ITEM, new Identifier("obsidia", "end_diamond_ore"),
                new BlockItem(END_DIAMOND_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.ITEM, new Identifier("obsidia", "rutile_crystal"),
                new BlockItem(RUTILE_CRYSTAL, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.ITEM, new Identifier("obsidia", "sulfur_ore"),
                new BlockItem(SULFUR_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.ITEM, new Identifier("obsidia", "ender_lichen"),
                new BlockItem(ENDER_LICHEN, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.ITEM, new Identifier("obsidia", "ender_roots"),
                new BlockItem(ENDER_ROOTS, new Item.Settings().group(ItemGroup.DECORATIONS)));

        Registry.register(Registry.ITEM, new Identifier("obsidia", "ender_sprouts"),
                new BlockItem(ENDER_SPROUTS, new Item.Settings().group(ItemGroup.DECORATIONS)));

        Registry.register(Registry.ITEM, new Identifier("obsidia", "chorus_stem"),
                new BlockItem(CHORUS_STEM, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.ITEM, new Identifier("obsidia", "mythril_pickaxe"), new PickaxeBase(new ToolMaterialMythril()));
        Registry.register(Registry.ITEM, new Identifier("obsidia", "mythril_sword"), new SwordBase(new ToolMaterialMythril()));
        Registry.register(Registry.ITEM, new Identifier("obsidia", "titanium_ingot"), titanium_ingot);
        Registry.register(Registry.ITEM, new Identifier("obsidia", "mythril_ingot"), mythril_ingot);
        Registry.register(Registry.ITEM, new Identifier("obsidia", "sulfur"), SULFUR);
        @SuppressWarnings("deprecated")
        final Biome BRIMSTONE_CAVERNS = Registry.register(Registry.BIOME,
                        new Identifier("obsidia", "brimstone_caverns"), new BrimstoneCavern());
        final Biome CORRUPT_PLAINS = Registry.register(Registry.BIOME, 
                        new Identifier("obsidia", "corrupted_plains"), new CorruptedPlains());


        NetherBiomes.addNetherBiome(BRIMSTONE_CAVERNS);

        NetherBiomes.addNetherBiome(CORRUPT_PLAINS);
        
        BlockRenderLayerMap.INSTANCE.putBlocks(

                ENDERROOTS_LAYER,
                Obsidia.ENDER_ROOTS,
                Obsidia.ENDER_SPROUTS
                );
                
        
                

    }
}