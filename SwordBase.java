package net.obsidia;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.Item;

public class SwordBase extends SwordItem {

    protected SwordBase(ToolMaterial toolMaterial_1) {
        super(toolMaterial_1, 4, -0.5f, new Item.Settings().group(ItemGroup.COMBAT));
       
    }
}