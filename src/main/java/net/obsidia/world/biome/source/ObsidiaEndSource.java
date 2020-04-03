package net.obsidia.world.biome.source;

import com.google.common.collect.ImmutableSet;
import java.util.Set;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.noise.SimplexNoiseSampler;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.biome.source.TheEndBiomeSourceConfig;
import net.minecraft.world.gen.ChunkRandom;
import net.obsidia.Obsidia;

public class ObsidiaEndSource extends BiomeSource {
    private final SimplexNoiseSampler noise;
    private final ChunkRandom random;
    private static final Set<Biome> BIOMES;

    public ObsidiaEndSource(TheEndBiomeSourceConfig config) {
        super(BIOMES);
        this.random = new ChunkRandom(config.getSeed());
        this.random.consume(17292);
        this.noise = new SimplexNoiseSampler(this.random);
    }

    public Biome getBiomeForNoiseGen(int biomeX, int biomeY, int biomeZ) {
        int i = biomeX >> 2;
        int j = biomeZ >> 2;
        if ((long)i * (long)i + (long)j * (long)j <= 4096L) {
            return Biomes.THE_END;
        } else {
            float f = this.getNoiseRange(i * 2 + 1, j * 2 + 1);
            if (f > 40.0F) {
                return Biomes.END_HIGHLANDS;
            } else if (f >= 20.0F) {
                return Obsidia.CORRUPT_FOREST;
            } else {
                return f < -20.0F ? Biomes.SMALL_END_ISLANDS : Biomes.END_BARRENS;
            }
        }
    }

    public float getNoiseRange(int i, int j) {
        int k = i / 2;
        int l = j / 2;
        int m = i % 2;
        int n = j % 2;
        float f = 100.0F - MathHelper.sqrt((float)(i * i + j * j)) * 8.0F;
        f = MathHelper.clamp(f, -100.0F, 80.0F);

        for(int o = -12; o <= 12; ++o) {
            for(int p = -12; p <= 12; ++p) {
                long q = (long)(k + o);
                long r = (long)(l + p);
                if (q * q + r * r > 4096L && this.noise.sample((double)q, (double)r) < -0.8999999761581421D) {
                    float g = (MathHelper.abs((float)q) * 3439.0F + MathHelper.abs((float)r) * 147.0F) % 13.0F + 9.0F;
                    float h = (float)(m - o * 2);
                    float s = (float)(n - p * 2);
                    float t = 100.0F - MathHelper.sqrt(h * h + s * s) * g;
                    t = MathHelper.clamp(t, -100.0F, 80.0F);
                    f = Math.max(f, t);
                }
            }
        }

        return f;
    }

    static {
        BIOMES = ImmutableSet.of(Biomes.THE_END, Biomes.END_HIGHLANDS, Biomes.END_MIDLANDS, Biomes.SMALL_END_ISLANDS, Biomes.END_BARRENS, Obsidia.CORRUPT_FOREST);
    }
}
