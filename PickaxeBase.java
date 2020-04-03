package net.obsidia;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.Item;

public class PickaxeBase extends PickaxeItem {

    protected PickaxeBase(ToolMaterial toolMaterial_1) {
        super(toolMaterial_1, 1, -1, new Item.Settings().group(ItemGroup.TOOLS));
       
    }
}