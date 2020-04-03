package net.obsidia.world.biome;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.carver.Carver;
import net.obsidia.Brimstone;
import net.obsidia.Obsidia; 


public class BrimstoneCavern extends Biome {

    public static Brimstone BRIMSTONE = new Brimstone();

    public BrimstoneCavern() {
        super(new Biome.Settings()
                .configureSurfaceBuilder(SurfaceBuilder.DEFAULT, new TernarySurfaceConfig(Obsidia.BRIMSTONE.getDefaultState(), Obsidia.BRIMSTONE.getDefaultState(), Obsidia.SULFUR_ORE.getDefaultState()))
                .precipitation(Biome.Precipitation.NONE).category(Biome.Category.NETHER).depth(0.5f).scale(0.5f)
                .temperature(2f).downfall(0.0f)
                .effects((new BiomeEffects.Builder()).waterColor(492512).waterFogColor(492512).fogColor(806701).build())
                .noises(ImmutableList.of(new Biome.MixedNoisePoint(0.2F, 0.1F, 0.4F, 0.2F, 0.7F)))
                .parent((String) null));

                DefaultBiomeFeatures.addNetherOres(this);
                DefaultBiomeFeatures.addDefaultStructures(this);
                DefaultBiomeFeatures.addLandCarvers(this);

                this.addStructureFeature(Feature.NETHER_FOSSIL.configure(FeatureConfig.DEFAULT));
                this.addStructureFeature(Feature.NETHER_BRIDGE.configure(FeatureConfig.DEFAULT));
                this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NETHERRACK, Blocks.MAGMA_BLOCK.getDefaultState(), 33)).createDecoratedFeature(Decorator.MAGMA.configure(new CountDecoratorConfig(4))));
                this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.NETHER_BRIDGE.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.NOPE.configure(DecoratorConfig.DEFAULT)));
                this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.NETHER_FOSSIL.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.NOPE.configure(DecoratorConfig.DEFAULT)));
                this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.GLOWSTONE_BLOB.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.LIGHT_GEM_CHANCE.configure(new CountDecoratorConfig(10))));
                this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.RANDOM_PATCH.configure(ObsidiaBiomeFeatures.HELL_FIRE_CONFIG).createDecoratedFeature(Decorator.FIRE.configure(new CountDecoratorConfig(10))));
                this.addCarver(GenerationStep.Carver.AIR, configureCarver(Carver.NETHER_CAVE, new ProbabilityConfig(0.2F)));

                this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.GHAST, 20, 1, 2));
                this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ZOMBIFIED_PIGLIN, 75, 3, 5));
    }
}