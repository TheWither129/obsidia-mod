package net.obsidia.world.biome;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.BiomeEffects.Builder;
import net.minecraft.world.dimension.TheEndDimension;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.feature.EndGatewayFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import net.obsidia.Obsidia;

public class CorruptedForest extends Biome {
    public CorruptedForest() {
        super((new Settings()).configureSurfaceBuilder(SurfaceBuilder.DEFAULT, new TernarySurfaceConfig(Obsidia.ENDER_LICHEN.getDefaultState(),
        Blocks.END_STONE.getDefaultState(), Blocks.NETHERRACK.getDefaultState())).precipitation(Precipitation.NONE).category(Category.THEEND).depth(0.1F).scale(0.2F).temperature(0.5F).downfall(0.5F).effects((new Builder()).waterColor(4159204).waterFogColor(329011).fogColor(10518688).moodSound(BiomeMoodSound.CAVE).build()).parent((String)null));
        this.addStructureFeature(Feature.END_CITY.configure(FeatureConfig.DEFAULT));
        this.addFeature(net.minecraft.world.gen.GenerationStep.Feature.SURFACE_STRUCTURES, Feature.END_GATEWAY.configure(EndGatewayFeatureConfig.createConfig(TheEndDimension.SPAWN_POINT, true)).createDecoratedFeature(Decorator.END_GATEWAY.configure(DecoratorConfig.DEFAULT)));
        DefaultBiomeFeatures.addEndCities(this);
        this.addFeature(net.minecraft.world.gen.GenerationStep.Feature.VEGETAL_DECORATION, Feature.CHORUS_PLANT.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.CHORUS_PLANT.configure(DecoratorConfig.DEFAULT)));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(EntityType.ENDERMAN, 10, 4, 4));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(EntityType.PHANTOM, 5, 2, 4));
    }

    @Environment(EnvType.CLIENT)
    public int getSkyColor() {
        return 0;
    }
}
