package net.obsidia;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;


public class EnderRoots extends PlantBlock {
   protected static final VoxelShape SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

   protected EnderRoots() {
      super(Settings.of(Material.REPLACEABLE_PLANT, MaterialColor.PURPLE).noCollision().breakInstantly().sounds(BlockSoundGroup.ROOTS));
   }

   public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
      return SHAPE;
   }

   protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
      Block block = floor.getBlock();
      return floor.isIn(BlockTags.NYLIUM) || block == Blocks.SOUL_SOIL || super.canPlantOnTop(floor, world, pos);
   }
}