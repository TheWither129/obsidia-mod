package net.obsidia.world.biome;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import net.minecraft.world.gen.GenerationStep;
import net.obsidia.Obsidia;

public class CorruptedPlains extends Biome {

    public CorruptedPlains() {
        super(new Biome.Settings()
                .configureSurfaceBuilder(SurfaceBuilder.DEFAULT,
                        new TernarySurfaceConfig(Obsidia.ENDER_LICHEN.getDefaultState(),
                                Blocks.END_STONE.getDefaultState(), Blocks.NETHERRACK.getDefaultState()))
                .precipitation(Biome.Precipitation.NONE).category(Biome.Category.NETHER).depth(0.5f).scale(0.2f)
                .temperature(2f).downfall(0.0f)
                .effects((new BiomeEffects.Builder()).waterColor(10518688).waterFogColor(10518688).fogColor(10518688).build())
                .noises(ImmutableList.of(new Biome.MixedNoisePoint(0.5F, 0.0F, 0.0F, 0.5F, 1.0F)))
                .parent((String) null));
        // 3407280 potential future color  ||  0.2F, 0.1F, 0.4F, 0.2F, 0.7F

        DefaultBiomeFeatures.addNetherOres(this);
        DefaultBiomeFeatures.addDefaultStructures(this);
        ObsidiaBiomeFeatures.addEndPlainsVegetation(this);
        DefaultBiomeFeatures.addLandCarvers(this);
        this.addFeature(GenerationStep.Feature.RAW_GENERATION, Feature.END_ISLAND.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.END_ISLAND.configure(DecoratorConfig.DEFAULT)));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.CHORUS_PLANT);
        this.addStructureFeature(Feature.NETHER_BRIDGE.configure(FeatureConfig.DEFAULT));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION,
                Feature.NETHER_BRIDGE.configure(FeatureConfig.DEFAULT)
                        .createDecoratedFeature(Decorator.NOPE.configure(DecoratorConfig.DEFAULT)));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ENDERMAN, 75, 3, 5));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.PHANTOM, 3, 2, 4));
        this.addSpawn(EntityCategory.CREATURE, new Biome.SpawnEntry(EntityType.STRIDER, 60, 2, 4));
    }

    private void addFeature(net.minecraft.world.gen.GenerationStep.Feature vegetalDecoration,
            Feature<DefaultFeatureConfig> chorusPlant) {
    }
}