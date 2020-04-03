package net.obsidia.world.biome;

import com.google.common.collect.ImmutableSet;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.BlockPileFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.obsidia.Obsidia;
import net.obsidia.world.gen.feature.ObsidiaFungusFeatureConfig;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;


public class ObsidiaBiomeFeatures {

    public static final BlockPileFeatureConfig ENDER_ROOTS_CONFIG;
    public static final BlockPileFeatureConfig ENDER_SPROUTS_CONFIG;
    public static final RandomPatchFeatureConfig HELL_FIRE_CONFIG;

    private static BlockState SOUL_FIRE;
    private static BlockState BRIMSTONE;

    public static void addEndPlainsVegetation(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.NETHER_FOREST_VEGETATION.configure(ENDER_ROOTS_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP.configure(new CountDecoratorConfig(4))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.NETHER_FOREST_VEGETATION.configure(ENDER_SPROUTS_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP.configure(new CountDecoratorConfig(5))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.HUGE_FUNGUS.configure(ObsidiaFungusFeatureConfig.ENDER_FUNGUS_NOT_PLANTED_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP.configure(new CountDecoratorConfig(1))));
   

     }
     static{
         ENDER_ROOTS_CONFIG = new BlockPileFeatureConfig((new WeightedBlockStateProvider()).addState(Obsidia.ENDER_ROOTS.getDefaultState(), 80).addState(Blocks.WARPED_ROOTS.getDefaultState(), 1).addState(Blocks.WARPED_FUNGUS.getDefaultState(), 13));
         ENDER_SPROUTS_CONFIG = new BlockPileFeatureConfig((new WeightedBlockStateProvider()).addState(Obsidia.ENDER_SPROUTS.getDefaultState(), 95));
         HELL_FIRE_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(SOUL_FIRE), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BRIMSTONE.getBlock())).cannotProject().build();     
        }
}