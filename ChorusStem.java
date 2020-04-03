package net.obsidia;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class ChorusStem extends Block {

    public ChorusStem() {
        super(FabricBlockSettings.of(Material.NETHER_WOOD).breakByHand(true).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.NETHER_STEM).strength(2f, 2f).build());
    }

}